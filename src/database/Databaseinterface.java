package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import game.RegisteredPlayer;
import game.Stats;

/**
 * interface for communicating with the database
 * 
 * @author Kjell Treder
 */

public final class Databaseinterface {

    private static Databaseinterface instance;
    private Connection conn;

    private static final String DRIVER_NAME = "org.hsqldb.jdbc.JDBCDriver";
    private static final String DB_URL = "jdbc:hsqldb:file:data/KniffelStats;ifexists=true";
    private static final String NAME = "Kjell Treder";
    private static final String PASSWORD = "";

    /**
     * private constructor prevents external instantiation
     */
    private Databaseinterface() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
            abort();
        }
    }

    /**
     * get the instance of this class, there can only be one instance at a time
     * (singleton)
     * 
     * @return the current instance, or a new instance, if there is none
     */
    public static Databaseinterface getInstance() {
        if (instance == null) {
            instance = new Databaseinterface();
        }
        return instance;
    }

    /**
     * read a player from the database by the name
     * 
     * @param name name and primary key of the player
     * @return a player object with the name, password and stats
     * @throws SQLException if a database access error occurs
     */
    public RegisteredPlayer readPlayer(String name) throws SQLException {
        connect();

        RegisteredPlayer player = null;
        int statsId;
        ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + name + "'");
        if (valid(set)) {
            player = new RegisteredPlayer(name, set.getString("password"));
            statsId = set.getInt("stats_id");
        } else {
            return null;
        }

        Stats stats = null;
        set = read("SELECT * FROM Stats WHERE stats_id=" + statsId);
        if (valid(set)) {
            stats = new Stats(player, set.getInt("gamesWon"), set.getInt("gamesPlayed"), set.getInt("roundsPlayed"),
                    set.getInt("points"), set.getInt("diceRolled"), set.getInt("timePlayed"));
        } else {
            return null;
        }
        player.assignStats(stats);

        close();

        return player;
    }

    /**
     * save a player and their stats in the database
     * 
     * @param player player object containing data
     * @throws SQLException if a database access error occurs
     */
    public boolean savePlayer(RegisteredPlayer player) throws SQLException {
        connect();

        if (player != null && player.getStats() != null) {
            Stats playerStats = player.getStats();
            ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + player.getName() + "'");
            if (valid(set)) {
                int statsId = set.getInt("stats_id");
                set = write("UPDATE Stats SET gamesWon=" + playerStats.getGamesWon() + "," + "gamesPlayed="
                        + playerStats.getGamesPlayed() + "," + "roundsPlayed=" + playerStats.getRoundsPlayed() + ","
                        + "points=" + playerStats.getPoints() + "," + "diceRolled=" + playerStats.getDiceRolled() + ","
                        + "timePlayed=" + playerStats.getTimePlayed() + " WHERE id=" + statsId);
            } else {
                set = write("INSERT INTO Stats (gamesPlayed, roundsPlayed, points, diceRolled, timePlayed) VALUES ("
                        + playerStats.getGamesWon() + "," + playerStats.getGamesPlayed() + ","
                        + playerStats.getRoundsPlayed() + "," + playerStats.getPoints() + ","
                        + playerStats.getDiceRolled() + "," + playerStats.getTimePlayed() + ")");
                if (valid(set)) {
                    set = write("INSERT INTO RegisteredPlayer (name, password, stats_id) VALUES ('" + player.getName()
                            + "','" + player.getPassword() + "'," + set.getInt("id") + ")");
                }
            }

            close();

            return valid(set);
        }
        return false;
    }

    /**
     * delete a player from the database by the name
     * 
     * @param player player object containing data
     * @return if successful
     * @throws SQLException if a database access error occurs
     */
    public boolean deletePlayer(RegisteredPlayer player) throws SQLException {
        if (player == null) {
            return false;
        }

        connect();

        ResultSet set = write("DELETE FROM RegisteredPlayer WHERE name='" + player.getName() + "'");
        if (valid(set)) {
            set = write("DELETE FROM Stats WHERE id=" + set.getInt("stats_id"));
        }

        close();

        return valid(set);

    }

    /**
     * connect to the database
     * 
     * @return if the connection was successful
     * @throws SQLException if a database access error occurs
     */
    private boolean connect() throws SQLException {
        close();

        try {
            conn = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
            System.out.println("Connection successful.");
            return true;
        } catch (SQLException exc) {
            exc.printStackTrace();
            abort();
        }
        return false;
    }

    /**
     * close the connection to the database
     * 
     * @return if successful
     * @throws SQLException if a database access error occurs
     */
    private boolean close() {
        if (isConnected()) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("SHUTDOWN");
                conn.close();
                System.out.println("Connection closed.");
                return true;
            } catch (SQLException exc) {
                exc.printStackTrace();
                abort();
            }
        }
        return false;
    }

    /**
     * read from the database with a query
     * 
     * @param query the SQL query for reading in the database
     * @return the result set from the executed query
     * @throws SQLException if a database access error occurs
     */
    private ResultSet read(String query) {
        if (isConnected() && !query.isBlank()) {
            try (Statement stmt = conn.createStatement()) {
                return stmt.executeQuery(query);
            } catch (SQLException exc) {
                exc.printStackTrace();
                abort();
            }
        }
        return null;
    }

    /**
     * write into the database
     * 
     * @param query the SQL query for writing in the database
     * @param keys  if the statement should return the generated keys, else null
     * @return the result set from the executed query
     * @throws SQLException if a database access error occurs
     */
    private ResultSet write(String query) {
        if (isConnected() && !query.isBlank()) {
            try (Statement stmt = conn.createStatement()) {
                int nLines = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                if (nLines != 0) {
                    return stmt.getGeneratedKeys();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
                abort();
            }
        }
        return null;
    }

    /**
     * checks if a connection to the database has been made
     * 
     * @return if the connection is open
     */
    private boolean isConnected() {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException exc) {
            exc.printStackTrace();
            abort();
        }
        return false;
    }

    /**
     * check the result set
     * 
     * @param set the result set to be checked
     * @return true if this set is not null and has a next entry
     */
    private boolean valid(ResultSet set) {
        try {
            return set != null && set.next();
        } catch (SQLException exc) {
            exc.printStackTrace();
            abort();
        }
        return false;
    }

    /**
     * Terminate the program
     */
    private void abort() {
        close();
        System.exit(-1);
    }
}

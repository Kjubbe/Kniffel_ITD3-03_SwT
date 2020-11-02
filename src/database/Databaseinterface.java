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
        RegisteredPlayer player = null;
        int statsId;
        connect();

        // search for the players name in the database
        ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + name + "'");
        if (newData(set)) { // player found
            player = new RegisteredPlayer(name, set.getString("password")); // new player object with data
            statsId = set.getInt("stats_id"); // retrieve the id of the stats
        } else { // player not found
            return null; // skip the following code
        }

        // search for the stats in the database
        Stats stats = null;
        set = read("SELECT * FROM Stats WHERE id=" + statsId);
        if (newData(set)) { // stats found
            stats = new Stats(player, set.getInt("gamesWon"), set.getInt("gamesPlayed"), set.getInt("roundsPlayed"),
                    set.getInt("points"), set.getInt("diceRolled"), set.getInt("timePlayed")); // new stats object
            player.assignStats(stats); // assign the stats to the player
        } else { // stats not found
            return null; // skip the following code
        }

        close();
        return player; // return the player object
    }

    /**
     * save a player and their stats in the database
     * 
     * @param player player object containing data
     * @return if successful
     * @throws SQLException if a database access error occurs
     */
    public boolean savePlayer(RegisteredPlayer player) throws SQLException {
        boolean result = false;
        connect();

        // player and their stats can not be null
        if (player != null && player.getStats() != null) {
            Stats playerStats = player.getStats(); // retrieve the players stats

            // check for the player in the database
            ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + player.getName() + "'");
            if (newData(set)) { // player found
                int statsId = set.getInt("stats_id"); // retrieve their stats id from the database

                // check if the player has changed their password TODO is this good?
                if (!set.getString("password").equals(player.getPassword())) {
                    write("UPDATE RegisteredPlayer SET password='" + player.getPassword() + "'");
                }

                // update the players stats
                write("UPDATE Stats SET gamesWon=" + playerStats.getGamesWon() + "," + "gamesPlayed="
                        + playerStats.getGamesPlayed() + "," + "roundsPlayed=" + playerStats.getRoundsPlayed() + ","
                        + "points=" + playerStats.getPoints() + "," + "diceRolled=" + playerStats.getDiceRolled() + ","
                        + "timePlayed=" + playerStats.getTimePlayed() + " WHERE id=" + statsId); // update their stats
                result = true;
            } else { // player not found
                // create a new row in the Stats table
                set = write("INSERT INTO Stats (gamesWon, gamesPlayed, roundsPlayed,"
                        + " points, diceRolled, timePlayed) VALUES (" + playerStats.getGamesWon() + ","
                        + playerStats.getGamesPlayed() + "," + playerStats.getRoundsPlayed() + ","
                        + playerStats.getPoints() + "," + playerStats.getDiceRolled() + ","
                        + playerStats.getTimePlayed() + ")");
                if (newData(set)) { // if successful
                    // create a new row in the RegisteredPlayer table with the id of the stats row
                    write("INSERT INTO RegisteredPlayer (name, password, stats_id) VALUES ('" + player.getName() + "','"
                            + player.getPassword() + "'," + set.getInt("id") + ")");
                    result = true;
                }

            }
        }

        close();
        return result;
    }

    /**
     * delete a player from the database by the name
     * 
     * @param player player object containing data
     * @return if successful
     * @throws SQLException if a database access error occurs
     */
    public boolean deletePlayer(String name) throws SQLException {
        boolean result = false;
        connect();

        // check for the player in the database
        ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + name + "'");
        if (newData(set)) { // player found
            write("DELETE FROM RegisteredPlayer WHERE name='" + name + "'"); // delete the player
            write("DELETE FROM Stats WHERE id=" + set.getInt("stats_id")); // delete their stats
            result = true;
        }

        close();
        return result;
    }

    /**
     * connect to the database
     * 
     * @return if the connection was successful
     * @throws SQLException if a database access error occurs
     */
    private boolean connect() throws SQLException {
        close(); // close before connecting if connected
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
        if (isConnected()) { // only close if connected
            try {
                Statement stmt = conn.createStatement();
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
        System.out.println("Reading query: " + query);
        if (isConnected() && !query.isBlank()) { // execute only non-blank queries on open connection
            try (Statement stmt = conn.createStatement()) {
                return stmt.executeQuery(query); // return the result set from the query
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
        System.out.println("Writing query: " + query);
        if (isConnected() && !query.isBlank()) { // execute only non-blank updates on open connection
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                return stmt.getGeneratedKeys(); // return the result set from the query
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
            return conn != null && !conn.isClosed(); // connected, if connection is not null and open
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
    private boolean newData(ResultSet set) {
        try {
            return set != null && set.next(); // valid, if not null and has at least one changed row
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
        close(); // close before exiting
        System.exit(-1);
    }
}

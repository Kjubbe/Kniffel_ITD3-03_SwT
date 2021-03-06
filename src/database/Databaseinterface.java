package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import game.RegisteredPlayer;
import game.Stats;

/**
 * interface for communicating with the database. the database consists of
 * players and their stats, which can be saved with this class
 * 
 * @author Kjell Treder
 */

public final class Databaseinterface {

    /**
     * instance of this class, singleton pattern
     */
    private static Databaseinterface instance;

    /**
     * contains the current connection object to the database
     */
    private Connection conn;

    // data for the jdbc connection
    private static final String DRIVER_NAME = "org.hsqldb.jdbc.JDBCDriver";
    private static final String DB_URL = "jdbc:hsqldb:file:data/KniffelStats;ifexists=true";
    private static final String NAME = "SA";
    private static final String PASSWORD = "";

    /**
     * private constructor prevents external instantiation, the Databaseinterface
     * can be instantiated with the getInstance method
     */
    private Databaseinterface() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * get the instance of this class, there can only be one instance at a time
     * (singleton pattern)
     * 
     * @return the current instance, or a new instance, if there is none
     */
    public static Databaseinterface getInstance() {
        if (instance == null) { // if there is no instance, create a new one
            instance = new Databaseinterface();
        }
        return instance;
    }

    /**
     * read a player from the database by the name
     * 
     * @param name name (primary key) of the player
     * @return a player object with the name, password and stats
     * @throws SQLException if a database access error occurs
     */
    public RegisteredPlayer retrievePlayer(String name) throws SQLException {
        RegisteredPlayer player = null;
        int statsId;
        connect();

        // search for the players name in the database
        ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + name + "'");
        if (check(set)) { // player found
            player = new RegisteredPlayer(name, set.getString("password")); // new player object with data
            statsId = set.getInt("stats_id"); // retrieve the id of the stats
        } else { // player not found
            return null; // skip the following code
        }

        // search for the stats in the database
        Stats stats = null;
        set = read("SELECT * FROM Stats WHERE id=" + statsId);
        if (check(set)) { // stats found
            stats = new Stats(set.getInt("gamesWon"), set.getInt("gamesPlayed"), set.getInt("roundsPlayed"),
                    set.getInt("points"), set.getInt("diceRolled"), set.getInt("timePlayed")); // new stats object
            player.assignStats(stats); // assign the stats to the player
        } else { // stats not found
            return null; // skip the following code wh
        }

        close();
        return player; // return the player object
    }

    /**
     * update a players stats in the database
     * 
     * @param player player object containing stats
     * @return if successful
     * @throws SQLException if a database access error occurs
     */
    public boolean updatePlayer(RegisteredPlayer player) throws SQLException {
        boolean result = false;
        connect();

        // player and their stats can not be null
        if (player != null && player.getStats() != null) {
            Stats playerStats = player.getStats(); // retrieve the players stats

            // check for the player in the database
            ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + player.getName() + "'");
            if (check(set)) { // player found
                int statsId = set.getInt("stats_id"); // retrieve their stats id from the database

                write("UPDATE Stats SET gamesWon=" + playerStats.getGamesWon() + "," + "gamesPlayed="
                        + playerStats.getGamesPlayed() + "," + "roundsPlayed=" + playerStats.getRoundsPlayed() + ","
                        + "points=" + playerStats.getPoints() + "," + "diceRolled=" + playerStats.getDiceRolled() + ","
                        + "timePlayed=" + playerStats.getTimePlayed() + " WHERE id=" + statsId); // update their stats
                result = true; // (0,0,4,12,254,55,2)
            }
        }

        close();
        return result;
    }

    /**
     * save a new player in the database
     * 
     * @param player player object containing data
     * @return true if successful, false if the player name exists
     * @throws SQLException if a database access error occurs
     */
    public boolean savePlayer(RegisteredPlayer player) throws SQLException {
        boolean result = false;
        connect();

        // player and their stats can not be null
        if (player != null && player.getStats() != null) { // player not found
            ResultSet set = read("SELECT * FROM RegisteredPlayer WHERE name='" + player.getName() + "'");
            if (!check(set)) { // no player found with that name
                Stats playerStats = player.getStats(); // retrieve the players stats

                // create a new row in the Stats table
                set = write("INSERT INTO Stats (gamesWon, gamesPlayed, roundsPlayed,"
                        + " points, diceRolled, timePlayed) VALUES (" + playerStats.getGamesWon() + ","
                        + playerStats.getGamesPlayed() + "," + playerStats.getRoundsPlayed() + ","
                        + playerStats.getPoints() + "," + playerStats.getDiceRolled() + ","
                        + playerStats.getTimePlayed() + ")");
                if (check(set)) { // if successful
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
     * connect to the database
     * 
     * @throws SQLException if a database access error occurs
     */
    private void connect() throws SQLException {
        close(); // close before connecting if connected
        conn = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
        System.out.println("Connection successful.");
    }

    /**
     * close the connection to the database
     * 
     * @throws SQLException if a database access error occurs
     */
    private void close() throws SQLException {
        if (isConnected()) { // only close if connected
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("SHUTDOWN");
            conn.close();
        }
    }

    /**
     * read from the database with a query
     * 
     * @param query the SQL query for reading in the database
     * @return the result set from the executed query
     * @throws SQLException if a database access error occurs
     */
    private ResultSet read(String query) throws SQLException {
        System.out.println("Reading query: " + query);
        if (isConnected() && !query.isBlank()) { // execute only non-blank queries on open connection
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query); // return the result set from the query
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
    private ResultSet write(String query) throws SQLException {
        System.out.println("Writing query: " + query);
        if (isConnected() && !query.isBlank()) { // execute only non-blank updates on open connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            return stmt.getGeneratedKeys(); // return the result set from the query
        }
        return null;
    }

    /**
     * checks if a connection to the database has been made
     * 
     * @return if the connection is open
     * @throws SQLException if a database access error occurs
     */
    private boolean isConnected() throws SQLException {
        return conn != null && !conn.isClosed(); // connected, if connection is not null and open
    }

    /**
     * check the result set
     * 
     * @param set the result set to be checked
     * @return true if this set is not null and has a next entry
     * @throws SQLException if a database access error occurs
     */
    private static boolean check(ResultSet set) throws SQLException {
        return set != null && set.next(); // valid, if not null and has at least one changed row
    }
}

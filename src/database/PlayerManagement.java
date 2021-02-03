package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import game.Player;
import game.RegisteredPlayer;
import game.Stats;

/**
 * manages players from the database, players can be logged in, registered and
 * play as a guest
 * 
 * @author Kjell Treder
 */

public class PlayerManagement {

    /**
     * instance of this class, singleton pattern
     */
    private static PlayerManagement instance;

    /**
     * contains all logged in players
     */
    private List<Player> loggedIn = new ArrayList<>();

    /**
     * maximum amount of players
     */
    public static final int MAX_PLAYERS = 8;

    /**
     * error and success messages
     */
    private static final String MAX_REACHED = "Maximale Anzahl an Spielern erreicht.";
    private static final String PLAYER_ALREADY_ADDED = "Spieler bereits hinzugefügt";
    private static final String SUCCESS = "Spieler wurde hinzugefügt.";
    private static final String ERROR = "Es ist ein Fehler aufgetreten.";

    /**
     * private constructor prevents external instantiation, the PlayerManagement can
     * be instantiated with the getInstance method
     */
    private PlayerManagement() {
        // empty
    }

    /**
     * get the instance of this class, there can only be one instance at a time
     * (singleton pattern)
     * 
     * @return the current instance, or a new instance, if there is none
     */
    public static PlayerManagement getInstance() {
        if (instance == null) { // if there is no instance, create a new one
            instance = new PlayerManagement();
        }
        return instance;
    }

    /**
     * login with a name and password
     * 
     * @param name      name of the player
     * @param password  password of the player
     * @param saveStats if the stats should be saved after the game
     * @return if successful
     */
    public Map<String, Boolean> login(String name, String password, boolean saveStats) {
        try {
            // retrieve the player from the database
            RegisteredPlayer player = Databaseinterface.getInstance().retrievePlayer(name);

            // if the player is found and has a correct password
            if (player != null && password.equals(player.getPassword())) {
                if (saveStats) { // save the stats of the players, when the boolean is set
                    player.saveStats();
                }

                // logged in players should replace quest players
                // if a quest with the same name as the logged in player exists,
                // they will be replaced by the logged in player

                // try adding the player
                Map<String, Boolean> res = addPlayer(player);
                if (res.containsValue(false)) { // if adding the player failed, try removing a quest
                    logout(name); // remove the quest
                    res = addPlayer(player); // try adding the player again
                }
                return res;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Collections.singletonMap(ERROR, false);
    }

    /**
     * register with a name and password
     * 
     * @param name      name of the player
     * @param password  password of the player
     * @param saveStats if the stats should be saved after the game
     * @return the player object if found
     */
    public Map<String, Boolean> register(String name, String password, boolean saveStats) {
        try {
            // retrieve the player from the database
            RegisteredPlayer player = Databaseinterface.getInstance().retrievePlayer(name);

            // if there is no player in the database, the player can register
            if (player == null) {
                // create a new player object
                player = new RegisteredPlayer(name, password);
                if (saveStats) { // save the stats of the players, when the boolean is set
                    player.saveStats();
                }

                // save the created player in the database
                boolean saved = Databaseinterface.getInstance().savePlayer(player);

                // logged in players should replace quest players
                // if a quest with the same name as the logged in player exists,
                // they will be replaced by the logged in player

                // try adding the player
                Map<String, Boolean> res = addPlayer(player);
                if (res.containsValue(false) && saved) { // if adding the player failed, try removing a quest
                    logout(name); // remove the quest
                    res = addPlayer(player); // try adding the player again
                }
                return res;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Collections.singletonMap(ERROR, false);
    }

    /**
     * remove a player by logging out
     * 
     * @param name name of the player logging out
     * @return if successful
     */
    public boolean logout(String name) {
        for (Player p : loggedIn) { // iterate over every player
            if (p.getName().equals(name)) { // player found
                loggedIn.remove(p); // remove the player
                return true;
            }
        }
        return false;
    }

    /**
     * the user can continue as a guest
     * 
     * @param name player name
     * @return if successful
     */
    public Map<String, Boolean> playAsGuest(String name) {
        return addPlayer(new Player(name)); // try adding the player
    }

    /**
     * checks if the player name is unique. if that is the case, the player is added
     * to the list
     * 
     * @param player player object to be checked
     * @return if unique
     */
    private Map<String, Boolean> addPlayer(Player player) {
        if (loggedIn.size() >= MAX_PLAYERS) { // check for maximum player amount
            return Collections.singletonMap(MAX_REACHED, false);
        }
        for (Player p : loggedIn) {
            if (p.getName().equals(player.getName())) { // check if the player already participates
                return Collections.singletonMap(PLAYER_ALREADY_ADDED, false);
            }
        }
        loggedIn.add(player); // add the player to the list
        return Collections.singletonMap(SUCCESS, true);
    }

    /**
     * get the stats of a player by name
     * 
     * @param name name of the player
     * @return the players stats
     */
    public Stats getStats(String name) {
        try {
            // get the player from the database
            RegisteredPlayer player = Databaseinterface.getInstance().retrievePlayer(name);
            if (player != null) { // player found
                return player.getStats(); // get their stats
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * get all logged in players
     * 
     * @return list of players
     */
    public List<Player> getAllPlayers() {
        return loggedIn;
    }

    /**
     * save all players in the database
     */
    public void savePlayers() {
        for (Player p : loggedIn) { // iterate over every player

            // save only the stats from registered players and the ones, who want to
            if (p instanceof RegisteredPlayer && p.isSavingStats()) {
                try {
                    // update the players stats in the database
                    Databaseinterface.getInstance().updatePlayer((RegisteredPlayer) p);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * validate a password, a password needs at least one uppercase letter, one
     * lowercase letter and one digit
     * 
     * @param password the password to be checked
     * @return if the password is valid
     */
    public static boolean checkPassword(String password) {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        boolean goodLength = false;
        char c;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasNum = true;
            } else if (Character.isUpperCase(c)) {
                hasCap = true;
            } else if (Character.isLowerCase(c)) {
                hasLow = true;
            } else if (password.length() < 7) {
                goodLength = true;
            }
            if (hasNum && hasCap && hasLow && goodLength) {
                return true;
            }
        }
        return false;
    }
}

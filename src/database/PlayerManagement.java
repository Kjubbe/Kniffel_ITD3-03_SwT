package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game.Player;
import game.RegisteredPlayer;
import game.Stats;

/**
 * manages players with the database
 * 
 * @author Kjell Treder
 */

public class PlayerManagement {

    private static PlayerManagement instance;
    /**
     * contains all logged in players
     */
    private List<Player> loggedIn = new ArrayList<>();

    /**
     * private constructor prevents external instantiation, the PlayerManagement can
     * be instantiated with getInstance
     */
    private PlayerManagement() {
        // empty
    }

    /**
     * get the instance of this class, there can only be one instance at a time
     * (singleton)
     * 
     * @return the current instance, or a new instance, if there is none
     */
    public static PlayerManagement getInstance() {
        if (instance == null) {
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
    public boolean login(String name, String password, boolean saveStats) {
        try {
            RegisteredPlayer player = Databaseinterface.getInstance().retrievePlayer(name);
            if (player != null && password.equals(player.getPassword())) {
                if (saveStats) {
                    player.saveStats();
                }
                return addPlayer(player);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * register with a name and password
     * 
     * @param name      name of the player
     * @param password  password of the player
     * @param saveStats if the stats should be saved after the game
     * @return the player object if found
     */
    public boolean register(String name, String password, boolean saveStats) {
        try {
            RegisteredPlayer player = Databaseinterface.getInstance().retrievePlayer(name);
            if (player == null) {
                player = new RegisteredPlayer(name, password);
                boolean result = Databaseinterface.getInstance().savePlayer(player);
                if (saveStats) {
                    player.saveStats();
                }
                // if adding the player failed, remove the local player
                if (!addPlayer(player) && result) {
                    logout(name);
                    addPlayer(player); // add the logged in player
                }
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * remove a player by logging out
     * 
     * @param name name of the player loggin out
     * @return if successful
     */
    public boolean logout(String name) {
        for (Player p : loggedIn) {
            if (p.getName().equals(name)) {
                loggedIn.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     * the user can continue as a guest
     * 
     * @param name player name
     */
    public boolean playAsGuest(String name) {
        return addPlayer(new Player(name));
    }

    /**
     * checks if the player name is unique. if that is the case, the player is added
     * to the list
     * 
     * @param player player object to be checked
     * @return if unique
     */
    private boolean addPlayer(Player player) {
        for (Player p : loggedIn) {
            if (p.getName().equals(player.getName())) {
                return false;
            }
        }
        loggedIn.add(player);
        return true;
    }

    /**
     * get the stats of a player by name
     * 
     * @param name name of the player
     * @return the players stats
     */
    public Stats getStats(String name) {
        try {
            RegisteredPlayer player = Databaseinterface.getInstance().retrievePlayer(name);
            if (player != null) {
                return player.getStats();
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
}

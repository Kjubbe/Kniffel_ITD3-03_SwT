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
 * manages players inside the database
 * 
 * @author Kjell Treder
 */

public class PlayerManagement {

    private static PlayerManagement instance;

    /**
     * contains all logged in players
     */
    private List<Player> loggedIn = new ArrayList<>();

    public static final int MAX_PLAYERS = 8;
    private static final String MAX_REACHED = "Maximale Anzahl an Spielern erreicht.";
    private static final String PLAYER_ALREADY_ADDED = "Spieler bereits hinzugefügt";
    private static final String SUCCESS = "Spieler wurde hinzugefügt.";
    private static final String ERROR = "Es ist ein Fehler aufgetreten.";

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
    public Map<String, Boolean> login(String name, String password, boolean saveStats) {
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
            RegisteredPlayer player = Databaseinterface.getInstance().retrievePlayer(name);
            if (player == null) {
                player = new RegisteredPlayer(name, password);
                if (saveStats) {
                    player.saveStats();
                }

                boolean saved = Databaseinterface.getInstance().savePlayer(player);

                // if adding the player failed, remove the local player
                Map<String, Boolean> res = addPlayer(player);
                if (res.containsValue(false) && saved) {
                    logout(name);
                    res = addPlayer(player);
                }
                return res; // add the logged in player
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
     * @return if successful
     */
    public Map<String, Boolean> playAsGuest(String name) {
        return addPlayer(new Player(name));
    }

    /**
     * checks if the player name is unique. if that is the case, the player is added
     * to the list
     * 
     * @param player player object to be checked
     * @return if unique
     */
    private Map<String, Boolean> addPlayer(Player player) {
        if (loggedIn.size() >= MAX_PLAYERS) {
            return Collections.singletonMap(MAX_REACHED, false);
        }
        for (Player p : loggedIn) {
            if (p.getName().equals(player.getName())) {
                return Collections.singletonMap(PLAYER_ALREADY_ADDED, false);
            }
        }
        loggedIn.add(player);
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

    /**
     * save all players in the database
     */
    public void savePlayers() {
        for (Player p : loggedIn) {
            if (p instanceof RegisteredPlayer && p.isSavingStats()) {
                try {
                    Databaseinterface.getInstance().savePlayer((RegisteredPlayer) p);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

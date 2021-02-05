package game;

/**
 * registered player, inherits from player, but stores a password
 * 
 * @author Kjell Treder
 *
 */

public class RegisteredPlayer extends Player {

    /**
     * contains the password of this player
     */
    private String password;

    /**
     * constructor, calls the super constructor and sets the password
     * 
     * @param n  name
     * @param pw password
     */
    public RegisteredPlayer(String name, String password) {
        super(name);
        this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
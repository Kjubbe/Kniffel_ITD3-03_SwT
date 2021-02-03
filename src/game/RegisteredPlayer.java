package game;

/**
 * registered player, inherits from player, stores a password
 * 
 * @author Kjell Treder
 *
 */

public class RegisteredPlayer extends Player {

    // password of this player
    private String password;

    /**
     * Constructor, gives a name and password, assigns a stat and a card
     * 
     * @param n  name
     * @param pw password
     */
    public RegisteredPlayer(String n, String pw) {
        super(n);
        this.password = pw;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
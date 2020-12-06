
import game.Game;
import game.Player;
import java.util.ArrayList;
import java.util.List;
import view.GameView;
import view.StartScreenView;
import view.LoginScreenView;
import view.StatistikDialogView;

/**
 * Main
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public class Main {

	/**
	 * Main method
	 * 
	 * @param args command parameters
	 */
	public static void main(String[] args) {
		System.out.println("Hello World"); // :)
		// TODO
                // scur scur 
                new GameView().setVisible(true);
                new LoginScreenView().setVisible(true);
                new StatistikDialogView().setVisible(true);
                
		// scur scur
                //StartScreenView start = new StartScreenView();
               
	}
}

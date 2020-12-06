
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
                
                List<Player> testlist = new ArrayList<Player>();
                testlist.add(new Player("Gustav"));
                testlist.add(new Player("Gerhart"));
                testlist.add(new Player("Günter"));
                testlist.add(new Player("Herbert"));
                testlist.add(new Player("Hubert"));
                testlist.add(new Player("Heinrich"));
                byte maxG = 5;
                Game test = new Game(false, false, maxG, testlist);
                
                
                GameView scurTest = new GameView(test);
                scurTest.setVisible(true);
                //new LoginScreenView().setVisible(true);
                
		// scur scur
                //StartScreenView start = new StartScreenView();
               
	}
}

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import database.Databaseinterface;
import game.RegisteredPlayer;

/**
 * testing class for testing main - use seeds for testing
 * 
 * @author Kjell Treder
 */

public class DatabaseinterfaceTest {

    /**
     * setup before each method
     */
    @Before
    public void setup() {
        // setup goes here
    }

    /**
     * test
     */
    @Test
    public void test() {
        try {
            RegisteredPlayer player;
            boolean result;

            // test: read a non existing player
            player = Databaseinterface.getInstance().readPlayer("Herbert");
            assertNull(player);

            // test: read null
            player = Databaseinterface.getInstance().readPlayer(null);
            assertNull(player);

            // test: delete a non existing player
            player = new RegisteredPlayer("Karin", "pw123");
            result = Databaseinterface.getInstance().deletePlayer(player);
            assertFalse(result);

            // test: delete null
            result = Databaseinterface.getInstance().deletePlayer(null);
            assertFalse(result);

            // test: save a player without stats
            result = Databaseinterface.getInstance().savePlayer(player);
            assertFalse(result);

            // test: save null
            result = Databaseinterface.getInstance().savePlayer(null);
            assertFalse(result);

            // test: save a non existing player with stats
            player.assignStats();
            result = Databaseinterface.getInstance().savePlayer(player);
            assertTrue(result);

            // test: save another player with stats and rounds played
            RegisteredPlayer player2 = new RegisteredPlayer("Herbert", "passwort");
            player2.assignStats();
            player2.getStats().increaseRoundsPlayed();
            result = Databaseinterface.getInstance().savePlayer(player2);
            assertTrue(result);

            // test: save another player with stats
            RegisteredPlayer player3 = new RegisteredPlayer("Mariella", "zrzhghrzegzher");
            player3.assignStats();
            result = Databaseinterface.getInstance().savePlayer(player3);
            assertTrue(result);

            // test: read a saved player
            player = Databaseinterface.getInstance().readPlayer("Karin");
            assertNotNull(player);
            assertTrue(player.getName().equals("Karin"));
            assertTrue(player.getPassword().equals("pw123"));
            assertEquals(0, player.getStats().getPoints());
            assertEquals(0, player.getStats().getGamesPlayed());

            // test: save the player again, but with points
            player.getStats().increasePoints(1000);
            result = Databaseinterface.getInstance().savePlayer(player);
            assertTrue(result);

            // test: read the added points from the player
            player = Databaseinterface.getInstance().readPlayer("Karin");
            assertEquals(1000, player.getStats().getPoints());

            // test: delete all players
            result = Databaseinterface.getInstance().deletePlayer(player);
            assertTrue(result);
            result = Databaseinterface.getInstance().deletePlayer(player2);
            assertTrue(result);
            result = Databaseinterface.getInstance().deletePlayer(player3);
            assertTrue(result);

            // safety tests:
            player = Databaseinterface.getInstance().readPlayer("Herbert");
            assertNull(player);
            player = Databaseinterface.getInstance().readPlayer("Karin");
            assertNull(player);
            player = Databaseinterface.getInstance().readPlayer("Mariella");
            assertNull(player);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
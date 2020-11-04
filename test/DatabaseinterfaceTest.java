import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import database.Databaseinterface;
import game.RegisteredPlayer;
import game.Stats;

/**
 * testing class for testing the databaseinterface
 * 
 * @author Kjell Treder
 */

public class DatabaseinterfaceTest {
    private final List<RegisteredPlayer> players = new ArrayList<>();
    private static final Random rng = new Random();
    private static boolean CLEANED_UP;

    /**
     * toggle cleaning the database before testing
     */
    private static boolean CLEAN_BEFORE = true;

    /**
     * toggle cleaning the database after testing
     */
    private static final boolean CLEAN_AFTER = true;

    /**
     * determines the amount of iterations for data generation
     */
    private static final int DATA_GEN_ITERATIONS = 5;

    /**
     * determines the amount of iterations for testing players
     */
    private static final int TEST_PLAYER_ITERATIONS = 20;

    /**
     * setup before each test
     */
    @Before
    public void setup() {
        // add players
        players.addAll(Arrays.asList(new RegisteredPlayer("Karin", "pw123"),
                new RegisteredPlayer("Marvin1337", "zUflldF"), new RegisteredPlayer("Dodo", "iHkUt"),
                new RegisteredPlayer("Tessa5", "dddddddd"), new RegisteredPlayer("Kathrina98", "12345"),
                new RegisteredPlayer("Wolly", "p"), new RegisteredPlayer("Zugtu488", ""),
                new RegisteredPlayer("Pfennato", "zuDaOpKa"), new RegisteredPlayer("Solariuuuu", "IhHbArKiEdPgUd")));
        for (RegisteredPlayer p : players) {
            p.assignStats(); // give each player stats
            generate(p); // generate data for the player
        }
    }

    /**
     * generate random stats for a chosen player
     * 
     * @param p the chosen one
     */
    private static void generate(RegisteredPlayer p) {
        if (p.getStats() != null) {
            System.out.println("Generating random data...");
            for (int i = 0; i < DATA_GEN_ITERATIONS; i++) { // 20 iterations
                Stats s = p.getStats();
                switch (rng.nextInt(6)) { // get a random player stat
                    case 0:
                        s.increaseDiceRolled();
                        break;
                    case 1:
                        s.increaseGamesPlayed();
                        break;
                    case 2:
                        s.increaseGamesWon();
                        break;
                    case 3:
                        s.increasePoints(rng.nextInt(100));
                        break;
                    case 4:
                        s.increaseRoundsPlayed();
                        break;
                    case 5:
                        s.increaseTimePlayed(rng.nextInt(800));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * test
     */
    @Test
    public void test() {
        try {

            if (CLEAN_BEFORE) { // delete if cleaning before testing
                delete();
                CLEAN_BEFORE = false;
            }

            for (RegisteredPlayer pl : players) { // save all players
                boolean result = Databaseinterface.getInstance().savePlayer(pl);
                if (CLEANED_UP) // if cleaned up, this should work
                    assertTrue(result);
            }

            if (CLEANED_UP) { // if cleaned up, there should be no players
                List<RegisteredPlayer> testList = Databaseinterface.getInstance().allPlayers();
                assertTrue(!testList.isEmpty());
            }

            RegisteredPlayer player;
            boolean result;
            double state;
            for (int i = 0; i < TEST_PLAYER_ITERATIONS; i++) {
                System.out.println("Testing next, " + (TEST_PLAYER_ITERATIONS - i) + " left...");
                state = rng.nextDouble();
                RegisteredPlayer chosenOne = players.get(rng.nextInt(players.size()));
                if (state < 0.21) { // 21% creating new player
                    RegisteredPlayer newP = new RegisteredPlayer("name" + rng.nextInt(99999),
                            "pw" + rng.nextInt(99999));
                    newP.assignStats();
                    generate(newP);
                    result = Databaseinterface.getInstance().savePlayer(newP);
                    if (result) { // if created, add to the list
                        players.add(newP);
                    } else { // player must be in the db
                        player = Databaseinterface.getInstance().retrievePlayer(newP.getName());
                        assertNotNull(player);
                    }
                } else if (state < 0.41) { // 20% removing player
                    result = Databaseinterface.getInstance().deletePlayer(chosenOne.getName());
                    players.remove(chosenOne);
                    assertTrue(result); // deleting player should work
                } else if (state < 0.6) { // 19% retrieving player
                    player = Databaseinterface.getInstance().retrievePlayer(chosenOne.getName());
                    assertNotNull(player);
                    if (CLEANED_UP) { // if cleaned up, every player should have consistent data over this test
                        assertTrue(player.getName().equals(chosenOne.getName()));
                        assertTrue(player.getPassword().equals(chosenOne.getPassword()));
                        Stats dbStats = chosenOne.getStats();
                        Stats pStats = player.getStats();
                        assertTrue(pStats.getDiceRolled() == dbStats.getDiceRolled());
                        assertTrue(pStats.getGamesPlayed() == dbStats.getGamesPlayed());
                        assertTrue(pStats.getGamesWon() == dbStats.getGamesWon());
                        assertTrue(pStats.getPoints() == dbStats.getPoints());
                        assertTrue(pStats.getRoundsPlayed() == dbStats.getRoundsPlayed());
                        assertTrue(Math.abs(pStats.getTimePlayed() - dbStats.getTimePlayed()) < 0.0001);
                    }

                } else if (state < 0.95) {// 35% updating player
                    generate(chosenOne);
                    result = Databaseinterface.getInstance().updatePlayer(chosenOne);
                    assertTrue(result);
                } else { // 5% nonsense and null
                    switch (rng.nextInt(6)) {
                        case 0: // null test: updating
                            result = Databaseinterface.getInstance().updatePlayer(null);
                            assertFalse(result);
                            break;

                        case 1: // null test: retrieving
                            player = Databaseinterface.getInstance().retrievePlayer(null);
                            assertNull(player);
                            break;

                        case 2: // null test: deleting
                            result = Databaseinterface.getInstance().deletePlayer(null);
                            assertFalse(result);
                            break;

                        case 3: // null test: saving
                            result = Databaseinterface.getInstance().savePlayer(null);
                            assertFalse(result);
                            break;

                        case 4: // nonsense test: deleting
                            result = Databaseinterface.getInstance().deletePlayer(rng.nextInt(64356) + "ii");
                            assertFalse(result);
                            break;

                        case 5: // nonsense test: retrieving
                            player = Databaseinterface.getInstance().retrievePlayer(rng.nextInt(64356) + "bb");
                            assertNull(player);
                            break;

                        default:
                            break;
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @After
    public void delete() {
        if (CLEAN_AFTER || CLEAN_BEFORE) { // clean up
            System.out.println("Cleaning up...");

            try {
                List<RegisteredPlayer> testList = Databaseinterface.getInstance().allPlayers();
                Databaseinterface.getInstance().reset(); // reset all players

                testList = Databaseinterface.getInstance().allPlayers();
                assertTrue(testList.isEmpty()); // no players left
                CLEANED_UP = true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            CLEANED_UP = false;
        }

    }
}
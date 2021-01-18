package view;

import game.Game;
import game.Player;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;

import database.PlayerManagement;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author simeonmurzin
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        this.setTitle("Knifflig - Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
        maxRoundsSelector.setModel(spinnerModel);
        assistantWantedCheckBox.setSelected(true);
        autocompleteWantedCheckBox.setSelected(true);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        updatePlayers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setBackground(new java.awt.Color(41, 128, 185));
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        maxRoundsSelector = new javax.swing.JSpinner();
        javax.swing.JLabel maxRoundsLabel = new javax.swing.JLabel();
        addPlayerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListOfPlayers = new javax.swing.JList<>();
        JListOfPlayers.setMaximumSize(JListOfPlayers.getPreferredSize());
        JListOfPlayers.setMinimumSize(JListOfPlayers.getPreferredSize());
        StartGameButton = new javax.swing.JButton();
        assistantWantedCheckBox = new javax.swing.JCheckBox();
        autocompleteWantedCheckBox = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE));
        jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE));

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE));
        jDialog2Layout.setVerticalGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE));

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE));
        jDialog3Layout.setVerticalGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE));


        jPanel1.setToolTipText("");

        maxRoundsLabel.setText("Runden werden gespielt");
        maxRoundsLabel.setToolTipText("");

        addPlayerButton.setText("Spieler hinzufügen");
        addPlayerButton.setToolTipText("");
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });

        JListOfPlayers.setModel(playerList);
        jScrollPane1.setViewportView(JListOfPlayers);
        JListOfPlayers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JListOfPlayers.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                                String name = JListOfPlayers.getSelectedValue().getName();
                                PlayerManagement.getInstance().logout(name);
                                updatePlayers();
                        }
                }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(106, 106, 106).addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addComponent(addPlayerButton)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(maxRoundsSelector, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maxRoundsLabel)))
                        .addContainerGap(93, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(addPlayerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(maxRoundsSelector, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(maxRoundsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
                        .addGap(8, 8, 8)));

        StartGameButton.setText("Spiel Starten");
        StartGameButton.setToolTipText("");
        StartGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGameButtonActionPerformed(evt);
            }
        });

        assistantWantedCheckBox.setText("Assistent nutzen");
        assistantWantedCheckBox.setToolTipText("");
        assistantWantedCheckBox.setEnabled(false);
        autocompleteWantedCheckBox.setText("Automatisch ausfüllen");
        autocompleteWantedCheckBox.setToolTipText("");
        autocompleteWantedCheckBox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                autocompleteWantedCheckBoxActionPerformed(evt);
                }
            });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(140, 140, 140).addComponent(autocompleteWantedCheckBox)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup().addGap(140, 140, 140).addComponent(assistantWantedCheckBox)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(StartGameButton))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                layout.createSequentialGroup().addGap(35, 35, 35)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 83, Short.MAX_VALUE)))
                                .addGap(23, 23, 23)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(72, 72, 72)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assistantWantedCheckBox).addComponent(autocompleteWantedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StartGameButton).addGap(44, 44, 44)));

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>

    private void StartGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        maxRounds = (int) maxRoundsSelector.getValue();
        assistantWanted = assistantWantedCheckBox.isSelected();
        autocompleteWanted = autocompleteWantedCheckBox.isSelected();
        if (playerList.size() < 2) {
            JOptionPane.showMessageDialog(null,
                    "Man braucht min. zwei Spieler, um das Spiel zu starten.", "Zu wenig Spieler",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.setVisible(false);
        System.out.println("assistand" + assistantWanted);
        System.out.println("auto" + autocompleteWanted);
        System.out.println("maxRounds:" + maxRounds);
        System.out.println("playerList" + playerList);

        // new game.Game(a=assistanWanted);
        // addPlayersToGame(new game.Game(s, pw, assistantWanted, NORMAL, WIDTH, WIDTH,
        // h));
        // int maxPlayers = length();
        System.out.println(pM.getAllPlayers().size() + "Gaming");
        Game game = new Game(autocompleteWanted, assistantWanted, maxRounds, pM.getAllPlayers());

        new GameView(game).setVisible(true);
        this.setVisible(false);

    }

    public static void updatePlayers() {
        playerList.removeAllElements();
        playerList.addAll(pM.getAllPlayers());
    }

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {
            new LoginScreenView().setVisible(true);

    }
    
    private void autocompleteWantedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (autocompleteWantedCheckBox.isSelected()) {
                assistantWantedCheckBox.setSelected(true);
               assistantWantedCheckBox.setEnabled(false);     
       } else {
        assistantWantedCheckBox.setEnabled(true);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JList<Player> JListOfPlayers;
    private javax.swing.JButton StartGameButton;
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JCheckBox assistantWantedCheckBox;
    private javax.swing.JCheckBox autocompleteWantedCheckBox;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner maxRoundsSelector;
    // End of variables declaration

    private int maxRounds;
    static DefaultListModel<Player> playerList = new DefaultListModel<Player>();
    private boolean assistantWanted;
    private boolean autocompleteWanted;
    LinkedList stringList = new LinkedList<String>();
    static PlayerManagement pM = PlayerManagement.getInstance();

}

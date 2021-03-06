/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import game.Card;
import game.Game;
import game.Player;

/**
 * shows the playercard in a new window. the playercard shows the chosen values
 * for the player referenced
 *
 * @author hanne
 */
public class PlayerCard extends javax.swing.JFrame {

    /**
     * reference to the game
     */
    private Game game;

    /**
     * reference to the player
     */
    private Player player;

    /**
     * Creates new form PlayerCard
     * 
     * @param game reference to the game
     * @param player reference to the player
     */
    public PlayerCard(Game game, Player player) {
        this.game = game;
        this.player = player;
        this.setLocationRelativeTo(null);
        initComponents();
        this.setTitle("Spielerkarte");
        playercardName.setText("Spielerkarte von " + player.getName());
        tableSetFieldNames();
        tableSetPoints();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playercardScrollPane = new javax.swing.JScrollPane();
        playercard = new javax.swing.JTable();
        playercardName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        playercard.setBackground(new java.awt.Color(55, 55, 55));
        playercard.setFont(new java.awt.Font("Calibri Light", 2, 14)); // NOI18N
        playercard.setForeground(new java.awt.Color(255, 255, 255));
        playercard
                .setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][] { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 },
                                { "Zwischensumme:", 0 }, { "Bonus bei min. 63:", 0 }, { "Gesamter erster Teil:", 0 },
                                { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 },
                                { "Gesamter erster Teil:", 0 }, { "Gesamter zweiter Teil:", 0 }, { "Gesamtsumme", 0 } },
                        new String[] { "", "Punktzahl" }));
        playercard.setToolTipText("Spielerkarte");
        playercard.setFocusCycleRoot(true);
        playercard.setName(""); // NOI18N
        playercard.setRowHeight(25);
        playercardScrollPane.setViewportView(playercard);

        playercardName.setText("Spielkarte von ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(playercardName).addComponent(playercardScrollPane,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playercardName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playercardScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
                                javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * setting the fieldnames into the playercard
     */
    private void tableSetFieldNames() {
        for (int i = 0; i < 6; i++) {
            playercard.setValueAt(Card.FIELD_NAMES[i], i, 0);
        }
        for (int j = 6; j < 13; j++) {
            playercard.setValueAt(Card.FIELD_NAMES[j], j + 3, 0);
        }
    }

    /**
     * setting the points into the playercard
     */
    private void tableSetPoints() {
        for (int i = 0; i < 6; i++) {
            if (player.getCard().allFields[i].isCrossed()) {
                playercard.setValueAt("---", i, 1);
            } else if (!player.getCard().allFields[i].isOpen()) {
                playercard.setValueAt("gewählt: " + player.getCard().allFields[i].getChosenValue(), i, 1);

            }

        }
        for (int j = 6; j < 13; j++) {

            if (player.getCard().allFields[j].isCrossed()) {
                playercard.setValueAt("---", j + 3, 1);
            } else if (!player.getCard().allFields[j].isOpen()) {
                playercard.setValueAt("gewählt: " + player.getCard().allFields[j].getChosenValue(), j + 3, 1);

            }

        }
        playercard.setValueAt(player.getCard().getPart1(false), 6, 1); // Part 1
        playercard.setValueAt(player.getCard().getPart1(true), 8, 1); // Part 1 + Bonus
        playercard.setValueAt(player.getCard().getPart1(true), 16, 1); // Part 1
        playercard.setValueAt(player.getCard().getPart2(), 17, 1); // Part 2
        playercard.setValueAt(player.getCard().getTotal(), 18, 1); // Totals
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable playercard;
    private javax.swing.JLabel playercardName;
    private javax.swing.JScrollPane playercardScrollPane;
    // End of variables declaration//GEN-END:variables
}

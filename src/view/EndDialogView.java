/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import game.Game;

import javax.swing.table.DefaultTableModel;

/**
 * end dialog for winning a game. this dialog is shown at the end of a game and
 * shows the points of all players. it also displays the wins, if this is the
 * last game
 * 
 * @author Rasmus Hildebrand
 */
public class EndDialogView extends javax.swing.JFrame {

    /**
     * true, if the referenced game is the last game. in this case, the amount of
     * won games is shown too
     */
    private boolean last;

    /**
     * Creates new form EndDialogView
     */
    public Game game;

    /**
     * constructor creates a new dialog
     * 
     * @param game reference to the game
     * @param last if this is the last game
     */
    public EndDialogView(Game game, boolean last) {
        this.game = game;
        this.last = last;
        this.setVisible(true);
        this.setTitle("Zusammenfassung");
        this.setLocationRelativeTo(null);
        initComponents();

        // winnerLabel.setText(game.winner.getName() + " hat das Spiel gewonnen!");
        // auskommentiert, da es ohne gewinner noch fehlermeldung gibt

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        if (this.last) {
            winnerLabel.setText("Das Spiel ist vorbei!");
            for (int i = 0; i < game.players.size(); i++) {
                model.addRow(new Object[] { game.getPlayerAt(i).getName(), game.getPlayerAt(i).getPoints(),
                        game.getPlayerAt(i).getWins() });
            }
            jButton1.setText("Hauptmenü");
        } else {
            winnerLabel.setText("Die Runde ist vorbei!");
            for (int i = 0; i < game.players.size(); i++) {
                model.addRow(new Object[] { game.getPlayerAt(i).getName(), game.getPlayerAt(i).getPoints() });
            }
            jButton1.setText("Nächste Runde");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        spielerTabelle = new javax.swing.JTable();
        winnerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");
        if (this.last) {
            spielerTabelle
                    .setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
                                    { null, null, null }, { null, null, null }, { null, null, null },
                                    { null, null, null }, { null, null, null } },
                            new String[] { "Title 1", "Title 2", "Title 3" }));
            jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

            }, new String[] { "Spieler", "Punkte diese Runde", "Siege" }));
        } else {
            spielerTabelle
                    .setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },
                                    { null, null }, { null, null }, { null, null }, { null, null } },
                            new String[] { "Title 1", "Title 2" }));
            jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

            }, new String[] { "Spieler", "Punkte" }));
        }

        jScrollPane2.setViewportView(spielerTabelle);

        if (this.last) {
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        }

        winnerLabel.setText("hat das Spiel gewonnen!");

        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(winnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(99, 99, 99))))
                .addGroup(layout
                        .createSequentialGroup().addGap(182, 182, 182).addComponent(jButton1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addComponent(winnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(7, 7, 7)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * disposes this dialog. creates a new opening screen, when this game is the
     * last
     * 
     * @param evt the event
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        if (this.last) {
            new OpeningScreen();
            game.nextGame();
        }
        this.dispose();
    }// GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable spielerTabelle;
    private javax.swing.JLabel winnerLabel;
    // End of variables declaration//GEN-END:variables
}

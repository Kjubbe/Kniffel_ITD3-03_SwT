/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import game.Stats;
import database.PlayerManagement;

/**
 * the opening screen is the first screen of the software
 * 
 * @author simeonmurzin
 */
public class OpeningScreen extends javax.swing.JFrame {

    /**
     * reference to the playermanagement
     */
    private static PlayerManagement pM;

    /**
     * constructor inits components
     */
    public OpeningScreen() {
        this.setResizable(false);
        initComponents();
        pM = PlayerManagement.getInstance();
        this.ErrorLabel.setVisible(false);
        this.setTitle("Knifflig - Start");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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

        panel1 = new java.awt.Panel();
        newGameButton = new javax.swing.JButton();
        playerNameTextField = new javax.swing.JTextField();
        showStatsButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ErrorLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(41, 128, 185));

        panel1.setBackground(new java.awt.Color(41, 128, 185));

        newGameButton.setText("Neues Spiel");
        newGameButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        playerNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerNameTextField.setText("Spielername");
        playerNameTextField.setMaximumSize(new java.awt.Dimension(87, 26));
        playerNameTextField.setMinimumSize(new java.awt.Dimension(87, 26));

        showStatsButton.setText("OK");
        showStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStatsButtonActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Zeige Statistik für");

        ErrorLabel.setBackground(new java.awt.Color(255, 255, 255));
        ErrorLabel.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        ErrorLabel.setForeground(new java.awt.Color(236, 240, 241));
        ErrorLabel.setText("Spieler nicht gefunden.");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 240, 241));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Knifflig");

        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Das Spiel");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        panel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panel1Layout.createSequentialGroup().addGap(49, 49, 49).addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ErrorLabel)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(playerNameTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(showStatsButton)))
                                        .addGap(0, 55, Short.MAX_VALUE)))
                        .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        panel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(newGameButton,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)));
        panel1Layout.setVerticalGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup().addGap(28, 28, 28).addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(newGameButton).addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showStatsButton).addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(ErrorLabel)
                        .addGap(60, 60, 60)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * invoked when stats should be shown by the show stats button. creates a new
     * dialog showing the stats
     * 
     * @param evt
     */
    private void showStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_showStatsButtonActionPerformed
        String name = playerNameTextField.getText();
        Stats stats = pM.getStats(name);
        if (stats == null) {
            ErrorLabel.setVisible(true);
        } else {
            ErrorLabel.setVisible(false);
            new StatistikDialogView(stats, name);
        }
    }// GEN-LAST:event_showStatsButtonActionPerformed

    /**
     * invoked when a new game should be created by the new game button. disposes
     * this window and creates a new menu
     * 
     * @param evt the event
     */
    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newGameButtonActionPerformed
        new MenuView();
        this.dispose();
    }// GEN-LAST:event_newGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton newGameButton;
    private java.awt.Panel panel1;
    private javax.swing.JTextField playerNameTextField;
    private javax.swing.JButton showStatsButton;
    // End of variables declaration//GEN-END:variables
}

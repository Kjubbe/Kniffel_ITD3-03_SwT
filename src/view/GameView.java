/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import game.Card;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanne
 */
public class GameView extends javax.swing.JFrame  {

        
    
    /**
     * Creates new form GameView
     */
    public GameView() {
        initComponents();
        tableSetFieldNames();
        playercard.setToolTipText("PART2");
        playercard.setName(""); // NOI18N
        playercard.setRowHeight(20);
        jScrollPane2.setViewportView(playercard);

        

        crossFieldButton.setText("Feld streichen");
        crossFieldButton.setEnabled(false);
        crossFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossFieldButtonActionPerformed(evt);
            }
        });
        
        
        
            
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        playercard = new javax.swing.JTable();
        crossFieldButton = new javax.swing.JButton();
        chooseFieldButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        ExitButton = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        Player1Button = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Player2Button = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        Player4Button = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        Player3Button = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(21, 10, 22));
        setResizable(false);

        playercard.setBackground(new java.awt.Color(21, 20, 22));
        playercard.setFont(new java.awt.Font("Comic Sans MS", 2, 12)); // NOI18N
        playercard.setForeground(new java.awt.Color(255, 117, 139));
        playercard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {"Zwischensumme:", null},
                {"Bonus bei min. 63:", null},
                {"Gesamter erster Teil:", null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {"Gesamter erster Teil:", null},
                {"Gesamter zweiter Teil:", null},
                {"Endsumme:", null}
            },
            new String [] {
                "", "Punktzahl"
            }
        ));
        playercard.setToolTipText("playercard");
        playercard.setFocusCycleRoot(true);
        playercard.setName(""); // NOI18N
        playercard.setRowHeight(25);
        jScrollPane2.setViewportView(playercard);

        crossFieldButton.setText("Feld streichen");
        crossFieldButton.setEnabled(false);
        crossFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossFieldButtonActionPerformed(evt);
            }
        });

        chooseFieldButton.setText("Feld auswählen");
        chooseFieldButton.setEnabled(false);
        chooseFieldButton.setMaximumSize(new java.awt.Dimension(110, 32));
        chooseFieldButton.setMinimumSize(new java.awt.Dimension(110, 32));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        File.setText("Spiel");

        jMenuItem6.setText("Spiel pausieren");
        File.add(jMenuItem6);

        ExitButton.setText("Spiel abbrechen");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        File.add(ExitButton);

        jMenuItem7.setText("Spiel neustarten");
        File.add(jMenuItem7);

        jMenuBar1.add(File);

        Player1Button.setText("Spieler 1");
        Player1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1ButtonActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Spielerkarte anzeigen");
        Player1Button.add(jMenuItem4);

        jMenuItem3.setText("Spieler überspringen");
        Player1Button.add(jMenuItem3);

        jMenuItem1.setText("Spieler entfernen");
        Player1Button.add(jMenuItem1);

        jMenuBar1.add(Player1Button);

        Player2Button.setText("Spieler 2");
        Player2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player2ButtonActionPerformed(evt);
            }
        });

        jMenuItem8.setText("Spielerkarte anzeigen");
        Player2Button.add(jMenuItem8);

        jMenuItem9.setText("Spieler entfernen");
        Player2Button.add(jMenuItem9);

        jMenuItem10.setText("Spieler überspringen");
        Player2Button.add(jMenuItem10);

        jMenuBar1.add(Player2Button);

        Player4Button.setText("Spieler 4");
        Player4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player4ButtonActionPerformed(evt);
            }
        });

        jMenuItem14.setText("jMenuItem14");
        Player4Button.add(jMenuItem14);

        jMenuItem15.setText("jMenuItem15");
        Player4Button.add(jMenuItem15);

        jMenuItem16.setText("jMenuItem16");
        Player4Button.add(jMenuItem16);

        jMenuBar1.add(Player4Button);

        Player3Button.setText("Spieler 3");
        Player3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player3ButtonActionPerformed(evt);
            }
        });

        jMenuItem11.setText("Spielerkarte anzeigen");
        Player3Button.add(jMenuItem11);

        jMenuItem12.setText("Spieler überspringen");
        Player3Button.add(jMenuItem12);

        jMenuItem13.setText("jMenuItem13");
        Player3Button.add(jMenuItem13);

        jMenuBar1.add(Player3Button);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(chooseFieldButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(crossFieldButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(498, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFieldButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crossFieldButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("1");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crossFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossFieldButtonActionPerformed
            // TODO cross a selected field
            System.out.println("test");
    }//GEN-LAST:event_crossFieldButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ExitButtonActionPerformed

    private void Player1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player1ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player1ButtonActionPerformed

    private void Player2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player2ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player2ButtonActionPerformed

    private void Player4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player4ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player4ButtonActionPerformed

    private void Player3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player3ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player3ButtonActionPerformed

    /**
     * Setting the fieldnames into the playercard
     */
    private void tableSetFieldNames() {
        for (int i = 0; i < 6; i++) {
            playercard.setValueAt(Card.fields[i].getName(), i, 0);
        }
        for (int j = 6; j < 13; j++) {
            playercard.setValueAt(Card.fields[j].getName(), j+3, 0);
        }
    }
    
    /**
     * Setting the points into the playercard
     */
    private void tableSetPoints() {
        // TODO show the points of the choosen fields
        //playercard.setValueAt(Card.getPart1(), 9, 1);     // Part 1
        //playercard.setValueAt(Card.getPart1(), 17, 1);    // Part 1
        //playercard.setValueAt(Card.getPart2(), 18, 1);    // Part 2
        //playercard.setValueAt(Card.getTotal(), 19, 1);    // Totals

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExitButton;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Player1Button;
    private javax.swing.JMenu Player2Button;
    private javax.swing.JMenu Player3Button;
    private javax.swing.JMenu Player4Button;
    private javax.swing.JButton chooseFieldButton;
    private javax.swing.JButton crossFieldButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable playercard;
    // End of variables declaration//GEN-END:variables
}

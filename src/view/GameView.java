/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import game.Card;

import game.Game;
import game.Player;
import game.Host;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanne
 */
public class GameView extends javax.swing.JFrame {

    //private Player playerWithTurn;
    /**
     * Creates new form GameView
     */
    public GameView() {
        initComponents();
        tableSetFieldNames();
        showDie();
        //tableSetPoints();
        playercard.setRowHeight(25);
        playercardScrollPane.setViewportView(playercard);
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
        availableDiece = new javax.swing.JPanel();
        dice1 = new javax.swing.JLabel();
        dice2 = new javax.swing.JLabel();
        dice3 = new javax.swing.JLabel();
        dice4 = new javax.swing.JLabel();
        dice5 = new javax.swing.JLabel();
        choosenDiece = new javax.swing.JPanel();
        dice7 = new javax.swing.JLabel();
        dice6 = new javax.swing.JLabel();
        dice8 = new javax.swing.JLabel();
        dice9 = new javax.swing.JLabel();
        dice10 = new javax.swing.JLabel();
        finishTurnButton = new javax.swing.JButton();
        rollButton = new javax.swing.JButton();
        playercardOf = new javax.swing.JTextField();
        dieSeperation = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        OptionsButton = new javax.swing.JMenu();
        pauseGame = new javax.swing.JMenuItem();
        restartGame = new javax.swing.JMenuItem();
        quitGame = new javax.swing.JMenuItem();
        Player1Button = new javax.swing.JMenu();
        showPlayer1Card = new javax.swing.JMenuItem();
        skipPlayer1 = new javax.swing.JMenuItem();
        removePlayer1 = new javax.swing.JMenuItem();
        Player2Button = new javax.swing.JMenu();
        showPlayer2Card = new javax.swing.JMenuItem();
        skipPlayer2 = new javax.swing.JMenuItem();
        removePlayer2 = new javax.swing.JMenuItem();
        Player3Button = new javax.swing.JMenu();
        showPlayer3Card = new javax.swing.JMenuItem();
        skipPlayer3 = new javax.swing.JMenuItem();
        removePlayer3 = new javax.swing.JMenuItem();
        Player4Button = new javax.swing.JMenu();
        showCardPlayer4 = new javax.swing.JMenuItem();
        skipPlayer4 = new javax.swing.JMenuItem();
        removePlayer4 = new javax.swing.JMenuItem();

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
                {"Gesamtsumme", null}
            },
            new String [] {
                "", "Punktzahl"
            }
        ));
        playercard.setToolTipText("Spielerkarte");
        playercard.setFocusCycleRoot(true);
        playercard.setFocusable(false);
        playercard.setName(""); // NOI18N
        playercard.setRowHeight(25);
        playercardScrollPane.setViewportView(playercard);

        dice1.setText("dice1");
        dice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice1MouseClicked(evt);
            }
        });

        dice2.setText("dice2");
        dice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice2MouseClicked(evt);
            }
        });

        dice3.setText("dice3");
        dice3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice3MouseClicked(evt);
            }
        });

        dice4.setText("dice4");
        dice4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice4MouseClicked(evt);
            }
        });

        dice5.setText("dice5");
        dice5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout availableDieceLayout = new javax.swing.GroupLayout(availableDiece);
        availableDiece.setLayout(availableDieceLayout);
        availableDieceLayout.setHorizontalGroup(
            availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableDieceLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(dice1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dice2)
                .addGap(128, 128, 128))
            .addGroup(availableDieceLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(dice3)
                .addGap(121, 121, 121)
                .addComponent(dice4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dice5)
                .addGap(56, 56, 56))
        );
        availableDieceLayout.setVerticalGroup(
            availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableDieceLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dice1)
                    .addComponent(dice2))
                .addGap(70, 70, 70)
                .addGroup(availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dice3)
                    .addComponent(dice4)
                    .addComponent(dice5))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        dice7.setText("dice7");
        dice7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice7MouseClicked(evt);
            }
        });

        dice6.setText("dice6");
        dice6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice6MouseClicked(evt);
            }
        });

        dice8.setText("dice8");
        dice8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice8MouseClicked(evt);
            }
        });

        dice9.setText("dice9");
        dice9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice9MouseClicked(evt);
            }
        });

        dice10.setText("dice10");
        dice10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout choosenDieceLayout = new javax.swing.GroupLayout(choosenDiece);
        choosenDiece.setLayout(choosenDieceLayout);
        choosenDieceLayout.setHorizontalGroup(
            choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosenDieceLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(dice6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dice7)
                .addGap(128, 128, 128))
            .addGroup(choosenDieceLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(dice8)
                .addGap(121, 121, 121)
                .addComponent(dice9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dice10)
                .addGap(56, 56, 56))
        );
        choosenDieceLayout.setVerticalGroup(
            choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosenDieceLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dice6)
                    .addComponent(dice7))
                .addGap(70, 70, 70)
                .addGroup(choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dice8)
                    .addComponent(dice9)
                    .addComponent(dice10))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        finishTurnButton.setText("Zug beenden");

        rollButton.setText("Würfeln");
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButtonActionPerformed(evt);
            }
        });

        playercardOf.setText("Spielerkarte von ");
        playercardOf.setToolTipText("Spielerkarte");
        playercardOf.setFocusable(false);
        playercardOf.setOpaque(false);

        dieSeperation.setBackground(new java.awt.Color(0, 0, 0));
        dieSeperation.setForeground(new java.awt.Color(0, 0, 0));
        dieSeperation.setDoubleBuffered(true);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        OptionsButton.setText("Optionen");

        pauseGame.setText("Spiel pausieren");
        pauseGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseGameActionPerformed(evt);
            }
        });
        OptionsButton.add(pauseGame);

        restartGame.setText("Spiel neustarten");
        restartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartGameActionPerformed(evt);
            }
        });
        OptionsButton.add(restartGame);

        quitGame.setText("Zurück zum Hauptmenü");
        quitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitGameActionPerformed(evt);
            }
        });
        OptionsButton.add(quitGame);

        jMenuBar1.add(OptionsButton);

        Player1Button.setText("Spieler 1");
        Player1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1ButtonActionPerformed(evt);
            }
        });

        showPlayer1Card.setText("Spielerkarte anzeigen");
        Player1Button.add(showPlayer1Card);

        skipPlayer1.setText("Spieler überspringen");
        Player1Button.add(skipPlayer1);

        removePlayer1.setText("Spieler entfernen");
        removePlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer1ActionPerformed(evt);
            }
        });
        Player1Button.add(removePlayer1);

        jMenuBar1.add(Player1Button);

        Player2Button.setText("Spieler 2");
        Player2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player2ButtonActionPerformed(evt);
            }
        });

        showPlayer2Card.setText("Spielerkarte anzeigen");
        Player2Button.add(showPlayer2Card);

        skipPlayer2.setText("Spieler überspringen");
        Player2Button.add(skipPlayer2);

        removePlayer2.setText("Spieler entfernen");
        removePlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer2ActionPerformed(evt);
            }
        });
        Player2Button.add(removePlayer2);

        jMenuBar1.add(Player2Button);

        Player3Button.setText("Spieler 3");
        Player3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player3ButtonActionPerformed(evt);
            }
        });

        showPlayer3Card.setText("Spielerkarte anzeigen");
        Player3Button.add(showPlayer3Card);

        skipPlayer3.setText("Spieler überspringen");
        Player3Button.add(skipPlayer3);

        removePlayer3.setText("Spieler entfernen");
        removePlayer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer3ActionPerformed(evt);
            }
        });
        Player3Button.add(removePlayer3);

        jMenuBar1.add(Player3Button);

        Player4Button.setText("Spieler 4");
        Player4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player4ButtonActionPerformed(evt);
            }
        });

        showCardPlayer4.setText("Spielerkarte anzeigen");
        showCardPlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCardPlayer4ActionPerformed(evt);
            }
        });
        Player4Button.add(showCardPlayer4);

        skipPlayer4.setText("Spieler überspringen");
        Player4Button.add(skipPlayer4);

        removePlayer4.setText("Spieler entfernen");
        removePlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer4ActionPerformed(evt);
            }
        });
        Player4Button.add(removePlayer4);

        jMenuBar1.add(Player4Button);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playercardScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(playercardOf))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dieSeperation)
                            .addComponent(availableDiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choosenDiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()

                        .addGap(96, 96, 96)
                        .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(finishTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(availableDiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(dieSeperation, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(choosenDiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finishTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playercardOf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playercardScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())

        );

        getAccessibleContext().setAccessibleName("1");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void crossFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossFieldButtonActionPerformed
            // TODO cross a selected field
            System.out.println("test");
    }//GEN-LAST:event_crossFieldButtonActionPerformed

    private void quitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitGameActionPerformed
        // Stop Game
        Host.stopGame();

    }//GEN-LAST:event_quitGameActionPerformed

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

    private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollButtonActionPerformed
        for (int i = 0; i < 6; i++) {
            if (Game.dice[i].isRollable()) {
                Game.dice[i].roll();
            }
        }
    }//GEN-LAST:event_rollButtonActionPerformed

    private void dice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice1MouseClicked
        dice1.setVisible(false);
        dice6.setVisible(true);
    }//GEN-LAST:event_dice1MouseClicked

    private void dice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice2MouseClicked
        dice2.setVisible(false);
        dice7.setVisible(true);

    }//GEN-LAST:event_dice2MouseClicked

    private void dice3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice3MouseClicked
        dice3.setVisible(false);
        dice8.setVisible(true);

    }//GEN-LAST:event_dice3MouseClicked

    private void dice4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice4MouseClicked
        dice4.setVisible(false);
        dice9.setVisible(true);
    }//GEN-LAST:event_dice4MouseClicked

    private void dice5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice5MouseClicked
        dice5.setVisible(false);
        dice10.setVisible(true);
    }//GEN-LAST:event_dice5MouseClicked

    private void dice6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice6MouseClicked
        dice6.setVisible(false);
        dice1.setVisible(true);
    }//GEN-LAST:event_dice6MouseClicked

    private void dice7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice7MouseClicked
        dice7.setVisible(false);
        dice2.setVisible(true);
    }//GEN-LAST:event_dice7MouseClicked

    private void dice8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice8MouseClicked
        dice8.setVisible(false);
        dice3.setVisible(true);
    }//GEN-LAST:event_dice8MouseClicked

    private void dice9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice9MouseClicked
        dice9.setVisible(false);
        dice4.setVisible(true);
    }//GEN-LAST:event_dice9MouseClicked

    private void dice10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice10MouseClicked
        dice10.setVisible(false);
        dice5.setVisible(true);
    }//GEN-LAST:event_dice10MouseClicked

    private void removePlayer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer3ActionPerformed
        Host.removePlayer(3);
    }//GEN-LAST:event_removePlayer3ActionPerformed

    private void showCardPlayer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCardPlayer4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showCardPlayer4ActionPerformed

    private void pauseGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseGameActionPerformed
        //Pause Game
        Host.pauseGame();
    }//GEN-LAST:event_pauseGameActionPerformed

    private void restartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartGameActionPerformed
        // Restart Game
        Host.restartGame();
    }//GEN-LAST:event_restartGameActionPerformed

    private void removePlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer1ActionPerformed
        // Remove Player
        Host.removePlayer(1);
    }//GEN-LAST:event_removePlayer1ActionPerformed

    private void removePlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer2ActionPerformed
        Host.removePlayer(2);
    }//GEN-LAST:event_removePlayer2ActionPerformed

    private void removePlayer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer4ActionPerformed
        Host.removePlayer(4);
    }//GEN-LAST:event_removePlayer4ActionPerformed


    /**
     * Setting the fieldnames into the playercard
     */
    private void tableSetFieldNames() {
        playercardOf.setText("Spielerkarte von " /*+ playerWithTurn.getName()*/);
        for (int i = 0; i < 6; i++) {
            playercard.setValueAt(Card.fieldnames[i], i, 0);
        }
        for (int j = 6; j < 13; j++) {
            playercard.setValueAt(Card.fieldnames[j], j + 3, 0);
        }
    }

    private void showDie() {
        if (Game.dice[0].isRollable()) {
            dice7.setVisible(false);
        } else {
            dice1.setVisible(false);
        }
        if (Game.dice[1].isRollable()) {
            dice6.setVisible(false);
        } else {
            dice2.setVisible(false);
        }
        if (Game.dice[2].isRollable()) {
            dice8.setVisible(false);
        } else {
            dice3.setVisible(false);
        }
        if (Game.dice[3].isRollable()) {
            dice9.setVisible(false);
        } else {
            dice4.setVisible(false);
        }
        if (Game.dice[4].isRollable()) {
            dice10.setVisible(false);
        } else {
            dice5.setVisible(false);
        }
    }

    /**
     * Setting the points into the playercard
     */
    /*
    private void tableSetPoints() {
        for (int i = 0; i < 6; i++) {
            if(Card.fields[i].isChosen()) playercard.setValueAt(Card.fields[i].getValue(), i, 1);
            if(Card.fields[i].isCrossed()) playercard.setValueAt("---", i, 1);
        }
        for (int j = 6; j < 13; j++) {
            if(Card.fields[j].isChosen()) { playercard.setValueAt(Card.fields[j].getValue(), j+3, 1);
            if(Card.fields[j].isCrossed()) playercard.setValueAt("---", j+3, 1);
        }
        playercard.setValueAt(Card.getPart1NoBonus(), 6, 1);     // Part 1
        playercard.setValueAt(Card.getPart1(), 8, 1);     // Part 1 + Bonus
        playercard.setValueAt(Card.getPart1(), 16, 1);    // Part 1
        playercard.setValueAt(Card.getPart2(), 17, 1);    // Part 2
        playercard.setValueAt(Card.getTotal(), 18, 1);    // Totals
    }
     */
    /**
     * show the avalibleDiece
     */
    public void showAvalibleDiece() {
        // TODO 
    }

    /**
     * show the choosenDiece
     */
    public void showChoosenDiece() {
        // TODO
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu OptionsButton;
    private javax.swing.JMenu Player1Button;
    private javax.swing.JMenu Player2Button;
    private javax.swing.JMenu Player3Button;
    private javax.swing.JMenu Player4Button;
    private javax.swing.JPanel availableDiece;
    private javax.swing.JPanel choosenDiece;
    private javax.swing.JLabel dice1;
    private javax.swing.JLabel dice10;
    private javax.swing.JLabel dice2;
    private javax.swing.JLabel dice3;
    private javax.swing.JLabel dice4;
    private javax.swing.JLabel dice5;
    private javax.swing.JLabel dice6;
    private javax.swing.JLabel dice7;
    private javax.swing.JLabel dice8;
    private javax.swing.JLabel dice9;
    private javax.swing.JSeparator dieSeperation;
    private javax.swing.JButton finishTurnButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTable playercard;
    private javax.swing.JTextField playercardOf;
    private javax.swing.JScrollPane playercardScrollPane;
    private javax.swing.JButton rollButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem pauseGame;
    private javax.swing.JTable playercard;
    private javax.swing.JMenuItem quitGame;
    private javax.swing.JMenuItem removePlayer1;
    private javax.swing.JMenuItem removePlayer2;
    private javax.swing.JMenuItem removePlayer3;
    private javax.swing.JMenuItem removePlayer4;
    private javax.swing.JMenuItem restartGame;
    private javax.swing.JMenuItem showCardPlayer4;
    private javax.swing.JMenuItem showPlayer1Card;
    private javax.swing.JMenuItem showPlayer2Card;
    private javax.swing.JMenuItem showPlayer3Card;
    private javax.swing.JMenuItem skipPlayer1;
    private javax.swing.JMenuItem skipPlayer2;
    private javax.swing.JMenuItem skipPlayer3;
    private javax.swing.JMenuItem skipPlayer4;
    // End of variables declaration//GEN-END:variables
}

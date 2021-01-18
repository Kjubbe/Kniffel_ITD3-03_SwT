/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import game.Card;
import game.Game;

/**
 *
 * @author hanne
 */
public class GameView extends javax.swing.JFrame {

    public Game game;

    public GameView(Game game) {
        this.game = game;
        this.setTitle("Knifflig - Game");
        initComponents();
        tableSetFieldNames();
        showDefaultDie();
    
        playercardOf.setText("Spielerkarte von " + game.currentPlayer.getName());
        counterLabel.setText(game.rolls + "/3");

        yourTurnLabel.setText(game.currentPlayer.getName() + ", du bist dran. Würfel jetzt!");
       
        player1Button.setVisible(false);
        player2Button.setVisible(false);
        player3Button.setVisible(false);
        player4Button.setVisible(false);
        player5Button.setVisible(false);
        player6Button.setVisible(false);
        player7Button.setVisible(false);
        player8Button.setVisible(false);

        for (int j = 0; j < game.players.size(); j++) {
            if (j == 0) {
                player1Button.setText(game.players.get(j).getName());
                player1Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer1Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer1Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer1.setText(game.players.get(j).getName() + " überspringen");
                removePlayer1.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 1) {
                player2Button.setText(game.players.get(j).getName());
                player2Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer2Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer2Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer2.setText(game.players.get(j).getName() + " überspringen");
                removePlayer2.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 2) {
                player3Button.setText(game.players.get(j).getName());
                player3Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer3Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer3Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer3.setText(game.players.get(j).getName() + " überspringen");
                removePlayer3.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 3) {
                player4Button.setText(game.players.get(j).getName());
                player4Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer4Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer4Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer4.setText(game.players.get(j).getName() + " überspringen");
                removePlayer4.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 4) {
                player5Button.setText(game.players.get(j).getName());
                player5Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer5Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer5Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer5.setText(game.players.get(j).getName() + " überspringen");
                removePlayer5.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 5) {
                player6Button.setText(game.players.get(j).getName());
                player6Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer6Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer6Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer6.setText(game.players.get(j).getName() + " überspringen");
                removePlayer6.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 6) {
                player7Button.setText(game.players.get(j).getName());
                player7Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer7Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer7Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer7.setText(game.players.get(j).getName() + " überspringen");
                removePlayer7.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 7) {
                player8Button.setText(game.players.get(j).getName());
                player8Button.setVisible(true);
                if (game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's') {
                    showPlayer8Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer8Card.setText(game.players.get(j).getName() + " Spielerkarte");
                }
                skipPlayer8.setText(game.players.get(j).getName() + " überspringen");
                removePlayer8.setText(game.players.get(j).getName() + " entfernen");
            }

        }
        
        playercard.setRowHeight(25);
        playercardScrollPane.setViewportView(playercard);

        this.setLocationRelativeTo(null);
    }

    /**
     * Creates new form GameView
     */
    /*public GameView() {
        initComponents();
        tableSetFieldNames();
        showDie();
        //tableSetPoints();
        playercard.setRowHeight(25);
        playercardScrollPane.setViewportView(playercard);
    }*/
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
        rollButton = new javax.swing.JButton();
        dieSeperation = new javax.swing.JSeparator();
        FeldStreichenButton = new javax.swing.JButton();
        FeldWaehlenButton = new javax.swing.JButton();
        yourTurnLabel = new javax.swing.JLabel();
        counterLabel = new javax.swing.JLabel();
        playercardOf = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        OptionsButton = new javax.swing.JMenu();
        restartGame = new javax.swing.JMenuItem();
        quitGame = new javax.swing.JMenuItem();
        player1Button = new javax.swing.JMenu();
        showPlayer1Card = new javax.swing.JMenuItem();
        skipPlayer1 = new javax.swing.JMenuItem();
        removePlayer1 = new javax.swing.JMenuItem();
        player2Button = new javax.swing.JMenu();
        showPlayer2Card = new javax.swing.JMenuItem();
        skipPlayer2 = new javax.swing.JMenuItem();
        removePlayer2 = new javax.swing.JMenuItem();
        player3Button = new javax.swing.JMenu();
        showPlayer3Card = new javax.swing.JMenuItem();
        skipPlayer3 = new javax.swing.JMenuItem();
        removePlayer3 = new javax.swing.JMenuItem();
        player4Button = new javax.swing.JMenu();
        showPlayer4Card = new javax.swing.JMenuItem();
        skipPlayer4 = new javax.swing.JMenuItem();
        removePlayer4 = new javax.swing.JMenuItem();
        player5Button = new javax.swing.JMenu();
        showPlayer5Card = new javax.swing.JMenuItem();
        skipPlayer5 = new javax.swing.JMenuItem();
        removePlayer5 = new javax.swing.JMenuItem();
        player6Button = new javax.swing.JMenu();
        showPlayer6Card = new javax.swing.JMenuItem();
        skipPlayer6 = new javax.swing.JMenuItem();
        removePlayer6 = new javax.swing.JMenuItem();
        player7Button = new javax.swing.JMenu();
        showPlayer7Card = new javax.swing.JMenuItem();
        skipPlayer7 = new javax.swing.JMenuItem();
        removePlayer7 = new javax.swing.JMenuItem();
        player8Button = new javax.swing.JMenu();
        showPlayer8Card = new javax.swing.JMenuItem();
        skipPlayer8 = new javax.swing.JMenuItem();
        removePlayer8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(21, 10, 22));
        setResizable(false);

        playercard.setBackground(new java.awt.Color(55, 55, 55));
        playercard.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        playercard.setForeground(new java.awt.Color(255, 255, 255));

        
         DefaultTableModel dft = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {"Zwischensumme:", 0},
                {"Bonus bei min. 63:", 0},
                {"Gesamter erster Teil:", 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {"Gesamter erster Teil:", 0},
                {"Gesamter zweiter Teil:", 0},
                {"Gesamtsumme", 0}
            },
            new String [] {
                "", "Punktzahl"
            }
        ) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                 if (column == 0 || (row >= 6 && row <= 8) || row >= 16) {
                     return false;
                 }
                 int i = row;
                 if (i > 5) {
                    i -= 3;
                    }
                if (game.currentPlayer.getCard().allFields[i].isCrossed() || game.currentPlayer.getCard().allFields[i].isChosen()) {
                     return false;
                }

               return !game.useAutocalc;
            }
         };

         if (!game.useAutocalc) {
            dft.addTableModelListener(new TableModelListener() {

                @Override
                public void tableChanged(TableModelEvent e) {
                    cellEdited(playercard.getSelectedRow(), playercard.getSelectedColumn());
                }
                
            });
         }

        playercard.setToolTipText("Spielerkarte");
        playercard.setFocusCycleRoot(true);
        playercard.setName(""); // NOI18N
        playercard.setRowHeight(25);
        playercard.putClientProperty("terminateEditOnFocusLost", true);
        playercard.setModel(dft);

        playercardScrollPane.setViewportView(playercard);

        dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/1.png"))); // NOI18N
        dice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice1MouseClicked(evt);
            }
        });

        dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/2.png"))); // NOI18N
        dice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice2MouseClicked(evt);
            }
        });

        dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/3.png"))); // NOI18N
        dice3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice3MouseClicked(evt);
            }
        });

        dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/4.png"))); // NOI18N
        dice4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice4MouseClicked(evt);
            }
        });

        dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/5.png"))); // NOI18N
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
                .addGap(100, 100, 100)
                .addGroup(availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(availableDieceLayout.createSequentialGroup()
                        .addComponent(dice3)
                        .addGap(121, 121, 121)
                        .addComponent(dice4)
                        .addGap(138, 138, 138)
                        .addComponent(dice5))
                    .addGroup(availableDieceLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(dice1)
                        .addGap(126, 126, 126)
                        .addComponent(dice2)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        availableDieceLayout.setVerticalGroup(
            availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableDieceLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice1)
                    .addComponent(dice2))
                .addGap(70, 70, 70)
                .addGroup(availableDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dice7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/2.png"))); // NOI18N
        dice7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice7MouseClicked(evt);
            }
        });

        dice6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/1.png"))); // NOI18N
        dice6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice6MouseClicked(evt);
            }
        });

        dice8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/3.png"))); // NOI18N
        dice8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice8MouseClicked(evt);
            }
        });

        dice9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/4.png"))); // NOI18N
        dice9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice9MouseClicked(evt);
            }
        });

        dice10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/5.png"))); // NOI18N
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
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice8)
                    .addGroup(choosenDieceLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(dice6)))
                .addGap(69, 69, 69)
                .addGroup(choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosenDieceLayout.createSequentialGroup()
                        .addComponent(dice9)
                        .addGap(123, 123, 123)
                        .addComponent(dice10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, choosenDieceLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(dice7)
                        .addGap(67, 67, 67)))
                .addGap(91, 91, 91))
        );
        choosenDieceLayout.setVerticalGroup(
            choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosenDieceLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice7)
                    .addComponent(dice6))
                .addGap(70, 70, 70)
                .addGroup(choosenDieceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28))
        );

        rollButton.setText("Würfeln");
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButtonActionPerformed(evt);
            }
        });

        dieSeperation.setBackground(new java.awt.Color(0, 0, 0));
        dieSeperation.setForeground(new java.awt.Color(0, 0, 0));
        dieSeperation.setDoubleBuffered(true);

        FeldStreichenButton.setText("Feld streichen");
        FeldStreichenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeldStreichenButtonActionPerformed(evt);
            }
        });

        FeldWaehlenButton.setText("Feld auswählen");
        if (!game.useAutocalc) {
            FeldWaehlenButton.setEnabled(false);
        }
        FeldWaehlenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeldWaehlenButtonActionPerformed(evt);
            }
        });

        yourTurnLabel.setText("Beispielname, du bist dran. Würfel jetzt!");

        counterLabel.setText("0/3");

        playercardOf.setText("Spielerkarte von ");
        playercardOf.setToolTipText("Spielerkarte");

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        OptionsButton.setText("Optionen");

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

        player1Button.setText("Spieler 1");
        player1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ButtonActionPerformed(evt);
            }
        });

        showPlayer1Card.setText("Spielerkarte anzeigen");
        showPlayer1Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer1CardActionPerformed(evt);
            }
        });
        player1Button.add(showPlayer1Card);

        skipPlayer1.setText("Spieler überspringen");
        skipPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer1ActionPerformed(evt);
            }
        });
        player1Button.add(skipPlayer1);

        removePlayer1.setText("Spieler entfernen");
        removePlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer1ActionPerformed(evt);
            }
        });
        player1Button.add(removePlayer1);

        jMenuBar1.add(player1Button);

        player2Button.setText("Spieler 2");
        player2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2ButtonActionPerformed(evt);
            }
        });

        showPlayer2Card.setText("Spielerkarte anzeigen");
        showPlayer2Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer2CardActionPerformed(evt);
            }
        });
        player2Button.add(showPlayer2Card);

        skipPlayer2.setText("Spieler überspringen");
        skipPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer2ActionPerformed(evt);
            }
        });
        player2Button.add(skipPlayer2);

        removePlayer2.setText("Spieler entfernen");
        removePlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer2ActionPerformed(evt);
            }
        });
        player2Button.add(removePlayer2);

        jMenuBar1.add(player2Button);

        player3Button.setText("Spieler 3");
        player3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3ButtonActionPerformed(evt);
            }
        });

        showPlayer3Card.setText("Spielerkarte anzeigen");
        showPlayer3Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer3CardActionPerformed(evt);
            }
        });
        player3Button.add(showPlayer3Card);

        skipPlayer3.setText("Spieler überspringen");
        skipPlayer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer3ActionPerformed(evt);
            }
        });
        player3Button.add(skipPlayer3);

        removePlayer3.setText("Spieler entfernen");
        removePlayer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer3ActionPerformed(evt);
            }
        });
        player3Button.add(removePlayer3);

        jMenuBar1.add(player3Button);

        player4Button.setText("Spieler 4");
        player4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player4ButtonActionPerformed(evt);
            }
        });

        showPlayer4Card.setText("Spielerkarte anzeigen");
        showPlayer4Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer4CardActionPerformed(evt);
            }
        });
        player4Button.add(showPlayer4Card);

        skipPlayer4.setText("Spieler überspringen");
        skipPlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer4ActionPerformed(evt);
            }
        });
        player4Button.add(skipPlayer4);

        removePlayer4.setText("Spieler entfernen");
        removePlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer4ActionPerformed(evt);
            }
        });
        player4Button.add(removePlayer4);

        jMenuBar1.add(player4Button);

        player5Button.setText("Spieler 5");

        showPlayer5Card.setText("Spielerkarte anzeigen");
        showPlayer5Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer5CardActionPerformed(evt);
            }
        });
        player5Button.add(showPlayer5Card);

        skipPlayer5.setText("Spieler überspringen");
        skipPlayer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer5ActionPerformed(evt);
            }
        });
        player5Button.add(skipPlayer5);

        removePlayer5.setText("Spieler entfernen");
        removePlayer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer5ActionPerformed(evt);
            }
        });
        player5Button.add(removePlayer5);

        jMenuBar1.add(player5Button);

        player6Button.setText("Spieler 6");

        showPlayer6Card.setText("Spielerkarte anzeigen");
        showPlayer6Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer6CardActionPerformed(evt);
            }
        });
        player6Button.add(showPlayer6Card);

        skipPlayer6.setText("Spieler überspringen");
        skipPlayer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer6ActionPerformed(evt);
            }
        });
        player6Button.add(skipPlayer6);

        removePlayer6.setText("Spieler entfernen");
        removePlayer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer6ActionPerformed(evt);
            }
        });
        player6Button.add(removePlayer6);

        jMenuBar1.add(player6Button);

        player7Button.setText("Spieler 7");

        showPlayer7Card.setText("Spielerkarte anzeigen");
        showPlayer7Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer7CardActionPerformed(evt);
            }
        });
        player7Button.add(showPlayer7Card);

        skipPlayer7.setText("Spieler überspringen");
        skipPlayer7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer7ActionPerformed(evt);
            }
        });
        player7Button.add(skipPlayer7);

        removePlayer7.setText("Spieler entfernen");
        removePlayer7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer7ActionPerformed(evt);
            }
        });
        player7Button.add(removePlayer7);

        jMenuBar1.add(player7Button);

        player8Button.setText("Spieler 8");

        showPlayer8Card.setText("Spielerkarte anzeigen");
        showPlayer8Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlayer8CardActionPerformed(evt);
            }
        });
        player8Button.add(showPlayer8Card);

        skipPlayer8.setText("Spieler überspringen");
        skipPlayer8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPlayer8ActionPerformed(evt);
            }
        });
        player8Button.add(skipPlayer8);

        removePlayer8.setText("Spieler entfernen");
        removePlayer8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer8ActionPerformed(evt);
            }
        });
        player8Button.add(removePlayer8);

        jMenuBar1.add(player8Button);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dieSeperation, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playercardScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(FeldStreichenButton)
                                .addGap(68, 68, 68)
                                .addComponent(FeldWaehlenButton))
                            .addComponent(playercardOf))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yourTurnLabel)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)))
                                .addGap(51, 51, 51)
                                .addComponent(counterLabel)
                                .addGap(137, 137, 137))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(availableDiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choosenDiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(43, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(availableDiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dieSeperation, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(choosenDiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yourTurnLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(counterLabel))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(playercardOf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playercardScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FeldWaehlenButton)
                    .addComponent(FeldStreichenButton))
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

    private void quitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitGameActionPerformed
        new OpeningScreen();
        this.dispose();
    }//GEN-LAST:event_quitGameActionPerformed

    private void player1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player1ButtonActionPerformed

    private void player2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2ButtonActionPerformed

    private void player4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player4ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player4ButtonActionPerformed

    private void player3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3ButtonActionPerformed

    private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollButtonActionPerformed
        yourTurnLabel.setVisible(false);
        if(game.rolls < 3) counterLabel.setText(game.rolls+1 + "/3");
        if (game.rollDie()) {
            System.out.println("Du darfst nicht mehr du Penner");
        } else {
            if (Game.DICE[0].isRollable()) {
                dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[0].getValue() + ".png")));
            }
            if (Game.DICE[1].isRollable()) {
                dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[1].getValue() + ".png")));
            }

            if (Game.DICE[2].isRollable()) {
                dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[2].getValue() + ".png")));
            }

            if (Game.DICE[3].isRollable()) {
                dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[3].getValue() + ".png")));
            }

            if (Game.DICE[4].isRollable()) {
                dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[4].getValue() + ".png")));
            }

        }

        tableSetPoints();
    }//GEN-LAST:event_rollButtonActionPerformed

    private void dice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice1MouseClicked
        if (game.rolls > 0) {
            dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
            dice6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[0].getValue() + ".png")));
            Game.DICE[0].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice1MouseClicked

    private void dice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice2MouseClicked
        if (game.rolls > 0) {
            dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
            dice7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[1].getValue() + ".png")));
            Game.DICE[1].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice2MouseClicked

    private void dice4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice4MouseClicked
        if (game.rolls > 0) {
            dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
            dice9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[3].getValue() + ".png")));
            Game.DICE[3].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice4MouseClicked

    private void dice5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice5MouseClicked
        if (game.rolls > 0) {
            dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
            dice10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[4].getValue() + ".png")));
            Game.DICE[4].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice5MouseClicked

    private void dice6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice6MouseClicked

        dice6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[0].getValue() + ".png")));
        Game.DICE[0].toggle();

    }//GEN-LAST:event_dice6MouseClicked

    private void dice7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice7MouseClicked

        dice7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[1].getValue() + ".png")));
        Game.DICE[1].toggle();

    }//GEN-LAST:event_dice7MouseClicked

    private void dice8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice8MouseClicked

        dice8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[2].getValue() + ".png")));
        Game.DICE[2].toggle();

    }//GEN-LAST:event_dice8MouseClicked

    private void dice9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice9MouseClicked

        dice9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[3].getValue() + ".png")));
        Game.DICE[3].toggle();

    }//GEN-LAST:event_dice9MouseClicked

    private void dice10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice10MouseClicked

        dice10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[4].getValue() + ".png")));
        Game.DICE[4].toggle();

    }//GEN-LAST:event_dice10MouseClicked

    private void removePlayer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer3ActionPerformed
        if (removePlayer(2)) {
            player3Button.setVisible(false);
        }
    }//GEN-LAST:event_removePlayer3ActionPerformed

    private void showPlayer4CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer4CardActionPerformed
        showCard(3);
    }//GEN-LAST:event_showPlayer4CardActionPerformed

    private void restartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartGameActionPerformed
        // Restart Game
        game.restart();
        //dispose();
        refresh();
        System.out.println("test");
    }//GEN-LAST:event_restartGameActionPerformed

    private void removePlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer1ActionPerformed
        if (removePlayer(0)) {
            player1Button.setVisible(false);
        }
    }//GEN-LAST:event_removePlayer1ActionPerformed

    private void removePlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer2ActionPerformed
        if (removePlayer(1)) {
            player2Button.setVisible(false);
        }
    }//GEN-LAST:event_removePlayer2ActionPerformed

    private void removePlayer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer4ActionPerformed
        if (removePlayer(3)) {
            player4Button.setVisible(false);
        }
    }//GEN-LAST:event_removePlayer4ActionPerformed

    private void dice3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice3MouseClicked
        if (game.rolls > 0) {
            dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
            dice8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[2].getValue() + ".png")));
            Game.DICE[2].toggle();
        }
    }//GEN-LAST:event_dice3MouseClicked

    private void FeldStreichenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeldStreichenButtonActionPerformed
        int index = playercard.getSelectedRow();
        if (index != 6 & index != 7 & index != 8 & index != 16 & index != 17 & index != 18){
            if (index > 5) {
            index -= 3;
            }
        
            if (game.crossField(index)) {
                refresh();
            }
        } else {
            System.out.println("Falsche Zeile");
        }
    }//GEN-LAST:event_FeldStreichenButtonActionPerformed

    private void FeldWaehlenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeldWaehlenButtonActionPerformed
        int index = playercard.getSelectedRow();
        if (index != -1 && index != 6 && index != 7 && index != 8 && index != 16 && index != 17 && index != 18) {
            if (index > 5) {
                index -= 3;
            }
            
            if (game.chooseField(index)) {
                refresh();
            } else {
                System.out.println("Diese Feld kann nicht ausgewählt werden");
            }
        } else {
            System.out.println("Falsche Zeile");
        }
    }//GEN-LAST:event_FeldWaehlenButtonActionPerformed

    private void showPlayer1CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer1CardActionPerformed
        showCard(0);
    }//GEN-LAST:event_showPlayer1CardActionPerformed

    private void showPlayer2CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer2CardActionPerformed
        showCard(1);
    }//GEN-LAST:event_showPlayer2CardActionPerformed

    private void showPlayer3CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer3CardActionPerformed
        showCard(2);
    }//GEN-LAST:event_showPlayer3CardActionPerformed

    private void showPlayer5CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer5CardActionPerformed
        showCard(4);
    }//GEN-LAST:event_showPlayer5CardActionPerformed

    private void showPlayer6CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer6CardActionPerformed
        showCard(5);
    }//GEN-LAST:event_showPlayer6CardActionPerformed

    private void showPlayer7CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer7CardActionPerformed
        showCard(6);
    }//GEN-LAST:event_showPlayer7CardActionPerformed

    private void showPlayer8CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer8CardActionPerformed
        showCard(7);
    }//GEN-LAST:event_showPlayer8CardActionPerformed

    private void removePlayer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer5ActionPerformed
        if (removePlayer(4)) {
            player5Button.setVisible(false);
        }
        
    }//GEN-LAST:event_removePlayer5ActionPerformed

    private void removePlayer6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer6ActionPerformed
        if (removePlayer(5)) {
            player6Button.setVisible(false);
        }
    }//GEN-LAST:event_removePlayer6ActionPerformed

    private void removePlayer7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer7ActionPerformed
        if (removePlayer(6)) {
            player7Button.setVisible(false);
        }
    }//GEN-LAST:event_removePlayer7ActionPerformed

    private void removePlayer8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer8ActionPerformed
        if (removePlayer(7)) {
            player8Button.setVisible(false);
        }
    }//GEN-LAST:event_removePlayer8ActionPerformed

    private void skipPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer1ActionPerformed
        skipPlayer(0);
    }//GEN-LAST:event_skipPlayer1ActionPerformed

    private void skipPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer2ActionPerformed
        skipPlayer(1);
    }//GEN-LAST:event_skipPlayer2ActionPerformed

    private void skipPlayer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer3ActionPerformed
        skipPlayer(2);
    }//GEN-LAST:event_skipPlayer3ActionPerformed

    private void skipPlayer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer4ActionPerformed
        skipPlayer(3);
    }//GEN-LAST:event_skipPlayer4ActionPerformed

    private void skipPlayer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer5ActionPerformed
        skipPlayer(4);
    }//GEN-LAST:event_skipPlayer5ActionPerformed

    private void skipPlayer6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer6ActionPerformed
        skipPlayer(5);
    }//GEN-LAST:event_skipPlayer6ActionPerformed

    private void skipPlayer7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer7ActionPerformed
        skipPlayer(6);
    }//GEN-LAST:event_skipPlayer7ActionPerformed

    private void skipPlayer8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPlayer8ActionPerformed
        skipPlayer(7);
    }//GEN-LAST:event_skipPlayer8ActionPerformed

    /**
     * skips a player by index
     * 
     * @param index
     */
    private void skipPlayer(int index) {
        if (game.currentPlayer == game.players.get(index)) {
            game.skipPlayer(game.players.get(index));
            refresh();
        } else {
            System.out.println("Dieser Spieler ist gerade nicht dran und kann nicht geskippt werden.");
        }
    }

    /**
     * removes a player by index
     * 
     * @param index
     */
    private boolean removePlayer(int index) {
        int result = game.removePlayer(index);
        if (result == -1) {
            refresh();
        } else {
            System.out.println("Es können keine weiteren Spieler entfernt werden.");
        }
        return result == 1;
    }

    /**
     * shows the card of a player by index
     * 
     * @param index
     */
    private void showCard(int index) {
        new PlayerCard(game, game.players.get(index)).setVisible(true);
    }

    /**
     * invoked when a cell gets edited
     * 
     * @param row row index of the cell
     * @param column column index of the cell
     */
    private void cellEdited(int row, int column) {
        if (row != -1 && column != -1 && (row < 6 || (row > 8 && row < 16))) {
            Object obj = playercard.getValueAt(row, column);
            if (obj != null) {
                String input = obj.toString();
                if (input.contains("---") || input.contains("gewählt: ")) {
                    return;
                }
                int index = row;
                if (index > 5) {
                    index -= 3;
                }
                try {
                    int n = Integer.parseInt(input);
                    if (game.chooseField(index, n)) {
                        System.out.println("chosen value, refresh: " + n);
                    }
                } catch (Exception ex) {
                    System.out.println("Du lutscher!");
                }
                playercard.setValueAt(null, row, column);
                refresh();
            }
        }
    }

    /**
     * Setting the field names into the playercard
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
     *
     */
    private void showDefaultDie() {
        for (game.Die d : game.DICE) { // set isRollable of every die on true
            if (!d.isRollable()) {
                d.toggle();
            }
        }

        dice6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));
        dice10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/Transparent.png")));

        dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/default.png")));
        dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/default.png")));
        dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/default.png")));
        dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/default.png")));
        dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/default.png")));

    }

    /**
     * Setting the points into the playercard
     */
    private void tableSetPoints() {
        System.out.println(game.useAutofill);
        for (int i = 0; i < 6; i++) {
            if (game.currentPlayer.getCard().allFields[i].isOpen() && game.useAutofill) {
                playercard.setValueAt(game.currentPlayer.getCard().allFields[i].getCurrentValue(), i, 1);
            } else if (game.currentPlayer.getCard().allFields[i].isCrossed()) {
                playercard.setValueAt("---", i, 1);
            } else if (game.currentPlayer.getCard().allFields[i].isChosen()) {
                playercard.setValueAt("gewählt: " + game.currentPlayer.getCard().allFields[i].getChosenValue(), i, 1);
            } else {
                playercard.setValueAt(null, i, 1);
            }

        }
        for (int j = 6; j < 13; j++) {
            if (game.currentPlayer.getCard().allFields[j].isOpen() && game.useAutofill) {
                playercard.setValueAt(game.currentPlayer.getCard().allFields[j].getCurrentValue(), j + 3, 1);
            } else if (game.currentPlayer.getCard().allFields[j].isCrossed()) {
                playercard.setValueAt("---", j + 3, 1);
            } else if (game.currentPlayer.getCard().allFields[j].isChosen()) {
                playercard.setValueAt("gewählt: " + game.currentPlayer.getCard().allFields[j].getChosenValue(), j + 3, 1);
            } else {
                playercard.setValueAt(null, j + 3, 1);
            }

        }
        playercard.setValueAt(game.currentPlayer.getCard().getPart1(false), 6, 1); // Part 1
        int bonus = game.currentPlayer.getCard().getPart1(false) != game.currentPlayer.getCard().getPart1(true) ? Card.BONUS
                : 0;
        playercard.setValueAt(bonus, 7, 1);     // Bonus
        playercard.setValueAt(game.currentPlayer.getCard().getPart1(true), 8, 1);     // Part 1 + Bonus
        playercard.setValueAt(game.currentPlayer.getCard().getPart1(true), 16, 1);    // Part 1
        playercard.setValueAt(game.currentPlayer.getCard().getPart2(), 17, 1);    // Part 2
        playercard.setValueAt(game.currentPlayer.getCard().getTotal(), 18, 1);    // Totals
    }

    /**
     * Refresh the GameView, set the values for the new currentplayer and resets
     * the die
     */
    private void refresh() {
        showDefaultDie();
        tableSetPoints();
        playercardOf.setText("Spielerkarte von " + game.currentPlayer.getName());
        yourTurnLabel.setVisible(true);
        yourTurnLabel.setText(game.currentPlayer + ", du bist dran. Würfel jetzt!");
        counterLabel.setText(game.rolls + "/3");
        if (game.isGameOver()) {
            this.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FeldStreichenButton;
    private javax.swing.JButton FeldWaehlenButton;
    private javax.swing.JMenu OptionsButton;
    private javax.swing.JPanel availableDiece;
    private javax.swing.JPanel choosenDiece;
    private javax.swing.JLabel counterLabel;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu player1Button;
    private javax.swing.JMenu player2Button;
    private javax.swing.JMenu player3Button;
    private javax.swing.JMenu player4Button;
    private javax.swing.JMenu player5Button;
    private javax.swing.JMenu player6Button;
    private javax.swing.JMenu player7Button;
    private javax.swing.JMenu player8Button;
    private javax.swing.JTable playercard;
    private javax.swing.JLabel playercardOf;
    private javax.swing.JScrollPane playercardScrollPane;
    private javax.swing.JMenuItem quitGame;
    private javax.swing.JMenuItem removePlayer1;
    private javax.swing.JMenuItem removePlayer2;
    private javax.swing.JMenuItem removePlayer3;
    private javax.swing.JMenuItem removePlayer4;
    private javax.swing.JMenuItem removePlayer5;
    private javax.swing.JMenuItem removePlayer6;
    private javax.swing.JMenuItem removePlayer7;
    private javax.swing.JMenuItem removePlayer8;
    private javax.swing.JMenuItem restartGame;
    private javax.swing.JButton rollButton;
    private javax.swing.JMenuItem showPlayer1Card;
    private javax.swing.JMenuItem showPlayer2Card;
    private javax.swing.JMenuItem showPlayer3Card;
    private javax.swing.JMenuItem showPlayer4Card;
    private javax.swing.JMenuItem showPlayer5Card;
    private javax.swing.JMenuItem showPlayer6Card;
    private javax.swing.JMenuItem showPlayer7Card;
    private javax.swing.JMenuItem showPlayer8Card;
    private javax.swing.JMenuItem skipPlayer1;
    private javax.swing.JMenuItem skipPlayer2;
    private javax.swing.JMenuItem skipPlayer3;
    private javax.swing.JMenuItem skipPlayer4;
    private javax.swing.JMenuItem skipPlayer5;
    private javax.swing.JMenuItem skipPlayer6;
    private javax.swing.JMenuItem skipPlayer7;
    private javax.swing.JMenuItem skipPlayer8;
    private javax.swing.JLabel yourTurnLabel;
    // End of variables declaration//GEN-END:variables
}

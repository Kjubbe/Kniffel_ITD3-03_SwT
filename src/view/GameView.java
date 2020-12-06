/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
        initComponents();
        tableSetFieldNames();
        showDefaultDie();
        
        playercardOf.setText("Spielerkarte von " + game.currentPlayer.getName());
        
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
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
                    showPlayer1Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer1Card.setText(game.players.get(j).getName() + "Spielerkarte");
                }
                skipPlayer1.setText(game.players.get(j).getName() + " überspringen");
                removePlayer1.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 1) {
                player2Button.setText(game.players.get(j).getName());
                player2Button.setVisible(true);
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
                    showPlayer2Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer2Card.setText(game.players.get(j).getName() + "Spielerkarte");
                }
                skipPlayer2.setText(game.players.get(j).getName() + " überspringen");
                removePlayer2.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 2) {
                player3Button.setText(game.players.get(j).getName());
                player3Button.setVisible(true);
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
                    showPlayer3Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer3Card.setText(game.players.get(j).getName() + "Spielerkarte");
                }
                skipPlayer3.setText(game.players.get(j).getName() + " überspringen");
                removePlayer3.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 3) {
                player4Button.setText(game.players.get(j).getName());
                player4Button.setVisible(true);
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
                    showPlayer4Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer4Card.setText(game.players.get(j).getName() + "Spielerkarte");
                }
                skipPlayer4.setText(game.players.get(j).getName() + " überspringen");
                removePlayer4.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 4) {
                player5Button.setText(game.players.get(j).getName());
                player5Button.setVisible(true);
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
                    showPlayer5Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer5Card.setText(game.players.get(j).getName() + "Spielerkarte");
                }
                skipPlayer5.setText(game.players.get(j).getName() + " überspringen");
                removePlayer5.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 5) {
                player6Button.setText(game.players.get(j).getName());
                player6Button.setVisible(true);
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
                    showPlayer6Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer6Card.setText(game.players.get(j).getName() + "Spielerkarte");
                }
                skipPlayer6.setText(game.players.get(j).getName() + " überspringen");
                removePlayer6.setText(game.players.get(j).getName() + " entfernen");
            }
            if (j == 6) {
                player7Button.setText(game.players.get(j).getName());
                player7Button.setVisible(true);
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
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
                if(game.players.get(j).getName().charAt(game.players.get(j).getName().length() - 1) != 's'){
                    showPlayer8Card.setText(game.players.get(j).getName() + "s" + " Spielerkarte");
                } else {
                    showPlayer8Card.setText(game.players.get(j).getName() + "Spielerkarte");
                }
                skipPlayer8.setText(game.players.get(j).getName() + " überspringen");
                removePlayer8.setText(game.players.get(j).getName() + " entfernen");
            }

        }
        //tableSetPoints();
        playercard.setRowHeight(25);
        playercardScrollPane.setViewportView(playercard);
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
        playercardOf = new javax.swing.JTextField();
        dieSeperation = new javax.swing.JSeparator();
        FeldStreichenButton = new javax.swing.JButton();
        FeldWaehlenButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        OptionsButton = new javax.swing.JMenu();
        pauseGame = new javax.swing.JMenuItem();
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
                .addGap(146, 146, 146)
                .addComponent(dice1)
                .addGap(126, 126, 126)
                .addComponent(dice2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(availableDieceLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(dice3)
                .addGap(121, 121, 121)
                .addComponent(dice4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(dice5)
                .addGap(56, 56, 56))
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
                .addGap(53, 53, 53)
                .addComponent(dice8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dice9)
                .addGap(123, 123, 123)
                .addComponent(dice10)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, choosenDieceLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(dice6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dice7)
                .addGap(138, 138, 138))
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

        playercardOf.setText("Spielerkarte von ");
        playercardOf.setToolTipText("Spielerkarte");
        playercardOf.setFocusable(false);
        playercardOf.setOpaque(false);

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
        FeldWaehlenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeldWaehlenButtonActionPerformed(evt);
            }
        });

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

        player1Button.setText("Spieler 1");
        player1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ButtonActionPerformed(evt);
            }
        });

        showPlayer1Card.setText("Spielerkarte anzeigen");
        player1Button.add(showPlayer1Card);

        skipPlayer1.setText("Spieler überspringen");
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
        player2Button.add(showPlayer2Card);

        skipPlayer2.setText("Spieler überspringen");
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
        player3Button.add(showPlayer3Card);

        skipPlayer3.setText("Spieler überspringen");
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
        player5Button.add(showPlayer5Card);

        skipPlayer5.setText("Spieler überspringen");
        player5Button.add(skipPlayer5);

        removePlayer5.setText("Spieler entfernen");
        player5Button.add(removePlayer5);

        jMenuBar1.add(player5Button);

        player6Button.setText("Spieler 6");

        showPlayer6Card.setText("Spielerkarte anzeigen");
        player6Button.add(showPlayer6Card);

        skipPlayer6.setText("Spieler überspringen");
        player6Button.add(skipPlayer6);

        removePlayer6.setText("Spieler entfernen");
        player6Button.add(removePlayer6);

        jMenuBar1.add(player6Button);

        player7Button.setText("Spieler 7");

        showPlayer7Card.setText("Spielerkarte anzeigen");
        player7Button.add(showPlayer7Card);

        skipPlayer7.setText("Spieler überspringen");
        player7Button.add(skipPlayer7);

        removePlayer7.setText("Spieler entfernen");
        player7Button.add(removePlayer7);

        jMenuBar1.add(player7Button);

        player8Button.setText("Spieler 8");

        showPlayer8Card.setText("Spielerkarte anzeigen");
        player8Button.add(showPlayer8Card);

        skipPlayer8.setText("Spieler überspringen");
        player8Button.add(skipPlayer8);

        removePlayer8.setText("Spieler entfernen");
        player8Button.add(removePlayer8);

        jMenuBar1.add(player8Button);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playercardScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(playercardOf, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dieSeperation, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(choosenDiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(availableDiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(FeldStreichenButton)
                .addGap(68, 68, 68)
                .addComponent(FeldWaehlenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(availableDiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(dieSeperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choosenDiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playercardOf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playercardScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FeldWaehlenButton)
                            .addComponent(FeldStreichenButton)
                            .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        // Back to Main Menu
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
        
        if(game.rollDie()) {
            System.out.println("Du darfst nicht mehr du Penner");
        } else {
            dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[0].getValue() + ".png")));
            dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[1].getValue() + ".png")));
            dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[2].getValue() + ".png")));
            dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[3].getValue() + ".png")));
            dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[4].getValue() + ".png")));

            dice6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[0].getValue() + ".png")));
            dice7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[1].getValue() + ".png")));
            dice8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[2].getValue() + ".png")));
            dice9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[3].getValue() + ".png")));
            dice10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/" + Game.DICE[4].getValue() + ".png")));
            tableSetPoints();
        }
        
    }//GEN-LAST:event_rollButtonActionPerformed

    private void dice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice1MouseClicked
        if (game.rolls > 0) {
            dice1.setVisible(false);
            dice6.setVisible(true);
            Game.DICE[0].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice1MouseClicked

    private void dice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice2MouseClicked
        if (game.rolls > 0) {
            dice2.setVisible(false);
            dice7.setVisible(true);
            Game.DICE[1].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice2MouseClicked

    private void dice4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice4MouseClicked
        if (game.rolls > 0) {
            dice4.setVisible(false);
            dice9.setVisible(true);
            Game.DICE[3].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice4MouseClicked

    private void dice5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice5MouseClicked
        if (game.rolls > 0) {
            dice5.setVisible(false);
            dice10.setVisible(true);
            Game.DICE[4].toggle();
        } else {
            System.out.println("du musst noch würfeln");
        }
    }//GEN-LAST:event_dice5MouseClicked

    private void dice6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice6MouseClicked

        dice6.setVisible(false);
        dice1.setVisible(true);
        Game.DICE[0].toggle();

    }//GEN-LAST:event_dice6MouseClicked

    private void dice7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice7MouseClicked

        dice7.setVisible(false);
        dice2.setVisible(true);
        Game.DICE[1].toggle();

    }//GEN-LAST:event_dice7MouseClicked

    private void dice8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice8MouseClicked

        dice8.setVisible(false);
        dice3.setVisible(true);
        Game.DICE[2].toggle();

    }//GEN-LAST:event_dice8MouseClicked

    private void dice9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice9MouseClicked
        if (game.rolls > 0) {
            dice9.setVisible(false);
            dice4.setVisible(true);
            Game.DICE[3].toggle();
        }
    }//GEN-LAST:event_dice9MouseClicked

    private void dice10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice10MouseClicked

        dice10.setVisible(false);
        dice5.setVisible(true);
        Game.DICE[4].toggle();

    }//GEN-LAST:event_dice10MouseClicked

    private void removePlayer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer3ActionPerformed

    }//GEN-LAST:event_removePlayer3ActionPerformed

    private void showPlayer4CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlayer4CardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showPlayer4CardActionPerformed

    private void pauseGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseGameActionPerformed
        //Pause Game
    }//GEN-LAST:event_pauseGameActionPerformed

    private void restartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartGameActionPerformed
        // Restart Game
        game.restart();
        System.out.println("test");
    }//GEN-LAST:event_restartGameActionPerformed

    private void removePlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer1ActionPerformed
        // Remove Player
    }//GEN-LAST:event_removePlayer1ActionPerformed

    private void removePlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer2ActionPerformed

    }//GEN-LAST:event_removePlayer2ActionPerformed

    private void removePlayer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlayer4ActionPerformed

    }//GEN-LAST:event_removePlayer4ActionPerformed

    private void dice3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice3MouseClicked
        if (game.rolls > 0) {
            dice3.setVisible(false);
            dice8.setVisible(true);
            Game.DICE[2].toggle();
        }
    }//GEN-LAST:event_dice3MouseClicked

    private void FeldStreichenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeldStreichenButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeldStreichenButtonActionPerformed

    private void FeldWaehlenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeldWaehlenButtonActionPerformed
        int index = playercard.getSelectedRow();
        
        if(index > 5) {
            index -= 3;
        }
        game.chooseField(index);
        game.crossField(index);
        refresh();
    }//GEN-LAST:event_FeldWaehlenButtonActionPerformed

    /**
     * Setting the fieldnames into the playercard
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
        dice1.setVisible(true);
        dice2.setVisible(true);
        dice3.setVisible(true);
        dice4.setVisible(true);
        dice5.setVisible(true);
        dice6.setVisible(false);
        dice7.setVisible(false);
        dice8.setVisible(false);
        dice9.setVisible(false);
        dice10.setVisible(false);

    }

    /**
     * Setting the points into the playercard
     */
    private void tableSetPoints() {
        for (int i = 0; i < 6; i++) {
            if(game.currentPlayer.getCard().allFields[i].getCurrentValue() >= 1) playercard.setValueAt(game.currentPlayer.getCard().allFields[i].getCurrentValue(), i, 1);
            if(game.currentPlayer.getCard().allFields[i].getCurrentValue() == 0) playercard.setValueAt("---" , i, 1);
        }
        for (int j = 6; j < 13; j++) {
            if(game.currentPlayer.getCard().allFields[j].getCurrentValue() >= 1) playercard.setValueAt(game.currentPlayer.getCard().allFields[j].getCurrentValue(), j+3, 1);
            if(game.currentPlayer.getCard().allFields[j].getCurrentValue() == 0) playercard.setValueAt("---" , j+3, 1);
        }
        playercard.setValueAt(game.currentPlayer.getCard().getPart1(false), 6, 1);     // Part 1
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

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FeldStreichenButton;
    private javax.swing.JButton FeldWaehlenButton;
    private javax.swing.JMenu OptionsButton;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem pauseGame;
    private javax.swing.JMenu player1Button;
    private javax.swing.JMenu player2Button;
    private javax.swing.JMenu player3Button;
    private javax.swing.JMenu player4Button;
    private javax.swing.JMenu player5Button;
    private javax.swing.JMenu player6Button;
    private javax.swing.JMenu player7Button;
    private javax.swing.JMenu player8Button;
    private javax.swing.JTable playercard;
    private javax.swing.JTextField playercardOf;
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
    // End of variables declaration//GEN-END:variables
}

package view;

import database.PlayerManagement;
import game.Stats;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author jarmo
 */
public class LoginScreenView extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreenView
     */
    public LoginScreenView() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Neuer Spieler");
        System.out.println("LoginScreen");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        guest = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        login = new javax.swing.JButton();


        jPanel1.setBackground(new java.awt.Color(41, 128, 185));

        guest.setText("Als Gast spielen");
        guest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestActionPerformed(evt);
            }
        });

        jPasswordField1.setText("jPasswordField1");

        jLabel1.setForeground(new java.awt.Color(236, 240, 241));
        jLabel1.setText("Passwort");

        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setText("Benutzername");

        jFormattedTextField1.setText("Benutzername...");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setText("Spieler hinzufügen");

        register.setText("Registrieren");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Statistik speichern");
        jRadioButton1.setSelected(true);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        login.setText("Einloggen");
        login.setActionCommand("login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(54, 54, 54).addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3)
                        .addComponent(jLabel2).addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(login, javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(register, javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(guest, javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)))
                        .addContainerGap(39, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(30, 30, 30).addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11).addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(guest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(register)
                        .addContainerGap(108, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    // Password Validator (1 Großbuchstabe, 1 Zahl und ein Minuskel)
    private static boolean checkPassword(String password) {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c;
        for (int i = 0; i < password.length(); i++) {   
            c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasNum = true;
            } else if (Character.isUpperCase(c)) {
                hasCap = true;
            } else if (Character.isLowerCase(c)) {
                hasLow = true;
            }
            if (hasNum && hasCap && hasLow) {
                return true;
            }
        }
        return false;
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {

        String playerName = jFormattedTextField1.getText();
        String playerPassword = String.valueOf(jPasswordField1.getPassword());
        Boolean statsSave = jRadioButton1.isSelected();

        if (PlayerManagement.getInstance().login(playerName, playerPassword, statsSave).containsValue(true)) {
            MenuView.updatePlayers();
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Du bist nun als \"" + playerName + "\" eingeloggt", "Erfolgreich eingeloggt",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Der Benutzername wurde nicht gefunden oder das Passwort ist nicht korrekt", "Fehler beim Einloggen",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guestActionPerformed(java.awt.event.ActionEvent evt) {
        String playerName = jFormattedTextField1.getText();
        
        if (PlayerManagement.getInstance().playAsGuest(playerName).containsValue(false)) {
            JOptionPane.showMessageDialog(null,
                    "Der Spieler konnte nicht hinzugefügt werden.",
                    "Add Error", JOptionPane.ERROR_MESSAGE);
        } else {
            MenuView.updatePlayers();
            this.setVisible(false);
        }
    }

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {
        String playerName = jFormattedTextField1.getText();
        String playerPassword = String.valueOf(jPasswordField1.getPassword());
        Boolean statsSave = jRadioButton1.isSelected();

        if (playerName.length() < 3) {
            JOptionPane.showMessageDialog(null, "Der Benutzername muss mindestens 3 Zeichen lang sein!",
                    "Benutzername zu kurz", JOptionPane.ERROR_MESSAGE);
        } else if (playerPassword.length() < 7 || checkPassword(playerPassword) == false) {
            JOptionPane.showMessageDialog(null,
                    "Das Passwort muss min. sieben Zeichen lang sein und min. einen Großbuchstaben und eine Zahl beinhalten.",
                    "Schlechtes Passwort", JOptionPane.ERROR_MESSAGE);
        } else {
            if (PlayerManagement.getInstance().register(playerName, playerPassword, statsSave).containsValue(false)) {
                JOptionPane.showMessageDialog(null, "Dieser Benutzername existiert bereits", "Fehler beim Registrieren",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                MenuView.updatePlayers();
                this.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "Registrierung erfolgreich, der Account \"" + playerName + "\" wurde erstellt und eingeloggt.",
                        "Erfolgreich registriert und eingeloggt", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify
    private static javax.swing.JButton guest;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private static javax.swing.JButton login;
    private static javax.swing.JButton register;
    // End of variables declaration

}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author simeonmurzin
 *
 */

public class StartScreenView extends javax.swing.JFrame {

	private JButton displayStatsButton;
	private JButton newGameButton;
	private JPanel mainPanel;
	private JLabel label;

	public StartScreenView() {
		super();
		this.setVisible(true);
        this.setBounds(200, 200, 1000, 600);
		System.out.println("StartScreen");
		initComponents();
	};

	public void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		

		displayStatsButton = new JButton();
		displayStatsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onDisplayStatsButtonClicked();
			}
		});
		
		

		newGameButton = new JButton();
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onNewGameButtonClicked();
			}
		});
		
		
		mainPanel = new JPanel();
		label = new JLabel("Kniffel");

		mainPanel.add(label);
		mainPanel.add(newGameButton);
		mainPanel.add(displayStatsButton);

		displayStatsButton.setText("Zeige Statistik");
		newGameButton.setText("Neues Spiel");
		displayStatsButton.setVisible(true);
		this.getContentPane().add(mainPanel);

	}

	void onNewGameButtonClicked() {
            new MenuView();
		
	}

	void onDisplayStatsButtonClicked() {

	}
}
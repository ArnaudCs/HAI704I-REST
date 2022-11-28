package com.agency.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Label;

public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private JTextField destinationInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientGUI() {
		Border whiteline, raisedetched, loweredetched,
	       raisedbevel, loweredbevel, empty;

		whiteline = BorderFactory.createLineBorder(Color.white);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder();
		setTitle("TripAdvisor - Comparateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1143, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComparateur = new JLabel("TripAdvisor");
		lblComparateur.setVerticalAlignment(SwingConstants.TOP);
		lblComparateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblComparateur.setForeground(new Color(255, 255, 255));
		lblComparateur.setFont(new Font("Gayathri Thin", Font.BOLD, 40));
		lblComparateur.setBounds(413, 26, 303, 37);
		contentPane.add(lblComparateur);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(435, 75, 257, 10);
		contentPane.add(separator);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(
		                       whiteline, "Destination");
		title.setTitleJustification(TitledBorder.CENTER);
		
		destinationInput = new JTextField();
		destinationInput.setHorizontalAlignment(SwingConstants.LEFT);
		destinationInput.setBounds(424, 168, 323, 28);
		contentPane.add(destinationInput);
		destinationInput.setColumns(10);
		destinationInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\SearchBar.png"));
		lblNewLabel.setBounds(380, 153, 380, 57);
		contentPane.add(lblNewLabel);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\background.jpg"));
		background.setBounds(0, 0, 1132, 709);
		contentPane.add(background);
	}
}

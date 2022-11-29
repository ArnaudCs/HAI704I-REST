package com.agency.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Label;
import java.util.Calendar;

import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;

public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private JTextField destinationInput;
	private JTextField personNumberInput;
	private JTextField priceSelectedMax;
	private JTextField dateOut;
	private JTextField dateIn;
	private JCheckBox AgencyCheck2;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\logo.png"));
		Border whiteline, raisedetched, loweredetched,
	       raisedbevel, loweredbevel, empty;

		whiteline = BorderFactory.createLineBorder(Color.white);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder();
		setTitle("HotelAdvisor - Comparateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1143, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JComboBox starsSelector = new JComboBox();
		starsSelector.setBounds(580, 320, 148, 24);
		starsSelector.setForeground(new Color(64, 0, 64));
		starsSelector.setModel(new DefaultComboBoxModel(new String[] {"1 étoile (★)", "2 étoiles (★★)", "3 étoiles (★★★)", "4 étoiles (★★★★)", "5 étoiles (★★★★★)"}));
		
		JLabel starsNumberLabel = new JLabel("Nombre d'étoiles");
		starsNumberLabel.setBounds(420, 322, 182, 24);
		starsNumberLabel.setForeground(Color.WHITE);
		starsNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel chooseAgencyLabel = new JLabel("Regarder sur :");
		chooseAgencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAgencyLabel.setForeground(Color.WHITE);
		chooseAgencyLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		chooseAgencyLabel.setBounds(450, 89, 240, 42);
		contentPane.add(chooseAgencyLabel);
		
		
		
		
		JLabel backCover = new JLabel("");
		backCover.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\back.png"));
		backCover.setBounds(-14, 650, 180, 40);
		contentPane.add(backCover);
		backCover.setVisible(false);
		
		JCheckBox AgencyCheck1 = new JCheckBox("TripFinder");
		AgencyCheck1.setFont(new Font("Tahoma", Font.BOLD, 14));
		AgencyCheck1.setForeground(new Color(255, 255, 255));
		AgencyCheck1.setBounds(373, 130, 135, 21);
		contentPane.add(AgencyCheck1);
		AgencyCheck1.setOpaque(false);
		
		AgencyCheck2 = new JCheckBox("Hotel.org");
		AgencyCheck2.setForeground(new Color(255, 255, 255));
		AgencyCheck2.setFont(new Font("Tahoma", Font.BOLD, 14));
		AgencyCheck2.setBounds(527, 130, 117, 21);
		contentPane.add(AgencyCheck2);
		AgencyCheck2.setOpaque(false);
		
		JCheckBox AgencyCheck3 = new JCheckBox("HotelScanner");
		AgencyCheck3.setForeground(new Color(255, 255, 255));
		AgencyCheck3.setFont(new Font("Tahoma", Font.BOLD, 14));
		AgencyCheck3.setBounds(672, 130, 167, 21);
		contentPane.add(AgencyCheck3);
		AgencyCheck3.setOpaque(false);
		
		
		JLabel titleLabel = new JLabel("HotelAdvisor");
		titleLabel.setBounds(417, 31, 303, 48);
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Gayathri Thin", Font.BOLD, 40));
		
		JSeparator titleSeparator = new JSeparator();
		titleSeparator.setBounds(440, 80, 257, 10);
		titleSeparator.setForeground(new Color(255, 255, 255));
		TitledBorder title;
		title = BorderFactory.createTitledBorder(
		                       whiteline, "Destination");
		title.setTitleJustification(TitledBorder.CENTER);
		
		destinationInput = new JTextField();
		destinationInput.setBounds(429, 202, 323, 28);
		destinationInput.setFont(new Font("Tahoma", Font.BOLD, 17));
		destinationInput.setHorizontalAlignment(SwingConstants.LEFT);
		destinationInput.setColumns(10);
		destinationInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		destinationInput.setOpaque(false);
		
		JLabel destinationCover = new JLabel("");
		destinationCover.setBounds(385, 188, 380, 57);
		destinationCover.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\SearchBar.png"));
		
		personNumberInput = new JTextField();
		personNumberInput.setBounds(545, 255, 28, 36);
		personNumberInput.setText("1");
		personNumberInput.setForeground(new Color(255, 255, 255));
		personNumberInput.setFont(new Font("Tahoma", Font.BOLD, 17));
		personNumberInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		personNumberInput.setOpaque(false);
		personNumberInput.setColumns(10);
		
		JLabel errorMessage = new JLabel("");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.BOLD, 17));
		errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessage.setBounds(264, 637, 621, 36);
		contentPane.add(errorMessage);
		
		JSlider priceSelector = new JSlider();
		priceSelector.setBounds(560, 376, 200, 22);
		priceSelector.setMaximum(1000);
		priceSelector.setOpaque(false);
		
		priceSelector.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	        	priceSelectedMax.setText(String.valueOf(priceSelector.getValue() + "€"));
	        }
		 });
		
		JSlider personNumberSelector = new JSlider();
		personNumberSelector.setBounds(585, 263, 200, 22);
		personNumberSelector.setValue(2);
		personNumberSelector.setOpaque(false);
		personNumberSelector.setMaximum(20);
		
		JButton searchButton = new JButton("");
		searchButton.setBounds(500, 573, 148, 42);
		searchButton.setForeground(new Color(255, 255, 255));
		
		JLabel homeMessage = new JLabel("Indiquez une destination ...");
		homeMessage.setBounds(450, 156, 240, 42);
		homeMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		homeMessage.setForeground(new Color(255, 255, 255));
		homeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		
		JLabel searchButtonBackground = new JLabel("");
		searchButtonBackground.setBounds(485, 575, 180, 40);
		searchButtonBackground.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\valider.png"));
		
		JLabel personNumberLabel = new JLabel("Nombre de Personnes : ");
		personNumberLabel.setBounds(349, 261, 207, 24);
		personNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		personNumberLabel.setForeground(new Color(255, 255, 255));
		
		JLabel priceLabel = new JLabel("Prix Max : ");
		priceLabel.setBounds(395, 374, 117, 24);
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel dateInCover = new JLabel("");
		dateInCover.setBounds(580, 429, 140, 40);
		dateInCover.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\calendarV1.png"));
		
		JLabel dateOutCover = new JLabel("");
		dateOutCover.setBounds(580, 490, 140, 40);
		dateOutCover.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\calendarV1.png"));
		
		JLabel departureLabel = new JLabel("Date de départ");
		departureLabel.setBounds(435, 440, 167, 24);
		departureLabel.setForeground(Color.WHITE);
		departureLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel returnDateLabel = new JLabel("Date de retour");
		returnDateLabel.setBounds(435, 500, 138, 24);
		returnDateLabel.setForeground(Color.WHITE);
		returnDateLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel quitCover = new JLabel("");
		quitCover.setBounds(962, 650, 180, 40);
		quitCover.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\QuitRest.png"));
		
		JButton exitBtn = new JButton("");
		exitBtn.setBounds(1021, 650, 74, 40);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setContentAreaFilled(false);
		exitBtn.setBorderPainted(false);
		JButton backButton = new JButton("");
		
		personNumberSelector.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	        	personNumberInput.setText(String.valueOf(personNumberSelector.getValue()));
	        }
		 });
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String destination = destinationInput.getText();
				String DateIn = dateIn.getText();
				String DateOut = dateOut.getText();
				int price = Integer.valueOf(priceSelector.getValue());;
				int bedNumber = Integer.valueOf(personNumberInput.getText());
				int stars = starsSelector.getSelectedIndex() + 1;
				
				if(!(AgencyCheck1.isSelected()) && !(AgencyCheck2.isSelected())&& !(AgencyCheck3.isSelected())) {
					errorMessage.setText("Veuillez selectionner au moins une agence");
				}
				
				errorMessage.setVisible(false);
				destinationInput.setVisible(false);
				homeMessage.setVisible(false);
				titleLabel.setVisible(false);
				titleSeparator.setVisible(false);
				destinationCover.setVisible(false);
				destinationInput.setVisible(false);
				personNumberLabel.setVisible(false);
				personNumberInput.setVisible(false);
				personNumberSelector.setVisible(false);
				quitCover.setVisible(false);
				exitBtn.setVisible(false);
				starsSelector.setVisible(false);
				starsNumberLabel.setVisible(false);
				priceLabel.setVisible(false);
				priceSelector.setVisible(false);
				priceSelectedMax.setVisible(false);
				departureLabel.setVisible(false);
				returnDateLabel.setVisible(false);
				dateIn.setVisible(false);
				dateOut.setVisible(false);
				dateInCover.setVisible(false);
				dateOutCover.setVisible(false);
				searchButtonBackground.setVisible(false);
				searchButton.setVisible(false);
				AgencyCheck1.setVisible(false);
				AgencyCheck2.setVisible(false);
				AgencyCheck3.setVisible(false);
				chooseAgencyLabel.setVisible(false);
				backButton.setVisible(true);
				backCover.setVisible(true);
			}
		});
		
		priceSelectedMax = new JTextField();
		priceSelectedMax.setBounds(490, 367, 66, 40);
		priceSelectedMax.setOpaque(false);
		priceSelectedMax.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		priceSelectedMax.setForeground(new Color(255, 255, 255));
		priceSelectedMax.setFont(new Font("Tahoma", Font.BOLD, 17));
		priceSelectedMax.setColumns(10);
		priceSelectedMax.setText("50€");
		
		dateOut = new JTextField();
		dateOut.setBounds(614, 496, 95, 28);
		dateOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateOut.setColumns(10);
		dateOut.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		dateOut.setOpaque(false);
		
		dateIn = new JTextField();
		dateIn.setBounds(614, 435, 95, 28);
		dateIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateIn.setColumns(10);
		dateIn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		dateIn.setOpaque(false);
		
		dateIn.setText("2022-12-10");
		dateOut.setText("2022-12-20");
		contentPane.setLayout(null);
		contentPane.add(starsSelector);
		contentPane.add(starsNumberLabel);
		contentPane.add(titleLabel);
		contentPane.add(titleSeparator);
		contentPane.add(destinationInput);
		contentPane.add(destinationCover);
		contentPane.add(personNumberInput);
		contentPane.add(priceSelector);
		contentPane.add(personNumberSelector);
		contentPane.add(homeMessage);
		contentPane.add(searchButton);
		contentPane.add(searchButtonBackground);
		contentPane.add(exitBtn);
		contentPane.add(quitCover);
		contentPane.add(personNumberLabel);
		contentPane.add(priceLabel);
		contentPane.add(departureLabel);
		contentPane.add(returnDateLabel);
		contentPane.add(priceSelectedMax);
		contentPane.add(dateOut);
		contentPane.add(dateIn);
		contentPane.add(dateInCover);
		contentPane.add(dateOutCover);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorMessage.setVisible(true);
				destinationInput.setVisible(true);
				homeMessage.setVisible(true);
				titleLabel.setVisible(true);
				titleSeparator.setVisible(true);
				destinationCover.setVisible(true);
				destinationInput.setVisible(true);
				personNumberLabel.setVisible(true);
				personNumberInput.setVisible(true);
				personNumberSelector.setVisible(true);
				quitCover.setVisible(true);
				exitBtn.setVisible(true);
				starsSelector.setVisible(true);
				starsNumberLabel.setVisible(true);
				priceLabel.setVisible(true);
				priceSelector.setVisible(true);
				priceSelectedMax.setVisible(true);
				departureLabel.setVisible(true);
				returnDateLabel.setVisible(true);
				dateIn.setVisible(true);
				dateOut.setVisible(true);
				dateInCover.setVisible(true);
				dateOutCover.setVisible(true);
				searchButtonBackground.setVisible(true);
				searchButton.setVisible(true);
				AgencyCheck1.setVisible(true);
				AgencyCheck2.setVisible(true);
				AgencyCheck3.setVisible(true);
				chooseAgencyLabel.setVisible(true);
				backButton.setVisible(false);
				backCover.setVisible(false);
				errorMessage.setText("");
			}
		});
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(42, 650, 74, 40);
		contentPane.add(backButton);
		backButton.setVisible(false);

		JLabel background = new JLabel("");
		background.setBounds(0, 5, 1142, 709);
		background.setFont(new Font("Tahoma", Font.BOLD, 14));
		background.setIcon(new ImageIcon("C:\\Users\\arnau\\Desktop\\HAI704I-REST\\Media\\background.jpg"));
		contentPane.add(background);
	}
}

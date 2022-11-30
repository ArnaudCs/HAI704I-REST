package com.comparator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.comparator.models.Hotel;
import com.comparator.models.Room;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
@Component
public class ClientGUI extends JFrame implements CommandLineRunner{
	@Autowired
	private RestTemplate proxy;
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
		
		JLabel chooseAgencyLabel = new JLabel("Regarder sur :");
		chooseAgencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAgencyLabel.setForeground(Color.WHITE);
		chooseAgencyLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		chooseAgencyLabel.setBounds(450, 89, 240, 42);
		contentPane.add(chooseAgencyLabel);
		
		JLabel bestPriceHotel = new JLabel("Crowne Plaza Hotel");
		bestPriceHotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		bestPriceHotel.setBounds(320, 46, 213, 21);
		contentPane.add(bestPriceHotel);
		bestPriceHotel.setVisible(false);
		
		JLabel bestRateHotel = new JLabel("Ritz");
		bestRateHotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		bestRateHotel.setBounds(866, 46, 213, 21);
		contentPane.add(bestRateHotel);
		bestRateHotel.setVisible(false);
		
		JLabel bestRateAgence = new JLabel("hotel.org");
		bestRateAgence.setFont(new Font("Tahoma", Font.BOLD, 15));
		bestRateAgence.setBounds(924, 76, 117, 21);
		contentPane.add(bestRateAgence);
		bestRateAgence.setVisible(false);
		
		JLabel bestPriceAgence = new JLabel("HotelScanner");
		bestPriceAgence.setFont(new Font("Tahoma", Font.BOLD, 15));
		bestPriceAgence.setBounds(360, 76, 117, 21);
		contentPane.add(bestPriceAgence);
		bestPriceAgence.setVisible(false);
		
		JLabel bestPricePrix = new JLabel("10");
		bestPricePrix.setFont(new Font("Tahoma", Font.BOLD, 16));
		bestPricePrix.setBounds(250, 76, 35, 21);
		contentPane.add(bestPricePrix);
		bestPricePrix.setVisible(false);
		
		JLabel bestRateStars = new JLabel("4");
		bestRateStars.setFont(new Font("Tahoma", Font.BOLD, 17));
		bestRateStars.setBounds(810, 75, 35, 21);
		contentPane.add(bestRateStars);
		bestRateStars.setVisible(false);
		
		JLabel backCover = new JLabel("");
		BufferedImage img6 = null;
		try {
			img6 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/back.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		backCover.setIcon(new ImageIcon(img6));
		
		backCover.setBounds(-14, 650, 180, 40);
		contentPane.add(backCover);
		backCover.setVisible(false);
		
		JCheckBox AgencyCheck1 = new JCheckBox("TripFinder");
		AgencyCheck1.setFont(new Font("Tahoma", Font.BOLD, 14));
		AgencyCheck1.setForeground(new Color(255, 255, 255));
		AgencyCheck1.setBounds(353, 130, 135, 21);
		contentPane.add(AgencyCheck1);
		AgencyCheck1.setOpaque(false);
		
		AgencyCheck2 = new JCheckBox("Hotel.org");
		AgencyCheck2.setForeground(new Color(255, 255, 255));
		AgencyCheck2.setFont(new Font("Tahoma", Font.BOLD, 14));
		AgencyCheck2.setBounds(510, 130, 117, 21);
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
		
		destinationInput = new JTextField();
		destinationInput.setBounds(429, 202, 323, 28);
		destinationInput.setFont(new Font("Tahoma", Font.BOLD, 17));
		destinationInput.setHorizontalAlignment(SwingConstants.LEFT);
		destinationInput.setColumns(10);
		destinationInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		destinationInput.setOpaque(false);
		
		JLabel destinationCover = new JLabel("");
		destinationCover.setBounds(385, 188, 380, 57);
		BufferedImage img5 = null;
		try {
			img5 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/SearchBar.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		destinationCover.setIcon(new ImageIcon(img5));
		
		personNumberInput = new JTextField();
		personNumberInput.setBounds(555, 255, 28, 36);
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
		priceSelector.setMinimum(10);
		priceSelector.setBounds(560, 376, 200, 22);
		priceSelector.setMaximum(1000);
		priceSelector.setOpaque(false);
		
		JLabel topPrice = new JLabel("");
		topPrice.setBounds(35, 31, 510, 90);
		contentPane.add(topPrice);
		BufferedImage img8 = null;
		try {
			img8 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/bestPrice.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		topPrice.setIcon(new ImageIcon(img8));
		topPrice.setVisible(false);
		
		JLabel topStars = new JLabel("");
		topStars.setBounds(580, 31, 510, 90);
		contentPane.add(topStars);
		BufferedImage img9 = null;
		try {
			img9 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/bestRate_2.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		topStars.setIcon(new ImageIcon(img9));
		topStars.setVisible(false);
		
		priceSelector.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	        	priceSelectedMax.setText(String.valueOf(priceSelector.getValue() + "€"));
	        }
		 });
		
		JSlider personNumberSelector = new JSlider();
		personNumberSelector.setMinimum(1);
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
		BufferedImage img4 = null;
		try {
			img4 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/valider.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		searchButtonBackground.setIcon(new ImageIcon(img4));
		
		JLabel personNumberLabel = new JLabel("Nombre de Personnes : ");
		personNumberLabel.setBounds(340, 261, 234, 24);
		personNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		personNumberLabel.setForeground(new Color(255, 255, 255));
		
		JLabel priceLabel = new JLabel("Prix Max : ");
		priceLabel.setBounds(395, 374, 117, 24);
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel dateInCover = new JLabel("");
		dateInCover.setBounds(580, 429, 140, 40);
		BufferedImage img3 = null;
		try {
			img3 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/calendarV1.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dateInCover.setIcon(new ImageIcon(img3));
		
		JLabel dateOutCover = new JLabel("");
		dateOutCover.setBounds(580, 490, 140, 40);
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/calendarV1.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dateOutCover.setIcon(new ImageIcon(img2));
		
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
		BufferedImage img1 = null;
		try {
			img1 = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/QuitRest.png"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		quitCover.setIcon(new ImageIcon(img1));
		
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
		
		JLabel starsNumberLabel = new JLabel("Nombre d'étoiles");
		starsNumberLabel.setBounds(420, 322, 182, 24);
		starsNumberLabel.setForeground(Color.WHITE);
		starsNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(starsNumberLabel);
		
		personNumberSelector.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	        	personNumberInput.setText(String.valueOf(personNumberSelector.getValue()));
	        }
		 });
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SERVICE_URL1 = "http://localhost:30007/hotelorg/api/";
				String SERVICE_URL2 = "http://localhost:30008/hotelscanner/api/";
				String SERVICE_URL3 = "http://localhost:30009/tripfinder/api/";
				
				String URI_HOTEL = "agency";
				String URI_HOTEL_ID = URI_HOTEL + "/{id}";
				Map<String, String> URIS = new HashMap<String, String>();
				URIS.put(SERVICE_URL1 + URI_HOTEL, SERVICE_URL1 + URI_HOTEL + URI_HOTEL_ID);
				URIS.put(SERVICE_URL2 + URI_HOTEL, SERVICE_URL2 + URI_HOTEL + URI_HOTEL_ID);
				URIS.put(SERVICE_URL3 + URI_HOTEL, SERVICE_URL3 + URI_HOTEL + URI_HOTEL_ID);
				
				String destination = destinationInput.getText();
				String DateIn = dateIn.getText();
				String DateOut = dateOut.getText();
				int price = Integer.valueOf(priceSelector.getValue());;
				int bedNumber = Integer.valueOf(personNumberInput.getText());
				int stars = starsSelector.getSelectedIndex() + 1;
				Map<String, String> params = new HashMap<>();
				params.put("position", destination);
				params.put("datein", DateIn);
				params.put("dateout", DateOut);
				params.put("size", String.valueOf(bedNumber));
				params.put("rating", String.valueOf(stars));
				params.put("price", String.valueOf(price));
				
				if(!(AgencyCheck1.isSelected()) && !(AgencyCheck2.isSelected())&& !(AgencyCheck3.isSelected())) {
					errorMessage.setText("Veuillez selectionner au moins une agence");
				} else if ((AgencyCheck1.isSelected()) && (AgencyCheck2.isSelected())&& (AgencyCheck3.isSelected())){
					List<Hotel> resultHotel = new ArrayList<>(); 
					int cpt = 1;
					ArrayList<String> uriList = new ArrayList<>();
					System.out.println("Results:\n");
					for (String uri : URIS.keySet()) {
						try {
							String url = uri + "/search?position={position}&size={size}&rating={rating}&datein={datein}&dateout={dateout}&price={price}";
							Hotel[] returnedHotel = proxy.getForObject(url, Hotel[].class, params);
							for (Hotel hotel : returnedHotel) {
								if(!hotel.getName().equals("Undefined")) {
									uriList.add(uri);
									resultHotel.add(hotel);
									cpt++;
								}
							}
						}
						catch (Exception e) {
							continue;
						}
					}
					for (int i= 0; i < resultHotel.size() ; i++) {
						for (int j= 0; j < resultHotel.size() ; j++) {
							if(i != j) {
								Hotel hotel = resultHotel.get(i);
								Hotel toCompare = resultHotel.get(j);
								if(hotel.getName().equals(toCompare.getName())) {
									resultHotel.remove(j);
								}
							}
						}
						
					}
					
					for (Hotel hotel : resultHotel) {
						if(!hotel.getName().equals("Undefined")) {
							System.out.println(hotel.toString());
							for (Room room: hotel.getRooms()) {
								System.out.println(room.toString());
							}
							System.out.println();
						}
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
					topPrice.setVisible(true);
					topStars.setVisible(true);
					bestRateAgence.setVisible(true);
					bestRateHotel.setVisible(true);
					bestRateStars.setVisible(true);
					bestPriceHotel.setVisible(true);
					bestPriceAgence.setVisible(true);
					bestPricePrix.setVisible(true);
				} else {
					
				}
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
				topPrice.setVisible(false);
				topStars.setVisible(false);
				bestRateAgence.setVisible(false);
				bestRateHotel.setVisible(false);
				bestRateStars.setVisible(false);
				bestPriceHotel.setVisible(false);
				bestPriceAgence.setVisible(false);
				bestPricePrix.setVisible(false);
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
		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL("http://hotelfinder.sc1samo7154.universe.wf/gui/background.jpg"));
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		background.setIcon(new ImageIcon(img));
		contentPane.add(background);
		
		JLabel backgroundSearch = new JLabel("");
		backgroundSearch.setBounds(0, 5, 1142, 709);
		backgroundSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		backgroundSearch.setIcon(new ImageIcon(img));
		contentPane.add(backgroundSearch);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}

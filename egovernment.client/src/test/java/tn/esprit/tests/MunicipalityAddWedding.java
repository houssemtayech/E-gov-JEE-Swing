package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessDelegator.MunicipalityGestionDelegator;
import tn.esprit.domain.Municipality;
import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;

import tn.esprit.services.ClaimGestionRemote;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JTextField;

public class MunicipalityAddWedding extends JFrame {

	private JPanel contentPane;
	String[][] donnes;
	int i;
	List<Request> r;
	List<Reclamation> rec;
	int service=0;
	static int idd;
	static int cinn;
	private JTextField first;
	private JTextField second;
	private JTextField WeddingDate;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	public MunicipalityAddWedding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JBirth = new JLabel("New label");
		JBirth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MunicipalityMain mm = new MunicipalityMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		JBirth.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\birth button.png"));
		JBirth.setBounds(339, 0, 183, 73);
		contentPane.add(JBirth);
		
		JButton Birth = new JButton("");
		Birth.setIcon(new ImageIcon("C:\\Users\\Houssem\\workspace\\picPdev\\birth button.png"));
		Birth.setBounds(339, 0, 183, 73);
		contentPane.add(Birth);
		
		JLabel JWedding = new JLabel("New label");
		JWedding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MunicipalityMain mm = new MunicipalityMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		JWedding.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\Wedding button.png"));
		JWedding.setBounds(700, 0, 183, 73);
		contentPane.add(JWedding);
		
		JButton Wedding = new JButton("");
		Wedding.setIcon(new ImageIcon("C:\\Users\\Houssem\\workspace\\picPdev\\Wedding button.png"));
		Wedding.setBounds(700, 0, 183, 73);
		contentPane.add(Wedding);
		
		
		JButton AllRequests = new JButton("");
		AllRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MunicipalityMain mm = new MunicipalityMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		AllRequests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//displayAll();
			}
		});
		
		AllRequests.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\request button.png"));
		AllRequests.setBounds(158, 0, 183, 73);
		contentPane.add(AllRequests);
		
		JLabel JDeath = new JLabel("New label");
		JDeath.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MunicipalityMain mm = new MunicipalityMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		JDeath.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\death button.png"));
		JDeath.setBounds(518, 0, 183, 73);
		contentPane.add(JDeath);
		
		JButton Death = new JButton("");
		Death.setIcon(new ImageIcon("C:\\Users\\Houssem\\workspace\\picPdev\\death button.png"));
		Death.setBounds(518, 0, 183, 73);
		contentPane.add(Death);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(201, 425, 659, -274);
		contentPane.add(scrollPane);
		
		JButton Claims = new JButton("New button");
		Claims.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MunicipalityMain mm = new MunicipalityMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
//		Claims.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		Claims.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//displayClaimsList();
			}
		});
		Claims.setBackground(Color.WHITE);
		Claims.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\Claims.png"));
		Claims.setBounds(26, 245, 120, 150);
		contentPane.add(Claims);
		
		JLabel lblNewLabel_1 = new JLabel("First ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(211, 162, 130, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSecondId = new JLabel("Second ID:");
		lblSecondId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSecondId.setBounds(211, 238, 130, 40);
		contentPane.add(lblSecondId);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(211, 313, 130, 40);
		contentPane.add(lblDate);
		
		first = new JTextField();
		first.setBounds(386, 174, 147, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		second = new JTextField();
		second.setColumns(10);
		second.setBounds(386, 250, 147, 20);
		contentPane.add(second);
		
		WeddingDate = new JTextField();
		WeddingDate.setColumns(10);
		WeddingDate.setBounds(386, 325, 147, 20);
		contentPane.add(WeddingDate);
		
		JButton weddingButton = new JButton("");
		weddingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date dt=null;
					
				try {
					dt=formatter.parse(WeddingDate.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int id1 = Integer.parseInt(first.getText());
				int id2 = Integer.parseInt(second.getText());
				 
				MunicipalityGestionDelegator mgd = new MunicipalityGestionDelegator();
				mgd.addWeddingCertificate(id1, id2, dt);
			}
		});
		weddingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		weddingButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\Add Wedding.png"));
		weddingButton.setBounds(386, 393, 183, 73);
		contentPane.add(weddingButton);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MunicipalityMain mm = new MunicipalityMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\Back Button .png"));
		button.setBackground(Color.WHITE);
		button.setBounds(185, 393, 191, 90);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\MunicipalityMain.jpg"));
		lblNewLabel.setBounds(0, 0, 893, 477);
		contentPane.add(lblNewLabel);
		
		/************************************************************/
		
		
		
	}
}

package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessDelegator.ClaimGestionDelegator;
import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;

import tn.esprit.services.ClaimGestionRemote;

import javax.swing.JLabel;
import javax.security.auth.Subject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class MunicipalityClaim extends JFrame {

	private JPanel contentPane;
	String[][] donnes;
	int i;
	List<Request> r;
	List<Reclamation> rec;
	int service=0;
	static int idd;


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MunicipalityClaim frame = new MunicipalityClaim();
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
	
	public MunicipalityClaim() {
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
				/*
				MunicipalityBirthCertificateList bc = new MunicipalityBirthCertificateList();
				bc.setVisible(true);
				setVisible(false);*/
				//displayBirthCertificateList();
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
				//displayWeddingCertificateList();
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
				//displayDeathCertificateList();
			}
		});
		JDeath.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\death button.png"));
		JDeath.setBounds(518, 0, 183, 73);
		contentPane.add(JDeath);
		
		JButton Death = new JButton("");
		Death.setIcon(new ImageIcon("C:\\Users\\Houssem\\workspace\\picPdev\\death button.png"));
		Death.setBounds(518, 0, 183, 73);
		contentPane.add(Death);
		
		JButton Claims = new JButton("New button");
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
		
		JLabel lblNewLabel_1 = new JLabel("Subject:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(226, 180, 115, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblClaim = new JLabel("Claim:");
		lblClaim.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblClaim.setBounds(226, 267, 115, 33);
		contentPane.add(lblClaim);
		
		JLabel subj = new JLabel("");
		subj.setBounds(339, 180, 213, 33);
		contentPane.add(subj);
		
		JLabel claimText = new JLabel("");
		claimText.setBounds(339, 267, 321, 128);
		contentPane.add(claimText);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClaimGestionDelegator.deleteClaim(MunicipalityMain.idd);
				MunicipalityMain mn = new MunicipalityMain();
				mn.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\delete button.png"));
		btnNewButton.setBounds(720, 187, 104, 94);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MunicipalityMain mn = new MunicipalityMain();
				mn.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\Back Button .png"));
		btnNewButton_1.setBounds(677, 292, 191, 90);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\MunicipalityMain.jpg"));
		lblNewLabel.setBounds(0, 0, 893, 477);
		contentPane.add(lblNewLabel);
		
		/************************************************************/
		Reclamation recl = new Reclamation();
		ClaimGestionDelegator cgd = new ClaimGestionDelegator();
		recl=cgd.findClaimById(MunicipalityMain.idd);
		subj.setText(recl.getSujet());
		claimText.setText(recl.getText());
		
		
	}
}

package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessDelegator.ClaimGestionDelegator;
import businessDelegator.RequestGestionDelegator;
import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;

import tn.esprit.services.ClaimGestionRemote;

import javax.swing.JLabel;
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

public class MunicipalityMain extends JFrame {

	private JPanel contentPane;
	String[][] donnes;
	int i;
	List<Request> r;
	private JTable table;
	List<Reclamation> rec;
	int service=0;
	static int idd;
	static int cinn;


	/**
	 * Launch the application.
	 */
	public void displayAll() {
		
		try {
			r = new ArrayList<Request>();
			r = RequestGestionDelegator.findRequestByDepartement("Municipality");
			System.out.println("done");
			donnes = new String[r.size()][4];
			for (i = 0; i < r.size(); i++) {
				donnes[i][0] = String.valueOf(r.get(i).getId());
				donnes[i][1] = String.valueOf(r.get(i).getCin());
				donnes[i][2] = r.get(i).getService();
				donnes[i][3] = r.get(i).getService();
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "id","Cin", "Service"}));
		} catch (Exception e1) {
			System.out.println(e1+"erreur");
		}
		
	}
	public void displayBirthCertificateList() {
		service=1;
		try {
			r = new ArrayList<Request>();
			r = RequestGestionDelegator.findRequestByType("BirthCertificate");
			System.out.println("done");
			donnes = new String[r.size()][2];
			for (i = 0; i < r.size(); i++) {
				donnes[i][0] = String.valueOf(r.get(i).getId());
				donnes[i][1] = String.valueOf(r.get(i).getCin());
				
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "id","Cin"}));
		} catch (Exception e1) {
			System.out.println(e1+"erreur");
		}
		
	}
	public void displayDeathCertificateList() {
		service=2;
		try {
			r = new ArrayList<Request>();
			r = RequestGestionDelegator.findRequestByType("DeathCertificate");
			System.out.println("done");
			donnes = new String[r.size()][2];
			for (i = 0; i < r.size(); i++) {
				donnes[i][0] = String.valueOf(r.get(i).getId());
				donnes[i][1] = String.valueOf(r.get(i).getCin());
				
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "id","Cin"}));
		} catch (Exception e1) {
			System.out.println(e1+"erreur");
		}
		
	}
	public void displayWeddingCertificateList() {
		service=3;
		try {
			r = new ArrayList<Request>();
			r = RequestGestionDelegator.findRequestByType("WeddingCertificate");
			System.out.println("done");
			donnes = new String[r.size()][2];
			for (i = 0; i < r.size(); i++) {
				donnes[i][0] = String.valueOf(r.get(i).getId());
				donnes[i][1] = String.valueOf(r.get(i).getCin());
				
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "id","Cin"}));
		} catch (Exception e1) {
			System.out.println(e1+"erreur");
		}
		
	}
	public void displayClaimsList() {
		service=4;
		try {
			rec = new ArrayList<Reclamation>();
			rec = ClaimGestionDelegator.findReclamationByType("Municipality");
			System.out.println(rec);
			System.out.println("done");
			donnes = new String[rec.size()][2];
			System.out.println("*************");
			for (i = 0; i < rec.size(); i++) {
				donnes[i][0] = String.valueOf(rec.get(i).getId());
				donnes[i][1] = rec.get(i).getSujet();
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] {"id","Sujet"}));
		} catch (Exception e1) {
			System.out.println(e1+"erreur");
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MunicipalityMain frame = new MunicipalityMain();
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
	
	public MunicipalityMain() {
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
				displayBirthCertificateList();
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
				displayWeddingCertificateList();
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
				
				displayAll();
			}
		});
		
		AllRequests.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\request button.png"));
		AllRequests.setBounds(158, 0, 183, 73);
		contentPane.add(AllRequests);
		
		JLabel JDeath = new JLabel("New label");
		JDeath.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDeathCertificateList();
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
//		Claims.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		Claims.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayClaimsList();
			}
		});
		Claims.setBackground(Color.WHITE);
		Claims.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\Claims.png"));
		Claims.setBounds(26, 245, 120, 150);
		contentPane.add(Claims);
		
		JButton addWedding = new JButton("");
		addWedding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MunicipalityAddWedding maw = new MunicipalityAddWedding();
				maw.setVisible(true);
				setVisible(false);
			}
		});
	
		addWedding.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\Add Wedding.png"));
		addWedding.setBounds(158, 84, 183, 73);
		contentPane.add(addWedding);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\MunicipalityMain.jpg"));
		lblNewLabel.setBounds(0, 0, 893, 477);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				idd=Integer.parseInt(donnes[a][0]);
				
				
				if(service==4){
					MunicipalityClaim mc = new MunicipalityClaim();
					mc.setVisible(true);
					setVisible(false);
				}else if(service==1){
					cinn=Integer.parseInt(donnes[a][1]);
					MunicipalityBirthCertificate mbc= new MunicipalityBirthCertificate();
					mbc.setVisible(true);
					setVisible(false);
				}else if(service==2){
					cinn=Integer.parseInt(donnes[a][1]);
					MunicipalityDeathCertificate mdc = new MunicipalityDeathCertificate();
					mdc.setVisible(true);
					setVisible(false);
				}else if(service==3){
					cinn=Integer.parseInt(donnes[a][1]);
					MunicipalityWeddingCertificate mwc = new MunicipalityWeddingCertificate();
					mwc.setVisible(true);
					setVisible(false);
				}
				
					
				
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.setBounds(197, 165, 644, 249);
		contentPane.add(table);
		
		/************************************************************/
		
	}
}

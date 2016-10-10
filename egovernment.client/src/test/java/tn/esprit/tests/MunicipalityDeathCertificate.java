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

public class MunicipalityDeathCertificate extends JFrame {

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
					MunicipalityDeathCertificate frame = new MunicipalityDeathCertificate();
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
	
	public MunicipalityDeathCertificate() {
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
			}
		});
		AllRequests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MunicipalityMain mm = new MunicipalityMain();
				mm.setVisible(true);
				setVisible(false);
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
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		btnNewButton_1.setBounds(692, 352, 191, 90);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(198, 124, 166, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel name = new JLabel("");
		name.setBounds(398, 124, 236, 35);
		contentPane.add(name);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(198, 170, 166, 35);
		contentPane.add(lblGender);
		
		JLabel gender = new JLabel("");
		gender.setBounds(398, 170, 236, 35);
		contentPane.add(gender);
		
		JLabel lblBirth = new JLabel("Birth:");
		lblBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBirth.setBounds(198, 216, 166, 35);
		contentPane.add(lblBirth);
		
		JLabel lblFather = new JLabel("Father:");
		lblFather.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFather.setBounds(198, 262, 166, 35);
		contentPane.add(lblFather);
		
		JLabel father = new JLabel("");
		father.setBounds(398, 262, 361, 35);
		contentPane.add(father);
		
		JLabel bith = new JLabel("");
		bith.setBounds(398, 216, 236, 35);
		contentPane.add(bith);
		
		JLabel lblMother = new JLabel("Mother:");
		lblMother.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMother.setBounds(198, 308, 166, 35);
		contentPane.add(lblMother);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemarks.setBounds(198, 354, 166, 35);
		contentPane.add(lblRemarks);
		
		JLabel remarks = new JLabel("");
		remarks.setBounds(398, 354, 236, 35);
		contentPane.add(remarks);
		
		JLabel mother = new JLabel("");
		mother.setBounds(398, 308, 361, 35);
		contentPane.add(mother);
		
		JLabel lblDeath = new JLabel("Death:");
		lblDeath.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeath.setBounds(198, 407, 166, 35);
		contentPane.add(lblDeath);
		
		JLabel death = new JLabel("");
		death.setBounds(398, 407, 236, 35);
		contentPane.add(death);
		
		JLabel birth = new JLabel("");
		birth.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\houss\\picPdev\\MunicipalityMain.jpg"));
		birth.setBounds(0, 0, 893, 477);
		contentPane.add(birth);
		
		/************************************************************/
		Municipality mun= new Municipality();
		
		mun=MunicipalityGestionDelegator.deathCertificateByCin(MunicipalityMain.cinn);
		name.setText(mun.getLname() +" " + mun.getFname());
		gender.setText(mun.getGender());
		bith.setText("Born on: " +mun.getBirthdate()+" in "+mun.getBirthplace());
		father.setText("name: " +mun.getFathername()+" profession: "+mun.getFatherprofession()+" nationality: "+mun.getFathernationality());
		mother.setText("name: " +mun.getMothername()+" profession: "+mun.getMotherprofession()+" nationality: "+mun.getMothernationality());
		if(mun.getRemarques()==null){
			remarks.setText("No remarks");
		}else{
			remarks.setText(mun.getRemarques());
		}
		death.setText(""+mun.getDeathDate());
	}
}

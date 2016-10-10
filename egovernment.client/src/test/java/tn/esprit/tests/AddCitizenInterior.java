package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.Address;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import businessDelegator.InteriorMinistryGestionDelegator;

import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import tn.esprit.domain.InteriorMinistry;
//import tn.esprit.domain.Poste;

//import tn.esprit.serviceDelegator.PostGestionDelegator;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import com.toedter.calendar.JDateChooser;

public class AddCitizenInterior extends JFrame {

	private JPanel contentPane;
	private JTextField cin;
	private JTextField lname;
	private JTextField fname;
	private JTextField father;
	private JTextField grandfather;
	private JTextField birthplace;
	private JTextField mothername;
	private JLabel lblBirthPlace;
	private JLabel lblMotherName;
	private JLabel lblIssueDate;
	private JLabel lblResidenceAddress;
	private JTextField address;
	private JLabel lblBInformation;
	private JTextField B3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCitizenInterior frame = new AddCitizenInterior();
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
	public AddCitizenInterior() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDateChooser ddd1 = new JDateChooser();
		
		ddd1.setBounds(170, 254, 170, 20);
		contentPane.add(ddd1);
		
		JDateChooser ddd2 = new JDateChooser();
	
		ddd2.setBounds(170, 341, 170, 20);
		contentPane.add(ddd2);
	
		
		cin = new JTextField();
		cin.setBounds(170, 115, 170, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(170, 139, 170, 20);
		contentPane.add(lname);
		lname.setColumns(10);
		
		fname = new JTextField();
		fname.setBounds(170, 165, 170, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		
		father = new JTextField();
		father.setBounds(170, 193, 170, 20);
		contentPane.add(father);
		father.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CIN:");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 112, 73, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setBounds(10, 140, 73, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setBounds(10, 166, 73, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Father Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setBounds(10, 194, 142, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Grand Father Name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setForeground(new Color(178, 34, 34));
		lblNewLabel_4.setBounds(10, 222, 142, 20);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\add.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String f = fname.getText();
				String l = lname.getText();
				int c = Integer.parseInt(cin.getText());
				int n =Integer.parseInt(ncc.getText());
				Long i= Long.parseLong(iban.getText());
				Poste poste=new Poste();
				
					poste.setFname(f);
					poste.setLname(l);
					poste.setCin(c);
					poste.setNcc(n);
					poste.setIban(i);
					//poste.setState(true);
					PostGestionDelegator.addReceipt(poste);
					
					*/	
				
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int c = Integer.parseInt(cin.getText());
				String l = lname.getText();
				String f = fname.getText();
				String n=father.getText();
				String g=grandfather.getText();
				String s=birthplace.getText();
				String m=mothername.getText();
				String a=address.getText();
				String b3=B3.getText();
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date  da = ddd1.getDate();
				Date  db = ddd2.getDate();
				//int n =Integer.parseInt(father.getText());
				//Long i= Long.parseLong(iban.getText());
				InteriorMinistry interior=new InteriorMinistry();
				
				interior.setCin(c);
				interior.setLname(l);
				interior.setFname(f);
				interior.setGrandFatherName(g);
				interior.setBirthPlace(s);
				interior.setMotherName(m);
				interior.setAddress(a);
				interior.setB3Information(b3);
				interior.setBirthDate(da);
				
				
				//interior.setIssueDate(db);
				//if(InteriorMinistryGestionDelegator.addPerson(interior)){
				
				
				
					final JPanel panel = new JPanel();
					int Result = JOptionPane.showConfirmDialog(panel, "Are you sure to add this citizen!!!", "Add Citizen",JOptionPane.YES_NO_OPTION);
					if(Result==JOptionPane.YES_NO_OPTION){
						InteriorMinistryGestionDelegator.addPerson(interior);
						setVisible(false);
						dispose();
						new ShowServices().setVisible(true);
					}
					//traitement si l’usager a appuyé sur oui.
					else{
						setVisible(false);
						dispose();
						new AddCitizenInterior().setVisible(true);
					}
				
				
					//poste.setState(true);
					//PostGestionDelegator.addReceipt(poste);
					
					
				
			}
		});
		btnNewButton.setBounds(649, 419, 68, 69);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\refresh.jpg"));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCitizenInterior p= new AddCitizenInterior();
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(791, 58, 51, 57);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ShowServices p= new ShowServices();
				p.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\back.jpg"));
		button.setForeground(new Color(102, 153, 51));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(153, 153, 255));
		button.setBounds(52, 64, 37, 37);
		contentPane.add(button);
		
		grandfather = new JTextField();
		grandfather.setColumns(10);
		grandfather.setBounds(170, 223, 170, 20);
		contentPane.add(grandfather);
		
		birthplace = new JTextField();
		birthplace.setColumns(10);
		birthplace.setBounds(170, 279, 170, 20);
		contentPane.add(birthplace);
		
		mothername = new JTextField();
		mothername.setColumns(10);
		mothername.setBounds(170, 310, 170, 20);
		contentPane.add(mothername);
		
		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setForeground(new Color(178, 34, 34));
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblBirthDate.setBounds(10, 249, 142, 20);
		contentPane.add(lblBirthDate);
		
		lblBirthPlace = new JLabel("Birth Place:");
		lblBirthPlace.setForeground(new Color(178, 34, 34));
		lblBirthPlace.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblBirthPlace.setBounds(10, 279, 142, 20);
		contentPane.add(lblBirthPlace);
		
		lblMotherName = new JLabel("Mother Name:");
		lblMotherName.setForeground(new Color(178, 34, 34));
		lblMotherName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMotherName.setBounds(10, 310, 142, 20);
		contentPane.add(lblMotherName);
		
		lblIssueDate = new JLabel("Issue Date:");
		lblIssueDate.setForeground(new Color(178, 34, 34));
		lblIssueDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblIssueDate.setBounds(10, 341, 142, 20);
		contentPane.add(lblIssueDate);
		
		lblResidenceAddress = new JLabel("Residence Address:");
		lblResidenceAddress.setForeground(new Color(178, 34, 34));
		lblResidenceAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblResidenceAddress.setBounds(170, 388, 142, 20);
		contentPane.add(lblResidenceAddress);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(338, 389, 230, 20);
		contentPane.add(address);
		
		lblBInformation = new JLabel("B3 Information:");
		lblBInformation.setForeground(new Color(178, 34, 34));
		lblBInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblBInformation.setBounds(170, 419, 142, 20);
		contentPane.add(lblBInformation);
		
		B3 = new JTextField();
		B3.setBounds(338, 420, 230, 57);
		contentPane.add(B3);
		B3.setColumns(10);
		
			
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label.setForeground(new Color(178, 34, 34));
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\Background.png"));
		label.setBounds(0, 0, 893, 496);
		contentPane.add(label);
	}
}

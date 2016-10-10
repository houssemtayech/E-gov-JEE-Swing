package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import businessDelegator.MunicipalityGestionDelegator;
import tn.esprit.domain.Municipality;


import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Mun extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField last_1;
	private JTextField fathername;
	private JTextField fatherpro;
	private JTextField fathernationality;
	private JTextField mothername;
	private JTextField motherprofession;
	private JTextField mothernationality;
	private JTextField remarque;
	private JTextField writter;
	private JTextField place;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mun frame = new Mun();
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
	public Mun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser birthdate = new JDateChooser();
		birthdate.setBounds(741, 379, 144, 20);
		contentPane.add(birthdate);
		JDateChooser deathdate = new JDateChooser();
		deathdate.setBounds(741, 426, 144, 20);
		contentPane.add(deathdate);
		JRadioButton fille = new JRadioButton("fille");
		fille.setBounds(186, 180, 109, 23);
		contentPane.add(fille);
		
		JRadioButton garcon = new JRadioButton("garcon");
		garcon.setBounds(186, 130, 109, 23);
		contentPane.add(garcon);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\khouloud\\upa1.jpg"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Municipality mm = new Municipality();
				//int cin1 = Integer.parseInt(cin.getText());
				mm.setCin(0);
				mm.setFname(name.getText());
				mm.setLname(last_1.getText());
					
				if(fille.isSelected()){
					mm.setGender(fille.getText());
				}
				if(garcon.isSelected()){
					mm.setGender(garcon.getText());
				}
				mm.setFathername(fathername.getText());
				mm.setFatherprofession(fatherpro.getText());
				mm.setFathernationality(fathernationality.getText());
				mm.setMothername(mothername.getText());
				mm.setMotherprofession(motherprofession.getText());
				mm.setMothernationality(mothernationality.getText());
				mm.setNameofwriter(writter.getText());
				mm.setRemarques(remarque.getText());
				mm.setBirthplace(place.getText());
			
				mm.setBirthdate(birthdate.getDate());
				mm.setDeathDate(deathdate.getDate());
				if (MunicipalityGestionDelegator.babyRedistration(mm)){
					JOptionPane.showMessageDialog(null, " new baby was added ");
				}
				else
					JOptionPane.showMessageDialog(null, " Error ");
				
				
				
				
				
				
				
				
			}
		});
		btnAdd.setBounds(779, 457, 54, 43);
		contentPane.add(btnAdd);
		
		
		
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBirthDate.setBounds(400, 379, 125, 32);
		contentPane.add(lblBirthDate);
		
		JLabel lblDeathBirth = new JLabel("Death birth");
		lblDeathBirth.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDeathBirth.setBounds(400, 427, 125, 32);
		contentPane.add(lblDeathBirth);
	
		
		place = new JTextField();
		place.setBounds(741, 343, 148, 20);
		contentPane.add(place);
		place.setColumns(10);
		
		JLabel lblBirthPlace = new JLabel("Birth place");
		lblBirthPlace.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBirthPlace.setBounds(400, 336, 125, 25);
		contentPane.add(lblBirthPlace);
		
		writter = new JTextField();
		writter.setBounds(737, 305, 148, 20);
		contentPane.add(writter);
		writter.setColumns(10);
		
		JLabel lblWritter = new JLabel("Writter");
		lblWritter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWritter.setBounds(396, 299, 138, 23);
		contentPane.add(lblWritter);
		
		remarque = new JTextField();
		remarque.setBounds(741, 256, 148, 20);
		contentPane.add(remarque);
		remarque.setColumns(10);
		
		JLabel lblRemarque = new JLabel("Remarque");
		lblRemarque.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRemarque.setBounds(396, 248, 125, 26);
		contentPane.add(lblRemarque);
		
		mothernationality = new JTextField();
		mothernationality.setBounds(737, 209, 148, 20);
		contentPane.add(mothernationality);
		mothernationality.setColumns(10);
		
		JLabel lblMotherNationality = new JLabel("mother nationality");
		lblMotherNationality.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMotherNationality.setBounds(396, 204, 186, 33);
		contentPane.add(lblMotherNationality);
		
		motherprofession = new JTextField();
		motherprofession.setBounds(221, 457, 155, 20);
		contentPane.add(motherprofession);
		motherprofession.setColumns(10);
		
		JLabel lblMotherProfession = new JLabel("mother profession");
		lblMotherProfession.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMotherProfession.setBounds(33, 456, 188, 24);
		contentPane.add(lblMotherProfession);
		
		mothername = new JTextField();
		mothername.setBounds(207, 410, 155, 20);
		contentPane.add(mothername);
		mothername.setColumns(10);
		
		JLabel lblMotherName = new JLabel("mother name");
		lblMotherName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMotherName.setBounds(35, 406, 148, 18);
		contentPane.add(lblMotherName);
		
		fathernationality = new JTextField();
		fathernationality.setBounds(207, 371, 137, 20);
		contentPane.add(fathernationality);
		fathernationality.setColumns(10);
		
		JLabel lblFatherNationality = new JLabel("father nationality");
		lblFatherNationality.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFatherNationality.setBounds(35, 357, 186, 38);
		contentPane.add(lblFatherNationality);
		
		fatherpro = new JTextField();
		fatherpro.setBounds(207, 326, 137, 20);
		contentPane.add(fatherpro);
		fatherpro.setColumns(10);
		
		JLabel lblFatherProfession = new JLabel("father profession");
		lblFatherProfession.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFatherProfession.setBounds(33, 319, 165, 27);
		contentPane.add(lblFatherProfession);
		
		fathername = new JTextField();
		fathername.setBounds(186, 289, 137, 20);
		contentPane.add(fathername);
		fathername.setColumns(10);
		
		JLabel lblFatherName = new JLabel("father name");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFatherName.setBounds(33, 281, 132, 27);
		contentPane.add(lblFatherName);
		
		last_1 = new JTextField();
		last_1.setBounds(186, 256, 137, 20);
		contentPane.add(last_1);
		last_1.setColumns(10);
		
		JLabel last = new JLabel("Last name");
		last.setFont(new Font("Tahoma", Font.PLAIN, 22));
		last.setBounds(33, 253, 109, 17);
		contentPane.add(last);
		
		name = new JTextField();
		name.setBounds(186, 210, 137, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFirstName.setBounds(33, 207, 120, 22);
		contentPane.add(lblFirstName);
		
		
		
		JLabel lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGender.setBounds(38, 152, 79, 38);
		contentPane.add(lblGender);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		label.setBounds(0, 0, 900, 500);
		contentPane.add(label);
	}
}

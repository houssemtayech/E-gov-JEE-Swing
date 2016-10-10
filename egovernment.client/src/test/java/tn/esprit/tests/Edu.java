package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.BirthdayEvaluator;

import businessDelegator.EducationMinistryGestionDelegator;
import tn.esprit.domain.HightEducationMinistry;


import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Edu extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField last;
	private JTextField adresse;
	private JTextField atablissement;
	private JTextField level;
	private JTextField cin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edu frame = new Edu();
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
	public Edu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDateChooser birthdate = new JDateChooser();
		birthdate.setBounds(325, 422, 182, 20);
		contentPane.add(birthdate);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\khouloud\\upa1.jpg"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HightEducationMinistry student = new HightEducationMinistry();
				student.setFname(name.getText());
				student.setLname(last.getText());
				student.setAdress(adresse.getText());
			    student.setEstablisment(atablissement.getText());
			    student.setLevel(level.getText());
			    int carte = Integer.parseInt(cin.getText());
				student.setCin(carte);
				student.setBirthdate(birthdate.getDate());
			if (EducationMinistryGestionDelegator.addStudent(student)){
				JOptionPane.showMessageDialog(null, "  new student was added ");
				
			}
			else
				JOptionPane.showMessageDialog(null, "Error");
			
			
			
			
					
				
				
				
			}
		});
		btnAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnAdd.setBounds(674, 448, 49, 41);
		contentPane.add(btnAdd);
		
		
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setForeground(Color.RED);
		lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBirthdate.setBounds(164, 417, 95, 25);
		contentPane.add(lblBirthdate);
		
		cin = new JTextField();
		cin.setBounds(325, 372, 182, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		JLabel lblNumCin = new JLabel("Num cin");
		lblNumCin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNumCin.setForeground(Color.RED);
		lblNumCin.setBounds(164, 369, 108, 17);
		contentPane.add(lblNumCin);
		
		JLabel lblLevel = new JLabel("level");
		lblLevel.setForeground(Color.RED);
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLevel.setBounds(164, 325, 108, 17);
		contentPane.add(lblLevel);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setForeground(Color.RED);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdress.setBounds(164, 239, 91, 17);
		contentPane.add(lblAdress);
		
		adresse = new JTextField();
		adresse.setBounds(325, 242, 182, 20);
		contentPane.add(adresse);
		adresse.setColumns(10);
		
		level = new JTextField();
		level.setBounds(325, 328, 182, 20);
		contentPane.add(level);
		level.setColumns(10);
		
		JLabel lblEstablishment = new JLabel("establishment");
		lblEstablishment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEstablishment.setForeground(Color.RED);
		lblEstablishment.setBounds(164, 279, 143, 17);
		contentPane.add(lblEstablishment);
		
		atablissement = new JTextField();
		atablissement.setBounds(325, 276, 182, 20);
		contentPane.add(atablissement);
		atablissement.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setForeground(Color.RED);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLastName.setBounds(164, 190, 124, 17);
		contentPane.add(lblLastName);
		
		last = new JTextField();
		last.setBounds(325, 187, 182, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFirstName.setForeground(Color.RED);
		lblFirstName.setBounds(164, 141, 124, 17);
		contentPane.add(lblFirstName);
		
		name = new JTextField();
		name.setBounds(325, 141, 182, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		label.setBounds(0, 0, 905, 500);
		contentPane.add(label);
	}
}

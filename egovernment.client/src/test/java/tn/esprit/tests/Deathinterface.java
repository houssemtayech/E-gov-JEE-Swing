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

import businessDelegator.MunicipalityGestionDelegator;
import tn.esprit.domain.Municipality;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Deathinterface extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField lastname;
	private JTextField place;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deathinterface frame = new Deathinterface();
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
	public Deathinterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Ajout = new JButton("");
		Ajout.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\khouloud\\upa1.jpg"));
		
		JDateChooser death = new JDateChooser();
		death.setBounds(219, 311, 135, 20);
		contentPane.add(death);
		JDateChooser datebirth = new JDateChooser();
		datebirth.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		datebirth.setBounds(208, 256, 146, 20);
		contentPane.add(datebirth);
		Ajout.setBounds(575, 349, 53, 34);
		Ajout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String name1 = name.getText();
				String last = lastname.getText();
				String place1 =place.getText();
				Date date1= death.getDate();
				Date date2 = datebirth.getDate();
				
			if (MunicipalityGestionDelegator.DeathRegistrationByName(date1,name1, last,date2,place1)){
			
					JOptionPane.showMessageDialog(null, " death date was added ");
	
			}
			
			else 
				JOptionPane.showMessageDialog(null, " Error!! ");
				
				
				
				
			}
		});
		
		contentPane.add(Ajout);
		Ajout.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Municipality mun = new Municipality();
				mun.setDeathDate(death.getDate());
			}
		});
		
		
		
		JLabel lblDeathdate = new JLabel("death date");
		lblDeathdate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDeathdate.setForeground(Color.RED);
		lblDeathdate.setBounds(47, 311, 109, 23);
		contentPane.add(lblDeathdate);
		
		
		
		
		JLabel lblBirthPlace = new JLabel("birth place");
		lblBirthPlace.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBirthPlace.setForeground(Color.RED);
		lblBirthPlace.setBounds(39, 191, 135, 20);
		contentPane.add(lblBirthPlace);
		
		place = new JTextField();
		place.setBounds(208, 196, 146, 20);
		contentPane.add(place);
		place.setColumns(10);
		
		JLabel lblLastName = new JLabel("last name");
		lblLastName.setForeground(Color.RED);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLastName.setBounds(39, 120, 104, 17);
		contentPane.add(lblLastName);
		
		lastname = new JTextField();
		lastname.setBounds(208, 120, 135, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		JLabel lblFirstName = new JLabel("first name");
		lblFirstName.setForeground(Color.RED);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFirstName.setBounds(39, 60, 104, 27);
		contentPane.add(lblFirstName);
		
		name = new JTextField();
		name.setBounds(208, 57, 135, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblBirthDate = new JLabel("birth date");
		lblBirthDate.setForeground(Color.RED);
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBirthDate.setBounds(41, 256, 102, 20);
		contentPane.add(lblBirthDate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		label.setBounds(0, 0, 744, 383);
		contentPane.add(label);
	}
}

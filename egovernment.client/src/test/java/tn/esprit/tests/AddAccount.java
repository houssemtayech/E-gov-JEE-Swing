package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessDelegator.PostGestionDelegator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tn.esprit.domain.Poste;


public class AddAccount extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField cin;
	private JTextField ncc;
	private JTextField iban;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccount frame = new AddAccount();
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
	public AddAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fname = new JTextField();
		fname.setBounds(356, 217, 223, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(356, 266, 223, 20);
		contentPane.add(lname);
		lname.setColumns(10);
		
		cin = new JTextField();
		cin.setBounds(356, 316, 223, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		ncc = new JTextField();
		ncc.setBounds(356, 369, 223, 20);
		contentPane.add(ncc);
		ncc.setColumns(10);
		
		iban = new JTextField();
		iban.setBounds(356, 428, 223, 20);
		contentPane.add(iban);
		iban.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(152, 218, 73, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setBounds(152, 267, 73, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setBounds(152, 317, 73, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero du compte courant");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setBounds(152, 362, 187, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Code IBAN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setForeground(new Color(178, 34, 34));
		lblNewLabel_4.setBounds(152, 425, 142, 20);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\boutonValider.gif"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String f = fname.getText();
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
					poste.setState(true);
					PostGestionDelegator.addReceipt(poste);
					
						
				
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(717, 428, 65, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\arrowLeft.png"));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionPoste p= new GestionPoste();
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(672, 70, 51, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label.setForeground(new Color(178, 34, 34));
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Background.jpg"));
		label.setBounds(0, 0, 893, 496);
		contentPane.add(label);
	}
}

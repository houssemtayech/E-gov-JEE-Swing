package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessDelegator.AgentServiceDelegate;
import tn.esprit.domain.Agent;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField Login;
	private JPasswordField Pwd;
	Admin a;
	GestionPoste b;
	Edu u ;
	AffichageRequest1 r;
	MunicipalityMain m ;
	ShowServices s;
	static login frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\maher\\Desktop\\pdev\\logo.png"));
		setTitle("E-Government");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("");
		message.setBounds(245, 433, 186, 21);
		contentPane.add(message);
		
		Pwd = new JPasswordField();
		Pwd.setBounds(245, 388, 279, 33);
		contentPane.add(Pwd);
		
		Login = new JTextField();
		Login.setBounds(245, 324, 279, 33);
		contentPane.add(Login);
		Login.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Login-Form1.png"));
		lblNewLabel.setBounds(0, 0, 804, 569);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String l=Login.getText();
				String p=Pwd.getText();
				AgentServiceDelegate agd = new AgentServiceDelegate();
				Agent c=agd.Authentification(l, p);
				System.out.println(c.getRole());
				
				
				if(c.getRole().equals("Admin"))
				{a = new Admin();
				a.setVisible(true);}
				if(c.getRole().equals("Post"))
				{b = new GestionPoste();
				b.setVisible(true);}
				if(c.getRole().equals("Transport"))
				{r = new AffichageRequest1();
				r.setVisible(true);}
				if(c.getRole().equals("Education"))
				{u = new Edu();
				u.setVisible(true);}
				if(c.getRole().equals("Municipality"))
				{m = new MunicipalityMain();
				m.setVisible(true);}
				if(c.getRole().equals("Interior"))
				{s= new ShowServices();
				s.setVisible(true);}
				else System.out.println("laaaaa");
				
				
			}
		});
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(240, 458, 333, 43);
		contentPane.add(btnNewButton);
	}
}

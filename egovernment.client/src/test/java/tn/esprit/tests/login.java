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

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField Login;
	private JPasswordField Pwd;
	Admin a;
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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Login-Form.png"));
		lblNewLabel.setBounds(0, 0, 804, 569);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String l=Login.getText();
				String p=Pwd.getText();
				Agent c=AgentServiceDelegate.Authentification(l, p);
				
				if(c == null)
			 {a = new Admin();
				a.setVisible(true);}
				else
					message.setText("c bon ya m3allem");
				
			}
		});
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(240, 458, 333, 43);
		contentPane.add(btnNewButton);
	}
}

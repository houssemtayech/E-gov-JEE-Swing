package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPoste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPoste frame = new GestionPoste();
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
	public GestionPoste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel content = new JLabel("");
		content.setBounds(212, 186, 692, 316);
		contentPane.add(content);
		
		JButton btnManagementClaims = new JButton("Management Claims");
		btnManagementClaims.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Gestionrec j = new Gestionrec();
			        j.setVisible(true);
			        setVisible(false);
			}
		});
		btnManagementClaims.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnManagementClaims.setForeground(new Color(178, 34, 34));
		btnManagementClaims.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		btnManagementClaims.setBounds(36, 82, 175, 93);
		contentPane.add(btnManagementClaims);
		
		JButton btnManagementRequests = new JButton("Management Requests");
		btnManagementRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManagementRequests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gestionreq g=new Gestionreq();
				g.setVisible(true);
				setVisible(false);
			}
		});
		btnManagementRequests.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		btnManagementRequests.setForeground(new Color(178, 34, 34));
		btnManagementRequests.setBounds(36, 172, 175, 86);
		contentPane.add(btnManagementRequests);
		
		JButton btnManagementServices = new JButton("Management Services");
		btnManagementServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManagementServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddAccount a = new AddAccount();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnManagementServices.setForeground(new Color(178, 34, 34));
		btnManagementServices.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		btnManagementServices.setBounds(36, 257, 175, 86);
		contentPane.add(btnManagementServices);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Background.jpg"));
		label.setBounds(0, 0, 904, 502);
		contentPane.add(label);
	}

}

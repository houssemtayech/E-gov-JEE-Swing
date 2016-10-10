package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessDelegator.PostGestionDelegator;
import tn.esprit.domain.Poste;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Desactivate extends JFrame {

	private JPanel contentPane;
	static int x;
	static Poste p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desactivate frame = new Desactivate();
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
	public Desactivate() {
		x=Gestionreq.ccin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		p=PostGestionDelegator.findReceiptByCin(x);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\red-cross-button-refuse-wrong-answer-cancel_106349696.jpg"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				p.setState(false);
				 JOptionPane.showConfirmDialog(rootPane,"Account Desactivated");
			   
				
			}
		});
		btnNewButton.setBounds(400, 224, 118, 140);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\arrowLeft.png"));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionPoste b=new GestionPoste();
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(732, 63, 47, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Background.jpg"));
		label.setBounds(0, 0, 884, 482);
		contentPane.add(label);
	}

}

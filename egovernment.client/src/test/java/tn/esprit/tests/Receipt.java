package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessDelegator.PostGestionDelegator;
import tn.esprit.domain.Poste;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Receipt extends JFrame {

	private JPanel contentPane;
	static int x;
	Poste p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt();
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
	public Receipt( ) {
		x=Gestionreq.ccin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		p=PostGestionDelegator.findReceiptByCin(x);
		
		JLabel fname = new JLabel("");
		fname.setBounds(344, 183, 234, 23);
		contentPane.add(fname);
		
		JLabel lname = new JLabel("");
		lname.setBounds(344, 230, 234, 23);
		contentPane.add(lname);
		
		JLabel cinn = new JLabel("");
		cinn.setBounds(344, 282, 234, 23);
		contentPane.add(cinn);
		
		JLabel ncc = new JLabel("");
		ncc.setBounds(344, 345, 234, 23);
		contentPane.add(ncc);
		
		JLabel iban = new JLabel("");
		iban.setBounds(344, 401, 234, 30);
		contentPane.add(iban);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\arrowLeft.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gestionreq g=new Gestionreq();
				g.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(793, 64, 57, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\1064242.gif"));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setBounds(759, 388, 70, 72);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Background.jpg"));
		label.setBounds(0, 0, 884, 499);
		contentPane.add(label);
	
        String f=p.getFname();
        String l=p.getLname();
        String c=String.valueOf(p.getCin());
        String n=String.valueOf(p.getNcc());
        String i=String.valueOf(p.getIban());
        
        fname.setText(f);
        lname.setText(l);
        cinn.setText(c);
        ncc.setText(n);
        iban.setText(i);
        
        
	}       
  
}

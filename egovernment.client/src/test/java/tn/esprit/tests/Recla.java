package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessDelegator.ClaimGestionDelegator;
import tn.esprit.domain.Reclamation;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Recla extends JFrame {

	private JPanel contentPane;
	private JTextField sujet;
	private JTextField text;
	private JLabel lblSubject;
	private JLabel lblText;
	private JLabel lblType;
	private JRadioButton Tecnical;
	private final Action action = new SwingAction();
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recla frame = new Recla();
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
	/**
	 * 
	 */
	public Recla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sujet = new JTextField();
		sujet.setBounds(312, 234, 220, 20);
		contentPane.add(sujet);
		sujet.setColumns(10);
		
		text = new JTextField();
		text.setBounds(312, 288, 220, 81);
		contentPane.add(text);
		text.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\images.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s=sujet.getText();
				String t=text.getText();
				
				Reclamation re= new Reclamation();
				if((s.equals(""))&&(t.equals("")) ){
					 final JPanel panel = new JPanel();
					 JOptionPane.showMessageDialog(panel, "You have to fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else{
				re.setSujet(s);
				re.setText(t);
				if(Tecnical.isSelected())
				{
					re.setType("Tecnical");
					ClaimGestionDelegator.addClaim(re);
					JOptionPane.showConfirmDialog(rootPane,"Send your claim");
				}
				
				else
				{
				  final JPanel panel = new JPanel();
				 JOptionPane.showMessageDialog(panel, "You have to select the Type", "Error", JOptionPane.ERROR_MESSAGE);
				
				}
			
			}}
		});
		btnNewButton.setBounds(583, 454, 49, 23);
		contentPane.add(btnNewButton);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblSubject.setForeground(new Color(178, 34, 34));
		lblSubject.setBounds(180, 228, 100, 23);
		contentPane.add(lblSubject);
		
		lblText = new JLabel("Text");
		lblText.setForeground(new Color(178, 34, 34));
		lblText.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblText.setBounds(180, 303, 100, 14);
		contentPane.add(lblText);
		
		lblType = new JLabel("Type");
		lblType.setForeground(new Color(178, 34, 34));
		lblType.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblType.setBounds(180, 391, 100, 19);
		contentPane.add(lblType);
		
		Tecnical = new JRadioButton("Tecnical");
		Tecnical.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Tecnical.setAction(action);
		Tecnical.setText("Tecnical");
		Tecnical.setBounds(337, 391, 109, 23);
		contentPane.add(Tecnical);
		
		button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gestionrec g=new Gestionrec();
				g.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\arrowLeft.png"));
		button.setBounds(809, 76, 49, 51);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Background.jpg"));
		label.setBounds(0, 0, 893, 510);
		contentPane.add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

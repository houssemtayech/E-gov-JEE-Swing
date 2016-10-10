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
import java.awt.SystemColor;

public class AddClaim extends JFrame {

	private JPanel contentPane;
	private JTextField sujet;
	private JTextField text;
	private JLabel lblSubject;
	private JLabel lblText;
	private JLabel lblType;
	private JRadioButton Tecnical;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClaim frame = new AddClaim();
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
	public AddClaim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sujet = new JTextField();
		sujet.setBackground(SystemColor.inactiveCaptionBorder);
		sujet.setFont(new Font("Tahoma", Font.BOLD, 14));
		sujet.setBounds(312, 218, 220, 44);
		contentPane.add(sujet);
		sujet.setColumns(10);
		
		text = new JTextField();
		text.setBackground(SystemColor.inactiveCaptionBorder);
		text.setFont(new Font("Tahoma", Font.BOLD, 14));
		text.setForeground(SystemColor.desktop);
		text.setBounds(312, 288, 220, 88);
		contentPane.add(text);
		text.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\Reclamation.png"));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
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
					final JPanel panel = new JPanel();
					int Result = JOptionPane.showConfirmDialog(panel, "Are you sure to send this kind of claim!!!", "Sending technical Claim",JOptionPane.YES_NO_OPTION);
							if(Result==JOptionPane.YES_NO_OPTION){
								ClaimGestionDelegator.addClaim(re);
								setVisible(false);
								dispose();
								new ListClaims().setVisible(true);
							}
							//traitement si l’usager a appuyé sur oui.
							else{
								setVisible(false);
								dispose();
								new AddClaim().setVisible(true);
							}
					
					
				}
				
				else
				{
				 final JPanel panel = new JPanel();
				 JOptionPane.showMessageDialog(panel, "You have to select the Type", "Error", JOptionPane.ERROR_MESSAGE);
				
				}
			
			}}
		});
		btnNewButton.setBounds(520, 436, 40, 33);
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
		Tecnical.setBounds(335, 389, 109, 23);
		contentPane.add(Tecnical);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				dispose();
				new ListClaims().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\back.jpg"));
		button.setForeground(new Color(102, 153, 51));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(153, 153, 255));
		button.setBounds(36, 71, 42, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				dispose();
				new AddClaim().setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\refresh.jpg"));
		button_1.setForeground(new Color(102, 153, 51));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(new Color(153, 153, 255));
		button_1.setBounds(797, 71, 67, 71);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setBackground(SystemColor.activeCaption);
		label.setForeground(SystemColor.desktop);
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\Background.png"));
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

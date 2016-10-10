package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessDelegator.EducationMinistryGestionDelegator;
import tn.esprit.domain.HightEducationMinistry;

import tn.esprit.services.EducationMinistryGestion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Taswira extends JFrame {

	private JPanel contentPane;
	private JButton btnAddPicture = new JButton("Add diploma");
	private JTextField tfCin;
	private byte[] photo;
	  Clip buhClip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taswira frame = new Taswira();
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
	public Taswira() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\khouloud\\upa1.jpg"));
		//final JFileChooser fc = new JFileChooser();
		btnAddPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser dialogue = new JFileChooser(new File("."));
				PrintWriter sortie;
				File fichier;
								   
				   if (dialogue.showOpenDialog(null)== 
				    JFileChooser.APPROVE_OPTION) {
				    fichier = dialogue.getSelectedFile();
				   String ch;
				   
				try {
					ch = fichier.getPath();
					 System.out.println(ch);
					   EducationMinistryGestion ee = new EducationMinistryGestion();
					  
					  					   
					   byte[] bb = ch.getBytes("US-ASCII");
					   photo = bb;
					   //System.out.println("c bon");
					  
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
				 
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				   HightEducationMinistry c = EducationMinistryGestionDelegator.findStudentByCin(Integer.parseInt(tfCin.getText()));
				   c.setDiploma(photo);
				   
				   if (EducationMinistryGestionDelegator.addDiploma(c,photo))
						JOptionPane.showMessageDialog(null, "Diplome ajouté");
					else
						JOptionPane.showMessageDialog(null, "Erreur diplome non ajouté");
					
				   
			}
		});
		
		btnAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnAdd.setBounds(719, 444, 49, 44);
		contentPane.add(btnAdd);
		
		
		btnAddPicture.setBounds(389, 387, 144, 23);
		contentPane.add(btnAddPicture);
		
		tfCin = new JTextField();
		tfCin.setBounds(350, 272, 212, 20);
		contentPane.add(tfCin);
		tfCin.setColumns(10);
		
		JLabel lblCin = new JLabel("cin :");
		lblCin.setForeground(Color.RED);
		lblCin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCin.setBounds(231, 264, 109, 27);
		contentPane.add(lblCin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		label.setBounds(0, 0, 900, 500);
		contentPane.add(label);
	}
}

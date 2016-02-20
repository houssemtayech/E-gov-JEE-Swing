package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Reclamation;

import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import businessDelegator.AdminServiceDelegate;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminclaim extends JFrame {

	private JPanel contentPane;
	List<Reclamation> lagent;
	Reclamation reclamation;
	private JTable table;
	String[][] donnes ;
	static Adminclaim frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Adminclaim();
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
	public Adminclaim() {
		lagent =new ArrayList<Reclamation>();
	
		lagent=AdminServiceDelegate.findReclamationByType();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton delete = new JButton("delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = table.getSelectedRow();
				int z = Integer.parseInt(donnes[x][0]);
				
				AdminServiceDelegate.deleteClaim(z);
				affichage();
			}
		});
	
		
		JButton btnNewButton = new JButton("Claim");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichage();
				
			}
		});
		btnNewButton.setBounds(632, 0, 89, 454);
		contentPane.add(btnNewButton);
		
		JButton btnAgent = new JButton("Agent");
		btnAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a =new Admin();
				a.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnAgent.setBounds(0, 0, 89, 454);
		contentPane.add(btnAgent);
		JLabel labelname = new JLabel("");
		labelname.setBounds(270, 343, 133, 35);
		contentPane.add(labelname);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				labelname.setText(donnes[a][1]);
			}
		});
		table.setBounds(106, 49, 501, 243);
		contentPane.add(table);
		delete.setBounds(270, 397, 133, 29);
		contentPane.add(delete);
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 721, 454);
		contentPane.add(label);
		
		
		
	}
	public void affichage(){
		try {
			
			lagent = AdminServiceDelegate.findReclamationByType();
			System.out.println("done");
			donnes = new String[lagent.size()][3];
			
			for (int i = 0; i < lagent.size(); i++) {
			
				donnes[i][0] = String.valueOf(lagent.get(i).getId());
				donnes[i][1] = lagent.get(i).getSujet();
				donnes[i][2] = lagent.get(i).getText();
				
				
				
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "Id","Subject","Text"}));
			System.out.println("DOOne");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
	}}

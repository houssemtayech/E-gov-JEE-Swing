package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessDelegator.ClaimGestionDelegator;
import tn.esprit.domain.Reclamation;


import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DisplayRec extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Reclamation> r;
	int i;
	String[][] donnes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayRec frame = new DisplayRec();
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
	public DisplayRec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 320, 569, -312);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(149, 19, 569, 288);
		contentPane.add(table);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					r = new ArrayList<Reclamation>();
					r = ClaimGestionDelegator.findReclamationByType("Service");
					System.out.println("done");
					donnes = new String[r.size()][4];
					for (i = 0; i < r.size(); i++) {
						donnes[i][0] = String.valueOf(r.get(i).getId());
						donnes[i][1] = r.get(i).getSujet();
						donnes[i][2] = r.get(i).getText();
						donnes[i][3] = r.get(i).getType();
						
						
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "id","Subject", "Text", "Type"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDisplay.setBounds(234, 342, 89, 42);
		contentPane.add(btnDisplay);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reclamation rec= new Reclamation();
				int a=table.getSelectedRow();
				int x = Integer.parseInt(donnes[a][0]);
				
				ClaimGestionDelegator.deleteClaim(x);
				try {
					r = new ArrayList<Reclamation>();
					r = ClaimGestionDelegator.findReclamationByType("Tecnical");
					System.out.println("done");
					donnes = new String[r.size()][4];
					for (i = 0; i < r.size(); i++) {
						donnes[i][0] = String.valueOf(r.get(i).getId());
						donnes[i][1] = r.get(i).getSujet();
						donnes[i][2] = r.get(i).getText();
						donnes[i][3] = r.get(i).getType();
						
						
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "id","Subject", "Text", "Type"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(543, 342, 89, 42);
		contentPane.add(btnDelete);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gestionrec g=new Gestionrec();
				g.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\arrowLeft.png"));
		button.setBounds(776, 36, 42, 42);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Background.jpg"));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 844, 429);
		contentPane.add(lblNewLabel);
	}
}

package tn.esprit.tests;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.List;


import businessDelegator.ClaimGestionDelegator;
import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;


import javax.swing.UIManager;
import java.awt.FlowLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import java.awt.Component;
import java.awt.SystemColor;
import java.util.ArrayList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListClaims extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Reclamation> rec;
	int i;
	String[][] donnes;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListClaims frame = new ListClaims();
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
	public ListClaims() {
		setTitle("Claims");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 569, -233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));
		table.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(153, 50, 204)));
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setBounds(181, 192, 548, 165);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("You want to send a claim!!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new AddClaim().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(367, 420, 167, 35);
		contentPane.add(btnNewButton);
		
		JButton btnDisplayClaims = new JButton("Display claims");
		btnDisplayClaims.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				
				try {
					rec = new ArrayList<Reclamation>();
					rec = (ArrayList<Reclamation>) ClaimGestionDelegator.findReclamationByType("Service");
					System.out.println("done");
					donnes = new String[rec.size()][4];
					for (i = 0; i < rec.size(); i++) {
						donnes[i][0] = String.valueOf(rec.get(i).getId());
						donnes[i][1] = rec.get(i).getSujet();
						donnes[i][2] = rec.get(i).getText();
						donnes[i][3] = rec.get(i).getType();
						
						
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "id","Subject", "Text", "Type"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		btnDisplayClaims.setForeground(new Color(128, 0, 0));
		btnDisplayClaims.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDisplayClaims.setBackground(new Color(0, 139, 139));
		btnDisplayClaims.setBounds(4, 248, 141, 35);
		contentPane.add(btnDisplayClaims);
		
		JButton btnDeleteClaims = new JButton("Delete claims");
		btnDeleteClaims.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Reclamation r= new Reclamation();
				int a=table.getSelectedRow();
				int x = Integer.parseInt(donnes[a][0]);
				ClaimGestionDelegator.deleteClaim(x);
				try {
					rec = new ArrayList<Reclamation>();
					rec = (ArrayList<Reclamation>) ClaimGestionDelegator.findReclamationByType("Service");
					System.out.println("done");
					donnes = new String[rec.size()][4];
					for (i = 0; i < rec.size(); i++) {
						donnes[i][0] = String.valueOf(rec.get(i).getId());
						donnes[i][1] = rec.get(i).getSujet();
						donnes[i][2] = rec.get(i).getText();
						donnes[i][3] = rec.get(i).getType();
						
						
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "id","Subject", "Text", "Type"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnDeleteClaims.setForeground(new Color(128, 0, 0));
		btnDeleteClaims.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteClaims.setBackground(new Color(0, 139, 139));
		btnDeleteClaims.setBounds(738, 248, 141, 35);
		contentPane.add(btnDeleteClaims);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				dispose();
				new ShowServices().setVisible(true);
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\back.jpg"));
		button.setForeground(new Color(102, 153, 51));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(153, 153, 255));
		button.setBounds(23, 74, 42, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				new ListClaims().setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\refresh.jpg"));
		button_1.setForeground(new Color(102, 153, 51));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(new Color(153, 153, 255));
		button_1.setBounds(758, 74, 67, 71);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 888, 498);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\Background.png"));
		contentPane.add(lblNewLabel);
		initDataBindings();
		


	}
	protected void initDataBindings() {
		JTableBinding<Reclamation, java.util.List<Reclamation>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, rec, table);
		//
		BeanProperty<Reclamation, Integer> reclamationBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(reclamationBeanProperty).setColumnName("New Column");
		//
		BeanProperty<Reclamation, String> reclamationBeanProperty_1 = BeanProperty.create("sujet");
		jTableBinding.addColumnBinding(reclamationBeanProperty_1).setColumnName("New Column");
		//
		BeanProperty<Reclamation, String> reclamationBeanProperty_2 = BeanProperty.create("text");
		jTableBinding.addColumnBinding(reclamationBeanProperty_2).setColumnName("New Column");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
	}
package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;


import java.util.ArrayList;
import java.util.List;


import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import businessDelegator.RequestGestionDelegator;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JComboBox;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import javax.swing.DefaultComboBoxModel;


public class Gestionreq extends JFrame {
	private AutoBinding<JComboBoxBinding, JComboBoxBinding, JComboBox, Integer> Receipt;

	private JPanel contentPane;
	private JTable table;
	List<Request> r;
	int i;
	String[][] donnes;
	private JComboBox combo;
	int b; 
	static int ccin;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestionreq frame = new Gestionreq();
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
	public Gestionreq() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Display Requests");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String[] b=new String[]{ "Id","CIN", "Service"};
					r = new ArrayList<Request>();
					
					//List<Request> r = null;
					System.out.println(RequestGestionDelegator.findRequestByDepartement("Poste"));
					r.addAll(RequestGestionDelegator.findRequestByDepartement("Poste"));
					
					donnes = new String[r.size()][3];
					for (i = 0; i < r.size(); i++) {
						donnes[i][0] = String.valueOf(r.get(i).getId());
						donnes[i][1] = String.valueOf(r.get(i).getCin());
						donnes[i][2] = r.get(i).getService();
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							b));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 112, 140, 69);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Request r= new Request();
				int a=table.getSelectedRow();
				String x = donnes[a][2];
								
				if(x.equals("Receipt")){
					
					
					b=table.getSelectedRow();
					System.out.println(b);
					 ccin = Integer.parseInt(donnes[b][1]);
					System.out.println(ccin);
									
					Receipt rc =new Receipt();
					System.out.println("molka");
					rc.setVisible(true);
					setVisible(false);
				}
				else if (x.equals("Desactivate account")){
					b=table.getSelectedRow();
					System.out.println(b);
					 ccin = Integer.parseInt(donnes[b][1]);
					System.out.println(ccin);
									
					Desactivate d =new Desactivate();
					System.out.println("molka");
					d.setVisible(true);
					setVisible(false);
				}
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(10, 179, 140, 69);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(730, 443, -460, -216);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(280, 219, 453, 226);
		contentPane.add(table);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Refresh-icon1.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gestionreq g= new Gestionreq();
				g.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_2.setBounds(622, 64, 55, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\arrowLeft.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionPoste p= new GestionPoste();
					p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(729, 64, 55, 43);
		contentPane.add(btnNewButton_3);
		
		combo = new JComboBox();
		combo.setForeground(new Color(178, 34, 34));
		combo.setModel(new DefaultComboBoxModel(new String[] {"Desactivate account", "Receipt"}));
		combo.setToolTipText("D\u00E9sactiver Compte\r\nReceipt");
		combo.setFont(new Font("Tahoma", Font.BOLD, 12));
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo.getSelectedIndex()==0){
					try {
						r = new ArrayList<Request>();
						System.out.println("doneeeeeeeeeeee");
						
						r.addAll(RequestGestionDelegator.findRequestByType("Desactivate account"));
						
						donnes = new String[r.size()][3];
						for (i = 0; i < r.size(); i++) {
							donnes[i][0] = String.valueOf(r.get(i).getId());
							donnes[i][1] = String.valueOf(r.get(i).getCin());
							donnes[i][2] = r.get(i).getService();
							
						}
						table.setModel(new javax.swing.table.DefaultTableModel(donnes,
								new String[] { "Id","CIN", "Service"}));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}else if (combo.getSelectedIndex()==1){
					try {
						r = new ArrayList<Request>();
						System.out.println("doneeeeeeeeeeee");
						
						r.addAll(RequestGestionDelegator.findRequestByType("Receipt"));
						
						donnes = new String[r.size()][3];
						for (i = 0; i < r.size(); i++) {
							donnes[i][0] = String.valueOf(r.get(i).getId());
							donnes[i][1] = String.valueOf(r.get(i).getCin());
							donnes[i][2] = r.get(i).getService();
							
						}
						table.setModel(new javax.swing.table.DefaultTableModel(donnes,
								new String[] { "Id","CIN", "Service"}));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
		
			}
		});
		combo.setBounds(10, 308, 150, 26);
		contentPane.add(combo);
		
		JLabel lblReceiptDesactivate = new JLabel("Receipt\r\nDesactivate");
		lblReceiptDesactivate.setLabelFor(combo);
		lblReceiptDesactivate.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\molka\\pics\\Background.jpg"));
		lblReceiptDesactivate.setBounds(0, 0, 898, 499);
		contentPane.add(lblReceiptDesactivate);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Request, List<Request>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, r, table);
		//
		BeanProperty<Request, Integer> requestBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(requestBeanProperty).setColumnName("New Column");
		//
		BeanProperty<Request, Integer> requestBeanProperty_1 = BeanProperty.create("cin");
		jTableBinding.addColumnBinding(requestBeanProperty_1).setColumnName("New Column");
		//
		BeanProperty<Request, String> requestBeanProperty_2 = BeanProperty.create("service");
		jTableBinding.addColumnBinding(requestBeanProperty_2).setColumnName("New Column");
		//
		jTableBinding.bind();
		//
		JComboBoxBinding<Request, List<Request>, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, r, combo, "Receipt");
		jComboBinding.bind();
		//
		BeanProperty<JComboBox, Integer> jComboBoxBeanProperty = BeanProperty.create("itemCount");
		Receipt = Bindings.createAutoBinding(UpdateStrategy.READ, jComboBinding, combo, jComboBoxBeanProperty);
		Receipt.bind();
	}
}

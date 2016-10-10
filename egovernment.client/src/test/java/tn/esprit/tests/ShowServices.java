package tn.esprit.tests;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.Font;

import businessDelegator.RequestGestionDelegator;
import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;


import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JSlider;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ShowServices extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Request> r;
	int i;
	String[][] donnes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowServices frame = new ShowServices();
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
	public ShowServices() {
		
		setTitle("Interior Ministry");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 569, -233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));
		table.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(153, 50, 204)));
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setBounds(230, 189, 548, 165);
		contentPane.add(table);
		
		JButton btnDisplay = new JButton("Display Requests");
		btnDisplay.setBackground(SystemColor.activeCaption);
		btnDisplay.setForeground(new Color(128, 0, 0));
		btnDisplay.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
		btnDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					r = new ArrayList<Request>();
					r = RequestGestionDelegator.findRequestByDepartement("Interior Ministry");
					System.out.println("done");
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
		});
		btnDisplay.setBounds(10, 314, 185, 40);
		contentPane.add(btnDisplay);
				
				JButton btnModifyCitizen = new JButton("Modify Citizen");
				
				btnModifyCitizen.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						setVisible(false);
						dispose();
						new ModifyCitizenInterior().setVisible(true);
						
					}
				});
				btnModifyCitizen.setForeground(new Color(128, 0, 0));
				btnModifyCitizen.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
				btnModifyCitizen.setBackground(SystemColor.activeCaption);
				btnModifyCitizen.setBounds(10, 241, 185, 40);
				contentPane.add(btnModifyCitizen);
				
				JButton btnAddPerson = new JButton("Add Citizen");
				btnAddPerson.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						setVisible(false);
						dispose();
						new AddCitizenInterior().setVisible(true);
						
					}
				});
				btnAddPerson.setForeground(new Color(128, 0, 0));
				btnAddPerson.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
				btnAddPerson.setBackground(SystemColor.activeCaption);
				btnAddPerson.setBounds(10, 164, 185, 40);
				contentPane.add(btnAddPerson);
				
				JButton btnGestionServices = new JButton("");
				btnGestionServices.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\service.jpg"));
				btnGestionServices.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						setVisible(false);
						dispose();
						new ShowServices().setVisible(true);
						
					}
				});
				btnGestionServices.setForeground(new Color(128, 0, 0));
				btnGestionServices.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
				btnGestionServices.setBackground(SystemColor.textHighlight);
				btnGestionServices.setBounds(205, 73, 98, 103);
				contentPane.add(btnGestionServices);
				
				JButton btnClaims = new JButton("");
				btnClaims.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\aaaaa.png"));
				btnClaims.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						setVisible(false);
						dispose();
						new ListClaims().setVisible(true);
					}
				});
				btnClaims.setForeground(new Color(128, 0, 0));
				btnClaims.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
				btnClaims.setBackground(SystemColor.activeCaption);
				btnClaims.setBounds(610, 73, 98, 103);
				contentPane.add(btnClaims);
				
				JLabel lblNewLabel = new JLabel("Search requests by type:");
				lblNewLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
				lblNewLabel.setBounds(150, 423, 177, 27);
				contentPane.add(lblNewLabel);
				
				JSpinner spinner = new JSpinner();
				spinner.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
				spinner.setBackground(new Color(173, 216, 230));
				spinner.setModel(new SpinnerListModel(new String[] {"CIN", "Bulletin 3", "Residence Certificate"}));
				spinner.setBounds(337, 425, 159, 27);
				contentPane.add(spinner);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\OK.png"));
				btnNewButton.setBackground(SystemColor.activeCaption);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							r = new ArrayList<Request>();
							System.out.println(spinner.getValue());
							r = RequestGestionDelegator.findRequestByType(spinner.getValue()+"");
							System.out.println("done");
							donnes = new String[r.size()][3];
							for (i = 0; i < r.size(); i++) {
								donnes[i][0] = String.valueOf(r.get(i).getId());
								donnes[i][1] = String.valueOf(r.get(i).getCin());
								donnes[i][2] = r.get(i).getService();
								
								
								
								
							} System.out.println("ooo");
							table.setModel(new javax.swing.table.DefaultTableModel(donnes,
									new String[] { "Id","CIN", "Service"}));
							
						} catch (Exception e1) {
							e1.printStackTrace();
							
						}
						
					}
				});
				btnNewButton.setForeground(new Color(128, 0, 0));
				btnNewButton.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
				btnNewButton.setBounds(506, 409, 60, 49);
				contentPane.add(btnNewButton);
				
				JButton btnDetails = new JButton("Details");
				btnDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				
				btnDetails.setBackground(SystemColor.activeCaption);
				btnDetails.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						Request r= new Request();
						int a=table.getSelectedRow();
						int x = Integer.parseInt(donnes[a][1]);
						
						new PersonInteriorDetails(x).setVisible(true);
						setVisible(false);
						
						
						//InteriorMinistryGestionDelegator.findPersonByCin(x);
						
					}
				});
				
				btnDetails.setForeground(new Color(128, 0, 0));
				btnDetails.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
				btnDetails.setBounds(791, 232, 98, 49);
				contentPane.add(btnDetails);
		
				JLabel mainLabel = new JLabel("");
				mainLabel.setForeground(new Color(0, 0, 0));
				mainLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
				mainLabel.setBounds(-8, 0, 897, 519);
				contentPane.add(mainLabel);
				
				mainLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\Background.png"));
				initDataBindings();


}
	protected void initDataBindings() {
		JTableBinding<Request, List<Request>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, r, table);
		//
		BeanProperty<Request, Integer> requestBeanProperty = BeanProperty.create("CIN");
		jTableBinding.addColumnBinding(requestBeanProperty).setColumnName("New Column");
		//
		BeanProperty<Request, String> requestBeanProperty_1 = BeanProperty.create("service");
		jTableBinding.addColumnBinding(requestBeanProperty_1).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
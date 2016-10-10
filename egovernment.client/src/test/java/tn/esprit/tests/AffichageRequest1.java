package tn.esprit.tests;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import businessDelegator.MinistryTransportDelegate;
import tn.esprit.domain.Bus;

import tn.esprit.domain.Request;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AffichageRequest1 extends JFrame {
	

	private JPanel contentPane;
	List<Request>requests;
	List< Bus > Buss;
	int i;
	private JTable table;
	int ccin=0;
	int id=0;
	String depa=null,service=null;

	
	

	/**
	 * Launch the application.
	 */


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageRequest1 frame = new AffichageRequest1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AffichageRequest1() {
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) { 
		
			}
		});
		panel.setBounds(10, 119, 365, 210);
		contentPane.add(panel);
		
		JButton btnShow = new JButton("show");
		btnShow.setBounds(54, 174, 80, 23);
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					requests = new ArrayList<Request>();
				requests =MinistryTransportDelegate.doviewrequestsub("subscription transport",0);
				
				
					String[][] donnes = new String[requests.size()][3];
					for (i = 0; i < requests.size(); i++) {
					
						donnes[i][0] = String.valueOf(requests.get(i).getCin());
						donnes[i][1] = requests.get(i).getService();
						
						donnes[i][2] = requests.get(i).getDepartement();
					
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "CIN","Service","Departement"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		panel.setLayout(null);
		panel.add(btnShow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
		
				ccin=(requests.get(table.getSelectedRow()).getCin());
			System.out.println(ccin);
			id=(requests.get(table.getSelectedRow()).getId());
			System.out.println(id);
			depa=(requests.get(table.getSelectedRow()).getDepartement());
			System.out.println(depa);
			service=(requests.get(table.getSelectedRow()).getService());
			System.out.println(service);
			
				
			}
		});
		scrollPane.setBounds(10, 11, 348, 152);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnInformation = new JButton("Information");
	
		btnInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (ccin==0){
					JOptionPane.showMessageDialog(null  , " Please click on the table First");
				}else{
				System.out.println(ccin);
				System.out.println(id);
				
		new Viewappanement(ccin,id ).setVisible(true);
		setVisible(false);
		
				}
			}
		});
		btnInformation.setBounds(206, 174, 89, 23);
		panel.add(btnInformation);
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 629, 21);
		contentPane.add(menuBar);
		
		JMenu mnPublicTransportSubscription_1 = new JMenu("Public Transport subscription");
		menuBar.add(mnPublicTransportSubscription_1);
		
		JMenu mnCarSticker = new JMenu("Car Sticker");
		mnCarSticker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AffichageCar().setVisible(true);
				setVisible(false);
				
			}
		});
		menuBar.add(mnCarSticker);
		
		JMenu mnHome = new JMenu("Mangement claim");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			
				
				
			}
		});
		menuBar.add(mnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		label.setBounds(10, 27, 609, 329);
		contentPane.add(label);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Request, List<Request>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, requests, table);
		//
		BeanProperty<Request, String> requestBeanProperty = BeanProperty.create("service");
		jTableBinding.addColumnBinding(requestBeanProperty).setColumnName("New Column");
		//
		BeanProperty<Request, String> requestBeanProperty_1 = BeanProperty.create("departement");
		jTableBinding.addColumnBinding(requestBeanProperty_1).setColumnName("Department");
		//
		jTableBinding.bind();
	}
}
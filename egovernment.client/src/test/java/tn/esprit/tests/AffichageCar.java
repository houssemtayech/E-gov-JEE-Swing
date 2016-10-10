package tn.esprit.tests;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.domain.Request;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import businessDelegator.MinistryTransportDelegate;

import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AffichageCar extends JFrame {

	private JPanel contentPane;
	List<Request>requests;
	int i,id;

	int ccin=0;
String sservice=null;
int ddepartement=0;
	private JTable table;
	int idreque=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageCar frame = new AffichageCar();
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
	public AffichageCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 30, 397, 282);
		contentPane.add(panel);
		
	
		JButton button = new JButton("show");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					requests = new ArrayList<Request>();
					requests =MinistryTransportDelegate.doviewrequestsub("Car sticker",0);
				
					String[][] donnes = new String[requests.size()][2];
					for (i = 0; i < requests.size(); i++) {
					
						donnes[i][0] = String.valueOf(requests.get(i).getCin());
						donnes[i][1] = requests.get(i).getService();
					
						
					}
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "CIN","Service"}));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
	
			}
		});
		
		JButton btnInformation = new JButton("Information");
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				ccin=(requests.get(table.getSelectedRow()).getCin());
			id=(requests.get(table.getSelectedRow()).getId());
			
				
				
			}
		});
		
		btnInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				System.out.println(ccin);
				if (ccin==0){
					JOptionPane.showMessageDialog(null  , " Please click on the table First");
				}else{
				new InformationCar(ccin,id).setVisible(true);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(btnInformation)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInformation)
						.addComponent(button))
					.addGap(43))
		);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 629, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Public Transport subscription");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AffichageRequest1().setVisible(true);
				setVisible(false);
			}
		});
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("Car Sticker");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("Mangement claim");
		menuBar.add(menu_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		lblNewLabel.setBounds(10, 32, 609, 324);
		contentPane.add(lblNewLabel);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Request, List<Request>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, requests, table);
		//
		BeanProperty<Request, Integer> requestBeanProperty = BeanProperty.create("cin");
		jTableBinding.addColumnBinding(requestBeanProperty).setColumnName("New Column");
		//
		BeanProperty<Request, String> requestBeanProperty_1 = BeanProperty.create("service");
		jTableBinding.addColumnBinding(requestBeanProperty_1).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}

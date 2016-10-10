package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import tn.esprit.domain.Agent;
import tn.esprit.services.AdminGestion;

import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;

import businessDelegator.AdminServiceDelegate;
import businessDelegator.AgentServiceDelegate;

import javax.swing.border.BevelBorder;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField pwd;
	private JTextField role;
	private JTable table;
	Agent agent=new Agent();
	String[][] donnes ;
	
	/**
	 * Launch the application.
	 */
	
	public void affichage(){
		try {
			List<Agent> agents= new ArrayList<Agent>();
			agents = AdminServiceDelegate.findAgent();
			System.out.println("done");
			donnes = new String[agents.size()][4];
			donnes[0][0] = "Id";
			donnes[0][1] = "Login";
			donnes[0][2] = "Password";
			donnes[0][3] = "Role";
			for (int i = 0; i < agents.size(); i++) {
			
				donnes[i][0] = String.valueOf(agents.get(i).getId());
				donnes[i][1] = agents.get(i).getLogin();
				donnes[i][2] = agents.get(i).getPwd();
				donnes[i][3] = agents.get(i).getRole();
				
				
				
			}
			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "Id","Login","Password","Role" }));
			System.out.println("DOOne");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	static Admin frame ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Admin();
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
	public Admin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				login.setText(donnes[a][1]);
				pwd.setText(donnes[a][2]);
				role.setText(donnes[a][3]);
			}
		});
		JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"Health", "Transport", "Municipality", "Education", "interior", "Post"}));
		combo.setBounds(489, 307, 133, 20);
		contentPane.add(combo);
		table.setBounds(104, 0, 688, 278);
		contentPane.add(table);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 246, 535, -234);
		contentPane.add(scrollPane);
		
		login = new JTextField();
		login.setBounds(154, 378, 126, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(389, 378, 126, 20);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		role = new JTextField();
		role.setBounds(633, 378, 126, 20);
		contentPane.add(role);
		role.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\BackgroundAdmin63.png"));
		label.setBounds(0, 0, 900, 500);
		contentPane.add(label);
		
		JButton add = new JButton("add");
		add.setOpaque(false);
		add.setBounds(122, 444, 158, 40);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agent a = new Agent();
				a.setLogin(login.getText());
				a.setPwd(pwd.getText());
				a.setRole(role.getText());
				AdminServiceDelegate.addAgent(a);
				affichage();
					
					
				
				
				
				}}
		);
		contentPane.add(add);
		
		JButton update = new JButton("update");
		update.setOpaque(false);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = table.getSelectedRow();
				int z = Integer.parseInt(donnes[x][0]);
				String log = login.getText();
				String pass = pwd.getText();
				String roll= role.getText();
				AdminServiceDelegate.updateAgent(z, log, pass, roll);
				affichage();
				
			}
		});
		update.setBounds(379, 444, 149, 40);
		contentPane.add(update);
		
		JButton delete = new JButton("Delete");
		delete.setOpaque(false);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = table.getSelectedRow();
				int z = Integer.parseInt(donnes[x][0]);
				
				AdminServiceDelegate.deleteAgent(z);
				affichage();
			}
		});
		delete.setBounds(616, 444, 149, 40);
		contentPane.add(delete);
		
		JButton btnNewButton = new JButton("Agent");
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichage();
			}
		});
		btnNewButton.setBounds(0, 0, 89, 500);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Claim");
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminclaim a = new Adminclaim();
				a.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(809, 0, 89, 500);
		contentPane.add(btnNewButton_1);
		JButton btnGg = new JButton("gg");
		btnGg.setOpaque(false);
		btnGg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int k =combo.getSelectedIndex();
				List<Agent> agents= new ArrayList<Agent>();
				
				if(k == 0)
				{
					agents = AdminServiceDelegate.findAgentByRole("Health");
					donnes = new String[agents.size()][4];
				
				for (int i = 0; i < agents.size(); i++) {
				
					donnes[i][0] = String.valueOf(agents.get(i).getId());
					donnes[i][1] = agents.get(i).getLogin();
					donnes[i][2] = agents.get(i).getPwd();
					donnes[i][3] = agents.get(i).getRole();
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "Id","Login","Password","Role" }));
					System.out.println("DOOne");
					}
			}
				if(k==1)
				{
					agents = AdminServiceDelegate.findAgentByRole("Transport");
					donnes = new String[agents.size()][4];
				
				for (int i = 0; i < agents.size(); i++) {
				
					donnes[i][0] = String.valueOf(agents.get(i).getId());
					donnes[i][1] = agents.get(i).getLogin();
					donnes[i][2] = agents.get(i).getPwd();
					donnes[i][3] = agents.get(i).getRole();
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "Id","Login","Password","Role" }));
					System.out.println("DOOne");
				}
				
			}
				if(k==2)
				{
					agents = AdminServiceDelegate.findAgentByRole("Municipality");
					donnes = new String[agents.size()][4];
				
				for (int i = 0; i < agents.size(); i++) {
				
					donnes[i][0] = String.valueOf(agents.get(i).getId());
					donnes[i][1] = agents.get(i).getLogin();
					donnes[i][2] = agents.get(i).getPwd();
					donnes[i][3] = agents.get(i).getRole();
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "Id","Login","Password","Role" }));
					System.out.println("DOOne");	
				}
			}
				if(k==3)
				{
					agents = AdminServiceDelegate.findAgentByRole("Education");
					donnes = new String[agents.size()][4];
				
				for (int i = 0; i < agents.size(); i++) {
				
					donnes[i][0] = String.valueOf(agents.get(i).getId());
					donnes[i][1] = agents.get(i).getLogin();
					donnes[i][2] = agents.get(i).getPwd();
					donnes[i][3] = agents.get(i).getRole();
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "Id","Login","Password","Role" }));
					System.out.println("DOOne");	
				}
			}
				if(k==4)
				{
					agents = AdminServiceDelegate.findAgentByRole("interior");
					donnes = new String[agents.size()][4];
				
				for (int i = 0; i < agents.size(); i++) {
				
					donnes[i][0] = String.valueOf(agents.get(i).getId());
					donnes[i][1] = agents.get(i).getLogin();
					donnes[i][2] = agents.get(i).getPwd();
					donnes[i][3] = agents.get(i).getRole();
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "Id","Login","Password","Role" }));
					System.out.println("DOOne");	
				}
			}
				if(k==5)
				{
					agents = AdminServiceDelegate.findAgentByRole("Post");
					donnes = new String[agents.size()][4];
				
				for (int i = 0; i < agents.size(); i++) {
				
					donnes[i][0] = String.valueOf(agents.get(i).getId());
					donnes[i][1] = agents.get(i).getLogin();
					donnes[i][2] = agents.get(i).getPwd();
					donnes[i][3] = agents.get(i).getRole();
					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "Id","Login","Password","Role" }));
					System.out.println("DOOne");	
				}
				
			}
			}
		});
		btnGg.setBounds(269, 306, 167, 23);
		contentPane.add(btnGg);
	}
}
package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tn.esprit.domain.HightEducationMinistry;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import businessDelegator.EducationMinistryGestionDelegator;

import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class listestudent extends JFrame {

	private JPanel contentPane;
	private JTextField cin;
	private JTable table;
	List<HightEducationMinistry> u;
	String[][] donnes;
	private JButton btnDelete;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField adresse;
	private JTextField establisement;
	private JTextField level;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listestudent frame = new listestudent();
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
	public listestudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDateChooser date = new JDateChooser();
		date.setBounds(712, 325, 87, 20);
		contentPane.add(date);
		
		JButton btnDisplay = new JButton("");
		btnDisplay.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\khouloud\\im1.jpg"));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					HightEducationMinistry student = new HightEducationMinistry();
					int carte = Integer.parseInt(cin.getText());
				

				student = 	EducationMinistryGestionDelegator.findStudentByCin(carte);
				if (student != null){
				 u = new ArrayList<HightEducationMinistry>();
				 u.add(student);
					//System.out.println("done");
				 donnes = new String[u.size()][8];
					for (int i = 0; i < u.size(); i++) {

						donnes[i][0] = String.valueOf(u.get(i).getId());
						donnes[i][1] = u.get(i).getFname();
						donnes[i][2] = u.get(i).getLname();
						donnes[i][3] = String.valueOf(u.get(i).getBirthdate());
						donnes[i][4] = u.get(i).getAdress();
						donnes[i][5] = u.get(i).getEstablisment();
						donnes[i][6] = u.get(i).getLevel();
						donnes[i][7] = String.valueOf(u.get(i).getCin());

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes, new String[] { "id", "First name",
							"last name", "birth date", " adresse ", " establisement", "level ", " cin" }));
					System.out.println("aaaaaaaaaaaaaaa");
					
				}else{
					JOptionPane.showMessageDialog(null, "There is no student with this CIN in our database.");
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			
				
			}
			
		});
		btnDisplay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\khouloud\\images1.jpg"));
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HightEducationMinistry std = new HightEducationMinistry();
				int a=table.getSelectedRow();
				int x = Integer.parseInt(donnes[a][7]);
		
				if (EducationMinistryGestionDelegator.deleteStudent(x)){
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Deleted");
				}
				else
					JOptionPane.showMessageDialog(null, "Delete Error");
			
				
				
				
				
						
				//btnDisplay.getActionListeners();
				
				
			
			}
			
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		}});
		btnDelete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\khouloud\\upa1.jpg"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = table.getSelectedRow();
				//int z = Integer.parseInt(donnes[x][7]);
				  int  carte =Integer.parseInt(cin.getText());
				//HightEducationMinistry std = EducationMinistryGestionDelegator.findStudentByCin(carte);
				String name = firstname.getText();
				String last = lastname.getText();
				String  ad = adresse.getText();
				String le = level.getText();
				String est = establisement.getText();
			Date  d = date.getDate();
				//Date d = calend.getDate();
			// std.setBirthdate(d);
				//student.setBirthdate(birthdate.getDate());
			
				
				if (EducationMinistryGestionDelegator.updateStudent(carte, name, last, ad, le, est,d)){
				
					JOptionPane.showMessageDialog(null, "Updated");
					//System.out.println("update");
				}
				else
					JOptionPane.showMessageDialog(null, "Error");
				
				
				
				
			}
		});
		btnUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		JLabel lblLevel = new JLabel("level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLevel.setForeground(Color.RED);
		lblLevel.setBounds(585, 289, 100, 24);
		contentPane.add(lblLevel);
		
		level = new JTextField();
		level.setBounds(585, 325, 86, 20);
		contentPane.add(level);
		level.setColumns(10);
		
		JLabel lblEstablisement = new JLabel("establisement");
		lblEstablisement.setForeground(Color.RED);
		lblEstablisement.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEstablisement.setBounds(409, 289, 152, 25);
		contentPane.add(lblEstablisement);
		
		establisement = new JTextField();
		establisement.setBounds(437, 325, 86, 20);
		contentPane.add(establisement);
		establisement.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdress.setForeground(Color.RED);
		lblAdress.setBounds(301, 289, 86, 25);
		contentPane.add(lblAdress);
		
		adresse = new JTextField();
		adresse.setBounds(301, 325, 86, 20);
		contentPane.add(adresse);
		adresse.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLastName.setForeground(Color.RED);
		lblLastName.setBounds(147, 291, 130, 20);
		contentPane.add(lblLastName);
		
		lastname = new JTextField();
		lastname.setBounds(177, 325, 86, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFirstName.setForeground(Color.RED);
		lblFirstName.setBounds(10, 289, 115, 25);
		contentPane.add(lblFirstName);
		
		firstname = new JTextField();
		firstname.setBounds(20, 325, 86, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);
		btnUpdate.setBounds(205, 376, 49, 34);
		contentPane.add(btnUpdate);
		btnDelete.setBounds(387, 376, 57, 34);
		contentPane.add(btnDelete);
		btnDisplay.setBounds(537, 376, 64, 34);
		contentPane.add(btnDisplay);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				
				//int z = Integer.parseInt(donnes[a][7]);
				firstname.setText(donnes[a][1]);
				lastname.setText(donnes[a][2]);
				try {
					date.setDate(formatter.parse(donnes[a][3]));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//calend.setDate(arg0);
				adresse.setText(donnes[a][4]);
				establisement.setText(donnes[a][5]);
				level.setText(donnes[a][6]);
				//role.setText(donnes[a][3]);
				System.out.println("mouse");
			
			}
		});
		table.setBounds(45, 108, 683, 180);
		contentPane.add(table);
		
		cin = new JTextField();
		cin.setBounds(121, 70, 130, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		JLabel lblCin = new JLabel("Cin  :");
		lblCin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCin.setForeground(Color.RED);
		lblCin.setBounds(21, 64, 104, 22);
		contentPane.add(lblCin);
		
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBirthDate.setForeground(Color.RED);
		lblBirthDate.setBounds(699, 289, 110, 25);
		contentPane.add(lblBirthDate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		label.setBounds(0, 0, 900, 496);
		contentPane.add(label);
	}
}

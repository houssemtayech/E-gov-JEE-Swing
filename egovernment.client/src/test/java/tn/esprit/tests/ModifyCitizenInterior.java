package tn.esprit.tests;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import tn.esprit.domain.HightEducationMinistry;
import tn.esprit.domain.InteriorMinistry;
//import tn.esprit.serviceDelegator.EducationMinistryGestionDelegator;


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

import businessDelegator.InteriorMinistryGestionDelegator;

import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class ModifyCitizenInterior extends JFrame {

	private JPanel contentPane;
	private JTextField cin;
	private JTable table;
	List<InteriorMinistry> u;
	String[][] donnes;
	private JButton btnDelete;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField adresse;
	private JTextField b3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyCitizenInterior frame = new ModifyCitizenInterior();
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
	public ModifyCitizenInterior() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDateChooser date = new JDateChooser();
		date.setBounds(732, 343, 141, 20);
		contentPane.add(date);
		
		JButton btnDisplay = new JButton("");
		btnDisplay.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\search.jpg"));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					InteriorMinistry citizen = new InteriorMinistry();
					int carte = Integer.parseInt(cin.getText());
				

				citizen = 	InteriorMinistryGestionDelegator.findPersonByCin(carte);
				if (citizen != null){
				 u = new ArrayList<InteriorMinistry>();
				 u.add(citizen);
					//System.out.println("done");
				 donnes = new String[u.size()][5];
					for (int i = 0; i < u.size(); i++) {

						//donnes[i][0] = String.valueOf(u.get(i).getCin());
						donnes[i][0] = u.get(i).getLname();
						donnes[i][1] = u.get(i).getFname();
						donnes[i][2] = u.get(i).getAddress();
						donnes[i][3] = u.get(i).getB3Information();
						donnes[i][4] = String.valueOf(u.get(i).getBirthDate());
				

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes, new String[] { "Last name",
							"First Name", "Residence Address", " B3 Information", "Birth Date" }));
					System.out.println("aaaaaaaaaaaaaaa");
					
				}else{
					JOptionPane.showMessageDialog(null, "There is no Citizen with this CIN in our Ministry");
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
		
/*		
btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\images1.jpg"));
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
		
*/

		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\modify.jpg"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = table.getSelectedRow();
				//int z = Integer.parseInt(donnes[x][7]);
				int  carte =Integer.parseInt(cin.getText());
				//HightEducationMinistry std = EducationMinistryGestionDelegator.findStudentByCin(carte);
				String name = firstname.getText();
				String last = lastname.getText();
				String  ad = adresse.getText();
				String le = b3.getText();
				//String est = b3.getText();
				Date  d = date.getDate();
				//Date d = calend.getDate();
			// std.setBirthdate(d);
				//student.setBirthdate(birthdate.getDate());
			InteriorMinistry person=new InteriorMinistry();
			//person.setCin(carte);
			person.setFname(name);
			person.setLname(last);
			person.setAddress(ad);
			person.setB3Information(le);
			person.setBirthDate(d);
			InteriorMinistryGestionDelegator.modifyPerson(person);
				//InteriorMinistry person;
				
				if (InteriorMinistryGestionDelegator.modifyPerson(person)){
				
					JOptionPane.showMessageDialog(null, "Updated");
					//System.out.println("update");
					
					setVisible(false);
					dispose();
					new ShowServices().setVisible(true);
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
		
		JLabel lblEstablisement = new JLabel("B3 Information");
		lblEstablisement.setForeground(Color.RED);
		lblEstablisement.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEstablisement.setBounds(548, 307, 152, 25);
		contentPane.add(lblEstablisement);
		
		b3 = new JTextField();
		b3.setFont(new Font("Tahoma", Font.BOLD, 12));
		b3.setBounds(548, 333, 152, 50);
		contentPane.add(b3);
		b3.setColumns(10);
		
		JLabel lblAdress = new JLabel("Residence Address");
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdress.setForeground(Color.RED);
		lblAdress.setBounds(352, 307, 161, 25);
		contentPane.add(lblAdress);
		
		adresse = new JTextField();
		adresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		adresse.setBounds(368, 343, 125, 20);
		contentPane.add(adresse);
		adresse.setColumns(10);
		
		JLabel lblLastName = new JLabel("First name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setForeground(Color.RED);
		lblLastName.setBounds(194, 309, 130, 20);
		contentPane.add(lblLastName);
		
		lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastname.setBounds(194, 343, 115, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		JLabel lblFirstName = new JLabel("Last name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setForeground(Color.RED);
		lblFirstName.setBounds(22, 307, 115, 25);
		contentPane.add(lblFirstName);
		
		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstname.setBounds(20, 343, 117, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);
		btnUpdate.setBounds(303, 402, 64, 72);
		contentPane.add(btnUpdate);
		//btnDelete.setBounds(387, 376, 57, 34);
		//contentPane.add(btnDelete);
		btnDisplay.setBounds(260, 93, 64, 63);
		contentPane.add(btnDisplay);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("Button.background"));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();
				
				//int z = Integer.parseInt(donnes[a][7]);
				firstname.setText(donnes[a][0]);
				lastname.setText(donnes[a][1]);
				
				//calend.setDate(arg0);
				adresse.setText(donnes[a][2]);
				b3.setText(donnes[a][3]);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				//Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(inputDate);
				//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss").format(date);
				
				try {
					date.setDate(formatter.parse(donnes[a][4]));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				//level.setText(donnes[a][6]);
				//role.setText(donnes[a][3]);
				System.out.println("mouse");
			
			}
		});
		table.setBounds(85, 174, 747, 131);
		contentPane.add(table);
		
		cin = new JTextField();
		cin.setBounds(96, 110, 146, 26);
		contentPane.add(cin);
		cin.setColumns(10);
		
		JLabel lblCin = new JLabel("Cin  :");
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCin.setForeground(new Color(165, 42, 42));
		lblCin.setBounds(22, 110, 64, 22);
		contentPane.add(lblCin);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBirthDate.setForeground(Color.RED);
		lblBirthDate.setBounds(722, 307, 110, 25);
		contentPane.add(lblBirthDate);
		
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
		button.setBounds(22, 51, 42, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				new ModifyCitizenInterior().setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\refresh.jpg"));
		button_1.setForeground(new Color(102, 153, 51));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(new Color(153, 153, 255));
		button_1.setBounds(765, 61, 67, 71);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\Background.png"));
		label.setBounds(0, 0, 904, 490);
		contentPane.add(label);
	}
}

package tn.esprit.tests;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import businessDelegator.MinistryTransportDelegate;
import tn.esprit.domain.transportMinistry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;

public class InformationCar extends JFrame {
	transportMinistry tran;

	private JPanel contentPane;
	
static 	int ccin,idd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationCar frame = new InformationCar(ccin,idd);
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
	public InformationCar( int cin ,int id) {
		idd=id;
		ccin=cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(297, 48, 339, 447);
		contentPane.add(panel);
	tran= MinistryTransportDelegate.doinformationcitzensub(ccin); 
		JLabel lblNewLabel = new JLabel("Car sticker");
		
		JLabel lblFirstName = new JLabel("First Name");
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		
		JLabel lblNewLabel_3 = new JLabel("sheet metal");
		
		JLabel lblNewLabel_4 = new JLabel("category");
		
		JLabel lblCertificationNumber = new JLabel("certification number");
		
		JLabel lblCylindre = new JLabel("Cylindre");
		
		JLabel lblPregnancy = new JLabel("Pregnancy");
		
		JLabel lblConstructor = new JLabel("constructor");
		
		JLabel lblCarPower = new JLabel("Car Power");
		
		JLabel lblCarRegistrationNumber = new JLabel("Car registration number");
		
		JLabel fname = new JLabel("");
		fname.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lname = new JLabel("");
		lname.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel caro = new JLabel("");
		
		JLabel caroor = new JLabel("");
		
		JLabel categorie = new JLabel("");
		
		JLabel certif = new JLabel("");
		
		JLabel charge = new JLabel("");
		
		JLabel construc = new JLabel("");
		
		JLabel cylindre = new JLabel("");
		cylindre.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel dele = new JLabel("");
		
		JLabel lastimmatnumb = new JLabel("");
		
		JLabel puissance = new JLabel("");
		
		fname.setText(tran.getFname());
		lname.setText(tran.getLname());
		caroor.setText(tran.getCarosserie());
		
		categorie.setText(tran.getCategory());
		certif.setText(String.valueOf(tran.getCertifnumb()));
		charge.setText(tran.getCharge());
		 construc.setText(tran.getConstructor());
		 cylindre.setText(String.valueOf(tran.getCylindre()));
		 lastimmatnumb.setText(String.valueOf(tran.getLastimmatnumb()));
		 puissance.setText(tran.getPuissance());
		
		JButton btnVerifyRequest = new JButton("Verify request");
		btnVerifyRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("boutton"+idd);
				 MinistryTransportDelegate.doRequestDone(idd);
				 Document document = new Document();
			        try{
			        	String titre ="                    Car sticker    ";
			         
			        	String a = "Last Name   "+tran.getLname();
			        	String b="First Name    "+tran.getFname();
			        	String c="Sheet metal   "+tran.getCarosserie();
			            String d="Categorie    "+tran.getCategory();
			         
			            String f="certification  number    "+tran.getCertifnumb();
			            String j="Pergancy    "+tran.getRestriction();
			            String h="Constructor    "+tran.getConstructor();
			            String l="Cylindre    "+tran.getCylindre();
			            String m="Car registre number    "+tran.getLastimmatnumb();
			            String n="Power  "+tran.getPuissance();
			            
			       
			        	//String ff = textnum.getText();
			        
			        	PdfWriter.getInstance(document, new FileOutputStream("E:\\CarSticker"+idd+".pdf"));
			            document.open();
			            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.UNDERLINE | Font.BOLD);
			            Paragraph p0 = new Paragraph(titre);
			            Paragraph p1 = new Paragraph(a);
			            Paragraph p2 = new Paragraph(b);
			            Paragraph p3 = new Paragraph(c);
			            Paragraph p4 = new Paragraph(d);
			            Paragraph p5 = new Paragraph(f);
			            Paragraph p6 = new Paragraph(j);
			            Paragraph p7 = new Paragraph(h);
			            Paragraph p8 = new Paragraph(l);
			            Paragraph p9 = new Paragraph(m);
			            Paragraph p10 = new Paragraph(n);
			          
			            
			           
			          /*  Paragraph p5 = new Paragraph(ff);*/
			            p0.setAlignment(Element.ALIGN_LEFT);
			            p1.setAlignment(Element.ALIGN_LEFT);
			            p2.setAlignment(Element.ALIGN_LEFT);
			            p3.setAlignment(Element.ALIGN_LEFT);
			            p4.setAlignment(Element.ALIGN_LEFT);
			            p5.setAlignment(Element.ALIGN_LEFT);
			            p6.setAlignment(Element.ALIGN_LEFT);
			            p7.setAlignment(Element.ALIGN_LEFT);
			            p8.setAlignment(Element.ALIGN_LEFT);
			            p9.setAlignment(Element.ALIGN_LEFT);
			            p10.setAlignment(Element.ALIGN_LEFT);
			            
			            /*p3.setAlignment(Element.ALIGN_CENTER);
			            p4.setAlignment(Element.ALIGN_CENTER);
			            p5.setAlignment(Element.ALIGN_CENTER);*/
			          
			            
			            //add blank line
			            document.add(p0);
				         
			    	    document.add( Chunk.NEWLINE );
			            document.add(p1);
			         
			    	    document.add( Chunk.NEWLINE );
			    	    document.add(p2);
			            document.add( Chunk.NEWLINE );
			            document.add(p3);
			            document.add( Chunk.NEWLINE );
			            document.add(p4);
			            document.add( Chunk.NEWLINE );
			            document.add(p5);
			            document.add( Chunk.NEWLINE );
			            document.add(p6);
			            document.add( Chunk.NEWLINE );
			            document.add(p7);
			            document.add( Chunk.NEWLINE );
			            document.add(p8);
			            document.add( Chunk.NEWLINE );
			            document.add(p9);
			            document.add( Chunk.NEWLINE );
			            document.add(p10);
			            document.add( Chunk.NEWLINE );
			            document.close();
			            
						JOptionPane.showMessageDialog(null  , "    You can find the document on D: / in pdf formin pdf form  : Car sticker"+idd+"pdf");
			        }
			        catch(Exception n){
			            System.out.println(n);
			        }
			        document.close();
			        
				 
				 
				 
				 
				 
			}
			
			
			
			
		});
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new AffichageCar().setVisible(true);		
				}
		});
		 
	
		 
		 
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFirstName)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblCarPower)
								.addGap(106)
								.addComponent(puissance)
								.addGap(641))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_3)
									.addComponent(lblNewLabel_4)
									.addComponent(lblCertificationNumber)
									.addComponent(lblPregnancy)
									.addComponent(lblConstructor)
									.addComponent(lblCylindre)
									.addComponent(lblCarRegistrationNumber)
									.addComponent(lblNewLabel_1)
									.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(60)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lastimmatnumb)
												.addGap(672))
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel.createSequentialGroup()
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(dele)
														.addComponent(cylindre)
														.addComponent(charge)
														.addComponent(certif)
														.addComponent(categorie)
														.addComponent(caroor)
														.addComponent(btnVerifyRequest))
													.addContainerGap(623, Short.MAX_VALUE))
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lname)
													.addPreferredGap(ComponentPlacement.RELATED, 552, Short.MAX_VALUE)
													.addComponent(caro)
													.addGap(71))
												.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
													.addComponent(fname)
													.addContainerGap()))))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(69)
										.addComponent(construc)
										.addContainerGap()))))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNewLabel)
					.addContainerGap(711, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(28)
							.addComponent(lblFirstName))
						.addComponent(fname))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(caro)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lname))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(caroor))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(categorie))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCertificationNumber)
						.addComponent(certif))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPregnancy)
						.addComponent(charge))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConstructor)
						.addComponent(construc))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCylindre)
						.addComponent(cylindre))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(dele)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCarRegistrationNumber)
							.addComponent(lastimmatnumb)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarPower)
						.addComponent(puissance))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReturn)
						.addComponent(btnVerifyRequest))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		label.setBounds(0, 0, 897, 495);
		contentPane.add(label);
	}
}

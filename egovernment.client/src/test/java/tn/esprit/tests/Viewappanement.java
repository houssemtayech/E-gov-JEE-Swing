package tn.esprit.tests;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;


import tn.esprit.domain.Bus;

import tn.esprit.domain.transportMinistry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.el.StaticFieldELResolver;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import businessDelegator.MinistryTransportDelegate;

import java.io.FileOutputStream;

public class Viewappanement extends JFrame {
	//InteriorMinistry o;

	static int ccin,iid=0;
	static int i;

transportMinistry tran;
Bus bus;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewappanement frame = new Viewappanement( ccin,  iid );
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
	public Viewappanement( int cin, int id ) {
		ccin=cin;
		iid=id;
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(59, 48, 406, 308);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Cin");
		
		JLabel lblSubscriptionPublicTransport = new JLabel("Subscription public transport");
		
		JLabel lblLastname = new JLabel("Last-Name");
		
		JLabel lblFirstname = new JLabel("First name");
		
		JLabel lblAdresse = new JLabel("Adresse");
		
		
		JLabel lblNewLabel_1 = new JLabel("Bus line ");
		tran= MinistryTransportDelegate.doinformationcitzensub(ccin);
		System.out.println(tran);
		
		//o=InteriorMinistryGestionDelegator.findPersonByCin(ccin);
		
	//bus =MinistryTransportDelegate.dofindlineBus(ccin);
		String	lab1= String.valueOf(tran.getCin());
		
		String	lab2= tran.getLname();
		String	lab3= tran.getFname();
		String	lab4= tran.getAdress();
		//String	lab5= bus.getBusLine();
		//System.out.println(lab5);
		
		
		
		JLabel label1 = new JLabel("");
		
		JLabel label2 = new JLabel("");
		
		JLabel label3 = new JLabel("");
		
		JLabel label4 = new JLabel("");
		JLabel label5 = new JLabel("");
		label1.setText(lab1);
		label2.setText(lab2);
		label3.setText(lab3);
		label4.setText(lab4);
	  // label5.setText(lab5);

		JButton btnNewButton = new JButton("verify request");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("boutton"+iid);
				 MinistryTransportDelegate.doRequestDone(iid);
					/****pdf***/
				 Document document = new Document();
			        try{
			        	String titre ="                  subscription transport    ";
			         	String c = "CIN:    "+String.valueOf( (tran.getCin()));
			        	String a = "Last Name   "+tran.getLname();
			        	String b="First Name    "+tran.getFname();
			        	
			        
			        	String d="Adresse :"+ tran.getAdress();
			        	//String ff = textnum.getText();
			        
			        	PdfWriter.getInstance(document, new FileOutputStream("E:\\Abonnements"+iid+".pdf"));
			            document.open();
			            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.UNDERLINE | Font.BOLD);
			            Paragraph p5 = new Paragraph(titre);
			            Paragraph p3 = new Paragraph(c);
			            Paragraph p1 = new Paragraph(a);
			        
			            Paragraph p2 = new Paragraph(b);
			            
			      
			            
			            Paragraph p4 = new Paragraph(d);
			   
			            p5.setAlignment(Element.ALIGN_LEFT);
			            p3.setAlignment(Element.ALIGN_LEFT);
			            p1.setAlignment(Element.ALIGN_LEFT);
			            p2.setAlignment(Element.ALIGN_LEFT);
			            p4.setAlignment(Element.ALIGN_LEFT);
			            
			            
			            /*p3.setAlignment(Element.ALIGN_CENTER);
			            p4.setAlignment(Element.ALIGN_CENTER);
			            p5.setAlignment(Element.ALIGN_CENTER);*/
			          
			            
			            //add blank line
			            
			            document.add(p5);
			         
			    	    document.add( Chunk.NEWLINE );
			    	    document.add(p3);
			            document.add( Chunk.NEWLINE );
			            document.add(p1);
			            document.add( Chunk.NEWLINE );
			            document.add(p2);
			            document.add( Chunk.NEWLINE );
			            document.add(p4);
			            document.add( Chunk.NEWLINE );
			            /*document.add(p3);
			            document.add( Chunk.NEWLINE );
			            document.add(p4);
			            document.add( Chunk.NEWLINE );
			            document.add(p5);
			            document.add( Chunk.NEWLINE );*/
			            document.close();
			        	JOptionPane.showMessageDialog(null  , "    You can find the document on D: / in pdf form  : subscription transport"+iid+"pdf");
			        }
			        catch(Exception n){
			            System.out.println(n);
			        }
			        document.close();
			        
				 
				 
				 
			}
		});
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new AffichageRequest1().setVisible(true);
			}
		});
		
		JLabel jphoto = new JLabel("");
		
		JButton btnNewButton_2 = new JButton("Recover picture");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			/*	byte[] img1 = o.getPhoto1();
		        ImageIcon icon1 = new ImageIcon(img1);
		        Image img = icon1.getImage();
		        Component jPhoto1;
				BufferedImage bi = new BufferedImage(jPhoto1.getWidth(), jPhoto1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		        Graphics g = bi.createGraphics();
		        g.drawImage(img, 0, 0, jPhoto1.getWidth(), jPhoto1.getHeight(), null);
		        ImageIcon newIcon = new ImageIcon(bi);
		        jPhoto1.setIcon(newIcon);
		
				*/
				
			}
		});
		
		JLabel lblBizetetunis = new JLabel("Bizete-Tunis");
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(117)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblFirstname)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel)
											.addComponent(lblLastname))))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(119)
									.addComponent(lblAdresse)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(58)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label3)
										.addComponent(label2)
										.addComponent(label1)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(53)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBizetetunis)
										.addComponent(label4))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jphoto, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(164)
									.addComponent(lblSubscriptionPublicTransport))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(269)
									.addComponent(label5))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(135)
									.addComponent(btnNewButton_1)
									.addGap(46)
									.addComponent(btnNewButton)))
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(144)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(btnNewButton_2)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblSubscriptionPublicTransport)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label1)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLastname)
								.addComponent(label2))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFirstname)
								.addComponent(label3))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(23)
									.addComponent(lblAdresse))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(25)
									.addComponent(label4)))
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jphoto, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblBizetetunis))
							.addGap(39)
							.addComponent(label5))
						.addComponent(btnNewButton_2))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(btnNewButton)))
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\maher\\Desktop\\pdev\\Background.png"));
		lblNewLabel_2.setBounds(10, 11, 609, 345);
		contentPane.add(lblNewLabel_2);
	}
}

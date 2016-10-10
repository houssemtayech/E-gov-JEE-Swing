package tn.esprit.tests;


import java.awt.EventQueue;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.fonts.*;
import com.itextpdf.text.pdf.draw.*;
import com.itextpdf.text.pdf.draw.*;
import com.itextpdf.text.pdf.events.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;
import tn.esprit.domain.InteriorMinistry;


import javax.swing.UIManager;
import java.awt.FlowLayout;


import businessDelegator.InteriorMinistryGestionDelegator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
public class PersonInteriorDetails extends JFrame {

	private JPanel contentPane;
	static int x;
	private JTable table;
	InteriorMinistry tran;
	public static final String IMAGE = "C:/Users/wezza/Desktop/jboss.jpg";
	public static final String IMAGE2 = "C:/Users/wezza/Desktop/pdf.jpg";
	public static final String DEST = "C:/Users/wezza/Desktop/wezza.pdf";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonInteriorDetails frame = new PersonInteriorDetails(x);
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
	public PersonInteriorDetails(int cin) {
		x=cin;
		setTitle("PersonInteriorDetails");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tran= InteriorMinistryGestionDelegator.findPersonByCin(x);
		
		JLabel lblNewLabel_1 = new JLabel("CIN:");
		lblNewLabel_1.setForeground(new Color(153, 0, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(244, 167, 61, 26);
		lblNewLabel_1.setBackground(new Color(204, 51, 0));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFirstName = new JLabel("Last Name:");
		lblFirstName.setForeground(new Color(153, 0, 102));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBackground(new Color(204, 51, 0));
		lblFirstName.setBounds(165, 195, 109, 26);
		contentPane.add(lblFirstName);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(SystemColor.desktop);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBackground(new Color(204, 51, 0));
		label_2.setBounds(307, 195, 193, 26);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(SystemColor.desktop);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBackground(new Color(204, 51, 0));
		label_3.setBounds(310, 225, 190, 26);
		contentPane.add(label_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(SystemColor.desktop);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBackground(new Color(204, 51, 0));
		label_6.setBounds(307, 255, 190, 26);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(SystemColor.desktop);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBackground(new Color(204, 51, 0));
		label_7.setBounds(307, 283, 190, 26);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(SystemColor.desktop);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBackground(new Color(204, 51, 0));
		label_8.setBounds(307, 308, 190, 26);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(SystemColor.desktop);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBackground(new Color(204, 51, 0));
		label_9.setBounds(310, 332, 190, 26);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setForeground(SystemColor.desktop);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBackground(new Color(204, 51, 0));
		label_10.setBounds(307, 357, 193, 26);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setForeground(SystemColor.desktop);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBackground(new Color(204, 51, 0));
		label_11.setBounds(307, 381, 193, 26);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(SystemColor.desktop);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_12.setBackground(new Color(204, 51, 0));
		label_12.setBounds(307, 407, 193, 26);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setForeground(SystemColor.desktop);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_13.setBackground(new Color(204, 51, 0));
		label_13.setBounds(307, 432, 193, 26);
		contentPane.add(label_13);
		
		JLabel lblLastName = new JLabel("First Name:");
		lblLastName.setForeground(new Color(153, 0, 102));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBackground(new Color(204, 51, 0));
		lblLastName.setBounds(165, 225, 109, 26);
		contentPane.add(lblLastName);
		
		JLabel lblFatherName = new JLabel("Father Name:");
		lblFatherName.setForeground(new Color(153, 0, 102));
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFatherName.setBackground(new Color(204, 51, 0));
		lblFatherName.setBounds(165, 255, 109, 26);
		contentPane.add(lblFatherName);
		
		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setForeground(new Color(153, 0, 102));
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthDate.setBackground(new Color(204, 51, 0));
		lblBirthDate.setBounds(165, 283, 109, 26);
		contentPane.add(lblBirthDate);
		
		JLabel lblBirthPlace = new JLabel("Birth Place:");
		lblBirthPlace.setForeground(new Color(153, 0, 102));
		lblBirthPlace.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthPlace.setBackground(new Color(204, 51, 0));
		lblBirthPlace.setBounds(165, 308, 109, 26);
		contentPane.add(lblBirthPlace);
		
		JLabel lblGrandFatherName = new JLabel("Grand Father Name:");
		lblGrandFatherName.setForeground(new Color(153, 0, 102));
		lblGrandFatherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrandFatherName.setBackground(new Color(204, 51, 0));
		lblGrandFatherName.setBounds(165, 357, 140, 26);
		contentPane.add(lblGrandFatherName);
		
		JLabel lblMotherName = new JLabel("Mother Name:");
		lblMotherName.setForeground(new Color(153, 0, 102));
		lblMotherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotherName.setBackground(new Color(204, 51, 0));
		lblMotherName.setBounds(165, 332, 109, 26);
		contentPane.add(lblMotherName);
		
		JLabel lblResidenceAddress = new JLabel("Residence Address:");
		lblResidenceAddress.setForeground(new Color(153, 0, 102));
		lblResidenceAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResidenceAddress.setBackground(new Color(204, 51, 0));
		lblResidenceAddress.setBounds(165, 381, 140, 26);
		contentPane.add(lblResidenceAddress);
		
		JLabel lblIssueDate = new JLabel("Issue Date:");
		lblIssueDate.setForeground(new Color(153, 0, 102));
		lblIssueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIssueDate.setBackground(new Color(204, 51, 0));
		lblIssueDate.setBounds(165, 407, 109, 26);
		contentPane.add(lblIssueDate);
		
		JLabel lblFin = new JLabel("B3 Information:");
		lblFin.setForeground(new Color(153, 0, 102));
		lblFin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFin.setBackground(new Color(204, 51, 0));
		lblFin.setBounds(165, 432, 140, 26);
		contentPane.add(lblFin);
		
		JLabel label = new JLabel("");
		label.setForeground(SystemColor.desktop);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBackground(new Color(204, 51, 0));
		label.setBounds(335, 167, 118, 26);
		contentPane.add(label);
		
		String	lab1= String.valueOf(tran.getCin());
		String	lab2= tran.getLname();
		String	lab3= tran.getFname();
		String lab4=tran.getFatherName();
		String lab5=String.valueOf(tran.getBirthDate());
		String lab6=tran.getBirthPlace();
		String lab7=tran.getMotherName();
		String lab8=tran.getGrandFatherName();
		String lab9=tran.getAddress();
		String lab10=String.valueOf(tran.getIssueDate());
		String lab11=tran.getB3Information();
		byte[] lab12=tran.getPicture();
		
		label.setText(lab1);
		label_2.setText(lab2);
		label_3.setText(lab3);
		label_6.setText(lab4);
		label_7.setText(lab5);
		label_8.setText(lab6);
		label_9.setText(lab7);
		label_10.setText(lab8);
		label_11.setText(lab9);
		label_12.setText(lab10);
		label_13.setText(lab11);
		
		//ImageIcon lab12 = new ImageIcon(PicURL);

		//label_1.setIcon(lab12);
		
		int aa= Integer.parseInt(lab1);
		
		
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(Color.WHITE);
		table.setBounds(164, 167, 336, 303);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				dispose();
				new ShowServices().setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\back.jpg"));
		btnNewButton.setBackground(new Color(153, 153, 255));
		btnNewButton.setForeground(new Color(102, 153, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 64, 42, 41);
		contentPane.add(btnNewButton);
		
		JCheckBox CheckBoxB3 = new JCheckBox("Bulletin 3");
		CheckBoxB3.setBackground(SystemColor.activeCaption);
		CheckBoxB3.setFont(new Font("Tahoma", Font.BOLD, 12));
		CheckBoxB3.setBounds(6, 232, 152, 23);
		contentPane.add(CheckBoxB3);
		
		JCheckBox checkBoxCIN = new JCheckBox("CIN");
		checkBoxCIN.setBackground(SystemColor.activeCaption);
		checkBoxCIN.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxCIN.setBounds(6, 214, 152, 23);
		contentPane.add(checkBoxCIN);
		
		JCheckBox CheckBoxResidenceCertificate = new JCheckBox("Residence Certificate");
		CheckBoxResidenceCertificate.setBackground(SystemColor.activeCaption);
		CheckBoxResidenceCertificate.setFont(new Font("Tahoma", Font.BOLD, 12));
		CheckBoxResidenceCertificate.setBounds(6, 255, 153, 23);
		contentPane.add(CheckBoxResidenceCertificate);
		
		
		
		/*public class HelloWorldExample {

		    public static void main(String[] args) {

		        Document document = new Document();

		        try {
		            PdfWriter.getInstance(document,
		                new FileOutputStream("HelloWorld.pdf"));

		            document.open();
		            document.add(new Paragraph("A Hello World PDF document."));
		            document.close(); // no need to close PDFwriter?

		        } catch (DocumentException e) {
		            e.printStackTrace();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }

		    }
		}*/
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String IMAGE = "C:\\Users\\maher\\git\\egovfinal\\egovernment.client\\tunisie.jpg";
				
				//Image IMAGE2 = InteriorMinistryGestionDelegator.findPersonByCin(aa).getPicture();
		if((CheckBoxB3!=null)||(CheckBoxResidenceCertificate!=null)||(CheckBoxResidenceCertificate!=null)){		

			
			//RequestGestionDelegator reqq=new RequestGestionDelegator();
			//reqq.RequestDone(id);
		        try {
		        	Document document = new Document();
		        	
		            PdfWriter writer=PdfWriter.getInstance(document,
		                    new FileOutputStream("WezzaWawled7lima.pdf"));
		            //PDPage page=new PDPage();

		            document.open();
		            
		            PdfContentByte canvas = writer.getDirectContentUnder();
		    		Image ima;
					try {
						ima = Image.getInstance(IMAGE);
						//ima.scaleAbsolute(PageSize.A4.getHeight(), PageSize.A4.getHeight());
			    		ima.setAbsolutePosition(0, 0);
			    		canvas.addImage(ima);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		

		    		PdfContentByte canvas2 = writer.getDirectContentUnder();
		    		Image ima2;
					try {
						ima2 = Image.getInstance(InteriorMinistryGestionDelegator.findPersonByCin(aa).getPicture());
						ima2.setAbsolutePosition(450,650);
			    		canvas2.addImage(ima2);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		//ima2.scaleAbsolute(PageSize.A4.getHeight(), PageSize.A4.getHeight());
		    		
		            
		            document.add(new Paragraph("----------------------------EGOV DREAM TEAM : WE ARE IN YOUR SUPPORT----------------------------"));
		            
		            
		            /*
		            document.addPage(page);
		            PDXObjectImage ima=new PDJpeg(document,new FileInputStream(imageName));
		            PDPageContentStream content = new PDPageContentStream(document,page);
		            content.drawImage(ima,250,500);
		            content.close();
		            document.save(fileName);
		            */
				
		            //document.add(new Chunk("This is sentence 1. "));
		                //document.add(new Phrase("This is sentence 1. "));
		            //document.add(new Chunk("This is sentence 2. "));
		            //document.add(new Chunk("This is sentence 3. "));
		            //document.add(new Chunk("This is sentence 4. "));
		            //document.add(new Chunk("This is sentence 5. "));
		           //document.add(new Chunk("This is sentence 6. "));
		              
		                
		                
		                /* Paragraph paragraph = new Paragraph();

		                for(int i=0; i<10; i++){
//Paragraphe		                  Chunk chunk = new Chunk(
		                        "This is a sentence which is long " + i + ". ");
		                  paragraph.add(chunk);
		                }

		                document.add(paragraph);Paragraphe*/
		                
		                
		               
		            
		            
		              	
		                List orderedList = new List(List.ORDERED);
		                if(checkBoxCIN.isSelected()){
		                orderedList.add(new ListItem("This is an Accomplished Service of :				CIN"));
		                orderedList.add(new ListItem("CIN:"+lab1+"\n"));
		                orderedList.add(new ListItem("Last Name:"+lab2+"\n"));
		                orderedList.add(new ListItem("\n"+"First Name:"+lab3+"\n"));
		                orderedList.add(new ListItem("\n"+"Father Name:"+lab4+"\n"));
		                orderedList.add(new ListItem("\n"+"Birth Date:"+lab5+"\n"));
		                orderedList.add(new ListItem("\n"+"Birth Place:"+lab6+"\n"));
		                orderedList.add(new ListItem("\n"+"Mother Name:"+lab7+"\n"));
		                orderedList.add(new ListItem("\n"+"Grand Father Name:"+lab8+"\n"));
		                orderedList.add(new ListItem("\n"+"Residence Address:"+lab9+"\n"));
		                orderedList.add(new ListItem("\n"+"Issue Date:"+lab10+"\n"));
		                //orderedList.add(new ImageIcon(location);
		                }else if(CheckBoxB3.isSelected()){
		                	orderedList.add(new ListItem("This is an Accomplished Service of :				Bulletin N°3"));
			                orderedList.add(new ListItem("CIN:"+lab1+"\n"));
			                orderedList.add(new ListItem("Last Name:"+lab2+"\n"));
			                orderedList.add(new ListItem("\n"+"First Name:"+lab3+"\n"));
			                orderedList.add(new ListItem("\n"+"Birth Date:"+lab5+"\n"));
			                orderedList.add(new ListItem("\n"+"Birth Place:"+lab6+"\n"));
			                orderedList.add(new ListItem("\n"+"Residence Address:"+lab9+"\n"));
			                orderedList.add(new ListItem("\n"+"B3 Information:"+lab11+"\n"));
		                }else if(CheckBoxResidenceCertificate.isSelected()){
		                	orderedList.add(new ListItem("This is an Accomplished Service of :				Residence Certificate"));
			                orderedList.add(new ListItem("CIN:"+lab1+"\n"));
			                orderedList.add(new ListItem("Last Name:"+lab2+"\n"));
			                orderedList.add(new ListItem("\n"+"First Name:"+lab3+"\n"));
			                orderedList.add(new ListItem("\n"+"Birth Date:"+lab5+"\n"));
			                orderedList.add(new ListItem("\n"+"Birth Place:"+lab6+"\n"));
			                orderedList.add(new ListItem("\n"+"Residence Address:"+lab9+"\n"));
		                }
		                document.add(orderedList);
 
		                
		                
		            /*    
						PdfContentByte canvas = writer.getDirectContentUnder();
		        		com.itextpdf.text.Image ima = Image.getInstance(document,IMAGE);
		        		ima.scaleAbsolute(PageSize.A4.getHeight(), PageSize.A4.getHeight());
		        		ima.setAbsolutePosition(0, 0);
		        		canvas.addImage(ima);

		        		document.newPage();
//Photo		        		document.open();

		        		PdfContentByte canvas2 = writer.getDirectContentUnder();

		        		com.itextpdf.text.Image ima2 = Image.getInstance(document,IMAGE2);
		        		ima2.scaleAbsolute(PageSize.A4.getHeight(), PageSize.A4.getHeight());
		        		ima2.setAbsolutePosition(0, 0);
		        		canvas2.addImage(ima2);
						*/



		        		document.close();

		                
		                
		                
		                /*
		                Chunk underline = new Chunk("Underline. ");
		                underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
		                document.add(underline);

		                document.add(new Paragraph("   "));

		                Chunk strikethrough = new Chunk("Strikethrough.");
		                strikethrough.setUnderline(0.1f, 3f); //0.1 thick, 2 y-location
		                document.add(strikethrough);
		                */
		                
/*		            PdfReader pdfReader = new PdfReader("HelloWorld.pdf");

		            PdfStamper pdfStamper = new PdfStamper(pdfReader,
		                  new FileOutputStream("HelloWorld-Stamped.pdf"));

		            Image image = Image.getInstance("watermark.png");

		            for(int i=1; i<= pdfReader.getNumberOfPages(); i++){

		                PdfContentByte content = pdfStamper.getUnderContent(i);

		                image.setAbsolutePosition(100f, 700f);

		                content.addImage(image);
		            }

		            pdfStamper.close();

		            //PDF READER    
		               
*/
		            
		           document.close();

		        } catch (DocumentException eb) {
		            eb.printStackTrace();
		        } catch (FileNotFoundException el) {
		            el.printStackTrace();
		        }
		           				
				try{
					Desktop.getDesktop().open(new File("C:\\Users\\maher\\git\\egovfinal\\egovernment.client\\WezzaWawled7lima.pdf"));
					setVisible(false);
					dispose();
					new ShowServices().setVisible(true);
				}catch (Exception es){
					System.out.println(es);
				}
		       
			}
			}
		});
		
		
		
		button.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\pdf.jpg"));
		button.setForeground(new Color(102, 153, 51));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(153, 153, 255));
		button.setBounds(52, 311, 49, 47);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				dispose();
				new PersonInteriorDetails(x).setVisible(true);
				
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\refresh.jpg"));
		button_1.setForeground(new Color(102, 153, 51));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(new Color(153, 153, 255));
		button_1.setBounds(777, 64, 67, 71);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBackground(new Color(204, 51, 0));
		label_1.setBounds(587, 55, 152, 138);
		contentPane.add(label_1);
		
		JButton btnNewButton_1 = new JButton("Display Picture");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aa= Integer.parseInt(lab1);
				byte[] img;
				
				try {
					img=InteriorMinistryGestionDelegator.findPersonByCin(aa).getPicture();
					ImageIcon image=new ImageIcon(img);
					java.awt.Image pic=image.getImage();
					BufferedImage bi = new BufferedImage(label_1.getWidth(), label_1.getHeight(), BufferedImage.TYPE_INT_ARGB);
					Graphics g = bi.createGraphics();
					g.drawImage(pic, 0, 0, label_1.getWidth(), label_1.getHeight(), null);
					ImageIcon newIcon = new ImageIcon(bi);
					label_1.setIcon(newIcon);
				} catch (FormatterClosedException e2) {
					System.out.println(e2+"erreur image");
					
				}
				//Image im=pic.getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH);
				//ImageIcon newImage= new ImageIcon(im);
				//label_1.setIcon(newImage);
				
				/*
				 *  byte[] img1 = o.getPhoto1();
        ImageIcon icon1 = new ImageIcon(img1);
        Image img = icon1.getImage();
        BufferedImage bi = new BufferedImage(jPhoto1.getWidth(), jPhoto1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, jPhoto1.getWidth(), jPhoto1.getHeight(), null);
        ImageIcon newIcon = new ImageIcon(bi);
        jPhoto1.setIcon(newIcon);
        /**
				 * 
				 */
			}
		});
		btnNewButton_1.setBounds(597, 215, 129, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 895, 481);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\maher\\Documents\\wiza\\New folder\\Background.png"));
		contentPane.add(lblNewLabel);
	
	
/*public void createPdf(String dest) throws IOException, DocumentException {
	Document document = new Document(PageSize.A4.rotate());
	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
	document.open();
	document.add(new Paragraph("flouuusssssssiiiiiiiiiiii"));
	document.add(new Paragraph("khaallaasniiiiiiiiii"));
	document.add(new Paragraph("ekhdeemliiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));

	PdfContentByte canvas = writer.getDirectContentUnder();

	com.itextpdf.text.Image image = Image.getInstance(IMAGE);
	IMAGE2.scaleAbsolute(PageSize.A4.getHeight(), PageSize.A4.getHeight());
	image.setAbsolutePosition(0, 0);
	canvas.addImage(image);

	document.newPage();
	document.open();

	PdfContentByte canvas2 = writer.getDirectContentUnder();

	Image image2 = Image.getInstance(IMAGE2);
	image2.scaleAbsolute(PageSize.A4.getHeight(), PageSize.A4.getHeight());
	image2.setAbsolutePosition(0, 0);
	canvas2.addImage(image2);

	document.close();
}*/
	}
}

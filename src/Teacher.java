

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Teacher  implements ActionListener{
				/**
	 * 
	 */
      public String filepath;
				JButton qusup;
				JButton qusv;
				JButton ans;
				JButton stud;
				JButton results;
				JButton viewans;
				JFileChooser f;
				JFileChooser f2;
				JLabel imgv;
				JLabel stdinfo;
				JLabel idsearchl;
				JTextField idsearch;
				JButton idsearchb;
				JLabel ansview;
				JFrame fr5;
				
				public Teacher(){ 
					JFrame fr=new JFrame("Teacher Panel");
					qusup=new JButton("Upload Question");
				      qusup.setBounds(50, 20, 150, 50);
				      qusup.addActionListener(this);
				      fr.add(qusup);
				      
				
			      qusv=new JButton("Viwe Question");			      
				      qusv.setBounds(50, 100, 150, 50);
				      qusv.addActionListener(this);
				      fr.add(qusv);
				      
				      
				      viewans=new JButton("View Answers");
				      viewans.setBounds(50, 170, 150, 50);
				      viewans.addActionListener(this);
				      fr.add(viewans);
				      
				      
				      results=new JButton("Upload Results");
				      results.setBounds(50, 240, 150, 50);
				      results.addActionListener(this);
				      fr.add(results);
				      
				      stud=new JButton("Student Information");
				      stud.setBounds(50, 310, 150, 50);
				      stud.addActionListener(this);
				      fr.add(stud);
				     
				      fr.setLayout(null);
				      fr.setVisible(true);
				      fr.setSize(300, 400);
				      fr.setLocationRelativeTo(null);
				      //fr.setLocationRelativeTo(null);
				      
				      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				      
					
				}
				//qustion upload actionlistener method
				public void qusup(){
					f=new JFileChooser();
					f.showOpenDialog(null);
					filepath = f.getSelectedFile().getPath();
						File f1=new File("Qus.txt");
						try {
							f1.createNewFile();
							
							FileWriter fr=new FileWriter(f1);
							fr.write(ImageProcess.toImageString(filepath));
							fr.close();
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
						finally{
							
						}
				}
				//Student information 
				public void stdinfo(){
					
					Scanner fileScan = null;
					String data="";
					int i=1;
					try {
						fileScan = new Scanner (new File("Student.txt"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			  		 
				 	 while (fileScan.hasNextLine()) {
				 		 
				    String input = fileScan.nextLine();

				    String[] str = input.split("[' ']");

				    data = data+i+". "+"Name: "+str[2] +" "+ str[3] +"\nID: "+ str[4]+"\n\n";
				    
				    i++;
				 
				  }
				 	
					JOptionPane jp= new JOptionPane();
					jp.setMessage(data);
					JDialog d=jp.createDialog(null,"Students Information");
					d.setVisible(true);
				}
				//qustion view
				public void qusview(){
					
				JFrame fr=new JFrame("QUSTION");
				
				imgv=new JLabel();
				imgv.setBounds(0, 0, 462, 598);
				imgv.setIcon(new ImageIcon(filepath));
				fr.add(imgv);
				
				fr.setLayout(null);
				
				
				
				fr.setSize(462, 598);
				fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				fr.setVisible(true);
					
				}
				//upload results
				
				public void results(){
					f2=new JFileChooser();
					f2.showOpenDialog(null);
					filepath = f2.getSelectedFile().getPath();
						File f1=new File("Results.txt");
						try {
							f1.createNewFile();
							@SuppressWarnings("resource")
							FileWriter fr=new FileWriter(f1);
							fr.write(ImageProcess.toImageString(filepath));
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
				}
				//view ans
				public void viewans(){
					 fr5=new JFrame("Answers");
					idsearchl=new JLabel("Enter Student ID");
					idsearchl.setBounds(2, 2, 100, 30);
					//Font f=new Font("SansSherif", Font.BOLD, 20);
					//idsearchl.setFont(f);
					fr5.add(idsearchl);
					idsearch=new JTextField(8);
					idsearch.setBounds(2, 40, 100, 30);
					fr5.add(idsearch);
					idsearchb=new JButton("View");
					idsearchb.setBounds(2, 100, 100, 30);
					idsearchb.addActionListener(this);
					
					fr5.add(idsearchb);
					fr5.setSize(300, 300);
					fr5.setLayout(null);
					fr5.setLocationRelativeTo(null);
					fr5.setVisible(true);
					
				}
				
				
				public void answers(){
					String x = "";
					Scanner sc = null;
					try {
						sc = new Scanner(new File(idsearch.getText()+".txt"));
						while(sc.hasNextLine()){
							x=x+sc.nextLine();
						}
						fr5.dispose();
						JOptionPane jp= new JOptionPane();
						jp.setMessage(x);
						JDialog d=jp.createDialog(null,"Answer Viewer!");
						d.setVisible(true);
					} catch (FileNotFoundException e) {
						String msg[]={"ID NOT FOUND"};
						JOptionPane jp= new JOptionPane();
						jp.setMessage(msg);
						JDialog d=jp.createDialog(null,"Warning!");
						d.setVisible(true);
						
					}
					
					
					
					
					
				}
				

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==qusup){
						qusup();
						String msg[]={"Qustion Uploaded Succesfully"};
						JOptionPane jp= new JOptionPane();
						jp.setMessage(msg);
						JDialog d=jp.createDialog(null,"Qustion!");
						d.setVisible(true);
						
					}
					
					else if(e.getSource()==qusv){
						qusview();
					}
					else if(e.getSource()==stud){
						stdinfo();
					}
					else if(e.getSource()==results){
						results();
						String msg[]={"Result Submited Succesfully"};
						JOptionPane jp= new JOptionPane();
						jp.setMessage(msg);
						JDialog d=jp.createDialog(null,"Results!");
						d.setVisible(true);
						
					}
					
					
					else if(e.getSource()==viewans){
						viewans();
					}
					else if(e.getSource()==idsearchb){
						answers();
					}
					
					
				}
				
				
			
}

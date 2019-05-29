

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.UnsupportedLookAndFeelException;

public class Home extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton log;
	private JButton reg;
	private JLabel title;
	private JPasswordField logpass;
	private JTextField loguser;
	private JComboBox<String> com;
	static String[] str =null;
			public Home () throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
				
				JPanel p3=new JPanel();
				p3.setLayout(new GridLayout(4,2,1,3));
				p3.add(new JLabel("Username:"));
				loguser=(new JTextField(8));
				p3.add(loguser);
				p3.add(new JLabel("Password:"));
				logpass=(new JPasswordField(8));
				p3.add(logpass);
				p3.add(new JLabel("Account Type:"));               //p3 pannel hold all input
				String[] options=new String[]{"Teacher","Student"};
				
				com=(new JComboBox<>(options));
				p3.add(com);
				JPanel p4=new JPanel(new BorderLayout(0,5));
				JPanel p5=new JPanel(new GridLayout(1,1,3,0));
				log=(new JButton("Login"));
				p5.add(log);
				log.addActionListener(this);
				reg=(new JButton("Registration"));
				p5.add(reg);
				reg.addActionListener(this);
				JPanel p6=new JPanel(new BorderLayout());
				Font f=new Font("SansSherif", Font.BOLD, 20); //Create a font type and size
				title=new JLabel("Exam Management System",JLabel.CENTER);
				title.setFont(f); //assign font in label
				
				p6.add(title); //p6 pannel hold upper title in main frame
				
				p4.add(p3,BorderLayout.CENTER); //p4 pannel hold p3,p5 and p6 pannel
			    p4.add(p5,BorderLayout.SOUTH);
			    p4.add(p6,BorderLayout.NORTH);
			    add(p4);  //p4 pannel added to frame
				
			}
			
			public void log(){
				if(com.getSelectedItem()=="Teacher"){
					Scanner fileScan = null;
					boolean check = false;
					try {
						fileScan = new Scanner (new File("Teacher.txt"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			  		 // added this variable
				 	 while (fileScan.hasNextLine()) {
				    String input = fileScan.nextLine();

				    String[] str = input.split("[' ']");
				    
				    
				    if (str[0].equals(loguser.getText()) && (str[1].equals(new String(logpass.getPassword())))) {
				      
				    	check = true;
				      // added this to set found
				    }
				 
				  }
				 	 
				 	 if(check) {
				 		this.setVisible(false);
				 		new Teacher();
				 	 }
				 	 else {

				 	String msg[]={"Username or Password Not Found"};
					JOptionPane jp= new JOptionPane();
					jp.setMessage(msg);
					JDialog d=jp.createDialog(null,"Warning!");
					d.setVisible(true);
				}
				}
				
				
				else if(com.getSelectedItem()=="Student"){
					
					Scanner fileScan = null;
					boolean check=false;
					try {
						fileScan = new Scanner (new File("Student.txt"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			  		 // added this variable
				 	 while (fileScan.hasNextLine()) {
				    String input = fileScan.nextLine();

				    str= input.split("[' ']");

				    if (str[0].equals(loguser.getText()) && (str[1].equals(new String(logpass.getPassword())))) {
				      check=true;
				    	
				    	// added this to set found
				    } // removed the else statement
				  }
				 	 
				 	 
					 if(check) {
					 		this.setVisible(false);
					 		new Student();
					 	 }
					 	 else {

					 	String msg[]={"Username or Password Not Found"};
						JOptionPane jp= new JOptionPane();
						jp.setMessage(msg);
						JDialog d=jp.createDialog(null,"Warning!");
						d.setVisible(true);
					}

				 
				}
				
				
				}
			
			
			
			
			
			

			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				//Registration button action
				if(e.getSource()==reg){
					Registration frame2=new Registration(); //Registration screen frame
				 
					frame2.setLocationRelativeTo(null);
					frame2.setSize(300,300);
					frame2.setTitle("Registration Form");
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame2.setVisible(true);
				
				}
				
				
				
				if(e.getSource()==log){
					
				log();


				

				  
				
					}
			  		


				}
					
				}
			


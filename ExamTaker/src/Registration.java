import java.awt.BorderLayout;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Registration extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit;
	JTextField first;
	JTextField last;
	JTextField user;
	JTextField id;
	JPasswordField pass;
	JPasswordField cpass;
	JComboBox<String> comb;
	

	 public Registration(){
		 JPanel p1=new JPanel();
		 p1.setLayout(new GridLayout(8,2,5,10));
		 p1.add(new JLabel("First Name:"));
		 first=(new JTextField(8));
		 p1.add(first);
		 p1.add(new JLabel("Last Name:")); //p1 pannel hold all inputs
		 last=(new JTextField(8));
		 p1.add(last);
		 
		 p1.add(new JLabel("NSU ID:"));
		 id=(new JTextField(8));
		 p1.add(id);
		 
		 
		
		 p1.add(new JLabel("Username:"));
		 user=(new JTextField(8));
		 p1.add(user);
		 p1.add(new JLabel("Password:"));
		 pass=(new JPasswordField());
		 p1.add(pass);
		 
		 p1.add(new JLabel("Confirm Password:"));
		 cpass=(new JPasswordField());
		 p1.add(cpass);
		 
		 
		 p1.add(new JLabel("Account Type:"));
		 String[] options=new String[]{"Teacher","Student"};
		 comb=(new JComboBox<>(options));
		 p1.add(comb);
		 JPanel p2=new JPanel(new BorderLayout(0,5));
		 submit=new JButton("Submit");	
		 submit.addActionListener(this);
		 p2.add(submit,BorderLayout.SOUTH);//p2 pannel hold submit button and p1 pannel
		 p2.add(p1,BorderLayout.CENTER);
		 add(p2); //p2 pannel added to frame
		 
	 }
	 
	 public void empty(){
		 if(first.getText().length()==0 || last.getText().length()==0|| id.getText().length()==0||user.getText().length()==0){
			 String msg[]={"Fill up all field!"};
				JOptionPane jp= new JOptionPane();
				jp.setMessage(msg);
				JDialog d=jp.createDialog(null,"Warning!");
				d.setVisible(true);
				
		 }
		 else{
				dialog();
			}
		
	 }
	 
	 public void teacher() throws IOException {
		 
		 
		 try {
			 FileOutputStream fr;
			 fr = new FileOutputStream("Teacher.txt",true);
			 fr.write((user.getText()+" ").getBytes());
			 fr.write((new String(pass.getPassword())+" ").getBytes());
				fr.write((first.getText()+" ").getBytes());
				fr.write((last.getText()+" ").getBytes());
				
				fr.write((id.getText()+" ").getBytes());
				
				fr.write(new String("\n").getBytes());
			 fr.close();
		 }
		 
		 catch (FileNotFoundException e) {
	            
			 File th=new File("Teacher.txt");
			 th.createNewFile();
				FileWriter fr=new FileWriter(th);
				fr.write(user.getText()+" ");
				fr.write(new String(pass.getPassword()) +" ");
				fr.write(first.getText()+" ");
				fr.write(last.getText()+" ");
				fr.write(id.getText() +" ");
				
				fr.write(new String("\n"));
			 fr.close();

	        }
		 
		 super.dispose();
		 String msg[]={"Registration Succesfull!"};
			JOptionPane jp= new JOptionPane();
			jp.setMessage(msg);
			JDialog d=jp.createDialog(null,"Registration!");
			d.setVisible(true);
		 
		 
		 
	 }
	 
	 
	 public void student() throws IOException{
		 
		 
		 try {
			 FileOutputStream fr;
			 fr = new FileOutputStream("Student.txt",true);
			 fr.write((user.getText()+" ").getBytes());
			 fr.write((new String(pass.getPassword())+" ").getBytes());
				fr.write((first.getText()+" ").getBytes());
				fr.write((last.getText()+" ").getBytes());
				
				fr.write((id.getText()+" ").getBytes());
				
				fr.write(new String("\n").getBytes());
			 fr.close();
		 }
		 
		 catch (FileNotFoundException e) {
	            
			 File th=new File("Student.txt");
			 th.createNewFile();
				FileWriter fr=new FileWriter(th);
				fr.write(user.getText()+" ");
				fr.write(new String(pass.getPassword()) +" ");
				fr.write(first.getText()+" ");
				fr.write(last.getText()+" ");
				
				fr.write(id.getText() +" ");
				
				fr.write(new String("\n"));
			 fr.close();

	        }
		 
		 super.dispose();
		 String msg[]={"Registration Succesfull!"};
			JOptionPane jp= new JOptionPane();
			jp.setMessage(msg);
			JDialog d=jp.createDialog(null,"Registration!");
			d.setVisible(true);
	 }
	 
	 
	 
	 //PASSWORD MATCHING;
	public void dialog(){

		if(Arrays.equals(pass.getPassword(), cpass.getPassword())){
			
			
			if(comb.getSelectedItem()=="Teacher"){
				try {
					teacher();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(comb.getSelectedItem()=="Student"){
				try {
					student();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

		if(!Arrays.equals(pass.getPassword(), cpass.getPassword())){
			String msg[]={"PASSWORD DOESN'T MATCH!"};
			JOptionPane jp= new JOptionPane();
			jp.setMessage(msg);
			JDialog d=jp.createDialog(null,"Warning!");
			d.setVisible(true);
		

		}
		 
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		//submit button actionlistener
		
		
		if(e.getSource()==submit){
			
	empty();
			
		}
	
		
	}

}

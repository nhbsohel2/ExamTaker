
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Student implements ActionListener {
	/**
	 * 
	 */
	
	JButton qusv;
	JButton ans;
	JButton results;
	JTextArea anssheet;
	JButton submit;
	JLabel qus;
	JFrame fr3;
	public Student(){
		
		JFrame fr=new JFrame("Student Panel");
	     
	      qusv=new JButton("Question View");
	      qusv.setBounds(50, 20, 150, 50);
	      qusv.addActionListener(this);
	      fr.add(qusv);
	      ans=new JButton("Answer Sheet");
	      ans.addActionListener(this);
	      
	      ans.setBounds(50, 100, 150, 50);
	      fr.add(ans);
	      results=new JButton("View Result");
	      results.setBounds(50, 170, 150, 50);
	      results.addActionListener(this);
	      fr.add(results);
	     
	      fr.setLayout(null);
	      fr.setLocationRelativeTo(null);
	      fr.setVisible(true);
	      fr.setSize(300, 300);
	      //fr.setLocationRelativeTo(null);
	      
	      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      
	   
	}
	
	public void ans() throws IOException{
		
		String imgs="";
		
		@SuppressWarnings("resource")
		Scanner in=new Scanner(new File("Qus.txt"));
		while(in.hasNextLine()){
			imgs=imgs+in.nextLine();
		}
	
		//System.out.println(imgs);
		fr3=new JFrame();		
		anssheet=new JTextArea();
		anssheet.setLineWrap(true);
		anssheet.getAutoscrolls();
		anssheet.setBounds(0, 0, 700, 600);
		fr3.add(anssheet);
		submit=new JButton("Submit");
		submit.setBounds(250, 610, 100, 50);
		submit.addActionListener(this);
		fr3.add(submit);
		fr3.setSize(700, 700);
		 fr3.setLayout(null);
		 fr3.setLocationRelativeTo(null);
		fr3.setVisible(true);
		fr3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}
	
	public void qusview() throws IOException{
String imgs="";
		
		@SuppressWarnings("resource")
		Scanner in=new Scanner(new File("Qus.txt"));
		while(in.hasNextLine()){
			imgs=imgs+in.nextLine();
		}
	
		//System.out.println(imgs);
		JFrame fr=new JFrame();
		qus=new JLabel();
		
		qus.setIcon(new ImageIcon(ImageProcess.toBufferedImage(imgs)));
		qus.setBounds(10, 10, 462, 598);
		fr.add(qus);	
		fr.setSize(462, 630);
		 fr.setLayout(null);
		 fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
	}
	
	public void  results() throws IOException{
		String imgs="";
		
		@SuppressWarnings("resource")
		Scanner in=new Scanner(new File("Results.txt"));
		while(in.hasNextLine()){
			imgs=imgs+in.nextLine();
		}
	
		//System.out.println(imgs);
		JFrame fr=new JFrame();
		qus=new JLabel();
		
		qus.setIcon(new ImageIcon(ImageProcess.toBufferedImage(imgs)));
		qus.setBounds(10, 10, 511, 715);
		fr.add(qus);	
		fr.setSize(550, 715);
		 fr.setLayout(null);
		 fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}
	
	
	public void anssubmit() throws IOException{
		//System.out.println();
		File f=new File(Home.str[4]+".txt");
		FileWriter fr=new FileWriter(f);
		String ans=anssheet.getText();
		fr.write(ans);
		fr.close();
		fr3.dispose();
		String msg[]={"Answer Submited Successfully"};
		JOptionPane jp= new JOptionPane();
		jp.setMessage(msg);
		JDialog d=jp.createDialog(null,"Answer");
		d.setVisible(true);
		
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ans){
		try {
			ans();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		}
		
		else if(e.getSource()==qusv){
			try {
				qusview();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==results){
			try {
				results();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==submit){
			try {
				anssubmit();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
}

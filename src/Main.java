import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
		public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			Home frame1=new Home(); 
			//Login screen frame
			//Teacher frame1=new Teacher();
			//Student frame1=new Student();
			//frame1.setSize(700, 700);
			frame1.setSize(400, 300);
			frame1.setLocationRelativeTo(null);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			frame1.setTitle("LOGIN"); 
			
			
			
		}
}

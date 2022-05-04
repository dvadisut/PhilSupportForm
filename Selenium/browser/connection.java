package browser;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class connection {

	connection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/philstatus","root","Aperta123!");

		}
			
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error-Connecting SQl");
			}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		

}
}

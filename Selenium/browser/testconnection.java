package browser;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

public class testconnection  {
	
	

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/philstatus","root","Aperta123!"); 
			//here sonoo is database name, root is username and password  
			java.sql.Statement stmt=con.createStatement();
			/*ResultSet rs=stmt.executeQuery("select * from apglobal");  
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); */
			PreparedStatement insert = con.prepareStatement("insert into apglobal(Date,CustName,IssueDesc,AttenBy,issueStatus,Notes)values(?,?,?,?,?,?)");
			insert.setString(1, "2022-04-18");
			insert.setString(2, "adsad");
			insert.setString(3, "adsad");
			insert.setString(4, "adsad");
			insert.setString(5, "adsad");
			insert.setString(6, "adsad");
			((PreparedStatement) insert).executeUpdate();
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}
	
	 }
		

	



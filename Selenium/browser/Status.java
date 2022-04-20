package browser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.sql.RowSetMetaData;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;








public class Status extends JFrame implements ActionListener{
	
	Container c;
	JLabel DateOfIssue;
	JLabel title;
	JTextField datei;
    JComboBox month;
    JComboBox year;
	JLabel CustomerName;
	JTextField tname;
	JTextArea tdesc;
	JComboBox tatten;
	JComboBox tstatus;
	JTextArea tnotes;
	JLabel IssueDescription;
	JLabel AttendedBy;
	JLabel IssueStatus;
	JLabel Notes;
	JButton sub;
	JButton sub1;
	JTable table;
	DefaultTableModel model;
	/*String joindate=datei.getSelectedItem().toString();
	String joinmonth=month.getSelectedItem().toString();
	String joinyear=year.getSelectedItem().toString();
	String date= (joinyear)+(joinmonth)+(joindate);*/


	
	/*private String dates[]
	        = { "01", "02", "03", "04", "05",
	            "06", "07", "08", "09", "10",
	            "11", "12", "13", "14", "15",
	            "16", "17", "18", "19", "20",
	            "21", "22", "23", "24", "25",
	            "26", "27", "28", "29", "30",
	            "31" };
	    private String months[]
	        = { "01", "02", "03", "04",
	            "05", "06", "07", "08",
	            "09", "10", "11", "12" };
	    private String years[]
	        = { "2022", "2023", "2024", "2025",
	           };*/
	    private String IssueStatusd[]
	    		={"","InProgress","Resolved","Closed", "PartiallyCompleted"};
	    
	    private String tattens[]
	    		={"","DV/Sujith","Sujith","DV"};
	
	    @SuppressWarnings("serial")
		public Status() {
	    	
	    	setTitle("PHILLIPINES STATUS");
	    	setBounds(300, 90, 1200, 700);
	    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	        
	        c=getContentPane();
			c.setLayout(null);
			
			title = new JLabel("PHILLIPINES SUPPORT LOG FORM");
	        title.setFont(new Font("Arial", Font.BOLD, 15));
	        title.setSize(300, 30);
	        title.setLocation(500, 30);
	        c.add(title);
	        
	        
	       DateOfIssue = new JLabel("Issue Date");
	        DateOfIssue.setFont(new Font("Arial", Font.PLAIN, 15));
	        DateOfIssue.setSize(100, 20);
	        DateOfIssue.setLocation(100, 250);
	        c.add(DateOfIssue);
	        
	        datei = new JTextField();
	        datei.setFont(new Font("Arial", Font.PLAIN, 15));
	        datei.setSize(190, 20);
	        datei.setLocation(200, 250);
	        c.add(datei);
	        
	        /*month = new JComboBox<String>(months);
	        month.setFont(new Font("Arial", Font.PLAIN, 15));
	        month.setSize(60, 20);
	        month.setLocation(250, 250);
	        c.add(month);
	        
	        year = new JComboBox<String>(years);
	        year.setFont(new Font("Arial", Font.PLAIN, 15));
	        year.setSize(60, 20);
	        year.setLocation(320, 250);
	        c.add(year);*/
	        
	        CustomerName = new JLabel("Cust Name");
	        CustomerName.setFont(new Font("Arial", Font.PLAIN, 15));
	        CustomerName.setSize(100, 20);
	        CustomerName.setLocation(100, 100);
	        c.add(CustomerName);
	        
	        tname = new JTextField();
	        tname.setFont(new Font("Arial", Font.PLAIN, 15));
	        tname.setSize(190, 20);
	        tname.setLocation(200, 100);
	        c.add(tname);
	        
	        IssueDescription = new JLabel("Issue Desc");
	        IssueDescription.setFont(new Font("Arial", Font.PLAIN, 15));
	        IssueDescription.setSize(100, 20);
	        IssueDescription.setLocation(100, 150);
	        c.add(IssueDescription);
	        
	        tdesc = new JTextArea();
	        tdesc.setFont(new Font("Arial", Font.PLAIN, 15));
	        tdesc.setSize(250, 30);
	        tdesc.setLocation(200, 150);
	        tdesc.setLineWrap(true);
	        c.add(tdesc);
	        
	        AttendedBy = new JLabel("Attended By");
	        AttendedBy.setFont(new Font("Arial", Font.PLAIN, 15));
	        AttendedBy.setSize(100, 20);
	        AttendedBy.setLocation(100, 200);
	        c.add(AttendedBy);
	        
	        tatten = new JComboBox<String>(tattens);
	        tatten.setFont(new Font("Arial", Font.PLAIN, 15));
	        tatten.setSize(200, 20);
	        tatten.setLocation(200, 200);
	        c.add(tatten);
	        
	        IssueStatus = new JLabel("Issue Status");
	        IssueStatus.setFont(new Font("Arial", Font.PLAIN, 15));
	        IssueStatus.setSize(100, 20);
	        IssueStatus.setLocation(100, 300);
	        c.add(IssueStatus);
	        
	        tstatus = new JComboBox<String>(IssueStatusd);
	        tstatus.setFont(new Font("Arial", Font.PLAIN, 15));
	        tstatus.setSize(150, 20);
	        tstatus.setLocation(200, 300);
	        c.add(tstatus);
	        
	        Notes = new JLabel("Notes");
	        Notes.setFont(new Font("Arial", Font.PLAIN, 15));
	        Notes.setSize(100, 20);
	        Notes.setLocation(100, 350);
	        c.add(Notes);
	        
	        tnotes = new JTextArea();
	        tnotes.setFont(new Font("Arial", Font.PLAIN, 15));
	        tnotes.setSize(250, 200);
	        tnotes.setLocation(200, 350);
	        tnotes.setLineWrap(true);
	        c.add(tnotes);
	        
	        JPanel panel = new JPanel();
	       //final String[] COLUMNS = {"Date", "Custname","IssueDesc","AttenBy","issueStatus","Notes"};
	        //String data[]= {"Date","Custname","IssueDesc","AttenBy","issueStatus","Notes"};
	        String data[][] = {{"Date", "Custname","IssueDesc","AttenBy","issueStatus","Notes"}};
	        		  String col[] = {"Emp_Id","Emp_name","Emp_depart","Emp_sal","Emp_sall","Emp_sallld"};
			DefaultTableModel model = new DefaultTableModel(data,col);
			JTable table = new JTable(model);
			table.setBackground(Color.CYAN);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(300);
					
			JTableHeader header = table.getTableHeader();
			header.setBackground(Color.YELLOW);
			JScrollPane pane = new JScrollPane(table);
			panel.add(pane);
			add(panel);
			//table.setLocation(700, 150);
			//table.setSize(300,400);
			//c.add(table);
	        
	        
	        sub = new JButton("Submit Date to DB");
	        sub.setFont(new Font("Arial", Font.PLAIN, 15));
	        sub.setSize(200, 50);
	        sub.setLocation(600, 450);
	        //sub.addActionListener(this);
	        c.add(sub);
	        
	        
	        sub.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
		    			
		    			/*String joindate=datei.getSelectedItem().toString();
		    			String joinmonth=month.getSelectedItem().toString();
		    			String joinyear=year.getSelectedItem().toString();*/
		    			//String date= (joinyear)+(joinmonth)+(joindate);
		    			//LocalDate date1 = LocalDate.parse(toString(), DateTimeFormatter.BASIC_ISO_DATE);
		    			String CustName=tname.getText();
		    			String date= datei.getText();
		    			String IssueDesc=tdesc.getText();
		    			String AttenBy=tatten.getSelectedItem().toString();
		    			String issueStatus=tstatus.getSelectedItem().toString();
		    			String Notes=tnotes.getText();
		    			
		    			
		    			try {
		   		
		    				Class.forName("com.mysql.cj.jdbc.Driver");
		    				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/philstatus","root","Aperta123!");
		    				PreparedStatement insert = con.prepareStatement("insert into apglobal(Date,CustName,IssueDesc,AttenBy,issueStatus,Notes)values(?,?,?,?,?,?)");
		    				
		    				if(CustName.isEmpty()) {
		    					//JOptionPane.showMessageDialog(this, "Enter the Customer Name");}
		    					JOptionPane.showMessageDialog((Component) e.getSource(),"Enter the Customer Name");}
		    					else if (IssueDesc.isEmpty()) {
		    						JOptionPane.showMessageDialog((Component) e.getSource(), "IssueDesc can't be empty");
		    				}
		    					else if (AttenBy.isEmpty()) {
		    					JOptionPane.showMessageDialog((Component) e.getSource(), "AttenBy can't be empty");}
		    					else if (issueStatus.isEmpty()) {
		    					JOptionPane.showMessageDialog((Component) e.getSource(), "issueStatus can't be empty");}
		    					else if (Notes.isEmpty()) {
		    					JOptionPane.showMessageDialog((Component) e.getSource(), "Notes can't be empty");
		    					
		    				}
		    					else if (date.isEmpty()) {
		    						JOptionPane.showMessageDialog((Component) e.getSource(), "Date can't be empty");
		    						
		    					}
		    				else {
		    					insert.setString(1, date);
		    					insert.setString(2, CustName);
		    					insert.setString(3, IssueDesc);
		    					insert.setString(4, AttenBy);
		    					insert.setString(5, issueStatus);
		    					insert.setString(6, Notes);
		    					((PreparedStatement) insert).executeUpdate();
		    					JOptionPane.showMessageDialog((Component) e.getSource(), "Issue Added successfully");
		    				}
		    				
		    	
		    			
		    			}
		    		
		    				
		    			 catch (Exception e1) {
		    				
		    				 JOptionPane.showMessageDialog((Component) e.getSource(), "Error- Add the issue again");
		    				 
		    			}
					
				}
			});
	
	        
	      
			
	        sub1 = new JButton("View Data"); 

	        	sub1.setFont(new Font("Arial", Font.PLAIN, 15));
		        sub1.setSize(200, 50);
		        sub1.setLocation(800, 450);
		        sub1.addActionListener(this);
		        c.add(sub1);
		        setVisible(true);
  
		        sub1.addActionListener(new ActionListener() {
					
		     
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(e.getSource()==sub1) {
						System.out.println("test "+tname.getText());
						table.setLocation(480, 150);
						table.setSize(750,200);
						c.add(table);
						Vector<String> rowData = new Vector<String>();  // create a row Vector
						rowData.add(datei.getText());
						rowData.add(tname.getText());    // fill it with data from JTextFields
				         rowData.add(tdesc.getText());
				         rowData.add(tatten.getSelectedItem().toString());
				         //rowData.add(datei.getSelectedItem().toString(),month.getSelectedItem().toString(),year.getSelectedItem().toString());
				        // rowData.add()
				         rowData.add(tstatus.getSelectedItem().toString());
				         rowData.add(tnotes.getText());
				         //rowData.add(JComboBox<E>)tstatus.getEditor().getEditorComponent()).getText();
				         model.addRow(rowData);
						
						}}
				});
	    }
		 
 
	    	   

	public static void main(String[] args) {
		Status s= new Status();
		

	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	


	
	
}
package browser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Window.Type;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.sql.RowSetMetaData;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.result.Row;


import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class PhilStatus {

	private JFrame frmPhilippinesSupportForm;
	JComboBox tatten;
	JLabel DateOfIssue;
	JLabel title;
	JTextArea datei;
    JComboBox month;
    JComboBox year;
	JLabel CustomerName;
	JTextField tname;
	JTextArea tdesc;
	JComboBox tstatus;
	JTextArea tnotes;
	JLabel IssueDescription;
	JLabel AttendedBy;
	JLabel IssueStatus;
	JButton sub;
	JButton sub1;
	JTable table;
	DefaultTableModel model;
	

	private String tattens[]
    		={"","DV/Sujith","Sujith","DV"};
	
	private String IssueStatusd[]
    		={"","InProgress","Resolved","Closed", "PartialCompleted"};
	


	private JTable table_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhilStatus window = new PhilStatus();
					window.frmPhilippinesSupportForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PhilStatus() {
		initialize();
	}
	
   public void floop() {
	   
	   String CustName=tname.getText();
		String date= datei.getText();
		String IssueDesc=tdesc.getText();
		String AttenBy=tatten.getSelectedItem().toString();
		String issueStatus=tstatus.getSelectedItem().toString();
		String Notes=tnotes.getText();
   }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhilippinesSupportForm = new JFrame();
		frmPhilippinesSupportForm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DHINAKARAN\\Desktop\\Capture.PNG"));
		frmPhilippinesSupportForm.setType(Type.POPUP);
		frmPhilippinesSupportForm.setTitle("Philippines Support Form");
		frmPhilippinesSupportForm.setBounds(300, 90, 1200, 700);
		frmPhilippinesSupportForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cust Name");
		lblNewLabel.setBounds(25, 34, 57, 29);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Issue Desc");
		lblNewLabel_1.setBounds(25, 74, 57, 14);
		lblNewLabel_1.setToolTipText("Enter the Issue Description");
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_1);
		
		JTextArea tdesc = new JTextArea();
		tdesc.setBounds(122, 69, 195, 81);
		tdesc.setFont(new Font("Arial", Font.PLAIN, 13));
		tdesc.setToolTipText("Enter the Issue Description");
		tdesc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tdesc.setLineWrap(true);
		frmPhilippinesSupportForm.getContentPane().add(tdesc);
		
		JTextArea tname = new JTextArea();
		tname.setBounds(122, 36, 195, 22);
		tname.setFont(new Font("Arial", Font.PLAIN, 13));
		tname.setToolTipText("Enter the Customer Name");
		tname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmPhilippinesSupportForm.getContentPane().add(tname);
		
		JLabel lblAttendedBy = new JLabel("Attended By");
		lblAttendedBy.setBounds(25, 167, 69, 29);
		frmPhilippinesSupportForm.getContentPane().add(lblAttendedBy);
		
		tatten = new JComboBox(tattens);
		tatten.setBounds(122, 170, 195, 22);
		tatten.setToolTipText("Select the Issue Attender");
		tatten.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tatten.setAutoscrolls(true);
		tatten.setEditable(true);
		frmPhilippinesSupportForm.getContentPane().add(tatten);
		
		JLabel lblNewLabel_2 = new JLabel("Issue Date");
		lblNewLabel_2.setBounds(25, 207, 57, 29);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_2);
		
		datei = new JTextArea();
		datei.setBounds(122, 209, 195, 22);
		datei.setFont(new Font("Arial", Font.PLAIN, 13));
		datei.setToolTipText("Enter the Date in YYYY-DD-MM");
		datei.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmPhilippinesSupportForm.getContentPane().add(datei);
		
		JLabel lblNewLabel_3 = new JLabel("Issue Status");
		lblNewLabel_3.setBounds(25, 247, 69, 29);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Notes");
		lblNewLabel_4.setBounds(25, 287, 69, 23);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_4);
		
		tnotes = new JTextArea();
		tnotes.setBounds(122, 286, 292, 125);
		tnotes.setFont(new Font("Arial", Font.PLAIN, 13));
		tnotes.setToolTipText("Enter the Notes");
		tnotes.setInheritsPopupMenu(true);
		tnotes.setLineWrap(true);
		tnotes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmPhilippinesSupportForm.getContentPane().add(tnotes);
		
		tstatus = new JComboBox(IssueStatusd);
		tstatus.setBounds(122, 250, 195, 22);
		tstatus.setToolTipText("Select the Issue Status");
		tstatus.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmPhilippinesSupportForm.getContentPane().add(tstatus);
		
		JLabel lblNewLabel_5 = new JLabel("PHILIPPINES SUPPORT LOG FORM");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_5.setBounds(526, 11, 336, 22);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Submit Data to DB");
		btnNewButton.setBounds(72, 515, 144, 72);
		btnNewButton.setBorder(new CompoundBorder());
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(449, 41, 725, 372);
		frmPhilippinesSupportForm.getContentPane().add(scrollPane);
		
		table_7 = new JTable();
		scrollPane.setViewportView(table_7);
		table_7.getTableHeader().setBackground(Color.yellow);
		model =new DefaultTableModel();
		Object[] column={
				"Date", "CustName", "IssueDesc", "AttenBy", "IssueStatus", "Notes"
			};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(column);
		table_7.setModel(model);
		
		table_7.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(2).setPreferredWidth(300);
		table_7.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(5).setPreferredWidth(300);
		
		
		
			
		
		JButton sub1 = new JButton("Data to TableView");
		sub1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String CustName=tname.getText();
				String date= datei.getText();
				String IssueDesc=tdesc.getText();
				String AttenBy=tatten.getSelectedItem().toString();
				String issueStatus=tstatus.getSelectedItem().toString();
				String Notes=tnotes.getText();
				
				
				if(CustName.isEmpty()) {
					//JOptionPane.showMessageDialog(, "Enter the Customer Name");}
					JOptionPane.showMessageDialog((Component) e.getSource(),"Enter the Customer Name");}
					else if (IssueDesc.isEmpty()) {
						JOptionPane.showMessageDialog((Component) e.getSource(), "IssueDesc can't be empty");
				}
					else if (AttenBy.isEmpty()) {
					JOptionPane.showMessageDialog((Component) e.getSource(), "AttenBy can't be empty");}
					else if (date.isEmpty()) {
						JOptionPane.showMessageDialog((Component) e.getSource(), "Date can't be empty");}
					else if (issueStatus.isEmpty()) {
					JOptionPane.showMessageDialog((Component) e.getSource(), "issueStatus can't be empty");}
					else if (Notes.isEmpty()) {
					JOptionPane.showMessageDialog((Component) e.getSource(), "Notes can't be empty");
					
				}
				
					else {
				Vector<String> rowData = new Vector<String>();  // create a row Vector
				rowData.add(datei.getText());
				rowData.add(tname.getText());    // fill it with data from JTextFields
		         rowData.add(tdesc.getText());
		         rowData.add(tatten.getSelectedItem().toString());
		         rowData.add(tstatus.getSelectedItem().toString());
		         rowData.add(tnotes.getText());
	
		          model.addRow(rowData);
		          
		          tname.setText("");
					datei.setText("");
					tdesc.setText("");
					tatten.removeAllItems();
					tstatus.removeAllItems();
					tnotes.setText("");
			}}
		});
		sub1.setBounds(280, 515, 144, 72);
		frmPhilippinesSupportForm.getContentPane().add(sub1);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBorder(new CompoundBorder());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tname.setText("");
				datei.setText("");
				tdesc.setText("");
				tatten.removeAllItems();
				tstatus.removeAllItems();
				tnotes.setText("");
				
			}
		});
		btnNewButton_1.setBounds(459, 515, 144, 72);
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton_1);
	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
    					//JOptionPane.showMessageDialog(, "Enter the Customer Name");}
    					JOptionPane.showMessageDialog((Component) e.getSource(),"Enter the Customer Name");}
    					else if (IssueDesc.isEmpty()) {
    						JOptionPane.showMessageDialog((Component) e.getSource(), "IssueDesc can't be empty");
    				}
    					else if (AttenBy.isEmpty()) {
    					JOptionPane.showMessageDialog((Component) e.getSource(), "AttenBy can't be empty");}
    					else if (date.isEmpty()) {
    						JOptionPane.showMessageDialog((Component) e.getSource(), "Date can't be empty");}
    					else if (issueStatus.isEmpty()) {
    					JOptionPane.showMessageDialog((Component) e.getSource(), "issueStatus can't be empty");}
    					else if (Notes.isEmpty()) {
    					JOptionPane.showMessageDialog((Component) e.getSource(), "Notes can't be empty");
    					
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
    					
    					tname.setText("");
    					datei.setText("");
    					tdesc.setText("");
    					tatten.removeAllItems();
    					tstatus.removeAllItems();
    					tnotes.setText("");
    				}
    				
    	
    			
    			}
    		
    				
    			 catch (Exception e1) {
    				
    				 JOptionPane.showMessageDialog((Component) e.getSource(), "Error- Add the issue again");
    				 
    			}
			}
		});
	}}
			
	
	
	




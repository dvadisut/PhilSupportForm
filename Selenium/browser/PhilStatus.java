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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.sql.RowSetMetaData;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.diagram.STArrowheadStyle;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.result.Row;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import net.proteanit.sql.DbUtils;

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
import javax.swing.UIManager;

public class PhilStatus  {

	public JFrame frmPhilippinesSupportForm;
	public JComboBox tatten;
	public JLabel DateOfIssue;
	public JLabel title;
	public JTextField datei;
	public JComboBox month;
	public JComboBox year;
	public JLabel CustomerName;
	public JTextField tname;
	public JTextArea tdesc;
	public JComboBox tstatus;
	public JTextArea tnotes;
	public JLabel IssueDescription;
	public JLabel AttendedBy;
	public JLabel IssueStatus;
	public JButton sub;
	public JButton sub1;
	public JTable table;
	public Connection con;
	public JTextField tid;
	public DefaultTableModel model;
	public String CustName;
	public String date;
	public String IssueDesc;
	public String AttenBy;
	public String issueStatus;
	public String Notes;
	public PreparedStatement insert;
	public JButton btnNewButton;
	
	String excelFilePath;
	
	
	
	public String tattens[]
    		={"","Paula","Sujith","Sathees","Sujith & Dhinakaran","Dhinakaran"};
	
	public String IssueStatusd[]
    		={"","Completed","InProgress","Issue Resolved","Closed", "Partially Completed","Remote Session","Request"};
	


	public JTable table_7;
	
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
	 * @throws SQLException 
	 */
	public PhilStatus() throws SQLException {
		initialize();
		dbconnect();
		//update jj= new update();
		tformat();
		//clear();
		//buttonon();
		//(e);
	}

	/** DB connection
	 * @throws SQLException 
	 * 
	 */
	
	public void tformat() {
		
		table_7.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_7.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_7.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_7.getColumnModel().getColumn(3).setPreferredWidth(500);
		table_7.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(6).setPreferredWidth(500);
	}
	
	public void dbconnect() throws SQLException{
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/philstatus","root","Aperta123!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	/*public void clear() {
		
		this.tname.setText("");
		this.datei.setText("");
		this.tdesc.setText("");
		this.tnotes.setText("");
		this.tid.setText("");
		
	}*/
	
	
	
	
	
	/*public void buttonstatus(boolean e) {
		
		btnNewButton.setEnabled(e);
	}*/
	

	
	/* variable declaration
	 * 
	 */

	/*public void vdeclaration() {
		
		int ID;
		String CustName=tname.getText();
		String date= datei.getText();
		String IssueDesc=tdesc.getText();
		String AttenBy=tatten.getSelectedItem().toString();
		String issueStatus=tstatus.getSelectedItem().toString();
		String Notes=tnotes.getText();
		Date dates;

	}*/
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	public void initialize() {
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
		tdesc.setBounds(132, 71, 195, 81);
		tdesc.setFont(new Font("Arial", Font.PLAIN, 13));
		tdesc.setToolTipText("Enter the Issue Description");
		tdesc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tdesc.setLineWrap(true);
		frmPhilippinesSupportForm.getContentPane().add(tdesc);
		
		JTextArea tname = new JTextArea();
		tname.setBounds(132, 38, 195, 22);
		tname.setFont(new Font("Arial", Font.PLAIN, 13));
		tname.setToolTipText("Enter the Customer Name");
		tname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmPhilippinesSupportForm.getContentPane().add(tname);
		
		JLabel lblAttendedBy = new JLabel("Attended By");
		lblAttendedBy.setBounds(25, 167, 69, 29);
		frmPhilippinesSupportForm.getContentPane().add(lblAttendedBy);
		
		tatten = new JComboBox(tattens);
		tatten.setBounds(132, 170, 195, 22);
		tatten.setToolTipText("Select the Issue Attender");
		tatten.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tatten.setAutoscrolls(true);
		frmPhilippinesSupportForm.getContentPane().add(tatten);
		
		JLabel lblNewLabel_2 = new JLabel("Issue Date");
		lblNewLabel_2.setBounds(25, 207, 57, 29);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_2);
		
		datei = new JTextField();
		datei.setBounds(132, 211, 195, 22);
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
		tnotes.setBounds(132, 288, 292, 125);
		tnotes.setFont(new Font("Arial", Font.PLAIN, 13));
		tnotes.setToolTipText("Enter the Notes");
		tnotes.setInheritsPopupMenu(true);
		tnotes.setLineWrap(true);
		tnotes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmPhilippinesSupportForm.getContentPane().add(tnotes);
		
		tstatus = new JComboBox(IssueStatusd);
		tstatus.setBounds(132, 250, 195, 22);
		tstatus.setToolTipText("Select the Issue Status");
		tstatus.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmPhilippinesSupportForm.getContentPane().add(tstatus);
		
		JLabel lblNewLabel_5 = new JLabel("PHILIPPINES SUPPORT LOG FORM");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_5.setBounds(526, 11, 336, 22);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Submit Data to DB");
		btnNewButton.setBounds(72, 515, 144, 72);
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					int row =table_7.getSelectedRow();
					
					String Date=(String) (table_7.getModel().getValueAt(row, 0)).toString();
					
					dbconnect();
    				PreparedStatement insert = con.prepareStatement("SELECT * FROM apglobal where Date='"+Date+"' ");
    				insert.setString(3, (String)tatten.getSelectedItem());
    				insert.setString(4, (String)tatten.getSelectedItem());
    				ResultSet rs=insert.executeQuery();
    				
    				while(rs.next()) {
    					datei.setText(rs.getString("Date"));
    					tname.setText(rs.getString("CustName"));
    					tdesc.setText(rs.getString("IssueDesc"));
    					tnotes.setText(rs.getString("Notes"));
    					System.out.println(""+datei);
    					//buttonstatus(false);
    				}
    				insert.close();
				}
				   
				catch (Exception e5) {
					// TODO: handle exception
				}
			}
		});
				
				
			
		
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(449, 41, 725, 372);
		frmPhilippinesSupportForm.getContentPane().add(scrollPane);
		
	
			
		
		table_7 = new JTable();
		table_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton.setEnabled(false);
				
				int row =table_7.getSelectedRow();
				
				//int ID;
				tid.setText(table_7.getModel().getValueAt(row, 0).toString());
				tname.setText(table_7.getModel().getValueAt(row,2 ).toString());
				datei.setText(table_7.getModel().getValueAt(row, 1).toString());
				tdesc.setText(table_7.getModel().getValueAt(row, 3).toString());
				//tatten.setSelectedItem(table_7.getModel().getValueAt(row, 2)).toString();
				//tstatus.getSelectedItem().toString();
				tnotes.setText(table_7.getModel().getValueAt(row, 6).toString());
				String attby=table_7.getModel().getValueAt(row, 4).toString();
				String isstatus=table_7.getModel().getValueAt(row,5).toString();
				
				btnNewButton.setEnabled(false);
				System.out.println(attby);
				
				
				for (int i = 0; i < tatten.getItemCount(); i++) {
					
				if (tatten.getItemAt(i).toString().equalsIgnoreCase(attby)) {
					
					tatten.setSelectedIndex(i);
					
					
				}
				
				for (int j = 0; j < tstatus.getItemCount(); j++) {
					
					if (tstatus.getItemAt(j).toString().equalsIgnoreCase(isstatus)) {
						
						tstatus.setSelectedIndex(j);
						
					}
				
								
			}
				}
			}
		});
		
		scrollPane.setViewportView(table_7);
		table_7.getTableHeader().setBackground(Color.yellow);
		model =new DefaultTableModel();
		Object[] column={
				"IssueID","Date", "CustName", "IssueDesc", "AttenBy", "IssueStatus", "Notes"
			};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(column);
		
		table_7.setModel(model);
		
		
		tformat();
		
		
		
			
		
		
				
				
			
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton.setEnabled(true);
				
				 CustName=tname.getText();
				 date= datei.getText();
				 IssueDesc=tdesc.getText();
				 AttenBy=tatten.getSelectedItem().toString();
				 issueStatus=tstatus.getSelectedItem().toString();
				 Notes=tnotes.getText();
				
				
				
				if(CustName.isEmpty() || date.isEmpty() || IssueDesc.isEmpty() || Notes.isEmpty() ) {
					
					
					JOptionPane.showMessageDialog(null, "Field has null values");
					
				} 
				
				else {
					tname.setText("");
					datei.setText("");
					tdesc.setText("");
					tnotes.setText("");
					tid.setText("");

				}
					
					
				}
			});
		

			
		
		btnNewButton_1.setBounds(459, 515, 144, 72);
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//buttonstatus(false);
					
				
				try {
					
					
					
					dbconnect();
					//PreparedStatement insert = con.prepareStatement("update apglobal set CustName=?,date=?,IssueDesc=?,AttenBy=?,issueStatus=?,Notes=? where ID=?");
					PreparedStatement insert = con.prepareStatement("update apglobal set CustName='"+tname.getText()+"',date='"+datei.getText()+"',IssueDesc='"+tdesc.getText()+"',AttenBy='"+tatten.getSelectedItem().toString()+"',issueStatus='"+tstatus.getSelectedItem().toString()+"',Notes='"+tnotes.getText()+"' where ID='"+tid.getText()+"'");
					
					if(tname.getText().isEmpty() || datei.getText().isEmpty() || tdesc.getText().isEmpty() || tnotes.getText().isEmpty() ) {
						
						
						JOptionPane.showMessageDialog(null, "Empty Fields");
					
					
					
					
				} 
				else
				{
					((PreparedStatement) insert).executeUpdate();
					JOptionPane.showMessageDialog(null, "Update Success");
                    PreparedStatement insert1 = con.prepareStatement("select * from apglobal");
					
					ResultSet rs= insert1.executeQuery();
					table_7.setModel(DbUtils.resultSetToTableModel(rs));
					tformat();
					tname.setText("");
					datei.setText("");
					tdesc.setText("");
					tnotes.setText("");
					tid.setText("");
					btnNewButton.setEnabled(true);
					insert.close();
				}}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					 
					 JOptionPane.showMessageDialog(null, "Update failed");
					 e1.printStackTrace();
				} 
				
			}
			});
	
		
	
			
		btnNewButton_2.setBounds(637, 515, 144, 72);
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Fetch Data");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(true);
				
				try {
					//buttonstatus(true);
					dbconnect();
					PreparedStatement insert = con.prepareStatement("select * from apglobal");
					
					ResultSet rs= insert.executeQuery();
					table_7.setModel(DbUtils.resultSetToTableModel(rs));
					
					tformat();
					
					JOptionPane.showMessageDialog(null, "Data Fetch Success");
					insert.close();
				} 
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					 
					 JOptionPane.showMessageDialog(null, "Error fetching SQL data");
				} 
				
				
			}
		});
		btnNewButton_3.setBounds(806, 515, 144, 72);
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//buttonstatus(false);
try {
					
					
					
					dbconnect();
					//PreparedStatement insert = con.prepareStatement("update apglobal set CustName=?,date=?,IssueDesc=?,AttenBy=?,issueStatus=?,Notes=? where ID=?");
					PreparedStatement insert = con.prepareStatement("delete from apglobal where ID='"+tid.getText()+"'");
					
					if(tname.getText().isEmpty() || datei.getText().isEmpty() || tdesc.getText().isEmpty() || tnotes.getText().isEmpty() ) {
						
						
						JOptionPane.showMessageDialog(null, "Empty Fields");
					
					
					
					
				} 
				else
				{
					((PreparedStatement) insert).executeUpdate();
					JOptionPane.showMessageDialog(null, "Delete Success");
					
                    PreparedStatement insert1 = con.prepareStatement("select * from apglobal");
					
					ResultSet rs= insert1.executeQuery();
					tformat();
					table_7.setModel(DbUtils.resultSetToTableModel(rs));
					tname.setText("");
					datei.setText("");
					tdesc.setText("");
					tnotes.setText("");
					tid.setText("");
					btnNewButton.setEnabled(true);
					insert.close();
				}}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					 
					 JOptionPane.showMessageDialog(null, "Update failed");
					 e1.printStackTrace();
				} 
				
               
			}
		});
		btnNewButton_4.setBounds(966, 515, 144, 72);
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setBounds(36, 441, 58, 14);
		frmPhilippinesSupportForm.getContentPane().add(lblNewLabel_6);
		
		tid = new JTextField();
		tid.setEditable(false);
		tid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tid.setBounds(132, 438, 86, 20);
		frmPhilippinesSupportForm.getContentPane().add(tid);
		tid.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Export");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				excelFilePath="Philpstatus.xlsx";
				try {
					
					
					dbconnect();
					PreparedStatement insert = con.prepareStatement("select * from apglobal");
					ResultSet rs=insert.executeQuery();
					
					String filename = "D:\\java-2021-06\\Balance.XLS";  
					//creating an instance of HSSFWorkbook class  
					HSSFWorkbook workbook = new HSSFWorkbook();  
					
					
					//invoking creatSheet() method and passing the name of the sheet to be created   
					HSSFSheet sheet = workbook.createSheet("SupportLog");   
					
					
					//sheet.autoSizeColumn(100000000);
					sheet.setColumnWidth(0, 5000);
					sheet.setColumnWidth(1, 5000);
					sheet.setColumnWidth(2, 5000);
					sheet.setColumnWidth(3, 5000);
					sheet.setColumnWidth(4, 5000);
					sheet.setColumnWidth(5, 5000);
					sheet.setColumnWidth(6, 7000);
					

					
					
					//CellRangeAddress celladd=new  CellRangeAddress(null);
					//sheet.addMergedRegion(new CellRangeAddress(1,1,1,2));

					
					//creating the 0th row using the createRow() method  
					HSSFRow rowhead = sheet.createRow((short)0);  
					//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
					
					
					
					HSSFRow row = sheet.createRow((short)1);  
					//modifying the cell
					
					//rowhead.setHeight((short) 10);
					
					rowhead.setHeightInPoints(20);
					
					
					HSSFCellStyle style = workbook.createCellStyle();
					HSSFFont font = workbook.createFont();
					
					font.setFontName(HSSFFont.FONT_ARIAL);
					font.setFontHeightInPoints((short)10);
					font.setBold(true);
				
					style.setFont(font);
					
					style.setWrapText(true);
					//sheet.setVerticallyCenter(true);
					
					
					/*rowhead.createCell(0).setCellValue("ID");  
					rowhead.createCell(1).setCellValue("Date");  
					rowhead.createCell(2).setCellValue("Customer Name");  
					rowhead.createCell(3).setCellValue("Issue Description");  
					rowhead.createCell(4).setCellValue("Atten By");  
					rowhead.createCell(5).setCellValue("Issue Status");
					rowhead.createCell(6).setCellValue("Notes");*/
					
					for(int j = 0; j<=6; j++) {
						rowhead.getCell(j).setCellStyle(style);
						style.setWrapText(true);
						//sheet.autoSizeColumn(j);
					}
					
					
					//CellStyle style1 = workbook.createCellStyle();
			        style.setBorderBottom(BorderStyle.THICK);
			        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			        style.setBorderLeft(BorderStyle.THICK);
			        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			        style.setBorderRight(BorderStyle.THICK);
			        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			        style.setBorderTop(BorderStyle.THICK);
			        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			        style.setWrapText(true);
			        
			      /*  for(int j = 0; j<=6; j++) {
						rowhead.getCell(j).setCellStyle(style);
						//sheet.autoSizeColumn(j);
						}*/
					
					//creating the 1st row  
					//HSSFRow row = sheet.createRow((short)1);  
					//inserting data in the first row  
					/*row.createCell(0).setCellValue("1");  
					row.createCell(1).setCellValue("John William");  
					row.createCell(2).setCellValue("9999999");  
					row.createCell(3).setCellValue("william.john@gmail.com");  
					row.createCell(4).setCellValue("700000.00");  
					//creating the 2nd row  
					HSSFRow row1 = sheet.createRow((short)2);  
					//inserting data in the second row  */
					row.createCell(0).setCellValue("2");  
					row.createCell(1).setCellValue("Math");  
					row.createCell(2).setCellValue("On Normal flow inclearing checks will not hit Balancer screen. If any item hits in DCB, You need to defer the particular item and that item will move to the balancer screen - Request  Clarified");  
					row.createCell(3).setCellValue("parker.mathew@gmail.com");  
					row.createCell(4).setCellValue("200000.00");
					
			     /*   for(int i = 0; i<=6; i++) {
						rowhead.getCell(i).setCellStyle(style);
						//sheet.autoSizeColumn(i);
						sheet.setVerticallyCenter(true);
						style.setWrapText(true);
						style.setShrinkToFit(true);
						sheet.autoSizeColumn(100000000);
												}*/

					writeHeaderLine(sheet);
					 
		            writeDataLines(rs, workbook, sheet);
					
					FileOutputStream fileOut = new FileOutputStream(filename);  
					workbook.write(fileOut);  
					//closing the Stream  
					fileOut.close();  
					//closing the workbook  
					workbook.close();  
					//prints the message on the console  
					 JOptionPane.showMessageDialog(null, "Excel file has been generated successfully");
					System.out.println("Excel file has been generated successfully.");  
					}   
					catch (Exception e1)   
					{  
					e1.printStackTrace();  
					}  
					}

			private void writeDataLines(ResultSet rs, HSSFWorkbook workbook, HSSFSheet sheet) {
				HSSFRow headerRow = sheet.createRow(0);
				 
				
				
		        Cell headerCell = headerRow.createCell(0);
		        headerCell.setCellValue("Course Name");
		 
		        headerCell = headerRow.createCell(1);
		        headerCell.setCellValue("Student Name");
		 
		        headerCell = headerRow.createCell(2);
		        headerCell.setCellValue("Timestamp");
		 
		        headerCell = headerRow.createCell(3);
		        headerCell.setCellValue("Rating");
		 
		        headerCell = headerRow.createCell(4);
		        headerCell.setCellValue("Comment");
				
			}

			private void writeHeaderLine(HSSFSheet sheet) {
				// TODO Auto-generated method stub
				
			}  
					

			
		 
		
	});

		
		btnNewButton_5.setBounds(255, 515, 144, 72);
		frmPhilippinesSupportForm.getContentPane().add(btnNewButton_5);
	
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ID;
				 CustName=tname.getText();
				 date= datei.getText();
				 IssueDesc=tdesc.getText();
				 AttenBy=tatten.getSelectedItem().toString();
				 issueStatus=tstatus.getSelectedItem().toString();
				 Notes=tnotes.getText();
				// buttonstatus(true);
    			
    			try {
   		
    		
    				dbconnect();
    				
    				PreparedStatement insert = con.prepareStatement("insert ignore into apglobal(Date,CustName,IssueDesc,AttenBy,issueStatus,Notes)values(?,?,?,?,?,?)");
    				PreparedStatement insert1 = con.prepareStatement("select * from apglobal");
    				
    				
    				if(CustName.isEmpty()) {
    					
    					JOptionPane.showMessageDialog(null,"Enter the Customer Name");}
    					else if (IssueDesc.isEmpty()) {
    						JOptionPane.showMessageDialog(null, "IssueDesc can't be empty");
    				}
    					else if (AttenBy.isEmpty()) {
    					JOptionPane.showMessageDialog(null, "AttenBy can't be empty");}
    					else if (date.isEmpty()) {
    						JOptionPane.showMessageDialog(null, "Date can't be empty");}
    					else if (issueStatus.isEmpty()) {
    					JOptionPane.showMessageDialog(null, "issueStatus can't be empty");}
    					else if (Notes.isEmpty()) {
    					JOptionPane.showMessageDialog(null, "Notes can't be empty");
    					
    				}
    					
    				else {
    					
    					insert.setString(1, date);
    					insert.setString(2, CustName);
    					insert.setString(3, IssueDesc);
    					insert.setString(4, AttenBy);
    					insert.setString(5, issueStatus);
    					insert.setString(6, Notes);
    					((PreparedStatement) insert).executeUpdate();
    					JOptionPane.showMessageDialog(null, "Issue Added successfully");
    					
    					
    					
 						
 						
 						
 						ResultSet rs= insert1.executeQuery();
 						table_7.setModel(DbUtils.resultSetToTableModel(rs));
 						
 						tformat();
 						
 						tname.setText("");
 						datei.setText("");
 						tdesc.setText("");
 						tnotes.setText("");
 						tid.setText("");

 						tname.requestFocus();

    				}
    				
    				insert.close();
    			
    			}
    		
    				
    			 catch (Exception e1) {
    				
    				 JOptionPane.showMessageDialog(null, "Error- Add the issue again");
    				 e1.printStackTrace();
    				 
    			}
    			
			}
		});
	}
}

	
			
			
		
	

		

			
	
	
			
	
	
	




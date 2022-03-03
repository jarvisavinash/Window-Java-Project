package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerId;
	
	public void registerCustomer(String customerName, String customerMobileNumber, String customerEmailId, String customerPassword)
	{
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","window","window")){
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WindowProject", "root", "root")){
				Statement stmt = con.createStatement();
				stmt.executeUpdate("Update counters set cur_val=cur_val+1 where ctr_name='customer'");
				ResultSet rs = stmt.executeQuery("select concat(initial,cur_val+1000)from counters where ctr_name='customer'");
				rs.next();
				String customerId = rs.getString(1);
				PreparedStatement pstmt = con.prepareStatement("insert into customerAccount(customerId, customerName, customerMobileNumber, customerEmailId, customerPassword) values (?,?,?,?,?)");
				pstmt.setString(1, customerId);
				pstmt.setString(2, customerName);
				pstmt.setString(3, customerMobileNumber);
				pstmt.setString(4, customerEmailId);
				pstmt.setString(5, customerPassword);
				
				pstmt.executeUpdate();
				
				rs.close();
				pstmt.close();
				stmt.close();
				
				}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
		public String getCustomerId()
		{
			return customerId;

		}
}
		










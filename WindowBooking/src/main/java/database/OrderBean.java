package database;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class OrderBean {
		
	//String customerId;
		
	public String placeOrder(String customerId, String productNumber, int qty) {
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "window", "window")){
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WindowProject", "root", "root")){
				Statement stmt = con.createStatement();
				stmt.executeUpdate("update counters set cur_val=cur_val+1 where ctr_name='orders'");
				ResultSet rs = stmt.executeQuery("select cur_val from counters where ctr_name='orders'");
				rs.next();
				String orderNumber = rs.getString(1) + 100;
				Date today = new Date(System.currentTimeMillis());
				
				PreparedStatement pstmt = con.prepareStatement("insert into orders values(?,?,?,?,?)");
				pstmt.setString(1, orderNumber);
				pstmt.setDate(2, today);
				pstmt.setString(3, customerId);
				pstmt.setString(4, productNumber);
				pstmt.setInt(5, qty);
				
				pstmt.executeUpdate();
				//con.commit();
				
				rs.close();
				stmt.close();
				pstmt.close();

				return orderNumber;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
}

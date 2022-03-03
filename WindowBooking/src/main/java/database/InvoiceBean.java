package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class InvoiceBean implements Serializable{
	//private String customerId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Iterable<Invoice> getInvoiceOf(String customerId) {
		List<Invoice> entries = new ArrayList<Invoice>();
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "window", "window")){
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WindowProject", "root", "root")){
				PreparedStatement pstmt = con.prepareStatement("select orderNumber, orderDate, productNumber, qty, amount from invoices where customerId=?");
				pstmt.setString(1, customerId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Invoice inv = new Invoice(rs);
					entries.add(inv);
				}
				
				rs.close();
				pstmt.close();
				
				return entries;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}

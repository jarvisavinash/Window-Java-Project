package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String customerId;
	
	public boolean authenticate(String customerId, String customerPassword) {
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "window", "window")){
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WindowProject", "root", "root")){
				PreparedStatement pstmt = con.prepareStatement("select count(customerId) from customerAccount where customerId=? and customerPassword=?");
				pstmt.setString(1, customerId);
				pstmt.setString(2, customerPassword);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				int n = rs.getInt(1);
				rs.close();
				pstmt.close();

				if(n == 1) {
					this.customerId = customerId;
					return true;
				}else {
					this.customerId = null;
					return false; 
				}
			} 
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
		public String getCustomerId() {
			return customerId;
		}
}

	
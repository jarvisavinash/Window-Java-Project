package database;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WindowCombinationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Iterable<WindowCombination> getWinc(){
		List<WindowCombination> winc = new ArrayList<WindowCombination>();
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
//			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "window", "window"))
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WindowProject", "root", "root")){
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select productNumber, productType, standardSize, productRate, stock from windowCombination");
				while(rs.next()) {
					WindowCombination product = new WindowCombination(rs);
					winc.add(product);
				}
				
				rs.close();
				stmt.close();
				
				return winc;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
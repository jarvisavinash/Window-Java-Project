package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WindowCombination {
	
	private String productNumber;
	private String productType;
	private String standardSize;
	private int productRate;
	 private int stock;
	
	
	
	public WindowCombination(ResultSet rs) throws SQLException {
		super();
		productNumber = rs.getString(1);
		productType = rs.getString(2);
		standardSize = rs.getString(3);
		productRate = rs.getInt(4);
		stock = rs.getInt(5);	
	}

	public String getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getStandardSize() {
		return standardSize;
	}
	
	public void setStandardSize(String standardSize) {
		this.standardSize = standardSize;
	}
	
	public int getProductRate() {
		return productRate;
	}
	
	public void setProductRate(int productRate) {
		this.productRate = productRate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "WindowCombination [productNumber=" + productNumber + ", productType=" + productType + ", standardSize="
				+ standardSize + ", productRate=" + productRate + ", stock=" + stock + "]";
	}
}
package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Invoice {

	private String orderNumber;
	private Date orderDate;
	private String productNumber;
	private int qty;
	private int amount;
	
	
	public Invoice(ResultSet rs) throws SQLException {
		super();
		orderNumber = rs.getString(1);
		orderDate = rs.getDate(2);
		productNumber = rs.getString(3);
		qty = rs.getInt(4);
		amount = rs.getInt(5);
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getProductNumber() {
		return productNumber;
	}


	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Invoice [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", productNumber=" + productNumber
				+ ", qty=" + qty + ", amount=" + amount + "]";
	}
	

}

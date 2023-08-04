package com.sandhiya.ecom.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sandhiya.ecom.pojo.Order;
import com.sandhiya.ecom.pojo.Products;

public class OrderRepo {

	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public OrderRepo(Connection con) {
		this.con = con;
	}

	public boolean insertOrder(Order model) {
		boolean result = false;
		try {
			query = "insert into orders (product_id,user_id,order_quantity,order_date) values(?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, model.getId());
			pst.setInt(2, model.getuId());
			pst.setInt(3, model.getQuantity());
			pst.setString(4, model.getDate());

			pst.executeUpdate();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Order> userOrder(int id) {
		List<Order> list = new ArrayList<>();

		try {
			query = "select * from orders where user_id=? order by orders.order_id desc";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				ProductRepo productDb = new ProductRepo(this.con);
				int productId = rs.getInt("product_id");

				Products product = productDb.getSingleProduct(productId);
				order.setOrderId(rs.getInt("order_id"));
				order.setId(productId);
				order.setName(product.getName());
				order.setCategory(product.getCategory());
				order.setPrice(product.getPrice() * rs.getInt("order_quantity"));
				order.setQuantity(rs.getInt("order_quantity"));
				order.setDate(rs.getString("order_date"));
				list.add(order);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 public void cancelOrder(int id) {
	        //boolean result = false;
	        try {
	            query = "delete from orders where order_id=?";
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            pst.execute();
	            //result = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	        }
	        //return result;
	    }

}

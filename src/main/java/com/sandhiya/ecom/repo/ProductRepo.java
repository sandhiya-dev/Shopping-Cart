package com.sandhiya.ecom.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sandhiya.ecom.pojo.Cart;
import com.sandhiya.ecom.pojo.Products;

public class ProductRepo {
	private Connection con;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
	public ProductRepo(Connection con) {
		super();
		this.con = con;
	}

	public List<Products> getAllProducts() {
        List<Products> book = new ArrayList<>();
        try {

            query = "select * from products";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Products row = new Products();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("productName"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));

                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	 public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
	        List<Cart> book = new ArrayList<>();
	        try {
	            if (cartList.size() > 0) {
	                for (Cart item : cartList) {
	                    query = "select * from products where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        Cart row = new Cart();
	                        row.setId(rs.getInt("id"));
	                        row.setName(rs.getString("productName"));
	                        row.setCategory(rs.getString("category"));
	                        row.setPrice(rs.getDouble("price")*item.getQuantity());
	                        row.setQuantity(item.getQuantity());
	                        book.add(row);
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return book;
	    }
	 
	 public double getTotalCartPrice(ArrayList<Cart> cartList) {
	        double sum = 0;
	        try {
	            if (cartList.size() > 0) {
	                for (Cart item : cartList) {
	                    query = "select price from products where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        sum+=rs.getDouble("price")*item.getQuantity();
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return sum;
	    }
	 
	 public Products getSingleProduct(int id) {
		 Products row=null;
		 
		 try {
			 query = "Select * from products where id=?";
			 pst = this.con.prepareStatement(query);
			 pst.setInt(1, id);
			 rs=pst.executeQuery();
			 
			 while(rs.next()) {
				 row =new Products();
				 row.setId(rs.getInt("id"));
				 row.setName(rs.getString("productName"));
				 row.setCategory(rs.getString("category"));
				 row.setPrice(rs.getDouble("price"));
				 row.setImage(rs.getString("image"));
				 
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return row;
		 
	 }


}

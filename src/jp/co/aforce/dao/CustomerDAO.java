package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Customer;
import jp.co.aforce.javaDAO.DAO;


public class CustomerDAO extends DAO{
	public Customer search (int id, String password)
	throws Exception{
		Customer customer=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select*from customer where id=? and password=?"
				);
		st.setInt(1, id);
		st.setString(2, password);
		
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			customer=new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}
		st.close();
		con.close();
		return customer;
				
	}

}

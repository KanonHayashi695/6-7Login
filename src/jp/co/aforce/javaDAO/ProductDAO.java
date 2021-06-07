package jp.co.aforce.javaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Customer;

public class ProductDAO extends DAO{
	public List<Customer> search(String keyword) throws Exception{
		List<Customer> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select*from product where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			Customer c=new Customer();
			c.setId(rs.getInt("id"));
			c.setLogin(rs.getString("login"));
			c.setPassword(rs.getString("password"));
			list.add(c);
		}
		st.close();
		con.close();
		
		return list;
	}
	
	public int insert(Customer customer) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into product values(?,?,?)");
		st.setInt(1, customer.getId());
		st.setString(2, customer.getPassword());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;

}
}
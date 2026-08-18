package com.reposity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.CategoryBean;

public class CategoryRepository {
	
	// Get ALl Category 
	public  List<CategoryBean> getAllCategory(){
		List<CategoryBean> catlist = new ArrayList<CategoryBean>();
		
		String sql="SELECT * FROM catogary";
		
		try(Connection con=DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				CategoryBean obj = new CategoryBean();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("cat_name"));
				
				catlist.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("Category List error : " +e.getMessage());
		}
		return catlist;
	}
	
}

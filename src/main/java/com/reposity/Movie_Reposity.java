package com.reposity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Movie_Bean;

public class Movie_Reposity {
	
	//Get Movies  By Catagory
	public  List<Movie_Bean> getMovesByCatId(int categoryId){
		List<Movie_Bean> movList = new ArrayList<Movie_Bean>();
		
		String sql="SELECT * FROM mydb.movie where catogary_id=?";
		
		try(Connection con=DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			
			ps.setInt(1, categoryId);
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Movie_Bean obj = new Movie_Bean();
				obj.setId(rs.getInt("id"));
				obj.setTitle(rs.getString("titlet"));
				obj.setPreShow(rs.getString("pre_show"));
				obj.setReleseYear(rs.getDate("relese_year").toLocalDate());
				obj.setDuction(rs.getString("ducation"));
				obj.setCategoryId(rs.getInt("catogary_id"));
				
				movList.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("Movie List error : " +e.getMessage());
		}
		return movList;
	}
	
	//Rentanced Movies
	public int rentMovi(int memberId , int movieId) {
		
		int i =0;
		
		String sql="insert into movie_randacted(member_id,movie_id) values(?,?)";
		
		try(Connection con=DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			
			ps.setInt(1, memberId);
			ps.setInt(2, movieId);
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Movie Rented error : "+e.getMessage());
		} 
		return i;
	}

}

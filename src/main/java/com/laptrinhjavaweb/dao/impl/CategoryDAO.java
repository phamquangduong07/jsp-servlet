package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/newservlet";
			String username="root";
			String password="28102003";
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}
//public static void main(String[] args) {
//	CategoryDAO ct = new CategoryDAO();
//	
//	List<CategoryModel> list = ct.findAll();
//	for(CategoryModel c: list) {
//		System.out.println(c);
//	}
//}
	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		String sql ="select * from category";
		//Open connection
		Connection connection = getConnection();
		ResultSet resultSet=null;
		PreparedStatement statement = null;
		if(connection!=null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet =  statement.executeQuery();
				while(resultSet.next()) {
					CategoryModel categoryModel = new CategoryModel();
					categoryModel.setId(resultSet.getLong("id"));
					categoryModel.setCode(resultSet.getString("code"));
					categoryModel.setName(resultSet.getString("name"));
					results.add(categoryModel);
				}
				
				return results;
			} catch (SQLException e) {
				return null;
			}finally {
				try {
					if(connection!=null) {
						connection.close();
					}
					if(statement!=null) {
						statement.close();
					}
					if(resultSet!=null) {
						resultSet.close();
					}
				} catch (SQLException e2) {
					return null;
				}
				
			}
			
			
		}
		return null;
		
	}

}

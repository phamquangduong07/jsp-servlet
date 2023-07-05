package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {

		String sql = "select * from news where categoryid =?";
		// Open connection

		return query(sql, new NewMapper(), categoryId);

	}

//	public static void main(String[] args) {
//		String title = "Bài viết 9";
//		String content = "bài viết 9";
//		Long categoryId = 1L;
//		NewModel model = new NewModel();
//		model.setTitle(title);
//		model.setContent(content);
//		model.setCategoryid(categoryId);
//		NewDAO dao = new NewDAO();
//		System.out.println(dao.save(model));
//		;
//	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "insert into news(title,content,categoryid) values(?,?,?);";

		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryid());

	}

}

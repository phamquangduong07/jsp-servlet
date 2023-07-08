package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}
private List<NewModel> findAll() {
	String sql ="select * from news where id =?";
	return query(sql, new NewMapper(),1L);
}
	public static void main(String[] args) {
//		String title = "Bài viết 9";
//		String content = "bài viết 9";
//		Long categoryId = 1L;
//		NewModel model = new NewModel();
//		model.setTitle(title);
//		model.setContent(content);
//		model.setCategoryid(categoryId);
	NewDAO dao = new NewDAO();
	NewModel list = dao.findOne(1L);
		
			System.out.println(list);
		

	}
	
	@Override
	public Long save(NewModel newModel) {
		String sql = "insert into news(title,content,categoryid) values(?,?,?);";

		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryid());

	}

	@Override
	public NewModel findOne(Long id) {

		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

}

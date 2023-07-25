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

	public List<NewModel> findAll() {
		String sql = "select * from news ";
		return query(sql, new NewMapper());
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), newModel.getThumbnail(),
				newModel.getShortdescription(), newModel.getCategoryid(), newModel.getCreatedDate(),
				newModel.getCreatedBy());

	}

	@Override
	public NewModel findOne(Long id) {

		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortdescription(),
				updateNew.getContent(), updateNew.getCategoryid(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());

	}

	@Override
	public void delete(long id) {
		String sql = "delete from news where id =?";
		update(sql, id);

	}

}

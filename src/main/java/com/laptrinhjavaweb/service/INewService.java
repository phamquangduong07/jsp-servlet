package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {
	List<NewModel> findbyCategoryId(Long categoryId);

	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long[] id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}

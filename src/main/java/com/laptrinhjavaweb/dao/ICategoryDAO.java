package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO extends GennericDAO<CategoryModel>{
	List<CategoryModel> findAll();
}

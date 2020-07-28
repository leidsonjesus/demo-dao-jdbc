package model.dao;

import java.util.List;

import model.entidade.Saller;

public interface SellerDao {
	void insert(Saller obj);
	void update(Saller obj);
	void deleteById(Integer id);
	Saller findbyId(Integer id);
	List<Saller> findAll();

}

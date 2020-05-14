package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.GroceryList;
import com.revature.repository.DaoContract;

@Service
public class GroceryListService {

	  private DaoContract<GroceryList, Integer> dao;

	  @Autowired
	  public void setUserService(DaoContract<GroceryList, Integer> dc) {
	    dao = dc;
	  }
	
	  public List<GroceryList> getAll() {
		    return dao.findAll();
		  }

		  public GroceryList save(GroceryList t) {
		    dao.save(t);
		    return t;
		  }

		  public GroceryList getById(int id) {
		    return dao.findById(id);
		  }

		  public GroceryList update(GroceryList list) {
			GroceryList oldUser = dao.findById(list.getId());
		    oldUser = dao.update(list);
		    return dao.findById(oldUser.getId());
		  }

		  public boolean deleteById(int id) {
		    dao.delete(dao.findById(id));
		    return true;
		  }
	
}

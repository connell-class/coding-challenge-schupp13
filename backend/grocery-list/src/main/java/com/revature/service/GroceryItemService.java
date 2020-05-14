package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.GroceryItem;
import com.revature.repository.DaoContract;


@Service
public class GroceryItemService {
	
	  private DaoContract<GroceryItem, Integer> dao;

	  @Autowired
	  public void setUserService(DaoContract<GroceryItem, Integer> dc) {
	    dao = dc;
	  }
	
	  public List<GroceryItem> getAll() {
		  
		    return dao.findAll();
		  }

		  public List<GroceryItem> getAllByAuthor(int id) {
		    return dao.findAllById(id);
		  }


		  public GroceryItem save(GroceryItem t) {
		    dao.save(t);
		    return t;
		  }

		  public GroceryItem getById(int id) {
		    return dao.findById(id);
		  }

		  public GroceryItem update(GroceryItem newItem) {
			  GroceryItem oldItem = dao.findById(newItem.getId());
			  oldItem = dao.update(newItem);
		    return dao.findById(oldItem.getId());
		  }

		  public boolean deleteById(int id) {
		    dao.delete(dao.findById(id));
		    return true;
		  }

		public List<GroceryItem> getAllByListId(int id) {
			return dao.findAllById(id);
		}


}

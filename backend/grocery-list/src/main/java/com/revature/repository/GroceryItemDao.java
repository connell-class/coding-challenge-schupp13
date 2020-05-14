package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.GroceryItem;



@Repository
@Transactional
public class GroceryItemDao implements DaoContract<GroceryItem, Integer> {
	
	  private SessionFactory ses;

	  @Autowired
	  public void setSesFact(SessionFactory sse) {
	    ses = sse;
	  }


	public GroceryItem findById(Integer id) {
		return ses.openSession().get(GroceryItem.class, id);
	}

	public void save(GroceryItem t) {
		 ses.openSession().save(t);
		
	}

	public boolean delete(GroceryItem t) {
		ses.getCurrentSession().delete(t);
	    if (findById(t.getId()) == null) {
	        return true;
	      }
	      return false;
	}

	public GroceryItem update(GroceryItem t) {
		ses.getCurrentSession().update(t);
	    return findById(t.getId());
	}

	public List<GroceryItem> findAll() {
	    return ses.openSession().createQuery("from GroceryItem", GroceryItem.class).getResultList();

	}

	public List<GroceryItem> findAllById(int id) {
	    return ses.openSession().createQuery("from GroceryItem where listId = " + id + " order by list_id desc", GroceryItem.class).getResultList();

	}

	public GroceryItem findByString(String s) {
		  return ses.openSession()
			        .createQuery("from GroceryItem where name = '" + s + "'", GroceryItem.class)
			        .getSingleResult();
	}


}

package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.GroceryList;



@Repository
@Transactional
public class GroceryListDao implements DaoContract<GroceryList, Integer> {
	
	  private SessionFactory ses;

	  @Autowired
	  public void setSesFact(SessionFactory sse) {
	    ses = sse;
	  }


	public GroceryList findById(Integer id) {
		
		 return ses.openSession().get(GroceryList.class, id);
	}

	public void save(GroceryList t) {
		ses.openSession().save(t);
		
	}

	public boolean delete(GroceryList t) {
		 ses.getCurrentSession().delete(t);
		    if (findById(t.getId()) == null) {
		      return true;
		    }
		    return false;
	}

	public GroceryList update(GroceryList t) {
		  ses.getCurrentSession().update(t);
		    return findById(t.getId());
	}

	public List<GroceryList> findAll() {
	    return ses.openSession().createQuery("from GroceryList", GroceryList.class).getResultList();

	}

	public List<GroceryList> findAllById(int id) {
		return null;
	}

	public GroceryList findByString(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}

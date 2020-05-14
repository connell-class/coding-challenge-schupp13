package com.revature.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.model.GroceryList;
import com.revature.service.GroceryListService;

@Controller
@CrossOrigin
public class GroceryListController {

	  @Autowired
	  private GroceryListService sc;
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/grocery-lists.app")
	  public ResponseEntity<List<GroceryList>> findAll() {	
		  System.out.println("hellllllllloooooooo");
	    return new ResponseEntity<List<GroceryList>>(sc.getAll(), HttpStatus.OK);
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/grocery-lists/{id}.app")
	  public ResponseEntity<GroceryList> getById(@PathVariable("id") int id) {
	    return new ResponseEntity<GroceryList>(sc.getById(id), HttpStatus.OK);
	  }
	  
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/grocery-lists.app")
	  public ResponseEntity<GroceryList> save(@RequestBody GroceryList g) {
	    g = sc.save(g);
	    return new ResponseEntity<GroceryList>(sc.getById(g.getId()), HttpStatus.CREATED);
	  }
	  
	  @RequestMapping(method = RequestMethod.DELETE, value = "/grocery-lists/{id}.app")
	  public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
		 
	    if (sc.deleteById(id)) {
	      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
	
	   
	  }
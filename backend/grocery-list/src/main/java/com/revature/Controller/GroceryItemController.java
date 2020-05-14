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
import com.revature.model.GroceryItem;
import com.revature.service.GroceryItemService;


@Controller
@CrossOrigin
public class GroceryItemController {
	
	 @Autowired
	  private GroceryItemService sc;
	
	  @RequestMapping(method = RequestMethod.POST, value = "/grocery-lists/items.app")
	  public ResponseEntity<GroceryItem> save(@RequestBody GroceryItem item) {
		  System.out.println(item);
		  System.out.println("HELLO FROM GRCOERY ITEM POST");
		  item = sc.save(item);
	    return new ResponseEntity<GroceryItem>(sc.getById(item.getId()), HttpStatus.CREATED);
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/grocery-lists/{id}/items.app")
	  public ResponseEntity<List<GroceryItem>> findByListId(@PathVariable("id") int id) {
	   return new ResponseEntity<List<GroceryItem>>(sc.getAllByListId(id), HttpStatus.OK);
	  }
	  
	  @RequestMapping(method = RequestMethod.DELETE, value = "/grocery-lists/items/{id}.app")
	  public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
		 
	    if (sc.deleteById(id)) {
	      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
}

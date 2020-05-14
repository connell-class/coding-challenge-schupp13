package com.revature.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class GroceryItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	 @JoinColumn(name = "list_id", referencedColumnName = "id", nullable = false)
	private GroceryList listId;
	
	private String name;
	
	private String type;
	
	private Float price;
	
	

	public GroceryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroceryItem(int id, GroceryList listId, String name, String type, Float price) {
		super();
		this.id = id;
		this.listId = listId;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GroceryList getListId() {
		return listId;
	}

	public void setListId(GroceryList listId) {
		this.listId = listId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "GroceryItem [id=" + id + ", listId=" + listId + ", name=" + name + ", type=" + type + ", price=" + price
				+ "]";
	}
}

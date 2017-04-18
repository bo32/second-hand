package com.david.secondhand.entities;

import java.util.List;

public class ObjectToSell {
	
	private Long id;
	private String name;
	private String description;
	private double price;
	private List<Picture> pictures;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Picture> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

package com.example.productdetails;

//Entity class
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity

	public class ProductDetails 
	{ @Id
	 private Integer id;
	 private String name;
	 private float price;
	 
	 public ProductDetails() 
	 {
		 
	 }
	 public ProductDetails(Integer id, String name, float price) 
	 {
	 this.id = id;
	 this.name = name;
	 this.price = price;
	 }

	 
	 public Integer getId() 
	 {
	 return id;
	 }
	public void setId(Integer id) 
	{
	this.id = id;
	}
	public String getName() 
	{
	return name;
	}
	public void setName(String name) 
	{
	this.name = name;
	}
	public float getPrice() 
	{
	return price;
	}
	public void setPrice(float price) 
	{
	this.price = price;
	}
	@Override
	public String toString() 
	{
	return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	 
	}
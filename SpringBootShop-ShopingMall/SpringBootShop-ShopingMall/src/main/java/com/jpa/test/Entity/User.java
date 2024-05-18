package com.jpa.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserId;
	private String name;
	private String type;
	private String password;
	
	@OneToOne(mappedBy = "user")
    private ShopOwner shopOwner;
	
	@OneToOne(mappedBy = "user")
    private Customer customer;
	
	@OneToOne(mappedBy = "user")
    private MallAdmin malladmin;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String name, String type, String password, ShopOwner shopOwner, Customer customer,
			MallAdmin malladmin) {
		super();
		UserId = userId;
		this.name = name;
		this.type = type;
		this.password = password;
		this.shopOwner = shopOwner;
		this.customer = customer;
		this.malladmin = malladmin;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public MallAdmin getMalladmin() {
		return malladmin;
	}

	public void setMalladmin(MallAdmin malladmin) {
		this.malladmin = malladmin;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", name=" + name + ", type=" + type + ", password=" + password
				+ ", shopOwner=" + shopOwner + ", customer=" + customer + ", malladmin=" + malladmin + "]";
	}

	
	
	
	
	
	
	
	
	

	
	
	
	
	

}

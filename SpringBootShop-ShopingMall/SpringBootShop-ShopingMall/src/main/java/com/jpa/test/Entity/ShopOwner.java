package com.jpa.test.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class ShopOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int UserId;
	private String name;
	private LocalDate DOB;
	private String address;
 
    
    @OneToOne
	@JoinColumn(name = "UserId")
    private User user;

	@OneToOne
	@JoinColumn(name = "shopid")
    private ShopEntity Shop;

	public ShopOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopOwner(int userId, String name, LocalDate dOB, String address, User user, ShopEntity shop) {
		super();
		UserId = userId;
		this.name = name;
		DOB = dOB;
		this.address = address;
		this.user = user;
		Shop = shop;
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

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ShopEntity getShop() {
		return Shop;
	}

	public void setShop(ShopEntity shop) {
		Shop = shop;
	}

	@Override
	public String toString() {
		return "ShopOwner [UserId=" + UserId + ", name=" + name + ", DOB=" + DOB + ", address=" + address + ", user="
				+ user + ", Shop=" + Shop + "]";
	}
    
	
	
	
    
    
	
	
	
	


}

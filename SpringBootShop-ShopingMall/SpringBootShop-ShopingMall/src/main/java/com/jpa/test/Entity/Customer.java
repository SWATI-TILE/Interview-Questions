package com.jpa.test.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Customer_ID;
	private String Name;
	private String Phone;
	private String Email;
	
	@ManyToOne
    @JoinColumn(name = "shopid")
    private ShopEntity CShop;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
    private List<OrderDetails> OrderDetails;

	@OneToOne
	@JoinColumn(name = "UserId")
    private User user;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_ID, String name, String phone, String email, ShopEntity cShop,
			List<com.jpa.test.Entity.OrderDetails> orderDetails, User user) {
		super();
		Customer_ID = customer_ID;
		Name = name;
		Phone = phone;
		Email = email;
		CShop = cShop;
		OrderDetails = orderDetails;
		this.user = user;
	}

	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public ShopEntity getCShop() {
		return CShop;
	}

	public void setCShop(ShopEntity cShop) {
		CShop = cShop;
	}

	public List<OrderDetails> getOrderDetails() {
		return OrderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		OrderDetails = orderDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [Customer_ID=" + Customer_ID + ", Name=" + Name + ", Phone=" + Phone + ", Email=" + Email
				+ ", CShop=" + CShop + ", OrderDetails=" + OrderDetails + ", user=" + user + "]";
	}

	
	
	
	
	
	
	
	
	
	

	

}

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
public class ShopEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int shopid;
	    private	String shopCategory ;
		//private String shopOwner;
		private String shopName;
		private String shopStatus;
		private String leaseStatus;
		
		//Employee and shop merging
		@OneToMany(mappedBy = "Shop", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JsonIgnore
	    private List<Employee> employees;
		
		
		//Item and Shop Merging
		@OneToMany(mappedBy = "IShop",cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	    @JsonIgnore
	    private List<ItemEntity> item;
		
		//OrderDetails and Shop Merging
		@OneToMany(mappedBy = "OShop",cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
		@JsonIgnore
		private List<OrderDetails> OrderDetails;
		
		@OneToMany(mappedBy = "CShop", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JsonIgnore
	    private List<Customer> customer;
		
		
		//Shop Owner and Shop one to one relationship
		@OneToOne(mappedBy = "Shop")
		ShopOwner shopOwner;


		public ShopEntity() {
			super();
			// TODO Auto-generated constructor stub
		}


		public ShopEntity(int shopid, String shopCategory, String shopName, String shopStatus, String leaseStatus,
				List<Employee> employees, List<ItemEntity> item, List<com.jpa.test.Entity.OrderDetails> orderDetails,
				List<Customer> customer, ShopOwner shopOwner) {
			super();
			this.shopid = shopid;
			this.shopCategory = shopCategory;
			this.shopName = shopName;
			this.shopStatus = shopStatus;
			this.leaseStatus = leaseStatus;
			this.employees = employees;
			this.item = item;
			OrderDetails = orderDetails;
			this.customer = customer;
			this.shopOwner = shopOwner;
		}


		public int getShopid() {
			return shopid;
		}


		public void setShopid(int shopid) {
			this.shopid = shopid;
		}


		public String getShopCategory() {
			return shopCategory;
		}


		public void setShopCategory(String shopCategory) {
			this.shopCategory = shopCategory;
		}


		public String getShopName() {
			return shopName;
		}


		public void setShopName(String shopName) {
			this.shopName = shopName;
		}


		public String getShopStatus() {
			return shopStatus;
		}


		public void setShopStatus(String shopStatus) {
			this.shopStatus = shopStatus;
		}


		public String getLeaseStatus() {
			return leaseStatus;
		}


		public void setLeaseStatus(String leaseStatus) {
			this.leaseStatus = leaseStatus;
		}


		public List<Employee> getEmployees() {
			return employees;
		}


		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}


		public List<ItemEntity> getItem() {
			return item;
		}


		public void setItem(List<ItemEntity> item) {
			this.item = item;
		}


		public List<OrderDetails> getOrderDetails() {
			return OrderDetails;
		}


		public void setOrderDetails(List<OrderDetails> orderDetails) {
			OrderDetails = orderDetails;
		}


		public List<Customer> getCustomer() {
			return customer;
		}


		public void setCustomer(List<Customer> customer) {
			this.customer = customer;
		}


		public ShopOwner getShopOwner() {
			return shopOwner;
		}


		public void setShopOwner(ShopOwner shopOwner) {
			this.shopOwner = shopOwner;
		}


		@Override
		public String toString() {
			return "ShopEntity [shopid=" + shopid + ", shopCategory=" + shopCategory + ", shopName=" + shopName
					+ ", shopStatus=" + shopStatus + ", leaseStatus=" + leaseStatus + ", employees=" + employees
					+ ", item=" + item + ", OrderDetails=" + OrderDetails + ", customer=" + customer + ", shopOwner="
					+ shopOwner + "]";
		}
		
		
		
		
		
		
		
		

		
		

	
		
		

}

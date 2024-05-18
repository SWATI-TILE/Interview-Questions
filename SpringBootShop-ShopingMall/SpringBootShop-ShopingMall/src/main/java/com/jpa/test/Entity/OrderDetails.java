package com.jpa.test.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailsId;
	private LocalDate dateOfPurchase;
	private float total;
	private String paymentMode;
	
		//shop
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "shopid")
		private ShopEntity OShop;
		
		//Customer
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "Customer_ID")
		private Customer customer;

		public OrderDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

		public OrderDetails(int orderDetailsId, LocalDate dateOfPurchase, float total, String paymentMode,
				ShopEntity oShop, Customer customer) {
			super();
			this.orderDetailsId = orderDetailsId;
			this.dateOfPurchase = dateOfPurchase;
			this.total = total;
			this.paymentMode = paymentMode;
			OShop = oShop;
			this.customer = customer;
		}

		public int getOrderDetailsId() {
			return orderDetailsId;
		}

		public void setOrderDetailsId(int orderDetailsId) {
			this.orderDetailsId = orderDetailsId;
		}

		public LocalDate getDateOfPurchase() {
			return dateOfPurchase;
		}

		public void setDateOfPurchase(LocalDate dateOfPurchase) {
			this.dateOfPurchase = dateOfPurchase;
		}

		public float getTotal() {
			return total;
		}

		public void setTotal(float total) {
			this.total = total;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

		public ShopEntity getOShop() {
			return OShop;
		}

		public void setOShop(ShopEntity oShop) {
			OShop = oShop;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "OrderDetails [orderDetailsId=" + orderDetailsId + ", dateOfPurchase=" + dateOfPurchase + ", total="
					+ total + ", paymentMode=" + paymentMode + ", OShop=" + OShop + ", customer=" + customer + "]";
		}


	
	
	
	
	
	

	
	
	
	
	
	
	
	

}

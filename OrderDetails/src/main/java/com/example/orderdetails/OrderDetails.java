package com.example.orderdetails;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class OrderDetails 
{
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;	//primary key
	    private LocalDateTime purchaseDateTime;
	    private String status;
	    private String paymentMode;
		
	    
	    //@ManyToOne
	   // private Shop shop;
	
	    //constructors
	    public OrderDetails() {
			super();
		}


		public OrderDetails(int id, LocalDateTime purchaseDateTime, String status, String paymentMode) {
			super();
			this.id = id;
			this.purchaseDateTime = purchaseDateTime;
			this.status = status;
			this.paymentMode = paymentMode;
		}


		//getters and setters
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public LocalDateTime getPurchaseDateTime() {
			return purchaseDateTime;
		}


		public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
			this.purchaseDateTime = purchaseDateTime;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public String getPaymentMode() {
			return paymentMode;
		}


		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}


		//tostring
		@Override
		public String toString() {
			return "OrderDetails [id=" + id + ", purchaseDateTime=" + purchaseDateTime + ", status=" + status
					+ ", paymentMode=" + paymentMode + "]";
		}
	    
	    
		

}

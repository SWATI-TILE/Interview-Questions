package com.jpa.test.Entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ItemId;
	private String ItemName;
	private LocalDate ItemManufacturingDate ;
	private LocalDate ItemExpiryDate ;
	private float ItemPrice;
	private String Category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopid")
	private ShopEntity IShop;

	public ItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemEntity(int itemId, String itemName, LocalDate itemManufacturingDate, LocalDate itemExpiryDate,
			float itemPrice, String category, ShopEntity iShop) {
		super();
		ItemId = itemId;
		ItemName = itemName;
		ItemManufacturingDate = itemManufacturingDate;
		ItemExpiryDate = itemExpiryDate;
		ItemPrice = itemPrice;
		Category = category;
		IShop = iShop;
	}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public LocalDate getItemManufacturingDate() {
		return ItemManufacturingDate;
	}

	public void setItemManufacturingDate(LocalDate itemManufacturingDate) {
		ItemManufacturingDate = itemManufacturingDate;
	}

	public LocalDate getItemExpiryDate() {
		return ItemExpiryDate;
	}

	public void setItemExpiryDate(LocalDate itemExpiryDate) {
		ItemExpiryDate = itemExpiryDate;
	}

	public float getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(float itemPrice) {
		ItemPrice = itemPrice;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public ShopEntity getIShop() {
		return IShop;
	}

	public void setIShop(ShopEntity iShop) {
		IShop = iShop;
	}

	@Override
	public String toString() {
		return "ItemEntity [ItemId=" + ItemId + ", ItemName=" + ItemName + ", ItemManufacturingDate="
				+ ItemManufacturingDate + ", ItemExpiryDate=" + ItemExpiryDate + ", ItemPrice=" + ItemPrice
				+ ", Category=" + Category + ", IShop=" + IShop + "]";
	}
	
	

	
	
	
	
	

	
	
	
	
	
	

}

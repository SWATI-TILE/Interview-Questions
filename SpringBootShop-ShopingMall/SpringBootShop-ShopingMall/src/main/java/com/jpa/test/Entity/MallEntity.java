package com.jpa.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
public class MallEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Mall_Id;
	
	private String Mall_Name;
	private String Location;
	private String Categories;
	

	 
	 
	 @OneToMany(mappedBy = "mall")
	 private List<MallAdmin> mallAdmins;




	public MallEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public MallEntity(long mall_Id, String mall_Name, String location, String categories, List<MallAdmin> mallAdmins) {
		super();
		Mall_Id = mall_Id;
		Mall_Name = mall_Name;
		Location = location;
		Categories = categories;
		this.mallAdmins = mallAdmins;
	}




	public long getMall_Id() {
		return Mall_Id;
	}




	public void setMall_Id(long mall_Id) {
		Mall_Id = mall_Id;
	}




	public String getMall_Name() {
		return Mall_Name;
	}




	public void setMall_Name(String mall_Name) {
		Mall_Name = mall_Name;
	}




	public String getLocation() {
		return Location;
	}




	public void setLocation(String location) {
		Location = location;
	}




	public String getCategories() {
		return Categories;
	}




	public void setCategories(String categories) {
		Categories = categories;
	}




	public List<MallAdmin> getMallAdmins() {
		return mallAdmins;
	}




	public void setMallAdmins(List<MallAdmin> mallAdmins) {
		this.mallAdmins = mallAdmins;
	}




	@Override
	public String toString() {
		return "MallEntity [Mall_Id=" + Mall_Id + ", Mall_Name=" + Mall_Name + ", Location=" + Location
				+ ", Categories=" + Categories + ", mallAdmins=" + mallAdmins + "]";
	}


	 
	 

	
	
	
	
	
	
	
	

	
	
	
	
	

}

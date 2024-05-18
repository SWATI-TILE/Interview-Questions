package com.jpa.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class MallAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MallAdminId;
	private String name;
	private String password; 
	private String phone;
	

	
	@OneToOne
	@JoinColumn(name = "UserId")
    private User user;
	
	@ManyToOne
	@JoinColumn(name = "mall_id")
	private MallEntity mall;

	public MallAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MallAdmin(int mallAdminId, String name, String password, String phone, User user,
			MallEntity mall) {
		super();
		MallAdminId = mallAdminId;
		this.name = name;
		this.password = password;
		this.phone = phone;
		
		this.user = user;
		this.mall = mall;
	}

	public int getMallAdminId() {
		return MallAdminId;
	}

	public void setMallAdminId(int mallAdminId) {
		MallAdminId = mallAdminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MallEntity getMall() {
		return mall;
	}

	public void setMall(MallEntity mall) {
		this.mall = mall;
	}

	@Override
	public String toString() {
		return "MallAdmin [MallAdminId=" + MallAdminId + ", name=" + name + ", password=" + password + ", phone="
				+ phone +  ", user=" + user + ", mall=" + mall + "]";
	}
	
	


	
	

	
	
	
	

	

}

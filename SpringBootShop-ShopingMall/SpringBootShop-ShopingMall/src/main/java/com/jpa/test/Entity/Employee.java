package com.jpa.test.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmpId;
	private String EmpName;
	private LocalDate DateOfBirth;
	private float Salary;
	private String Address;
	private String Designation;
	
	@ManyToOne
	@JoinColumn(name="shopid")
	private ShopEntity Shop;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, LocalDate dateOfBirth, float salary, String address, String designation,
			ShopEntity shop) {
		super();
		EmpId = empId;
		EmpName = empName;
		DateOfBirth = dateOfBirth;
		Salary = salary;
		Address = address;
		Designation = designation;
		Shop = shop;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float salary) {
		Salary = salary;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public ShopEntity getShop() {
		return Shop;
	}

	public void setShop(ShopEntity shop) {
		Shop = shop;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", DateOfBirth=" + DateOfBirth + ", Salary="
				+ Salary + ", Address=" + Address + ", Designation=" + Designation + ", Shop=" + Shop + "]";
	}
	
	

	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	

}

package com.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="emp_name",length=100,nullable=false)
	private String name;
	
	@Column(name="email" ,unique=true)
	private String Emial;
	private Double salary;
	private Date doj;

	public Employee() {

	}
	
	
	public Employee(Integer id, String name, String emial, Double salary, Date doj) {
		super();
		this.id = id;
		this.name = name;
		Emial = emial;
		this.salary = salary;
		this.doj = doj;
	}

	

	public Employee(String name, String emial, Double salary) {
		super();
		this.name = name;
		Emial = emial;
		this.salary = salary;
		this.doj=new Date();
	}


	public Employee(String name, String emial, Double salary, Date doj) {
		super();
		this.name = name;
		Emial = emial;
		this.salary = salary;
		this.doj = doj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmial() {
		return Emial;
	}

	public void setEmial(String emial) {
		Emial = emial;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Emial=" + Emial + ", salary=" + salary + ", doj=" + doj
				+ "]";
	}
	
	
}

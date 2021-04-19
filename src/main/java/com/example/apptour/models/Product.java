package com.example.apptour.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Product.findByName",
query = "select p from Product p where p.name = ?1")
@Table(name = "products")
public class Product {

	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private Integer count;

	private Double cost;

	private Double prize;

	private Timestamp date_start;


	public Product() {

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public Double getPrize() {
		return prize;
	}


	public void setPrize(Double prize) {
		this.prize = prize;
	}


	public Timestamp getDate_start() {
		return date_start;
	}


	public void setDate_start(Timestamp date_start) {
		this.date_start = date_start;
	}




}

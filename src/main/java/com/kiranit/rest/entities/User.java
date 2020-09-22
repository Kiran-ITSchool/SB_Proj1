package com.kiranit.rest.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//import javax.validation.hateoas.ResourceSupport;

//import antlr.collections.List;

// Appling JsonIgnoreProperties at class Level.
@ApiModel(description="This model is to create a user")
@Entity
@Table(name="user")
//@Import(BeanValidatorPluginsConfiguration.class)

public class User extends RepresentationModel{
	
	@ApiModelProperty(notes="Automatically generated unique id", required=true,position=1)
	@Id
	@GeneratedValue
	private long id;
	
	
	@ApiModelProperty(notes="username should start as flname",example="dmagoo",required=false,position=2)
	@NotEmpty(message="username is mandatory field. Please provide the username")
	@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	private String username;
	
	
	@Size(min=2, max=50,message="Firstname should have 2 characters")
	@Column(name="FIRST_NAME" , length=50, nullable=false)
	private String firstname;
	
	@Column(name="LAST_NAME", length=50, nullable=false)
	private String lastname;
	
	@Column(name="EMAIL_ADDRESS", length=50, nullable=false)
	private String email;
	
	@Column(name="ROLE", length=50, nullable=false)
	private String role;
	
	@Column(name="SSN", length=50, nullable=false, unique=true)
	//@JsonIgnore
	private String ssn;
	

	
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	
	
	@Column(name="ADDRESS",length=50)
	private String address;
	// Default constructor
	
	public User()
	{
		
	}

	// args construtor
	public User(long id, String username, String firstname, String lastname, String email, String role, String ssn,String address) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.address=address;
	}
	
	// Getters-setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}	
	
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}

	
	
	

	// generate toString() method here.
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + ", address=" + address
				+ "]";
	}
}

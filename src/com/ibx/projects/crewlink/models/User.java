package com.ibx.projects.crewlink.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;




@Entity
@Table(name = "user")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
public class User implements Serializable  {
	
	@Id
	@GeneratedValue
	private Long id;
	private String email;             
	private String employee_no; 
	private String extension;
	private String first_name;
	private String last_name;
	private String mobile_no;   
	private String password;       
	private String telephone_no;    
	private String username;  
	
	
	@NotNull
	@ManyToOne
	private Role role;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<UserPlan> userPlans = new LinkedList<UserPlan>();

	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")  
	private Boolean mark_delete;  
	private String address;
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean is_active;  

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone_no() {
		return telephone_no;
	}

	public void setTelephone_no(String telephone_no) {
		this.telephone_no = telephone_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getMark_delete() {
		return mark_delete;
	}

	public void setMark_delete(Boolean mark_delete) {
		this.mark_delete = mark_delete;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public List<UserPlan> getUserPlans() {
		return userPlans;
	}

	public void setUserPlans(List<UserPlan> userPlans) {
		this.userPlans = userPlans;
	}



	

}

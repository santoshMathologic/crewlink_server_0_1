package com.ibx.projects.crewlink.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "user_plan")
@XmlRootElement
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPlan implements Serializable  {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Column(unique=true)
	private String planName;
	@Column(columnDefinition = "BIT(1) DEFAULT b'0'")
	private Boolean isComplete;
	@Column(columnDefinition = "BIT(1) DEFAULT b'0'")
	private Boolean isUnderReview;
	@Column(columnDefinition = "BIT(1) DEFAULT b'0'")
	private Boolean isLocked;
	private String reviewer;
	private String owner;
	private Boolean markDelete;
	private String createdTime;
	
	@ManyToOne
	private User user;
	

	public UserPlan() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPlanName() {
		return planName;
	}


	public void setPlanName(String planName) {
		this.planName = planName;
	}


	public Boolean getIsComplete() {
		return isComplete;
	}


	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}


	public Boolean getIsUnderReview() {
		return isUnderReview;
	}


	public void setIsUnderReview(Boolean isUnderReview) {
		this.isUnderReview = isUnderReview;
	}


	public Boolean getIsLocked() {
		return isLocked;
	}


	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}


	public String getReviewer() {
		return reviewer;
	}


	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public Boolean getMarkDelete() {
		return markDelete;
	}


	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}


	public String getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}

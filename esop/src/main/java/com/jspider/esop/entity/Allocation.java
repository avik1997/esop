package com.jspider.esop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "allocation_details")
public class Allocation implements Serializable {
	
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="id")
	private Long id;
	
	@Column(name="allocate_Grant_Date")
	private Date allocateGrantDate;
	
	@Column(name="allocate_Grant_Number")
	private Long allocateGrantNumber;
	
	@Column(name="allocate_Grant_Status")
	private String allocateGrantStatus;
	
	@Column(name="allocate_Grant_Year")
	private String allocateGrantYear;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="grant_id")
	private Grant grant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAllocateGrantDate() {
		return allocateGrantDate;
	}

	public void setAllocateGrantDate(Date allocateGrantDate) {
		this.allocateGrantDate = allocateGrantDate;
	}

	public Long getAllocateGrantNumber() {
		return allocateGrantNumber;
	}

	public void setAllocateGrantNumber(Long allocateGrantNumber) {
		this.allocateGrantNumber = allocateGrantNumber;
	}

	public String getAllocateGrantStatus() {
		return allocateGrantStatus;
	}

	public void setAllocateGrantStatus(String allocateGrantStatus) {
		this.allocateGrantStatus = allocateGrantStatus;
	}

	public String getAllocateGrantYear() {
		return allocateGrantYear;
	}

	public void setAllocateGrantYear(String allocateGrantYear) {
		this.allocateGrantYear = allocateGrantYear;
	}

	public Grant getGrant() {
		return grant;
	}

	public void setGrant(Grant grant) {
		this.grant = grant;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", allocateGrantDate=" + allocateGrantDate + ", allocateGrantNumber="
				+ allocateGrantNumber + ", allocateGrantStatus=" + allocateGrantStatus + ", allocateGrantYear="
				+ allocateGrantYear + ", grant=" + grant + "]";
	}




	
	
	
	
}

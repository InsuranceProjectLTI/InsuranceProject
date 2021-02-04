package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMIN_LOGIN database table.
 * 
 */
@Entity
@Table(name="ADMIN_LOGIN")
@NamedQuery(name="AdminLogin.findAll", query="SELECT a FROM AdminLogin a")
public class AdminLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADMIN_ID")
	private long adminId;

	@Column(name="EMAIL_ID")
	private String emailId;

	private String password;

	public AdminLogin() {
	}

	public long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
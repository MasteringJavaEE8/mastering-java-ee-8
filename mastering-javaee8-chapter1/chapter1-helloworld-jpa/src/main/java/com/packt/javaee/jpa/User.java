package com.packt.javaee.jpa;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({
		@NamedQuery(name = "findUsers", query = "select u from User u"),
		@NamedQuery(name = "deleteUsers", query = "delete from User u") })
public class User {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "user_job_role")
	private String user_job_role;

	public User() {
	}

	public User(String user_name, String user_job_role) {
		this.user_name = user_name;
		this.user_job_role = user_job_role;
	}

	public String getId() {
		return this.id;
	}

	public String getUserName() {
		return this.user_name;
	}

	public String getUserJobRole() {
		return this.user_job_role;
	}

}

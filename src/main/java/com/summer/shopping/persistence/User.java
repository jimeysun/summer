package com.summer.shopping.persistence;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USER")
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="role")
	private String role;
	
	@Column(name="password")
	private String password;
	
	@Column(name="disabled")
	private Boolean disabled;
	
	@Column(name="description")
	private String description;
	
	@Column(name="sex")
	private char sex;
	
	@Column(name="create_time")
	private Timestamp create_time;
	
	@Column(name="update_time")
	private Timestamp update_time;
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "user")
	private Set<ShippingAddress> shippingAddresses;
}

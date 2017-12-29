package com.summer.shopping.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="ShippingAddress")
@Data
public class ShippingAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name = "phone")
	private String phone;
	
	@NotNull
	@Column(name = "consignee_address")
	private String consigneeAddress;
	
	@NotNull
	@Column(name = "consignee_name")
	private String consigneeName;
	
    @Column(name = "identity_card_number")
	private String identityCardNumber;
    
    @Column(name="default_address")
    private Boolean defaultAddress;
    
    @Column(name="create_time")
	private Timestamp create_time;
	
	@Column(name="update_time")
	private Timestamp update_time;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

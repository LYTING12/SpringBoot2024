package com.example.psi.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "purchase")
@Data
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 採購單序號
	
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date; // 採購日期
	
	@JoinColumn(name = "supplier_id") //供應商序號(外鍵)
	@ManyToOne
	private Supplier supplier;
	
	@JoinColumn(name = "employee_id") //員工序號(外鍵)
	@ManyToOne
	private Employee employee;
	
	@OneToMany(mappedBy = "purchase")
	@OrderBy("id ASC")
	private Set<PurchaseItem> prPurchaseItems = new LinkedHashSet<>();
	
}

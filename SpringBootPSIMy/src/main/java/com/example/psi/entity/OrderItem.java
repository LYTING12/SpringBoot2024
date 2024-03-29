package com.example.psi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 訂單細目序號
	
	@Column
	private Integer amount; // 訂購數量
	
	@Column
	private Integer price; // 商品價格(售價)
	
	@JoinColumn(name = "order_id")
	@ManyToOne
	private Order order;
	
	@JoinColumn(name = "product_id")
	@ManyToOne
	private Product product;
	
}

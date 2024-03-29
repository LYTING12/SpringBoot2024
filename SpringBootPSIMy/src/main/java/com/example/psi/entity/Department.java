package com.example.psi.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 部門序號
	
	@Column
	private String name; // 部門名稱
	
	@OneToMany(mappedBy = "department") // 一對多，依賴於員工的部門
	@OrderBy("id ASC") //讓資料庫根據 id 排序
	private Set<Employee> employees = new LinkedHashSet<>();
	
}

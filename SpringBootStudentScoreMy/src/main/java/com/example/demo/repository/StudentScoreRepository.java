package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.StudentScore;

import jakarta.transaction.Transactional;

//<StudentScore, Integer> StudentScore 是對應的資料；Integer 是主鍵屬性
public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer>{ 

	//只要修改學生名字的方法
	@Modifying
	@Transactional
	@Query("UPDATE StudentScore s SET s.name = :name WHERE s.id = :id ")// JPQL :欄位名稱要跟entity一致
	void updateNameById(@Param("id") Integer id, @Param("name") String name);
	
	//只要修改學生名字的方法
	@Modifying
	@Transactional
	@Query(value = "UPDATE student_score SET name = :name WHERE id = :id ", nativeQuery = true) // SQL :欄位名稱要跟sql的一致
	void updateNameByIdNativeSQL(@Param("id") Integer id, @Param("name") String name);
	
	//@Query(value = "SELECT s StudentScore ORDER BY s.totalScore DESC")
	List<StudentScore> findAllByOrderByTotalScoreDesc();
	
}

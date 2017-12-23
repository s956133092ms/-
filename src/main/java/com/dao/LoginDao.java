package com.dao;

import com.user.Login;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository; 
import org.springframework.transaction.annotation.Transactional;

import java.lang.String;
import java.util.List;   
@Transactional
@Repository
public interface LoginDao extends CrudRepository<Login, Integer> {   //jpa 方法名就是查询语句,只要规法写方法名一切就都可以完成(当然.有时候会造成方法名又臭又长)
	Login findByEmail(String email);//根据邮箱查询
	
	Login findByName(String name);//根据用户名查询       

	List<Login> findByNameAndEmail(String name, String email);//根据用户名和邮箱进行查询
 
	List<Login> findByNameAndEmailOrderByIdDesc(String name, String email);//根据用户名和邮箱进行查询,排序
  
	List<Login> findTop2ByNameAndEmailOrderByIdDesc(String name, String email);//根据用户名和邮箱进行查询,排序,前两个

	List<Login> findByEmail(String email, Pageable pageable);//根据用户名和邮箱进行查询
} 

package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.user.RepUser;

public interface RepUserDao extends CrudRepository<RepUser, Integer>,JpaRepository<RepUser, Integer>{
    RepUser findByVideoweb(String videoweb);
	
	RepUser findByVideoweburl(String videoweburl);
	
	RepUser findByVideowebAndVideoweburl(String videoweb,String videoweburl);
}

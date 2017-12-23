package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.user.User2;

public interface User2Dao extends CrudRepository<User2, Integer>,JpaRepository<User2, Integer> {
	@Query(value="select * from use_view order by hot2 desc", nativeQuery = true)
	List<User2> user2();
	
	@Query(value="select * from use_view where TO_DAYS(Now()) - TO_DAYS(collttime2) <= 30 order by hot2 desc", nativeQuery = true)//hql
	List<User2> findmonth();
	
	@Query(value="select * from use_view where TO_DAYS(Now()) - TO_DAYS(collttime2) <= 7 order by hot2 desc", nativeQuery = true)
	List<User2> findweek();
}

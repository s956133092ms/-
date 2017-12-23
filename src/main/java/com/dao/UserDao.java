package com.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.User;
@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer>,JpaRepository<User, Integer>{
	
	List<User> findByWebname(String webname);
	
	User findByVideoname(String videoname);
	
	List<User> findByWebnameAndVideoname(String webname,String videoname);
	
	@Query(value="select * from new_view", nativeQuery = true)
	List<User> countProperty();
	
	@Query("select area,count(videoname) as value from User user group by area")
	List<User> countArea();
	
	@Query("from User user where TO_DAYS(Now()) - TO_DAYS(hot) <= 30 order by hot desc")//hql
	List<User> findmonth();
	
	@Query("from User user where TO_DAYS(Now()) - TO_DAYS(hot) <= 7 order by hot desc")
	List<User> findweek();
	
	
}

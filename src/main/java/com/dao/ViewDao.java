package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.View;

@Transactional
@Repository
public interface ViewDao extends CrudRepository<View, Integer>,JpaRepository<View, Integer>{
	@Query(value="select * from new_view", nativeQuery = true)
	List<View> countProperty();
}

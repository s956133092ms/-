package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.Area;

@Transactional
@Repository
public interface AreaDao extends CrudRepository<Area, Integer>,JpaRepository<Area, Integer>{
	@Query(value="select * from area_view", nativeQuery = true)
	List<Area> countArea();
}

package com.example.demo.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ItemEntity;
import com.example.demo.forms.ItemForm;


@Repository
public interface UserRepository extends JpaRepository<ItemEntity, String>{
	Optional<ItemEntity> findById(String id);
	List<ItemEntity> findAll();
	
	

}
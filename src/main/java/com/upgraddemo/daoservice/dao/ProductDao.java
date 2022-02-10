package com.upgraddemo.daoservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgraddemo.daoservice.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}

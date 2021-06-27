package com.example.hexagonal.infrastructure.repository;

import com.example.hexagonal.infrastructure.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryCrud extends JpaRepository<ProductDao, Long> {
}

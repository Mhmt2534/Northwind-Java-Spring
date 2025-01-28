package com.arsen.northwind.dataAccess.abstracts;

import com.arsen.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product , Integer> {




}

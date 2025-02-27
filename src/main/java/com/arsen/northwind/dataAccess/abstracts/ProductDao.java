package com.arsen.northwind.dataAccess.abstracts;

import com.arsen.northwind.entities.concretes.Product;
import com.arsen.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product , Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category=:categoryId")
    List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);

    @Query("SELECT new com.arsen.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) FROM Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getByProductNameWithCategoryDetails();


}

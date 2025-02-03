package com.arsen.northwind.business.abstracts;

import com.arsen.northwind.core.utilities.results.DataResult;
import com.arsen.northwind.core.utilities.results.Result;
import com.arsen.northwind.entities.concretes.Product;
import com.arsen.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductService {
    public DataResult< List<Product>> getall();
    public DataResult< List<Product>> getall(int pageNo, int pageSize);
    public DataResult< List<Product>> getAllSorted();
    public Result add(Product product);
    public DataResult<Product> getById(int id);


    DataResult<Product>  getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getByProductNameWithCategoryDetails();


}

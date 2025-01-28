package com.arsen.northwind.business.abstracts;

import com.arsen.northwind.core.utilities.results.DataResult;
import com.arsen.northwind.core.utilities.results.Result;
import com.arsen.northwind.entities.concretes.Product;

import java.util.List;


public interface ProductService {
    public DataResult< List<Product>> getall();
    public Result add(Product product);
}

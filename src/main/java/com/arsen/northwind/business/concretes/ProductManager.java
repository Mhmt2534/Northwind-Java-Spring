package com.arsen.northwind.business.concretes;

import com.arsen.northwind.business.abstracts.ProductService;
import com.arsen.northwind.core.utilities.results.DataResult;
import com.arsen.northwind.core.utilities.results.Result;
import com.arsen.northwind.core.utilities.results.SuccessDataResult;
import com.arsen.northwind.core.utilities.results.SuccessResult;
import com.arsen.northwind.dataAccess.abstracts.ProductDao;
import com.arsen.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getall() {
        return new SuccessDataResult<>(productDao.findAll(),"Ürünler listelendi");
    }

    @Override
    public Result add(Product product) {
         this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }


}

package com.arsen.northwind.business.concretes;

import com.arsen.northwind.business.abstracts.ProductService;
import com.arsen.northwind.core.utilities.results.DataResult;
import com.arsen.northwind.core.utilities.results.Result;
import com.arsen.northwind.core.utilities.results.SuccessDataResult;
import com.arsen.northwind.core.utilities.results.SuccessResult;
import com.arsen.northwind.dataAccess.abstracts.ProductDao;
import com.arsen.northwind.entities.concretes.Product;
import com.arsen.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return new SuccessDataResult<List<Product>>(productDao.findAll(),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<Product>> getall(int pageNo, int pageSize) {
        Pageable pagebale = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pagebale).getContent(),"Ürünler Listelendi");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort =  Sort.by(Sort.Direction.DESC, "id");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Ürünler Listelendi");
    }

    @Override
    public Result add(Product product) {
         this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getById(int id) {
        return new SuccessDataResult<Product>(this.productDao.findById(id).orElse(null),"Ürün getirildi.");

    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(productDao.getByProductName(productName),"Ürünler listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory_CategoryId(productName,categoryId),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getByProductNameWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getByProductNameWithCategoryDetails(),"Listeledni");
    }

}

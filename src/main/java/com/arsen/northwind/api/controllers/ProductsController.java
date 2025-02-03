package com.arsen.northwind.api.controllers;

import com.arsen.northwind.business.abstracts.ProductService;
import com.arsen.northwind.core.utilities.results.DataResult;
import com.arsen.northwind.core.utilities.results.Result;
import com.arsen.northwind.entities.concretes.Product;
import com.arsen.northwind.entities.dtos.ProductWithCategoryDto;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getall();
    }

    @GetMapping("/getByProductNameWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getByProductNameWithCategoryDetails(){
        return this.productService.getByProductNameWithCategoryDetails();
    }


    @GetMapping("/getallbypage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getall(pageNo, pageSize);
    }

    @GetMapping("/getallbysort")
    public DataResult<List<Product>> getAllSort(){
        return this.productService.getAllSorted();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getbyid")
    public DataResult<Product> getById(int id){
        return this.productService.getById(id);
    }


    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getbyproductnameandcategoryid")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }


    @GetMapping("/getbyproductnameorcategoryid")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam(required = false) String productName, @RequestParam(required = false) int categoryId){
        return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }



}

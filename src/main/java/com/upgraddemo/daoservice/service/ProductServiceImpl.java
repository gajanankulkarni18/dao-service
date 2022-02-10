package com.upgraddemo.daoservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upgraddemo.daoservice.dao.ProductDao;
import com.upgraddemo.daoservice.entity.Product;
import com.upgraddemo.daoservice.exception.ResourceNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    
    @Override
    public List<Product> getAllProducts() {
        //Select * from products
        return this.productDao.findAll();
    }

    @Override
    public Product getProductById(long id) {
        //Select * from products where id =?
        return this.productDao.findById(id).get();
    }

    @Override
    public Product createProduct(Product product) {
        return this.productDao.save(product);
    }

    @Override
    public Product updateProduct(long id, Product product) {
        Optional<Product> existingProduct = this.productDao.findById(id);
        if(existingProduct.isPresent()) {
            Product updateProduct = existingProduct.get();
            updateProduct.setName(product.getName());
            updateProduct.setDescription(product.getDescription());
            this.productDao.save(updateProduct);
            return updateProduct;
        } else {
            throw new ResourceNotFoundException("Record not found for an Id: " + id);
        }
    }

    @Override
    public HttpStatus deleteProduct(long id) {
        Optional<Product> existingProduct = this.productDao.findById(id);
        if(existingProduct.isPresent()) {
            this.productDao.delete(existingProduct.get());
            return HttpStatus.OK;
        } else {
            throw new ResourceNotFoundException("Record not found for an Id: " + id);
        }
    }

}

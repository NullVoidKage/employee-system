package com.project.project.controller;

import com.project.project.exception.ProductNotFoundException;
import com.project.project.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static{
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(),honey);
    }

    @RequestMapping(value="/products", method= RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @GetMapping(value="/products")
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        if (!productRepo.containsKey(id)){
            throw new ProductNotFoundException();
        } else {
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
        }

    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        if (!productRepo.containsKey(id)){
            throw new ProductNotFoundException();
        } else {
            productRepo.remove(id);
            return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
        }
    }


}

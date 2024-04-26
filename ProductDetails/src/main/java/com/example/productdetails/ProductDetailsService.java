package com.example.productdetails;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductDetailsService //CRUD
{
 @Autowired
 private ProductDetailsRepository repo;// no new operator
 
 public List<ProductDetails> listAll() //RETRIEVE
 {
 return repo.findAll();
 }
 
 public void save(ProductDetails product) //CREATE OR INSERT
 {
 repo.save(product);
 }
 
 public ProductDetails get(Integer id) //RETRIEVE ON THE BASIS OF ID
 {
 return repo.findById(id).get();
 }
 
 public void delete(Integer id) 
 {
 repo.deleteById(id);
 }
}
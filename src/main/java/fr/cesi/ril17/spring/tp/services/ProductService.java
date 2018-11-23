package fr.cesi.ril17.spring.tp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.repository.ProductRepository;

@Service
public class ProductService {

private ProductRepository prodRepo;
	
	public ProductService(ProductRepository prodRepo) {
		super();
		this.prodRepo = prodRepo;
	}
	
	public Product findByName(String name){
		List<Product> products = prodRepo.findByName(name);
		return (products.isEmpty()) ? null : products.get(0);
	}
	
	public List<Product> findAll(){
		List<Product> products = prodRepo.findAll();
		return products;
	}
}

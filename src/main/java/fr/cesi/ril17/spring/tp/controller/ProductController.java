package fr.cesi.ril17.spring.tp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.repository.ProductRepository;
import fr.cesi.ril17.spring.tp.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService prodService;
	private ProductRepository prodRepo;
	
	public ProductController(ProductService prodService, ProductRepository prodRepo) {
		super();
		this.prodService = prodService;
		this.prodRepo = prodRepo;
	}

	/*
	 * Get product by name
	 */
	@GetMapping("/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name) {
		return new ResponseEntity<Product>(prodService.findByName(name), HttpStatus.OK);
	}
	
	/*
	 * Get all products
	 */
	@GetMapping("/all")
	public List<Product> getProducts() {
		return prodService.findAll();
	}
	
	/*
	 * Create a new product
	 */
	@PostMapping("/")
	public Product postProduct(@Validated @RequestBody Product product) {
		return prodRepo.save(product);
	}
	
	/*
	 * Update a product
	 */
	@PutMapping("/{idProd}")
	@ResponseStatus(HttpStatus.OK)
	public Product postProduct(@PathVariable("idProd") long id, @RequestBody Product product) throws Exception {
		if(prodRepo.existsById(id))
			return prodRepo.save(product);
		else
			throw new Exception("No product found with this id");
	}
	
	/*
	 * Delete a product
	 */
	@DeleteMapping("/{idProd}")
	public ResponseEntity deleteProduct(@PathVariable("idProd") long id) {
		if(! prodRepo.existsById(id))
			return new ResponseEntity("No product found with this id", HttpStatus.NOT_FOUND);
		try {			
				prodRepo.deleteById(id);
				return new ResponseEntity("Product deleted with success", HttpStatus.OK);					
		} catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

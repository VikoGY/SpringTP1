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

import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.repository.SellerRepository;
import fr.cesi.ril17.spring.tp.services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	private SellerService sellerService;
	private SellerRepository sellerRepo;
	
	
	public SellerController(SellerService sellerService, SellerRepository sellerRepo) {
		super();
		this.sellerService = sellerService;
		this.sellerRepo = sellerRepo;
	}

	/*
	 * Get seller by name
	 */
	@GetMapping("/{name}")
	public ResponseEntity<Seller> getSellerByName(@PathVariable String name) {
		return new ResponseEntity<Seller>(sellerService.findByName(name), HttpStatus.OK);
	}
	
	/*
	 * Get all sellers
	 */
	@GetMapping("/all")
	public List<Seller> getSellers() {
		return sellerService.findAll();
	}
	
	/*
	 * Create a new seller
	 */
	@PostMapping("/")
	public Seller postSeller(@Validated @RequestBody Seller seller) {
		return sellerRepo.save(seller);
	}
	
	/*
	 * Update a seller
	 */
	@PutMapping("/{idSeller}")
	@ResponseStatus(HttpStatus.OK)
	public Seller postSeller(@PathVariable("idSeller") long id, @RequestBody Seller seller) throws Exception {
		if(sellerRepo.existsById(id))
			return sellerRepo.save(seller);
		else
			throw new Exception("No seller found with this id");
	}
	
	/*
	 * Delete a seller
	 */
	@DeleteMapping("/{idSeller}")
	public ResponseEntity deleteSeller(@PathVariable("idSeller") long id) {
		if(! sellerRepo.existsById(id))
			return new ResponseEntity("No seller found with this id", HttpStatus.NOT_FOUND);
		try {
			sellerRepo.deleteById(id);
			return new ResponseEntity("Seller deleted with success", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}

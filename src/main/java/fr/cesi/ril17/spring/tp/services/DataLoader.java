package fr.cesi.ril17.spring.tp.services;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.tp.domain.Product;
import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.repository.ProductRepository;
import fr.cesi.ril17.spring.tp.repository.SellerRepository;

@Service
public class DataLoader {
	
	private SellerRepository sellerRepo;
	private ProductRepository productRepo;
	
	@Autowired
	public DataLoader(SellerRepository sellerRepo, ProductRepository productRepo) {
		super();
		this.sellerRepo = sellerRepo;
		this.productRepo = productRepo;
	}
	
	@PostConstruct
	private void loadData() {
		productRepo.deleteAll();
	    sellerRepo.deleteAll();		
		Seller seller1 = new Seller(null,"Vendeur1","44 rue des pins","31300","toulouse",null);
		sellerRepo.save(seller1);
		Date date=new Date();
		Product product1 = new Product(null,"Jouet","un petit jouet","lala.jpg",9.2,date,seller1);
		productRepo.save(product1);
	}
	
	

}

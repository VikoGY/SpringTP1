package fr.cesi.ril17.spring.tp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.tp.domain.Seller;
import fr.cesi.ril17.spring.tp.repository.SellerRepository;

@Service
public class SellerService {
	
	private SellerRepository sellerRepo;
	
	public SellerService(SellerRepository sellerRepo) {
		super();
		this.sellerRepo = sellerRepo;
	}
	
	public Seller findByName(String name){
		List<Seller> sellers = sellerRepo.findByName(name);
		return (sellers.isEmpty()) ? null : sellers.get(0);
	}
	
	public List<Seller> findAll(){
		List<Seller> sellers = sellerRepo.findAll();
		return sellers;
	}
	
	

}

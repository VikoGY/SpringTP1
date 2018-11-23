package fr.cesi.ril17.spring.tp.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cesi.ril17.spring.tp.domain.*;

public interface SellerRepository extends CrudRepository<Seller,Long>{
	List<Seller> findByName(String name);
	List<Seller> findAll();
	}

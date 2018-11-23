package fr.cesi.ril17.spring.tp.repository;
import fr.cesi.ril17.spring.tp.domain.*;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findByName(String name);
	List<Product> findAll();
}

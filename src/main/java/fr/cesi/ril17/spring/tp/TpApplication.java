package fr.cesi.ril17.spring.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cesi.ril17.spring.tp.services.*;

@SpringBootApplication
public class TpApplication {

	@Autowired
	private DataLoader dataLoader;
	
	public static void main(String[] args) {
		SpringApplication.run(TpApplication.class, args);
	}
}

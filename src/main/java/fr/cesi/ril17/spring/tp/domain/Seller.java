package fr.cesi.ril17.spring.tp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="seller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String name;
	private String address;
	@Length(max=5)
	private String zipcode;	
	private String city;
	@OneToMany(mappedBy="seller")
	@JsonBackReference
	private List<Product> products;

}

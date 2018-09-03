package be.bt.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bt.dataaccess.IProduitRepository;

@RestController
@RequestMapping("/produits")
@CrossOrigin("*")
public class Produit {
@Autowired
private IProduitRepository repo;
@GetMapping(value= {"","/"})
	public List<be.bt.domain.Produit> getAll(){
		return repo.findAll();
	}
@GetMapping("/{id}")
public ResponseEntity<Produit> geProduitById(@PathVariable String id)
{
	Optional<Produit> resultat=repo.findById(id);
	return (resultat.isPresent())? new ResponseEntity<>(resultat.get(),HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}

package be.bt.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bt.domain.Produit;

public interface IProduitRepository extends JpaRepository<Produit, String>{

}

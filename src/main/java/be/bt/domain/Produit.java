package be.bt.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="PRODUITS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit {
@Id
	private String code;
	private String titre;
	private BigDecimal prixUnitaire;
	 
}

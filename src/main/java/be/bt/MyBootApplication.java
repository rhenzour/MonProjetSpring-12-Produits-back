package be.bt;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.bt.dataaccess.IProduitRepository;
import be.bt.dataaccess.UserRepository;
import be.bt.domain.Produit;
import be.bt.domain.security.Authority;
import be.bt.domain.security.User;

@SpringBootApplication
public class MyBootApplication {
	@Autowired
   private IProduitRepository repo;
	@Autowired
	private UserRepository repoUser;
	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	
	}
	@Bean
	CommandLineRunner runIt()
	{
	return args->{
		User user=new User();
		user.setUsername("user");
		user.setPassword("password");
		user.setAuthorities(new ArrayList<Authority>());
		
		Authority autority= new Authority();
		autority.setUsers(new ArrayList<User>());
		autority.getUsers().add(user);
		user.getAuthorities().add(autority);
		User admin=new User();
		admin.setUsername("admin");
		admin.setPassword("password");
		admin.setAuthorities(new ArrayList<Authority>());
		Authority autorityadmin= new Authority();
		autorityadmin.setUsers(new ArrayList<User>());
		autorityadmin.getUsers().add(admin);
		admin.getAuthorities().add(autorityadmin);
	
	//deuxiéme user

		repoUser.save(user);
		
	/*	repo.save(new Produit("A100","disque",new BigDecimal("200.5")));
		repo.save(new Produit("A200","OKKK",new BigDecimal("100")));

		repo.save(new Produit("A300","SOURIS",new BigDecimal("50")));

		repo.save(new Produit("A400","ECRAN",new BigDecimal("20.5")));

		*/
	};
	}
}

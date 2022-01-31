package com.travelExpress.covoiturage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import com.travelExpress.covoiturage.models.Conducteur;
import com.travelExpress.covoiturage.models.Passager;
import com.travelExpress.covoiturage.models.User;
import com.travelExpress.covoiturage.repositories.CompteRepository;
import com.travelExpress.covoiturage.repositories.UserRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;*/

@SpringBootApplication
public class CovoiturageApplication{

		/*@Autowired 
	  	private UserRepository userRepository;
		
		@Autowired 
	  	private CompteRepository compteRepository;*/

		
	public static void main(String[] args) {
	SpringApplication.run(CovoiturageApplication.class, args);	
	}

	/*@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {
		
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatTime = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		User Uber= userRepository.save(new User("Uber","Hill","uberhill@uqac.ca","UBERH"));
		User Kuate= userRepository.save(new User("Kuate","Alex","bruelkuate@gmail.com","KUATEA"));
		User Kamdem = userRepository.save(new User("Kamdem","Cedric","cedrick@uqac.ca","KAMDEMC"));
		
		
		Conducteur cptU = compteRepository.save(new Conducteur(Uber,"non fumeur, 1 seul bagage","Toyota","noir", "CAA 452"));
		Conducteur cptK = compteRepository.save(new Conducteur(Kuate,"non fumeur, 2 bagages max","Honda","blanche","CAA 353"));
		Passager cptKa =compteRepository.save(new Passager(Kamdem));
		
		implements CommandLineRunner 
		spring.jpa.hibernate.ddl-auto=create
		
	}*/

}

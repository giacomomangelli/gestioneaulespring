package it.prova.gestioneaule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestioneauleApplication implements CommandLineRunner {
	
	@Autowired
	private BatteriaDiTestService batteriaDiTestService;

	public static void main(String[] args) {
		SpringApplication.run(GestioneauleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String casoDaTestare = BatteriaDiTestService.INSERISCI_STUDENTE_DATA_AULA_SCOLASTICA;
		// ##########################################################

		System.out.println("################ START   #################");
		System.out.println("################ eseguo il test " + casoDaTestare + "  #################");

		batteriaDiTestService.eseguiBatteriaDiTest(casoDaTestare);

		System.out.println("################ FINE   #################");
		
	}

}

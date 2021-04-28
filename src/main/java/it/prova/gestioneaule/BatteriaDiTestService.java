package it.prova.gestioneaule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneaule.model.AulaScolastica;
import it.prova.gestioneaule.model.Studente;
import it.prova.gestioneaule.service.aulascolastica.IAulaScolasticaService;
import it.prova.gestioneaule.service.studente.IStudenteService;

@Service
public class BatteriaDiTestService {

	@Autowired
	private IStudenteService studenteServiceInstance;
	@Autowired
	private IAulaScolasticaService aulaScolasticaServiceInstance;

	public static final String INSERISCI_NUOVO_STUDENTE = "INSERISCI_NUOVO_STUDENTE";
	public static final String INSERISCI_STUDENTE_DATA_AULA_SCOLASTICA = "INSERISCI_STUDENTE_DATA_AULA_SCOLASTICA";
	public static final String INSERISCI_AULA_SCOLASTICA = "INSERISCI_AULA_SCOLASTICA";
	public static final String RIMUOVI_STUDENTE = "RIMUOVI_STUDENTE";
	public static final String ELENCA_TUTTE_LE_AULE = "ELENCA_TUTTE_LE_AULE";
	public static final String FIND_BY_EXAMPLE_BY_CODICE = "FIND_BY_EXAMPLE_BY_CODICE";
	public static final String UPDATE_STUDENTE_SET_COGNOME = "UPDATE_STUDENTE_SET_COGNOME";
	public static final String REMOVE_AULA_SCOLASTICA = "REMOVE_AULA_SCOLASTICA";
	public static final String FIND_BY_EXAMPLE_BY_COGNOME = "FIND_BY_EXAMPLE_BY_COGNOME";
	public static final String FIND_BY_EXAMPLE_BY_COGNOME_AND_NOME = "FIND_BY_EXAMPLE_BY_COGNOME_AND_NOME";

	public void eseguiBatteriaDiTest(String casoDaTestare) {

		try {

			switch (casoDaTestare) {
			case INSERISCI_NUOVO_STUDENTE:

				Studente nuovoStudente = new Studente("prova", "pippo", new Date());
				studenteServiceInstance.inserisci(nuovoStudente);
				System.out.println("Studente appena inserito: " + nuovoStudente);
				break;

			case INSERISCI_STUDENTE_DATA_AULA_SCOLASTICA:

				Studente nuovoStudente1 = new Studente("prova", "pippo", new Date());
				nuovoStudente1.setAulaScolastica(aulaScolasticaServiceInstance.findOne(1L));
				studenteServiceInstance.inserisci(nuovoStudente1);
				break;

			case INSERISCI_AULA_SCOLASTICA:

				AulaScolastica nuovaAulaScolastica = new AulaScolastica("A-12", "Scienze", 1);
				aulaScolasticaServiceInstance.inserisci(nuovaAulaScolastica);
				System.out.println("AulaScolastica appena inserita: " + nuovaAulaScolastica);
				break;

			case RIMUOVI_STUDENTE:
				studenteServiceInstance.rimuovi(studenteServiceInstance.findOne(1L));
				break;

			case ELENCA_TUTTE_LE_AULE:
				System.out.println("Elenca le AuleScolastiche:");
				for (AulaScolastica aulaScolasticaItem : aulaScolasticaServiceInstance.findAll()) {
					System.out.println(aulaScolasticaItem);
				}
				break;

			case FIND_BY_EXAMPLE_BY_CODICE:
				AulaScolastica aulaScolasticaExample = new AulaScolastica();
				aulaScolasticaExample.setCodice("prova Set");
				for (AulaScolastica aulaScolasticaItem : aulaScolasticaServiceInstance.findByExample(aulaScolasticaExample)) {
					System.out.println(aulaScolasticaItem);
				}
				break;

			case FIND_BY_EXAMPLE_BY_COGNOME:

				Studente studenteExample = new Studente();
				studenteExample.setCognome("Rossi");
				for (Studente studenteItem : studenteServiceInstance.findByExample(studenteExample)) {
					System.out.println(studenteItem);
				}
				break;

			case FIND_BY_EXAMPLE_BY_COGNOME_AND_NOME:

				Studente studenteExample2 = new Studente();
				studenteExample2.setCognome("Rossi");
				studenteExample2.setNome("Mario");

				for (Studente studenteItem : studenteServiceInstance.findByExample(studenteExample2)) {
					System.out.println(studenteItem);
				}
				break;

			case UPDATE_STUDENTE_SET_COGNOME:
				Studente studenteEsistente = studenteServiceInstance.findOne(1L);
				if (studenteEsistente != null) {
					studenteEsistente.setCognome("Rossi");
					studenteServiceInstance.aggiorna(studenteEsistente);
				}
				break;

			case REMOVE_AULA_SCOLASTICA:

				try {

					AulaScolastica aulaScolasticaDeleteInstance = aulaScolasticaServiceInstance.findOne(2L);
					aulaScolasticaServiceInstance.rimuovi(aulaScolasticaDeleteInstance);
					
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

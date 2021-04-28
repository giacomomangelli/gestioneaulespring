package it.prova.gestioneaule.service.aulascolastica;

import java.util.List;

import it.prova.gestioneaule.model.AulaScolastica;

public interface IAulaScolasticaService {
	
	public AulaScolastica findOne(Long id);
	
	public List<AulaScolastica> findAll();
	
	public void aggiorna(AulaScolastica aulaScolasticaInstance);
	
	public void rimuovi(AulaScolastica aulaScolasticaInstance);
	
	public void inserisci(AulaScolastica aulaScolasticaInstance);
	
	public List<AulaScolastica> findByExample(AulaScolastica aulaScolasticaInstance);

}

package it.prova.gestioneaule.service.studente;

import java.util.List;

import it.prova.gestioneaule.model.Studente;

public interface IStudenteService {
	
	public Studente findOne(Long id);
	
	public List<Studente> findAll();
	
	public void aggiorna(Studente studenteInstance);
	
	public void rimuovi(Studente studenteInstance);
	
	public void inserisci(Studente studenteInstance);

	public List<Studente> findByExample(Studente studenteInstance);
	
}

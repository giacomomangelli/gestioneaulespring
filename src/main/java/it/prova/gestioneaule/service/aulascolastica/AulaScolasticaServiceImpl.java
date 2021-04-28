package it.prova.gestioneaule.service.aulascolastica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneaule.dao.aulascolastica.IAulaScolasticaDao;
import it.prova.gestioneaule.model.AulaScolastica;

@Service
public class AulaScolasticaServiceImpl implements IAulaScolasticaService {

	@Autowired
	private IAulaScolasticaDao aulaScolasticaDaoInstance; 
	
	@Override
	@Transactional(readOnly = true)
	public AulaScolastica findOne(Long id) {
		return aulaScolasticaDaoInstance.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AulaScolastica> findAll() {
		return aulaScolasticaDaoInstance.list();
	}

	@Override
	@Transactional
	public void aggiorna(AulaScolastica aulaScolasticaInstance) {
		aulaScolasticaDaoInstance.update(aulaScolasticaInstance);
	}

	@Override
	@Transactional
	public void rimuovi(AulaScolastica aulaScolasticaInstance) {
		if(!aulaScolasticaInstance.getStudenti().isEmpty()) {
			throw new RuntimeException("L'aula ha studenti presenti al suo interno e non puo' essere eliminata.");
		}		
		aulaScolasticaDaoInstance.delete(aulaScolasticaInstance);
			
	}

	@Override
	@Transactional
	public void inserisci(AulaScolastica aulaScolasticaInstance) {
		aulaScolasticaDaoInstance.insert(aulaScolasticaInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AulaScolastica> findByExample(AulaScolastica aulaScolasticaInstance) {
		return aulaScolasticaDaoInstance.findByExamle(aulaScolasticaInstance);
	}

}

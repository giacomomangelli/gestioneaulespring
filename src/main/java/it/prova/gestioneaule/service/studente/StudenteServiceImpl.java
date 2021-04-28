package it.prova.gestioneaule.service.studente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneaule.dao.studente.IStudenteDao;
import it.prova.gestioneaule.model.AulaScolastica;
import it.prova.gestioneaule.model.Studente;
import it.prova.gestioneaule.service.aulascolastica.IAulaScolasticaService;

@Service
public class StudenteServiceImpl implements IStudenteService {

	@Autowired
	private IStudenteDao studenteDaoInstance;
	@Autowired
	private IAulaScolasticaService aulaScolasticaServiceInstance;

	@Override
	@Transactional(readOnly = true)
	public Studente findOne(Long id) {
		return studenteDaoInstance.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Studente> findAll() {
		return studenteDaoInstance.list();
	}

	@Override
	@Transactional
	public void aggiorna(Studente studenteInstance) {
		if (studenteInstance.getAulaScolastica() != null) {
			AulaScolastica aulaScolastica = aulaScolasticaServiceInstance.findOne((studenteInstance.getAulaScolastica().getId()));
			if(aulaScolastica.getCapienza()<1) {
				throw new RuntimeException("Capienza Aula massima.");
			}
			aulaScolastica.setCapienza(aulaScolastica.getCapienza()-1);
			aulaScolasticaServiceInstance.aggiorna(aulaScolastica);
		}
		studenteDaoInstance.update(studenteInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Studente studenteInstance) {
		if (studenteInstance.getAulaScolastica() != null) {
			AulaScolastica aulaScolastica = aulaScolasticaServiceInstance.findOne((studenteInstance.getAulaScolastica().getId()));
			aulaScolastica.setCapienza(aulaScolastica.getCapienza()+1);
			aulaScolasticaServiceInstance.aggiorna(aulaScolastica);
		}
		studenteDaoInstance.delete(studenteInstance);
	}

	@Override
	@Transactional
	public void inserisci(Studente studenteInstance) {
		if (studenteInstance.getAulaScolastica() != null) {
			AulaScolastica aulaScolastica = aulaScolasticaServiceInstance.findOne((studenteInstance.getAulaScolastica().getId()));
			if(aulaScolastica.getCapienza()<1) {
				throw new RuntimeException("Capienza Aula massima.");
			}
			aulaScolastica.setCapienza(aulaScolastica.getCapienza()-1);
			aulaScolasticaServiceInstance.aggiorna(aulaScolastica);
		}
		studenteDaoInstance.insert(studenteInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Studente> findByExample(Studente studenteInstance) {
		return studenteDaoInstance.findByExamle(studenteInstance);
	}

}

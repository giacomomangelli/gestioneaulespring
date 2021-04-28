package it.prova.gestioneaule.dao.studente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import it.prova.gestioneaule.model.Studente;

@Component
public class StudenteDaoImpl implements IStudenteDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Studente> list() {
		return entityManager.createQuery("from Studente",Studente.class).getResultList();
	}

	@Override
	public Studente get(Long id) {
		return entityManager.find(Studente.class, id);
	}

	@Override
	public void update(Studente studenteInput) {
		entityManager.merge(studenteInput);
	}

	@Override
	public void insert(Studente studenteInput) {
		entityManager.persist(studenteInput);
	}

	@Override
	public void delete(Studente studenteInput) {
		entityManager.remove(entityManager.merge(studenteInput));
	}

	@Override
	public List<Studente> findByExamle(Studente studenteInput) {
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<>();
		StringBuilder queryBuilder;
		
		queryBuilder = new StringBuilder("select s from Studente s where s.id = s.id ");
		
		if (StringUtils.isNotBlank(studenteInput.getNome())) {
			whereClauses.add(" s.nome like :nome ");
			parameterMap.put("nome", "%" + studenteInput.getNome() + "%");
		}
		if (StringUtils.isNotBlank(studenteInput.getCognome())) {
			whereClauses.add(" s.cognome like :cognome ");
			parameterMap.put("cognome", "%" + studenteInput.getCognome() + "%");
		}
		if (studenteInput.getDataDiNascita()!=null) {
			whereClauses.add(" s.data_di_nascita like :dataDiNascita");
			parameterMap.put("dataDiNascita", "%" + studenteInput.getDataDiNascita() + "%");
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Studente> typedQuery = entityManager.createQuery(queryBuilder.toString(), Studente.class);

		for (String key : parameterMap.keySet()) {
			typedQuery.setParameter(key, parameterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}

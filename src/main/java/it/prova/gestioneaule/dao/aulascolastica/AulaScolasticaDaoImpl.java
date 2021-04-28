package it.prova.gestioneaule.dao.aulascolastica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import it.prova.gestioneaule.model.AulaScolastica;

@Component
public class AulaScolasticaDaoImpl implements IAulaScolasticaDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<AulaScolastica> list() {
		return entityManager.createQuery("from AulaScolastica",AulaScolastica.class).getResultList();
	}

	@Override
	public AulaScolastica get(Long id){
		return entityManager.find(AulaScolastica.class, id);
	}

	@Override
	public void update(AulaScolastica aulaScolasticaInstance) {
		entityManager.merge(aulaScolasticaInstance);
	}

	@Override
	public void insert(AulaScolastica aulaScolasticaInstance) {
		entityManager.persist(aulaScolasticaInstance);
	}

	@Override
	public void delete(AulaScolastica aulaScolasticaInstance) {
		entityManager.remove(aulaScolasticaInstance);
	}

	@Override
	public List<AulaScolastica> findByExamle(AulaScolastica aulaScolasticaInstance) {
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<>();
		StringBuilder queryBuilder;
		
		queryBuilder = new StringBuilder("select a from AulaScolastica a where a.id = a.id ");
		
		if (StringUtils.isNotBlank(aulaScolasticaInstance.getCodice())) {
			whereClauses.add(" a.codice like :codice ");
			parameterMap.put("codice", "%" + aulaScolasticaInstance.getCodice() + "%");
		}
		if (StringUtils.isNotBlank(aulaScolasticaInstance.getMateria())) {
			whereClauses.add(" a.materia like :materia ");
			parameterMap.put("materia", "%" + aulaScolasticaInstance.getMateria() + "%");
		}
		if (aulaScolasticaInstance.getCapienza()!=null && aulaScolasticaInstance.getCapienza()>1) {
			whereClauses.add(" a.capienza like :capienza");
			parameterMap.put("capienza", "%" + aulaScolasticaInstance.getCapienza() + "%");
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<AulaScolastica> typedQuery = entityManager.createQuery(queryBuilder.toString(), AulaScolastica.class);

		for (String key : parameterMap.keySet()) {
			typedQuery.setParameter(key, parameterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}

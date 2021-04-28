package it.prova.gestioneaule.dao;

import java.util.List;

public interface IBaseDao<T> {
	
	public List<T> list();

	public T get(Long id);

	public void update(T input);

	public void insert(T input);

	public void delete(T input);
	
	public List<T> findByExamle(T input);


}

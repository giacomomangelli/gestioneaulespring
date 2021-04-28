package it.prova.gestioneaule.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aula_scolastica")
public class AulaScolastica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codice")
	private String codice;
	@Column(name = "materia")
	private String materia;
	@Column(name = "capienza")
	private Integer capienza;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aulaScolastica")
	private Set<Studente> studenti = new HashSet<>(0);

	public AulaScolastica() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public AulaScolastica(Long id, String codice, String materia, Integer capienza) {
		super();
		this.id = id;
		this.codice = codice;
		this.materia = materia;
		this.capienza = capienza;
	}

	public AulaScolastica(String codice, String materia, Integer capienza) {
		super();
		this.codice = codice;
		this.materia = materia;
		this.capienza = capienza;
	}

	public AulaScolastica(String codice, String materia, Integer capienza, Set<Studente> studenti) {
		super();
		this.codice = codice;
		this.materia = materia;
		this.capienza = capienza;
		this.studenti = studenti;
	}

	public Set<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Studente> studenti) {
		this.studenti = studenti;
	}
	
	

}

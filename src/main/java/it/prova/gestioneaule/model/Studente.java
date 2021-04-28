package it.prova.gestioneaule.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studente")
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "data_di_nascita")
	private Date dataDiNascita;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_aula_scolastica")
	AulaScolastica aulaScolastica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public AulaScolastica getAulaScolastica() {
		return aulaScolastica;
	}

	public void setAulaScolastica(AulaScolastica aulaScolastica) {
		this.aulaScolastica = aulaScolastica;
	}

	public Studente(Long id, String nome, String cognome, Date dataDiNascita, AulaScolastica aulaScolastica) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.aulaScolastica = aulaScolastica;
	}

	public Studente() {
	}

	public Studente(String nome, String cognome, Date dataDiNascita, AulaScolastica aulaScolastica) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.aulaScolastica = aulaScolastica;
	}

	public Studente(Long id, String nome, String cognome, Date dataDiNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}

	public Studente(String nome, String cognome, Date dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}

}

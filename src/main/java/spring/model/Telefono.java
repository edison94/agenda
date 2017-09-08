package spring.model;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefonos", catalog = "agenda")
public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idtelefonos;
	private Persona personas;
	private String telefono;

	public Telefono() {
	}

	public Telefono(Persona personas, String telefono) {
		this.personas = personas;
		this.telefono = telefono;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtelefonos", unique = true, nullable = false)
	public Integer getIdtelefonos() {
		return this.idtelefonos;
	}

	public void setIdtelefonos(Integer idtelefonos) {
		this.idtelefonos = idtelefonos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	public Persona getPersonas() {
		return this.personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	@Column(name = "telefono", length = 45)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}

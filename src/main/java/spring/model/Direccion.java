package spring.model;
// default package
// Generated 12-sep-2017 9:12:47 by Hibernate Tools 5.2.3.Final

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
@Table(name = "direcciones", catalog = "agenda")
public class Direccion implements Serializable {

	private static final long serialVersionUID = 7944342381894124581L;
	private Integer iddirecciones;
	private Persona personas;
	private String direccion;
	private String codPostal;
	private String localidad;
	private String provincia;

	public Direccion() {
	}

	public Direccion(String direccion, String codPostal, String localidad, String provincia) {
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public Direccion(Persona personas, String direccion, String codPostal, String localidad, String provincia) {
		this.personas = personas;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iddirecciones", unique = true, nullable = false)
	public Integer getIddirecciones() {
		return this.iddirecciones;
	}

	public void setIddirecciones(Integer iddirecciones) {
		this.iddirecciones = iddirecciones;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	public Persona getPersonas() {
		return this.personas;
	}

	public void setPersonas(Persona persona) {
		this.personas = persona;
	}

	@Column(name = "direccion", nullable = false, length = 45)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "codPostal", nullable = false, length = 45)
	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	@Column(name = "localidad", nullable = false, length = 45)
	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Column(name = "provincia", nullable = false, length = 45)
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Direccion [iddirecciones=");
		builder.append(iddirecciones);
		builder.append(", personas=");
		builder.append(personas);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", codPostal=");
		builder.append(codPostal);
		builder.append(", localidad=");
		builder.append(localidad);
		builder.append(", provincia=");
		builder.append(provincia);
		builder.append("]");
		return builder.toString();
	}

}

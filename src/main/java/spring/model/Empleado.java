package spring.model;
// default package
// Generated 12-sep-2017 9:12:47 by Hibernate Tools 5.2.3.Final

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "empleados", catalog = "agenda", uniqueConstraints = @UniqueConstraint(columnNames = "idPersona"))
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1715043125510012159L;
	private Integer idempleados;
	private Categoria categorias;
	private Departamento departamentos;
	private Persona personas;
	private String codEmpleado;
	private String salario;
	private Date fechaAlta;

	public Empleado() {
	}

	public Empleado(Persona personas, String codEmpleado) {
		this.personas = personas;
		this.codEmpleado = codEmpleado;
	}

	public Empleado(Categoria categorias, Departamento departamentos, Persona personas, String codEmpleado,
			String salario, Date fechaAlta) {
		this.categorias = categorias;
		this.departamentos = departamentos;
		this.personas = personas;
		this.codEmpleado = codEmpleado;
		this.salario = salario;
		this.fechaAlta = fechaAlta;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idempleados", unique = true, nullable = false)
	public Integer getIdempleados() {
		return this.idempleados;
	}

	public void setIdempleados(Integer idempleados) {
		this.idempleados = idempleados;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria")
	public Categoria getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDepartamento")
	public Departamento getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Departamento departamentos) {
		this.departamentos = departamentos;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona", unique = true, nullable = false)
	public Persona getPersonas() {
		return this.personas;
	}

	public void setPersonas(Persona personas) {
		this.personas = personas;
	}

	@Column(name = "codEmpleado", nullable = false, length = 45)
	public String getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	@Column(name = "salario", length = 45)
	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaAlta", length = 19)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}

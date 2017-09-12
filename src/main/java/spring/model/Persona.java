package spring.model;
// default package
// Generated 12-sep-2017 9:12:47 by Hibernate Tools 5.2.3.Final

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "personas", catalog = "agenda")
public class Persona implements Serializable {

	private static final long serialVersionUID = 2386478252995393754L;
	private Integer idpersonas;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private Date fechaNacimiento;
	private Empleado empleado;
	private Set<Direccion> direcciones = new HashSet<Direccion>(0);
	private Set<Telefono> telefonos = new HashSet<Telefono>(0);

	public Persona() {
	}

	public Persona(String nombre, String apellido1) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}

	public Persona(String nombre, String apellido1, String apellido2, String dni, Date fechaNacimiento,
			Empleado empleado, Set<Direccion> direcciones, Set<Telefono> telefonos) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.empleado = empleado;
		this.direcciones = direcciones;
		this.telefonos = telefonos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpersonas", unique = true, nullable = false)
	public Integer getIdpersonas() {
		return this.idpersonas;
	}

	public void setIdpersonas(Integer idpersonas) {
		this.idpersonas = idpersonas;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido1", nullable = false, length = 45)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "apellido2", length = 45)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "dni", length = 20)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento", length = 10)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personas")
	public Empleado getempleado() {
		return this.empleado;
	}

	public void setempleados(Empleado empleado) {
		this.empleado = empleado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personas")
	public Set<Direccion> getdirecciones() {
		return this.direcciones;
	}

	public void setdirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personas")
	public Set<Telefono> gettelefonos() {
		return this.telefonos;
	}

	public void settelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

}

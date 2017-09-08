package spring.model;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Departamentos generated by hbm2java
 */
@Entity
@Table(name = "departamentos", catalog = "agenda")
public class Departamento implements java.io.Serializable {

	private Integer iddepartamento;
	private String nombre;
	private Set<Empleado> empleadoses = new HashSet<Empleado>(0);

	public Departamento() {
	}

	public Departamento(String nombre) {
		this.nombre = nombre;
	}

	public Departamento(String nombre, Set<Empleado> empleadoses) {
		this.nombre = nombre;
		this.empleadoses = empleadoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iddepartamento", unique = true, nullable = false)
	public Integer getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentos")
	public Set<Empleado> getEmpleadoses() {
		return this.empleadoses;
	}

	public void setEmpleadoses(Set<Empleado> empleadoses) {
		this.empleadoses = empleadoses;
	}

}

package spring.model;
// default package
// Generated 08-sep-2017 9:59:39 by Hibernate Tools 5.2.3.Final

import java.io.Serializable;
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

@Entity
@Table(name = "categorias", catalog = "agenda")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idcategorias;
	private String nombre;
	private String descripcion;
	private Set<Empleado> empleadoses = new HashSet<Empleado>(0);

	public Categoria() {
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(String nombre, String descripcion, Set<Empleado> empleadoses) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.empleadoses = empleadoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcategorias", unique = true, nullable = false)
	public Integer getIdcategorias() {
		return this.idcategorias;
	}

	public void setIdcategorias(Integer idcategorias) {
		this.idcategorias = idcategorias;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 45)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
	public Set<Empleado> getEmpleadoses() {
		return this.empleadoses;
	}

	public void setEmpleadoses(Set<Empleado> empleadoses) {
		this.empleadoses = empleadoses;
	}

	@Override
	public String toString() {
		return "Categoria [idcategorias=" + idcategorias + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ "]";
	}
	
	

}

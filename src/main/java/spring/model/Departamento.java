package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
	@Column(name = "nombre")
	@Id
	private String nombre;
	
	public Departamento (String n){
		nombre = n;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

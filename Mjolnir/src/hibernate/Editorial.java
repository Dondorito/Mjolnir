package hibernate;
// Generated 06-jun-2018 14:30:57 by Hibernate Tools 5.3.0.Beta2

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Editorial generated by hbm2java
 */
public class Editorial implements java.io.Serializable {

	private BigDecimal codigo;
	private String nombre;
	private Set productos = new HashSet(0);

	public Editorial() {
	}

	public Editorial(BigDecimal codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Editorial(BigDecimal codigo, String nombre, Set productos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.productos = productos;
	}

	public BigDecimal getCodigo() {
		return this.codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getProductos() {
		return this.productos;
	}

	public void setProductos(Set productos) {
		this.productos = productos;
	}

	public String toString() {
		return nombre;
	}
}
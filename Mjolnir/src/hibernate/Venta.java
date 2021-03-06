package hibernate;
// Generated 06-jun-2018 14:30:57 by Hibernate Tools 5.3.0.Beta2

import java.math.BigDecimal;
import java.util.Date;

/**
 * Venta generated by hbm2java
 */
public class Venta implements java.io.Serializable {

	private BigDecimal codigo;
	private Date fecha;
	private BigDecimal iva;

	public Venta() {
	}

	public Venta(BigDecimal codigo, Date fecha, BigDecimal iva) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.iva = iva;
	}

	public BigDecimal getCodigo() {
		return this.codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

}

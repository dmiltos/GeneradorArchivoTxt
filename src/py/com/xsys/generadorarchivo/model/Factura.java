package py.com.xsys.generadorarchivo.model;

import java.util.Calendar;

public class Factura {
	
	private String tipoFactura;
	private long numero;
	private long timbrado;
	private Calendar fecha;
	private String moneda;
	private String cliente;	
	private String situacion;	
	private String direccion;
	private String pais;	
	private String telefono;
	private String correo;
	private String condicionCompra;
	private int cuotas;  	
	private String tipoIdentificacion;
	private String identificacion; 	
	private int digitoVerificador; 
	private String descripcion;
	private int cantidad;
	private int importeExento;
	private int importeGrav10; 
	private int importeGrav5;
	private String conceptoIva;
	
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public long getTimbrado() {
		return timbrado;
	}
	public void setTimbrado(long timbrado) {
		this.timbrado = timbrado;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getSituacion() {
		return situacion;
	}
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCondicionCompra() {
		return condicionCompra;
	}
	public void setCondicionCompra(String condicionCompra) {
		this.condicionCompra = condicionCompra;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public int getDigitoVerificador() {
		return digitoVerificador;
	}
	public void setDigitoVerificador(int digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getImporteExento() {
		return importeExento;
	}
	public void setImporteExento(int importeExento) {
		this.importeExento = importeExento;
	}
	public int getImporteGrav10() {
		return importeGrav10;
	}
	public void setImporteGrav10(int importeGrav10) {
		this.importeGrav10 = importeGrav10;
	}
	public int getImporteGrav5() {
		return importeGrav5;
	}
	public void setImporteGrav5(int importeGrav5) {
		this.importeGrav5 = importeGrav5;
	}
	public String getConceptoIva() {
		return conceptoIva;
	}
	public void setConceptoIva(String conceptoIva) {
		this.conceptoIva = conceptoIva;
	}
	
}

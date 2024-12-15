package com.control.testwisslub.dto;

public class MovimientoDto {


	private String idEmpresa;
	private String descripcion;
	private String bodegaOrigenCodigo;
    private String bodegaDestinoCodigo;
	private String fechaEntrega;
	private String estado;
	
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getBodegaOrigenCodigo() {
		return bodegaOrigenCodigo;
	}
	public void setBodegaOrigenCodigo(String bodegaOrigenCodigo) {
		this.bodegaOrigenCodigo = bodegaOrigenCodigo;
	}
	public String getBodegaDestinoCodigo() {
		return bodegaDestinoCodigo;
	}
	public void setBodegaDestinoCodigo(String bodegaDestinoCodigo) {
		this.bodegaDestinoCodigo = bodegaDestinoCodigo;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}

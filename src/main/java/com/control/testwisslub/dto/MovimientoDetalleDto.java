package com.control.testwisslub.dto;

public class MovimientoDetalleDto {


	 private Long movimientoId;
	    private Long movimientoDetalleId;
	    private String bodegaOrigenCodigo;
	    private Long idEmpresa;
	    private String bodegaDestinoCodigo;
	    private String itemId;

	    public MovimientoDetalleDto(Long movimientoId, Long movimientoDetalleId, String bodegaOrigenCodigo,
                Long idEmpresa, String bodegaDestinoCodigo, String itemId) {
this.movimientoId = movimientoId;
this.movimientoDetalleId = movimientoDetalleId;
this.bodegaOrigenCodigo = bodegaOrigenCodigo;
this.idEmpresa = idEmpresa;
this.bodegaDestinoCodigo = bodegaDestinoCodigo;
this.itemId = itemId;
}

		public Long getMovimientoId() {
			return movimientoId;
		}

		public void setMovimientoId(Long movimientoId) {
			this.movimientoId = movimientoId;
		}

		public Long getMovimientoDetalleId() {
			return movimientoDetalleId;
		}

		public void setMovimientoDetalleId(Long movimientoDetalleId) {
			this.movimientoDetalleId = movimientoDetalleId;
		}

		public String getBodegaOrigenCodigo() {
			return bodegaOrigenCodigo;
		}

		public void setBodegaOrigenCodigo(String bodegaOrigenCodigo) {
			this.bodegaOrigenCodigo = bodegaOrigenCodigo;
		}

		

		public Long getIdEmpresa() {
			return idEmpresa;
		}

		public void setIdEmpresa(Long idEmpresa) {
			this.idEmpresa = idEmpresa;
		}

		public String getBodegaDestinoCodigo() {
			return bodegaDestinoCodigo;
		}

		public void setBodegaDestinoCodigo(String bodegaDestinoCodigo) {
			this.bodegaDestinoCodigo = bodegaDestinoCodigo;
		}

		public String getItemId() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
   
	
	
	
	
	
	
}

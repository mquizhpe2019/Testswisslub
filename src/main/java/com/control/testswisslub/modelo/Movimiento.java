	package com.control.testswisslub.modelo;
	
	
	import jakarta.persistence.*;
	import java.util.Date;
	import java.util.List;

import com.control.testwisslub.dto.MovimientoDetalleDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
	
	@Entity
	@Table(name = "movimiento", schema = "testswisslub")
	@SqlResultSetMapping(
		    name = "MovimientoDetalleDtoMapping",
		    classes = @ConstructorResult(
		        targetClass = MovimientoDetalleDto.class,
		        columns = {
		            @ColumnResult(name = "movimiento_id", type = Long.class),
		            @ColumnResult(name = "movimiento_detalle_id", type = Long.class),
		            @ColumnResult(name = "bodega_origen_codigo", type = String.class),
		            @ColumnResult(name = "id_empresa", type = Long.class),
		            @ColumnResult(name = "bodega_destino_codigo", type = String.class),
		            @ColumnResult(name = "item_codigo", type = String.class)
		        }
		    )
		)
	public class Movimiento {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @Column(name = "id_empresa", nullable = false)
	    private Long idEmpresa;
	
	    @Column(nullable = false, length = 255)
	    private String descripcion;
	
	    @Column(name = "bodega_origen_codigo", nullable = false, length = 10)
	    private String bodegaOrigenCodigo;
	
	    @Column(name = "bodega_destino_codigo", nullable = false, length = 10)
	    private String bodegaDestinoCodigo;
	
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "fecha_creacion", nullable = false)
	    private Date fechaCreacion;
	
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "fecha_entrega")
	    private Date fechaEntrega;
	
	    @Column(nullable = false, length = 1)
	    private String estado = "P"; // P: Pendiente, T: Transito, E: Entregado
	
	    @OneToMany(mappedBy = "movimiento", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private List<MovimientoDetalle> detalles;
	
	    
	    
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public Long getIdEmpresa() {
			return idEmpresa;
		}
	
		public void setIdEmpresa(Long idEmpresa) {
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
	
		public Date getFechaCreacion() {
			return fechaCreacion;
		}
	
		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}
	
		public Date getFechaEntrega() {
			return fechaEntrega;
		}
	
		public void setFechaEntrega(Date fechaEntrega) {
			this.fechaEntrega = fechaEntrega;
		}
	
		public String getEstado() {
			return estado;
		}
	
		public void setEstado(String estado) {
			this.estado = estado;
		}
	
		public List<MovimientoDetalle> getDetalles() {
			return detalles;
		}
	
		public void setDetalles(List<MovimientoDetalle> detalles) {
			this.detalles = detalles;
		}
	
	    
	    
	}
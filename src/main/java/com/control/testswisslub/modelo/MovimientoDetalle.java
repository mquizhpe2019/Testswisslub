package com.control.testswisslub.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "movimiento_detalle", schema = "testswisslub")
public class MovimientoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @Column(name = "item_codigo", nullable = false, length = 20)
    private String itemCodigo;

   // @Column(name = "movimiento_id", nullable = false)
   // private Long movimientoId;;
    
    
    @Column(name = "cantidad_enviada", nullable = false)
    private Integer cantidadEnviada;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movimiento_id", nullable = false)
    @JsonBackReference
    private Movimiento movimiento;

    @Transient
    @JsonProperty("movimiento_id")
    private Long movimientoId; // Campo temporal

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemCodigo() {
		return itemCodigo;
	}

	public void setItemCodigo(String itemCodigo) {
		this.itemCodigo = itemCodigo;
	}

	

	public Integer getCantidadEnviada() {
		return cantidadEnviada;
	}

	public void setCantidadEnviada(Integer cantidadEnviada) {
		this.cantidadEnviada = cantidadEnviada;
	}

	public Movimiento getMovimiento() {
	   return movimiento;
	}
	
	
	public void setMovimientoId(Long movimientoId) {
	   if (movimientoId != null) {
	       Movimiento movimiento = new Movimiento();
	       movimiento.setId(movimientoId);
	      this.movimiento = movimiento;
	        }
	    }

	@JsonProperty("movimiento_id")
	public Long getMovimientoId() {
        return movimiento != null ? movimiento.getId() : null;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

    

}
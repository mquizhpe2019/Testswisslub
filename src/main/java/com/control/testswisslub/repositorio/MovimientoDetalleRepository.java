package com.control.testswisslub.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.control.testswisslub.modelo.Movimiento;
import com.control.testswisslub.modelo.MovimientoDetalle;

public interface MovimientoDetalleRepository extends JpaRepository<MovimientoDetalle, Long> {

	
}

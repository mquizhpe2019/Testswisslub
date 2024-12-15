package com.control.testwisslub.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.control.testswisslub.modelo.MovimientoDetalle;
import com.control.testswisslub.repositorio.MovimientoDetalleRepository;
import com.control.testwisslub.dto.MovimientoDetalleDto;
import com.control.testwisslub.dto.RespuestaWs;

@Service
public class MovimientoDetalleServicio {


	@Autowired
	private MovimientoDetalleRepository movDetRepo;
	/*
	
	public List<MovimientoDetalle> getMovimientoDetalle(){
		return movDetRepo.findAll();
	}  
	
	public RespuestaWs saveMovDet(MovimientoDetalleDto mov){
		
	  RespuestaWs respuesta = new RespuestaWs();
	  MovimientoDetalle movi = new MovimientoDetalle();
				
	 // movi.setMovimientoId(Long.parseLong(mov.getMovimientoId()));
	  movi.setItemCodigo(mov.getItemCodigo());
	  movi.setCantidadEnviada(Integer.parseInt( mov.getCantidadEnviada()));
			
	 // System.out.println("MovimientoId="+ movi.getMovimientoId());
	  System.out.println("ItemCodigo="+movi.getItemCodigo());
	  System.out.println("CantidadEnviada"+movi.getCantidadEnviada());
      try {
		movDetRepo.save(movi);
    	respuesta.setCodigo("1");
    	respuesta.setMensaje("El MovimientoDetalle se guardó exitósamente");
    	}catch (Exception e) {
    		respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("insertarMovimientoDetalle - Ocurrió un error al grabar"+e.getMessage());
    	}
    	return respuesta;
	}
	
	
	public RespuestaWs updateMovDet(Long id, MovimientoDetalleDto mov ){

		RespuestaWs respuesta = new RespuestaWs();
		MovimientoDetalle updateMov = movDetRepo.findById(id).get();
	//	updateMov.setMovimientoId(Long.parseLong(mov.getMovimientoId()));
		updateMov.setItemCodigo(mov.getItemCodigo());
		updateMov.setCantidadEnviada(Integer.parseInt(mov.getCantidadEnviada()));
		
		try {
			movDetRepo.save(updateMov);
			respuesta.setCodigo("1");
	    	respuesta.setMensaje("El MovimientoDetalle se actualizó exitósamente");
	    } catch (Exception e) {
			respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("editarMovimientoDetalle - Ocurrió un error al actualizar"+e.getMessage());
		}
		return respuesta;
	}
	
	
	public RespuestaWs deleteMovDetalle(Long id){
		RespuestaWs respuesta = new RespuestaWs();
		MovimientoDetalle deleteMov = movDetRepo.findById(id).get();
		try {
		movDetRepo.delete(deleteMov);
		respuesta.setCodigo("1");
    	respuesta.setMensaje("El MovimientoDetalle se eliminó exitósamente");
		}catch (Exception e) {
			respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("eliminarMovimientoDetalle - Ocurrió un error al eliminar"+e.getMessage());
		}
		return respuesta;
	}
	*/
	
}

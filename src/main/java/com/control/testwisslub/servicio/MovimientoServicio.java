package com.control.testwisslub.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.testswisslub.modelo.Movimiento;
import com.control.testswisslub.repositorio.MovimientoRepository;
import com.control.testwisslub.dto.MovimientoDto;
import com.control.testwisslub.dto.RespuestaWs;

@Service
public class MovimientoServicio {

	
	@Autowired
	private MovimientoRepository movRepo;
		/*
	
	public List<Movimiento> getMovimiento(){
		return movRepo.findAll();
	}
	

	
	
    public RespuestaWs saveMovimiento(MovimientoDto mov){
        RespuestaWs respuesta = new RespuestaWs();
    	Movimiento movi = new Movimiento();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateEntrega = mov.getFechaEntrega();
		String dateCreacion= format.format(new Date());
		
		  try {
			  movi.setFechaEntrega(format.parse(dateEntrega));
			  movi.setFechaCreacion(format.parse(dateCreacion));
			  movi.setIdEmpresa(Long.parseLong(mov.getIdEmpresa()));
			  movi.setDescripcion(mov.getDescripcion());
			  movi.setBodegaDestinoCodigo(mov.getBodegaDestinoCodigo());
			  movi.setBodegaOrigenCodigo(mov.getBodegaOrigenCodigo());
			  System.out.println("fechaEntrega="+format.parse(dateEntrega));
			  System.out.println("fechaCreacion="+format.parse(dateCreacion));
		   } catch (ParseException e) {
				e.printStackTrace();
		   }
		  try {
		      movRepo.save(movi);
			  respuesta.setCodigo("1");
	    	  respuesta.setMensaje("El Movimiento se guardó exitósamente");
		      }catch (Exception e) {
	    		respuesta = new RespuestaWs();
	    		respuesta.setCodigo("-1");
	        	respuesta.setMensaje("saveMovimiento - Ocurrió un error al grabar"+e.getMessage());
	    	}
		 return respuesta;
	}

    
     public RespuestaWs updateMovimiento(Long id, MovimientoDto mov ){
 		
    	RespuestaWs respuesta = new RespuestaWs();
   	    Movimiento updateMov = movRepo.findById(id).get();
		updateMov.setIdEmpresa(Long.parseLong(mov.getIdEmpresa()));
		updateMov.setDescripcion(mov.getDescripcion());
		updateMov.setBodegaOrigenCodigo(mov.getBodegaOrigenCodigo());
		updateMov.setBodegaDestinoCodigo(mov.getBodegaDestinoCodigo());
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateEntrega = mov.getFechaEntrega();
		    updateMov.setFechaEntrega(format.parse(dateEntrega));
			updateMov.setEstado(mov.getEstado());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			movRepo.save(updateMov);
			respuesta.setCodigo("1");
	    	respuesta.setMensaje("El Movimiento se actualizó exitósamente");
	
		} catch (Exception e) {
				respuesta = new RespuestaWs();
	    		respuesta.setCodigo("-1");
	        	respuesta.setMensaje("updateMovimiento - Ocurrió un error al actualizar"+e.getMessage());
			}
		return respuesta;
	}
     
     
     public RespuestaWs deleteMovimiento(Long id){
 		RespuestaWs respuesta = new RespuestaWs();
    	Movimiento deleteMov = movRepo.findById(id).get();
    	try {
 		movRepo.delete(deleteMov);
 		respuesta.setCodigo("1");
    	respuesta.setMensaje("El Movimiento se eliminó exitósamente");
		
    	}catch (Exception e) {
			respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("deleteMovimiento - Ocurrió un error al eliminar"+e.getMessage());
		}
    	
 		return respuesta;
 	}
     
*/
}

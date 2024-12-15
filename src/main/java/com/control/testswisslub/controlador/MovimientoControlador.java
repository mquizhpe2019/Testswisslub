package com.control.testswisslub.controlador;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.control.testswisslub.modelo.Movimiento;
import com.control.testswisslub.modelo.MovimientoDetalle;
import com.control.testswisslub.repositorio.MovimientoDetalleRepository;
import com.control.testswisslub.repositorio.MovimientoRepository;
import com.control.testwisslub.dto.MovimientoDetalleDto;
import com.control.testwisslub.dto.MovimientoDto;
import com.control.testwisslub.dto.RespuestaWs;
import com.control.testwisslub.servicio.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@RestController
@RequestMapping("api/")
public class MovimientoControlador {

	
    @PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private MovimientoRepository movRepo;
	

	@Autowired
	private MovimientoDetalleRepository movDetRepo;
	
	@GetMapping()
	public String  index() {
		return "Conectado";
	}
	
	@GetMapping("listarMovimientos")
	public List<Movimiento> listarTodo(){
		return movRepo.findAll();
	}
	
	@PostMapping("insertarMovimiento")
	public RespuestaWs saveMovimiento(@RequestBody Movimiento mov){
		
		 RespuestaWs respuesta = new RespuestaWs();
	    	Movimiento movi = new Movimiento();
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//	String dateEntrega = mov.getFechaEntrega();
		String dateCreacion= format.format(new Date());
		try {
			mov.setFechaCreacion(format.parse(dateCreacion));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 /* try {
			//	  movi.setFechaEntrega(format.parse(dateEntrega));
				  
				//  movi.setIdEmpresa(Long.parseLong(mov.getIdEmpresa()));
				//  movi.setDescripcion(mov.getDescripcion());
				//  movi.setBodegaDestinoCodigo(mov.getBodegaDestinoCodigo());
				//  movi.setBodegaOrigenCodigo(mov.getBodegaOrigenCodigo());
				//  System.out.println("fechaEntrega="+format.parse(dateEntrega));
				//  System.out.println("fechaCreacion="+format.parse(dateCreacion));
			   } catch (ParseException e) {
					e.printStackTrace();
			   }*/
			  try {
				  
				  
				  if (mov.getDetalles() != null) {
				        for (MovimientoDetalle detalle : mov.getDetalles()) {
				            detalle.setMovimiento(mov); // Vincular detalle al movimiento
				        }
				    }

				    // Persistir movimiento junto con sus detalles
				    
			      movRepo.save(mov);
				  respuesta.setCodigo("1");
		    	  respuesta.setMensaje("El Movimiento se guardó exitósamente");
			      }catch (Exception e) {
		    		respuesta = new RespuestaWs();
		    		respuesta.setCodigo("-1");
		        	respuesta.setMensaje("saveMovimiento - Ocurrió un error al grabar"+e.getMessage());
		    	}
			 return respuesta;
		 
	}
	
	@PostMapping("editarMovimiento/{id}")
	public RespuestaWs updateMovimiento(@PathVariable Long id, @RequestBody MovimientoDto mov ){
		RespuestaWs respuesta = new RespuestaWs();
		
   	    Movimiento updateMov = new Movimiento();
		try {
   	     updateMov = movRepo.findById(id).get();
		}catch (Exception e) {
			respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("editarMovimiento - No existe id enviado"+e.getMessage());
	
		}
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
		return respuesta;	}
	
	
	@DeleteMapping("eliminarMovimiento/{id}")
	public RespuestaWs deleteMovimiento(@PathVariable Long id){
		RespuestaWs respuesta = new RespuestaWs();
		
		Movimiento deleteMov = new Movimiento();
		try {
    	 deleteMov = movRepo.findById(id).get();
		}catch (Exception e) {
			respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("eliminarMovimiento - No existe id enviado");
		}
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
	
	
    @GetMapping("consultarxId/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        return movRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("consultarxEstado/{estado}")
    public ResponseEntity<List<Movimiento>> getMovimientosByEstado(@PathVariable String estado) {
        List<Movimiento> movimientos = movRepo.findByEstado(estado);
        if (movimientos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movimientos);
    }
    
	///MovimientoDetalle
	
	@GetMapping("listarMovimientoDetalles")
	public List<MovimientoDetalle> getMovimientoDetalle(){
		return movDetRepo.findAll();
	}
	
	
	@PostMapping("insertarMovimientoDetalle")
	public RespuestaWs saveMovDet(@RequestBody MovimientoDetalle mov){
		 RespuestaWs respuesta = new RespuestaWs();
		  MovimientoDetalle movi = new MovimientoDetalle();
					
		 // movi.setMovimientoId(Long.parseLong(mov.getMovimientoId()));
		//  movi.setItemCodigo(mov.getItemCodigo());
		//  movi.setCantidadEnviada(Integer.parseInt( mov.getCantidadEnviada()));
				
		  System.out.println("----="+mov.getMovimientoId());
		  
		  if (mov.getMovimientoId() != null) {
	            Movimiento movimiento = movRepo.findById(mov.getMovimientoId())
	                                  .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
	            mov.setMovimiento(movimiento);
	        }
		  
		 // System.out.println("MovimientoId="+ movi.getMovimientoId());
		  System.out.println("ItemCodigo="+movi.getItemCodigo());
		  System.out.println("CantidadEnviada"+movi.getCantidadEnviada());
	      try {
			movDetRepo.save(mov);
	    	respuesta.setCodigo("1");
	    	respuesta.setMensaje("El MovimientoDetalle se guardó exitósamente");
	    	}catch (Exception e) {
	    		respuesta = new RespuestaWs();
	    		respuesta.setCodigo("-1");
	        	respuesta.setMensaje("insertarMovimientoDetalle - Ocurrió un error al grabar"+e.getMessage());
	    	}
	    	return respuesta;
	}
	
	
	
	@PostMapping("editarMovimientoDetalle/{id}")
	public RespuestaWs updateMovDet(@PathVariable Long id, @RequestBody MovimientoDetalle mov ){
		RespuestaWs respuesta = new RespuestaWs();
		MovimientoDetalle updateMov = new MovimientoDetalle();
		try {
		 updateMov = movDetRepo.findById(id).get();
		}catch (Exception e) {
			respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("editarMovimientoDetalle - No existe el id enviado");
    		return respuesta;

		}
		updateMov.setCantidadEnviada(mov.getCantidadEnviada());
		updateMov.setItemCodigo(mov.getItemCodigo());
		updateMov.setMovimientoId(mov.getMovimientoId());
		
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
	
	
	@DeleteMapping("eliminarMovimientoDetalle/{id}")
	public RespuestaWs deleteMovDetalle(@PathVariable Long id){
		RespuestaWs respuesta = new RespuestaWs();
		MovimientoDetalle deleteMov = new MovimientoDetalle();

		try {
			 deleteMov = movDetRepo.findById(id).get();

		}catch (Exception e) {
			respuesta = new RespuestaWs();
    		respuesta.setCodigo("-1");
        	respuesta.setMensaje("eliminarMovimientoDetalle - No existe id enviado");
    		return respuesta;

		}
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
	
	
	
	 @GetMapping("movimientosPorEstado")
	    public ResponseEntity<List<MovimientoDetalleDto>> obtenerMovimientosPorEstado(@RequestParam String estado) {
	        try {
	            // Creamos el CriteriaBuilder
	            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	            
	            // Creamos la CriteriaQuery
	            CriteriaQuery<MovimientoDetalleDto> criteriaQuery = criteriaBuilder.createQuery(MovimientoDetalleDto.class);
	            
	            // Definimos la raíz de la consulta (entidad Movimiento)
	            Root<Movimiento> movimientoRoot = criteriaQuery.from(Movimiento.class);
	            Join<Movimiento, MovimientoDetalle> movimientoDetalleJoin = movimientoRoot.join("detalles", JoinType.INNER);
	            
	            // Seleccionamos los campos para la proyección a MovimientoDetalleDto
	            criteriaQuery.select(
	                criteriaBuilder.construct(
	                    MovimientoDetalleDto.class,
	                    movimientoRoot.get("id"),  // movimiento_id
	                    movimientoDetalleJoin.get("id"),  // movimiento_detalle_id
	                    movimientoRoot.get("bodegaOrigenCodigo"),  // bodega_origen_codigo
	                    movimientoRoot.get("idEmpresa"),  // empresa
	                    movimientoRoot.get("bodegaDestinoCodigo"),  // bodega_destino_codigo
	                    movimientoDetalleJoin.get("itemCodigo")  // item_id
	                )
	            );
	            
	            // Agregamos el filtro por estado
	            criteriaQuery.where(criteriaBuilder.equal(movimientoRoot.get("estado"), estado));
	            
	            // Ejecutamos la consulta
	            List<MovimientoDetalleDto> resultados = entityManager.createQuery(criteriaQuery).getResultList();
	            
	            if (resultados.isEmpty()) {
	                return ResponseEntity.noContent().build();
	            }

	            return ResponseEntity.ok(resultados);

	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).build();  // Código HTTP 500 para errores internos
	        }
	    }
	
}

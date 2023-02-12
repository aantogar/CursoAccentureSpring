package rf.com.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.Resource;
import rf.com.dominio.Producto;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;
import rf.com.repository.IProductoRepo;
import rf.com.services.IServicioProducto;
import rf.com.services.IServicioProducto;
import rf.com.util.Messagesmessages;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	private final IServicioProducto serviceP;

	@Autowired 
	 public ProductoController( IServicioProducto serviceP) {
        this.serviceP = serviceP;
    }
	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id")String id)throws DAOException  {
		return serviceP.readOne(id);
	}
	
	@GetMapping()
	public String[]leerTodos()throws DAOException {
		return serviceP.readAll();
	}
	
	@PutMapping
	public String[] updateProducto(@RequestBody Producto producto) throws DAOException {
		return serviceP.updateRegistro(producto);
	}
	
	@DeleteMapping("/{id}")
	public String[] borrarProducto(@PathVariable("id") String id){
		return serviceP.deleteById(id);
	}	
	
	
	@PostMapping
	public String[] insertarRegistro( @RequestBody  Producto producto) throws DAOException{
		return serviceP.insertRegistro(producto);
	}

		
	
	
}

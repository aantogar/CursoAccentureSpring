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
import rf.com.dominio.Categoria;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;
import rf.com.repository.ICategoriaRepo;
import rf.com.services.IServicioCategoria;
import rf.com.util.Messagesmessages;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	private final IServicioCategoria serviceC;

	@Autowired 
	 public CategoriaController( IServicioCategoria serviceC) {
        this.serviceC = serviceC;
    }
	
	
	
	 @GetMapping(value = "/api/throwException")
	    public void throwException() {
	        throw new IllegalArgumentException("\"I am the error message from Rest Controller\"");
	    }
	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id")String id)throws DAOException  {
		return serviceC.readOne(id);
	}
	
	@GetMapping()
	public String[]leerTodos()throws DAOException {
		return serviceC.readAll();
	}
	
	@PutMapping
	public String[] updateCategoria(@RequestBody Categoria category) throws DAOException {
		return serviceC.updateRegistro(category);
	}
	
	@DeleteMapping("/{id}")
	public String[] borrarCategoria(@PathVariable("id") int id){
		return serviceC.deleteById(id);
	}	
	
	
	@PostMapping
	public String[] insertarRegistro( @RequestBody  Categoria c) throws DAOException{
		return serviceC.insertRegistro(c);
	}

		
	
	
}

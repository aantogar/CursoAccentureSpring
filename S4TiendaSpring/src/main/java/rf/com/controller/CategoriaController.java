package rf.com.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import rf.com.dominio.Categoria;
import rf.com.repository.ICategoriaRepo;
import rf.com.services.IServicioCategoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	
	@Autowired 
	private IServicioCategoria serviceC;
	
	@GetMapping("/{id}")
	public Categoria leerUno(@PathVariable("id")int id) {
		return serviceC.readOne(id);
	}
	
	@GetMapping()
	public List<Categoria>leerTodos() {
		return serviceC.readAll();
	}
	@PutMapping
	public boolean updateCategoria(@RequestBody Categoria category) {
		return serviceC.updateRegistro(category);
	}
	
	@DeleteMapping("/{id}")
	public String[] borrarCategoria(@PathVariable("id") int id){
		return serviceC.deleteById(id);
	}	
	
	
	@PostMapping
	public boolean insertarRegistro( @RequestBody  Categoria c) {
		return serviceC.insertRegistro(c);
	}


	
}

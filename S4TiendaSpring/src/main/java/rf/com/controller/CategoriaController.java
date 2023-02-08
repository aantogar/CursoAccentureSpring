package rf.com.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import rf.com.dominio.Categoria;
import rf.com.repository.ICategoriaRepo;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	
	@Autowired 
	private ICategoriaRepo cDao;
	
	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id")int id) {
		try {
			Categoria c=cDao.findById(id).get();
			return new String[] {"200",c.toString()};
		}catch(NoSuchElementException e) {
			return new String[] {"400","No se ha podido recuperar el registro"};
		}
	}
	
	@GetMapping()
	public List<Categoria>leerTodos() {
		return cDao.findAll();
	}
	
	@PostMapping
	public String[]alta (@RequestBody Categoria c){
		c.setId_categoria(0);
		if(c.isValid()) {
		cDao.save(c);
		return new String[] {"200","Registro guardado"};
	}else {
		return new String[] {"500","Registro no guardado"};
		}
	}
}

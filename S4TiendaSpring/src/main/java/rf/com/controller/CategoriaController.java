package rf.com.controller;

import java.util.List;

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

	/*private rf.com.repository.ICategoriaRepo cDao;
	public void ICategoriaRepo(ICategoriaRepo cDao) {
		this.cDao=cDao;
	}*/
	
	
	 @Autowired
	    private ICategoriaRepo cDao;
	
	@GetMapping("/{id}")
	public Categoria leerUno(@PathVariable("id")int id) {
		return cDao.findById(id).get();
	}
	
	@GetMapping()
	public List<Categoria>leerTodos() {
		return cDao.findAll();
	}
	
	@PostMapping
	public String[]alta (@RequestBody Categoria c){
		c.setId_categoria(0);
		cDao.save(c);
		return new String[] {"200","Registro guardado"};
	}
	

}

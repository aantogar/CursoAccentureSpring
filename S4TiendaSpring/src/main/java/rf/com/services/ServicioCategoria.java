package rf.com.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rf.com.dominio.Categoria;
import rf.com.repository.ICategoriaRepo;


@Service
public class ServicioCategoria  implements IServicioCategoria{
	
	@Autowired 
	private ICategoriaRepo cDao;
	
	/**
	 * Método que comprueba si el id
	 * es valido y guarda el registro.
	 * @param c(Categoria objeto)
	 * @return
	 * @throws Exception
	 */
	public boolean insertRegistro(Categoria c) throws Exception {
		if(c.isValidInsert()) {
			cDao.save(c);
			return true;
		}else {
			return false;
		}	
	}
	
	/**
	 * Método que comprueba si el id
	 * es valido y guarda el registro.
	 * @param c(Categoria objeto)
	 * @return
	 * @throws Exception
	 */
	public boolean updateRegistro(Categoria c) throws Exception {
		if(c.isValidUpdate()) {
			cDao.save(c);
			return true;
		}else {
			return false;
		}	
	}
	
	/**
	 * Método que borra el registro por id.
	 */
	public boolean deleteById(int id) {
		cDao.deleteById(id);
		return true;
	}
	
	/**
	 * Método que lee todos los registros
	 */
	public List<Categoria> readAll() {
		return cDao.findAll();
		
	}
	
	

}

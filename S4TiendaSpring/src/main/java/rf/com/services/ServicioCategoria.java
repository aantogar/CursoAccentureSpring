package rf.com.services;
import java.util.List;
import java.util.NoSuchElementException;

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
	@Override
	public boolean insertRegistro(Categoria c) {
		if(c.isValidInsert()) {
			cDao.save(c);
			System.out.println("Saved");
			return true;
		}else {
			System.out.println("Error");
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
	@Override
	public boolean updateRegistro(Categoria c)  {
		if(c.isValidUpdate()) {
			cDao.save(c);
			System.out.println("Saved");
			return true;
		}else {
			System.out.println("Error");
			return false;
		}	
	}
	
	/**
	 * Método que borra el registro por id.
	 */
	@Override
	public String[] deleteById(int id) {
		try {
			cDao.deleteById(id);
			return new String[] {"200", "Registro eliminado"};
		}catch (NoSuchElementException e) {
			return new String[] {"400", "No existe registro solicitado"};
		}
	}
	/**
	 * Método para eliminar todas las categorias
	 */
	
	/**
	 * Método que lee todos los registros
	 */
	@Override
	public List<Categoria> readAll() {
		return cDao.findAll();
		
	}
	
	/**
	 * Método que lee un registro
	 */
	@Override
	public Categoria readOne(int id) {
		try {
			Categoria categoria=cDao.findById(id).get();
			return categoria;
		}catch(NoSuchElementException e) {
			return new Categoria();	
		}		
	}	

}

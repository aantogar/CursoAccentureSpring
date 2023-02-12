package rf.com.services;

import org.springframework.stereotype.Service;
import rf.com.dominio.Categoria;
import rf.com.dominio.Producto;
import rf.com.exception.DAOException;

@Service
public interface IServicioProducto {
		public String[] insertRegistro(Producto p)throws DAOException;
		public String[] updateRegistro(Producto p)throws DAOException;
		public String[] deleteById(String id);
		public String[]readAll();
		public String[] readOne(String id);

}

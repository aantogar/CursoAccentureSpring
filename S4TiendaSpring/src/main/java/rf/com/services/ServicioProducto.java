package rf.com.services;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rf.com.dominio.Producto;
import rf.com.dominio.Producto;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;
import rf.com.repository.IProductoRepo;
import rf.com.repository.IProductoRepo;
import rf.com.util.Messagesmessages;


@Service
public class ServicioProducto  implements IServicioProducto{
	
	
	@Autowired 
	private IProductoRepo cDao;
	
	/**
	 * Método que comprueba si el id
	 * es valido y guarda el registro.
	 * @throws DomainException 
	 */
	@Override
	public String[] insertRegistro(Producto producto) throws  DAOException {
		try { 
			if(producto.isValidInsert()) {
				Producto result=cDao.save(producto);
				return Messagesmessages.PROERR_027;}
		}catch(NumberFormatException e ) {
			return Messagesmessages.PROERR_020;
		}
		return Messagesmessages.PROERR_028;
	}	
	/**
	 * Método que comprueba si el id
	 * es valido y guarda el registro.
	 * @throws DAOException 
	 */
	
	@Override
	public String[] updateRegistro(Producto producto) throws DAOException  {
		try{
			if(producto.isValidUpdate()) { 
				if(cDao.existsById(producto.getId_producto())) { 
					cDao.save(producto);
					return Messagesmessages.PROERR_025;}
				}
			}catch(NoSuchElementException e){
				throw new DAOException(Messagesmessages.PROERR_019);
			}catch(NumberFormatException e) {
				return Messagesmessages.PROERR_020;
			}
			return (Messagesmessages.PROERR_019);
		}
	
	/**
	 * Método que borra el registro por id.
	 */
	@Override
	public String[] deleteById(String id) {
			try {
				if(cDao.existsById(id)) {
					cDao.deleteById(id);
					return Messagesmessages.PROERR_O21;
				}else {
					return Messagesmessages.PROERR_O22;
				}		
			}catch (NoSuchElementException e) {	
				return Messagesmessages.PROERR_O22;
			}catch(NumberFormatException e) {
				return Messagesmessages.PROERR_020;
			}
	}
	
	/**
	 * Método que lee todos los registros
	 */
	@Override
	public String[] readAll() {
		try {
			List<Producto>repo=cDao.findAll();
			return new String[] {repo+"",""+Messagesmessages.PROERR_O24};
		}catch(NoSuchElementException e){
			return Messagesmessages.PROERR_019;
		}catch(NumberFormatException e) {
			return Messagesmessages.PROERR_020;
		}
	}
	
	/**
	 * Método que lee un registro
	 */
	@Override
	public String[] readOne(String id) {
		if(id!=null)
			try {
				Producto result=cDao.findById(id).get();
				return new String[] {result +"",""+Messagesmessages.PROERR_O23};
			}catch(NoSuchElementException e) {
				return Messagesmessages.PROERR_019;
			}catch(NumberFormatException e) {
				return Messagesmessages.PROERR_020;
			}		
		return Messagesmessages.PROERR_020;
	}
}

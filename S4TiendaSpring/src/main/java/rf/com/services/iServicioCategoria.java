package rf.com.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import rf.com.dominio.Categoria;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;

@Service
public interface IServicioCategoria{
	public String[] insertRegistro(Categoria c)throws DAOException;
	public String[] updateRegistro(Categoria c)throws DAOException;
	public String[] deleteById(int id);
	public String[]readAll();
	public String[] readOne(String id);
	

}

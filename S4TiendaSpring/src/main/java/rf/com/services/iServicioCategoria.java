package rf.com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rf.com.dominio.Categoria;

@Service
public interface IServicioCategoria{
	public boolean insertRegistro(Categoria c);
	public boolean updateRegistro(Categoria c);
	public String[] deleteById(int id);
	public List<Categoria> readAll();
	public Categoria readOne(int id);
	

}

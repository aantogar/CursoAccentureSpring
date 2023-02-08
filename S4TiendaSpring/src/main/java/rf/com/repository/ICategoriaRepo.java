package rf.com.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rf.com.dominio.Categoria;


public interface ICategoriaRepo extends JpaRepository<Categoria,Integer> {
	


}

package rf.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.com.dominio.Categoria;
import rf.com.dominio.Producto;

public interface IProductoRepo extends JpaRepository<Producto,String> {

}

package rf.com.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rf.com.dominio.Categoria;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;
import rf.com.repository.ICategoriaRepo;
import rf.com.services.ServicioCategoria;
import rf.com.util.Validator;

class CategoriaControllerTest {
	/**
	 * Constantes que se implementan para testear.
	 */
	private final String CAT_DESCRIPCION="Esto es una descripción";
	private final String CAT_DESCRIPCION2="Esto es otra una descripción";
	private final String CAT_NOMBRE="Andrea Antón";
	private final String CAT_NOMBRE2="Sara Garcia";
	private final int ID_CATEGORIA=1;
	private final int ID_CATEGORIA2=12;
	private final int ID_CATEGORIA3=122;
	private final String ID_CAT="1";
	private final String ID_CATT="12";
	private final int IDDD=Integer.parseInt(ID_CAT);
	private final Categoria CATE=new Categoria();
	private final String CAT_DESCRIPCION4="Esto es una descripción";
	private final String CAT_NOMBRE4="Esto es otra  descripción más";
	private final int ID4=Integer.parseInt(ID_CATT);
	private final String UPD="13";
	private final int UP_PARSE=Integer.parseInt(UPD);
	private final String UPD_DES="Decripción de update";
	private final String UPD_NOM="Update!!!";
	
	
	
	
	/**
     * 
     * Tests donde comprobamos el funcionamiento
     * de Controller y Service
     */
	private CategoriaController controller;
    private ServicioCategoria servicio;
    Categoria categoria;

    @BeforeEach
    public void setUp() {
        servicio = Mockito.mock(ServicioCategoria.class);
        controller = new CategoriaController(servicio);
        categoria=new Categoria();
    }  
    
    /**
     * 
     * Test que comprueba lo que registramos por service, 
     * lo recibe controller por el parámetro ID.
     */
    @Test
    public void insertarRegistroService() throws DAOException {
    	categoria.setId_categoria(ID4);
        assertEquals(servicio.insertRegistro(categoria),controller.leerUno(ID_CAT));
    }
    

    /**
     * 
     * Test que comprueba lo que registramos por controller, 
     * lo recibe service por el parámetro ID.
     */
    @Test
    public void insertarRegistroControllerr() throws DAOException {
    	categoria.setId_categoria(ID_CATEGORIA2);
        assertEquals(controller.insertarRegistro(categoria),servicio.readOne(ID_CATT));
    }
    
    /**
     * Test que comprueba que insertando campo por campo
     * en el objeto categoria y registrándolo por servicio
     * lo lee controller por su ID
     * 
     */
    @Test
    public void insertarRegistroEquals() throws DAOException, DomainException {
    	categoria.setCat_descripcion(CAT_DESCRIPCION);
    	categoria.setCat_nombre(CAT_NOMBRE);
    	categoria.setId_categoria(ID_CATEGORIA);
    	assertEquals(servicio.insertRegistro(categoria),controller.leerUno(ID_CAT)); 	   
    }
    /**
     * Test que comprueba que insertando campo por campo
     * en el objeto categoria y registrándolo por controller
     * lo lee servicio por su ID y lo parsea recibiéndolo como String
     * 
     */
    @Test
    public void insertarRegistroController() throws DAOException, DomainException {
    	categoria.setCat_descripcion(CAT_DESCRIPCION);
    	categoria.setCat_nombre(CAT_NOMBRE);
    	categoria.setId_categoria(ID_CATEGORIA2);
    	assertEquals(controller.insertarRegistro(categoria),servicio.readOne(ID_CATT));
    }
    /**
     * 
     * Test que comprueba que tanto controller como service
     * leen todos los registros
     * 
     * 
     */
    
    @Test
    public void readAllRegistros() throws DAOException, DomainException {
    	categoria.setCat_descripcion(CAT_DESCRIPCION);
    	categoria.setCat_nombre(CAT_NOMBRE);
    	categoria.setId_categoria(ID_CATEGORIA2);
    	categoria.setCat_descripcion(CAT_DESCRIPCION2);
    	categoria.setCat_nombre(CAT_NOMBRE2);
    	categoria.setId_categoria(ID_CATEGORIA3);
    	assertEquals(controller.leerTodos(),servicio.readAll());
    }
    
    /**
     * 
     * Método que comprueba que elimina los registros
     * 
     */
	@Test
	void testBorrarCategoria() throws DomainException, DAOException {
		categoria.setCat_descripcion(CAT_DESCRIPCION);
    	categoria.setCat_nombre(CAT_NOMBRE);
    	categoria.setId_categoria(ID_CATEGORIA2);
    	servicio.deleteById(IDDD);
    	assertNull(controller.leerTodos());
	}
	
	/**
	 * 
	 * Test que comprueba que elimina solo un registro
	 * por ID.
	 * 
	 */
	@Test
	void testBorrarCategoriaOther() throws DomainException, DAOException {
		categoria.setCat_descripcion(CAT_DESCRIPCION);
    	categoria.setCat_nombre(CAT_NOMBRE);
    	categoria.setId_categoria(ID_CATEGORIA2);
    	categoria.setCat_descripcion(CAT_DESCRIPCION2);
    	categoria.setCat_nombre(CAT_NOMBRE2);
    	categoria.setId_categoria(ID_CATEGORIA3);
    	servicio.deleteById(ID_CATEGORIA3);
    	assertEquals(controller.leerUno(ID_CATT),servicio.readOne(ID_CATT));
	}


	@Test
	void updateRegistros() throws DomainException, DAOException {
		Exception thrown= Assertions.assertThrows(DAOException.class, () -> {
			servicio.updateRegistro(categoria);},"Error. No existe el registro");
		Assertions.assertEquals("Error. No existe el registro", thrown.getMessage());
		
	}

}

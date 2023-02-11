package rf.com.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rf.com.exception.DomainException;
import rf.com.util.Messagesmessages;
import rf.com.util.Validator;

class CategoriaTest {
	//Constantes  declaradas para testear-
	private final int ID_CATEG=1;
	private final int ID_CATEG_FAL=3;
	private final int ID_CATEG2=7;
	private final int ID_CATEG3=5;
	private final String CAT_NOM="Andrea";
	private final String CAT_NOM_FAL="";
	private final String CAT_DESC="Esto es una descripción";
	private final String CAT_DESC_FAL="Esto es una descripción distinta";
	private final String CAT_NULL="";
	private final String ANOTHER_NULL=null;
	private final int INSERT=1;
	private final int NOTINSERT=-100;
	private final String INSERT_NULL="";
	private final int ID_ZERO=0;
	
	
	

	Categoria categoria;
	/**
	 * Instanciamos un nuevo objeto de Categoria
	 * antes de cada test.
	 * 
	 */
	@BeforeEach
	void startObject() {
	categoria=new Categoria();
	}
	
	
	/**
	 * Test de los setters que comprueban también los getters
	 * y métodos de isValidInsert, isValidUpdate
	 */
	//ID_CATEGORIA
	@Test
	void testSetId_categoria() {
		categoria.setId_categoria(ID_CATEG);
		assertEquals(ID_CATEG,categoria.getId_categoria());
	}
	@Test
	void testSetId_categoriaFalse() {
		categoria.setId_categoria(ID_CATEG_FAL);
		assertNotEquals(ID_CATEG2,categoria.getId_categoria());
	}
	@Test
	void testSetId_categoriaNull() {
		categoria.setId_categoria(ID_CATEG3);
		assertNotNull(categoria.getId_categoria());
	}
	
	//CAT_NOMBRE
	@Test
	void testSetCat_nombre() throws DomainException {
		categoria.setCat_nombre(CAT_NOM);
		assertEquals(CAT_NOM,categoria.getCat_nombre());
	}
	
	@Test
	void testSetCat_nombreThrows() throws DomainException {
		Exception thrown= Assertions.assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre(CAT_NOM_FAL);});
	}
	@Test
	void testIsValidInsert() throws DomainException {
		categoria.setCat_nombre(CAT_NOM);
		assertNotNull(Validator.isVacio(categoria.getCat_nombre()));
	}
	//CAT_DESCRIPCION
	@Test
	void testSetCat_descripcion() {
		categoria.setCat_descripcion(CAT_DESC);
		assertEquals(CAT_DESC,categoria.getCat_descripcion());
	}
	@Test
	void testSetCat_descripcionFal() {
		categoria.setCat_descripcion(CAT_DESC_FAL);
		assertNotEquals(CAT_DESC,categoria.getCat_descripcion());
	}
	@Test
	void testSetCat_descripcionNull() {
		categoria.setCat_descripcion(CAT_NULL);
		assertNull(ANOTHER_NULL,categoria.getCat_descripcion());
	}
	
	@Test
	void testSetCat_descripcionNotNull() {
		categoria.setCat_descripcion(CAT_DESC);
		assertNotNull(CAT_DESC,categoria.getCat_descripcion());
	}


	@Test
	void testIsValidInsertThrows() throws DomainException {
		Exception thrown= Assertions.assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre(INSERT_NULL);});
	}


}

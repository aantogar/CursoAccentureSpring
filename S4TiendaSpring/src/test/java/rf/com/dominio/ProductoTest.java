package rf.com.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import rf.com.util.Validator;

class ProductoTest {
	//Constantes declaradas para testear
	private final String ID_PRODUCT="HB123";
	private final String ID_PRODUCT_FALSE="HM122";
	private final String ID_PRODUCT_THROWS="98276";
	private final String PRO_DESC_TRUE="Esto es una descripción buena";
	private final String PRO_DESC_FALSE="Esto es una descripción FALSE";
	private final String PRO_LARG_TRUE="Esto es una descripción buena,Esto es una descripción buena,Esto es una descripción buena";
	private final String PRO_LARGA_FALSE="Esto es una descripción FALSE,Esto es una descripción FALSE,Esto es una descripción FALSE";
	private final double PRO_PRECIO=100.00;
	private final double PRO_PREC_FALSE=100L;
	
	
		
	
	Producto prod;
	
	/**
	 * Instanciamos un nuevo objeto de Producto
	 * antes de cada test
	 * @throws Exception 
	 * 
	 */
	@BeforeEach
	void startObject() throws Exception {
	prod=new Producto();
		
	}

	/**
	 * Tests que comparan, que devuelvan el getter
	 * lo que se obtiene de setter y comprobamos 
	 * las expcepciones  que lanza cada setter
	 * @throws Exception
	 */
	
	//ID_PRODUCTO
	@Test
	void testSetId_producto() throws Exception {
		prod.setId_producto(ID_PRODUCT);
		assertEquals(ID_PRODUCT,prod.getId_producto());
	}
	
	@Test
	void testSetId_productoFalse() throws Exception {
		prod.setId_producto(ID_PRODUCT_FALSE);
		assertNotEquals(ID_PRODUCT,prod.getId_producto());
	}
	@Test
	void testSetId_productoThrows() throws Exception {
		Exception thrown= Assertions.assertThrows(Exception.class, () -> {
			prod.setId_producto(ID_PRODUCT_THROWS);},"Formato codigo erroneo");
		Assertions.assertEquals("Formato codigo erroneo", thrown.getMessage());
	}

	//PRO_DESCRIPCION
	@Test
	void testSetPro_descripcion() throws Exception {
		prod.setPro_descripcion(PRO_DESC_TRUE);
		assertEquals(PRO_DESC_TRUE,prod.getPro_descripcion());
	}
	@Test
	void testSetPro_descripcionFalse() throws Exception {
		prod.setPro_descripcion(PRO_DESC_TRUE);
		assertNotEquals(PRO_DESC_FALSE,prod.getPro_descripcion());
	}

	//PRO_DESLARGA
	@Test
	void testSetPro_desLarga() throws Exception {
		prod.setPro_desLarga(PRO_LARG_TRUE);
		assertEquals(PRO_LARG_TRUE,prod.getPro_desLarga());
	}
	@Test
	void testSetPro_desLargaFalse() throws Exception {
		prod.setPro_desLarga(PRO_LARGA_FALSE);
		assertNotEquals(PRO_LARG_TRUE,prod.getPro_desLarga());
	}

	//PRO_PRECIO

	@Test
	void testSetPro_precio() {
		prod.setPro_precio(PRO_PRECIO);
		assertEquals(PRO_PRECIO,prod.getPro_precio());
	}
	@Test
	void testSetPro_precioFalse() {
		prod.setPro_precio(PRO_PREC_FALSE);
		assertNotEquals(PRO_PRECIO,prod.getPro_precio());
	}

	//Stock
	@Test
	void testSetStock() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_fecRepos() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_fecRepos() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_fecActi() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_fecActi() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_fecDesacti() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_fecDesacti() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_uniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_uniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_cantXUniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_cantXUniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_uniUltNivel() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_uniUltNivel() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId_pais() {
		fail("Not yet implemented");
	}

	@Test
	void testSetId_pais() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_usoRecomendado() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_usoRecomendado() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId_categoria() {
		fail("Not yet implemented");
	}

	@Test
	void testSetId_categoria() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_stkReservado() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_stkReservado() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_nStkAlto() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_nStkAlto() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_nStkBajo() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_nStkBajo() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_stat() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_stat() {
		fail("Not yet implemented");
	}

}
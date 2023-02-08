package rf.com.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import rf.com.util.Validator;

class ProductoTest {
	//Constantes declaradas para testear
	private final String ID_PRODUCT="HB123";
	private final String ID_PRODUCT_FALSE="1123PO";
	
	
	
	
	
	
	
	
	
	Producto prod;
	
	@BeforeEach
	void startObject() throws Exception {
	prod=Mockito.mock(Producto.class);
		
	}


	

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
	void testSetPro_descripcion() {
		
	}

	@Test
	void testGetPro_desLarga() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_desLarga() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_precio() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_precio() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStock() {
		fail("Not yet implemented");
	}

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

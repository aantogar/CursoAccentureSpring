package rf.com.util;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class ValidatorTest {
	Validator validator;
	//constantes para los test
	private final String ALFA_NUM="Jjdshfjsdhf90";
	private final String ALFA_NUM_FAL="";
	private final String PHONE_NUM="987 67 8911";
	private final String PHONE_NUM_FAL="987";
	private final int MIN_PHONE=10;
	private final int MAX_PHONE=20;
	private final String EMAIL="andrea@hola.com";
	private final String EMAIL_FAL="holahola";
	private final String DNI_BUENO="26.752.080-K";
	private final String DNI_FAL="26.320.067-J";
	private final int VALOR_MIN=4;
	private final int VALOR_MAX=10;
	private final int VALOR_TEST=5;
	private final int VALOR_TEST_FAL=2;
	private final double VALOR_TESTB=5D;
	private final double VALOR_TESTB_FAL=2D;
	private final String VALOR_STR="Hola estamos ";
	private final String VALOR_STR_FAL="mar";
	private final String VALOR_STR_FAL_MAX="estamos probando la longitud maxima ";
	private final int MIN_STR=4;
	private final int MAX_STR=20;
	private final String EMPTY_STR="";
	private final String FORMATO_BARRA="dd/MM/yyyy";
	private final String FECHA_VALIDA="20/02/2023";
	private final String FECHA_VALIDA_STR="20.02.2023";
	private final LocalDate FECHA_VALIDA_FALSE=LocalDate.of(2020, 12, 02);
	private final String FECHA_VALIDA_FALSE_ST="02-12-2020";
	private final LocalDate DATE_DATE=LocalDate.of(2021, 10, 02);
	private final LocalDate DATE_DATE_FAL=LocalDate.of(1999, 10, 02);
	private final LocalDate DATE_DATE_FAL_MAX=LocalDate.of(2025, 10, 02);
	private final LocalDate DATE_MIN=LocalDate.of(2020, 10, 18);
	private final LocalDate DATE_MIN_DOS=LocalDate.of(2020, 10, 18);
	private final LocalDate DATE_MAX=LocalDate.of(2023, 12,9);
	private final String PASSWORD_TRUE="1@Holacomhola";
	private final String PASSWORD_FALSE="jajajaja";
	private final String NULL_STRING="";
	private final String ID_PROD_BUENO="KK123";
	private final String ID_PROD_FAL="KKKKK1222223";
	private final String ALFANUM_EXC="###444$$$jjj";
	private final double PRO_PRECIO_BUENO=20.30;
	private final double PRO_PRECIO_FALSE=2030;
	private final char VALOR_A='A';
	private final char VALOR_B='B';
	private final char PRUEBA_STAT='A';
	private final char PRUEBA_STAT_DOS='B';
	private final char PRUEBA_STAT_FALSE='X';
	
	
	//generamos los test
	
	@Test
	
	void testIsVacio(){
		assertNotNull(Validator.isVacio(EMPTY_STR));
	}
	

	@Test
		
	void cumplePrecioProduc() {
		assertTrue(Validator.cumplePrecioProduc(PRO_PRECIO_BUENO));
	}
	
	@Test
	
	void cumplePrecioProducDos() {
		assertFalse(Validator.cumplePrecioProduc(PRO_PRECIO_FALSE));
	}
	
	@Test
	
	void cumpleRangoStat() {
		assertTrue(Validator.cumpleRangoStat(PRUEBA_STAT, VALOR_B, VALOR_A));
	}
	
@Test
	
	void cumpleRangoStatDos() {
		assertFalse(Validator.cumpleRangoStat(PRUEBA_STAT_FALSE, VALOR_B, VALOR_A));
	}
	
	@Test
	
	void testIsAlfanumeric() {
		assertTrue(Validator.isAlfanumeric(ALFA_NUM));
	}
	@Test
	void testIsAlfanumericDos() {
			assertFalse(Validator.isAlfanumeric(ALFANUM_EXC));
	}
	

	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(PHONE_NUM));
	}
	
	@Test
	void testCumplePhoneNumberDos() {
		assertFalse(Validator.cumplePhoneNumber(PHONE_NUM_FAL));
	}

	@Test
	void testIsEmailValido() {
		assertTrue(Validator.isEmailValido(EMAIL));
	}
	
	@Test
	void testIsEmailValidoDos() {
		assertFalse(Validator.isEmailValido(EMAIL_FAL));
	}

	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI_BUENO));
	}
	
	@Test
	void testCumpleDNIDos() {
		assertFalse(Validator.cumpleDNI(DNI_FAL));
	}

	@Test
	void testCumpleRangoIntIntInt() {
		assertTrue(Validator.cumpleRango(VALOR_TEST, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoIntIntIntDos() {
		assertFalse(Validator.cumpleRango(VALOR_TEST_FAL, VALOR_MIN, VALOR_MAX));
	}

	@Test
	void testCumpleRangoDoubleIntInt() {
		assertTrue(Validator.cumpleRango(VALOR_TESTB, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoDoubleIntIntDos() {
		assertFalse(Validator.cumpleRango(VALOR_TESTB_FAL, VALOR_MIN, VALOR_MAX));
	}

	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin(VALOR_STR, VALOR_MIN));
	}
	
	@Test
	void testCumpleLongitudMinDos() {
		assertFalse(Validator.cumpleLongitudMin(VALOR_STR_FAL, VALOR_MIN));
	}

	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax(VALOR_STR, MAX_STR));
	}
	@Test
	void testCumpleLongitudMaxDos() {
		assertFalse(Validator.cumpleLongitudMax(VALOR_STR_FAL_MAX, MAX_STR));
	}

	@Test
	void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud(VALOR_STR, MIN_STR, MAX_STR));
	}
	
	@Test
	void testCumpleLongitudDos() {
		assertFalse(Validator.cumpleLongitud(VALOR_STR_FAL, MIN_STR, MAX_STR));
	}

	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(DATE_DATE, DATE_MIN));
	}

	@Test
	void testValDateMinDos() {
		assertFalse(Validator.valDateMin(DATE_DATE_FAL, DATE_MIN));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(DATE_DATE, DATE_MAX));
	}
	
	@Test
	void testValDateMaxDos() {
		assertFalse(Validator.valDateMax(DATE_DATE_FAL_MAX, DATE_MAX));
	}

	@Test
	void testEsFechaValidaString() {
		assertTrue(Validator.esFechaValida(FECHA_VALIDA));
	}
	
	@Test
	void testEsFechaValidaStringDos() {
		Assertions.assertThrows(Exception.class, () -> {
			Validator.esFechaValida(FECHA_VALIDA_FALSE_ST);
		});
	}


	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(PASSWORD_TRUE));
	}
	@Test
	void testEsPasswordValidaDos() {
		assertFalse(Validator.esPasswordValida(PASSWORD_FALSE));
	}
	@Test
	void testCumpleIdProduc() {
		assertTrue(Validator.cumpleIdproduc(ID_PROD_BUENO));
	}
	@Test
	void testCumpleIdProducDos() {
		assertFalse(Validator.cumpleIdproduc(ID_PROD_FAL));
	}

}
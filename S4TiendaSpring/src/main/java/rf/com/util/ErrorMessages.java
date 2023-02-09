package rf.com.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
 *  
 *  *****************************************************/
public class ErrorMessages extends Exception{
	
	
		
	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	public final static String PROERR_004 = "La longitud no cumple con la longitud mínima";
	public final static String PROERR_005 = "La longitud no cumple con la longitud máxima";
	
	/**
	 *Campo  de rango double 
	 */
	public static final String PROERR_006="Número decimar erróneo, no está en el rango";
	
	/**
	 * Comprobación de campo de fecha correcta
	 */
	public static final String PROERR_007="La fecha indicada no puede ser inferior.";
	public static final String PROERR_008="La fecha indicada no puede ser superior.";
	public static final String PROERR_009="Formato introducido incorrecto o no es una fecha válida";
	
	/**
	 * Campo de comprobación alfanumérica
	 */
	public static final String PROERR_010="Formato introducido incorrecto, debe de ser alfanumérico";
	/**
	 * Campo de formato erróneo y longitud
	 */
	public static final String PROERR_011="El formato o la  longitud introducida, son incorrectos";
	
	/**
	 * Campo de formato erróneo.
	 */
	public static final String PROERR_012="El formato introducido no es correcto";
	
	/**
	 * Campo de Error para dominio Categoria isValidinsert/isValidUpdate
	 */
	public static final String PROERR_013="ERROR. No se puede insertar";
	
	

}

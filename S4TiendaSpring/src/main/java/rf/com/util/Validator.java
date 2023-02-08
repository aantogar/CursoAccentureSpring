package rf.com.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: 
 * 			Clase auxiliar para validar los datos que sean 
 * 			introducidos en la aplicación.
 * 
 *  @version	30/01/2023 
 *  @author 	Andrea Anton
 *  
 * ******************************************************************************************/
public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * patrón para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * car�cteres alfanumericos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patrón XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
		
	/**
	 * Permite validar un teléfono, el cual debe contener de 10 a 20 dígitos
	 * y donde los espacios estén permitidos
	 */
	private final static String PHONE_PATTERN =  "[\\d ]{10,20}";
	
	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicación.
	 */
	private final static int LONGITUD_DNI = 12;
	/**
	 * Permite verificar el patrón de Código de producto
	 */
	private final static String ID_PROD_PATTERN="[A-Z]{2}\\d{3}";
	/**
	 * 
	 * Permite verificar que double en precio producto
	 * 
	 */
	private final static String PRECIO_PROD_PATTERN= "\\d{0,3}\\.\\d{1,2}";
	/* ***************************************************************************************
	 * NOMBRE: isAlfanumeric                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Permite verificar que el texto pasado solo contiene caracters alfanumericos
	 * 
	 * @param texto String a verificar que solo tenga car�cteres alfanumericos
	 * 
	 * @return  true, si cumple solo contiene caracters alfanumericos. <br> 
	 * 			false en caso contrario
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Andrea Anton - Madrid
	 * 
	 * **************************************************************************************/
	public static boolean isAlfanumeric(String texto){
		//devuelve true si se cumple la condición
		return !isVacio(texto) && texto.matches(ALFANUMERIC_PATTERN );
	}
	
	public static boolean isVacio( String prueba ){
		return prueba!= null && prueba.equalsIgnoreCase("");
	}
	
	/* ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		El phone number debe tener un total de entre 10 y 20, contando dígitos y espacios.
	 * 		Mínimo aceptable son 10 dígitos.
	 * 
	 * @param phoneNumber String con el número de telefono de entre 10 y 20 dígitos. 
	 * 		Puede tener espacios, pero siempre con 10 dígitos como Mínimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Andrea Anton
	 * 
	 * **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber){
        //utilizamos Matcher para buscar y comprobar el patron en la variable
        return !isVacio(phoneNumber) && phoneNumber.matches(PHONE_PATTERN);
	}
	/* ***************************************************************************************
	 * NOMBRE: cumplePrecioProduc                                                              *
	 * 
	 * DESCRIPCIÓN: 
	 * 		El precio del producto tiene que tener como mínimo 2 decimales.
	 * 		
	 * 
	 * @param pro_precio String con las carácteristicas anteriores. 
	 * 		
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Andrea Anton
	 * 
	 * **************************************************************************************/
	
	public static boolean cumplePrecioProduc(double pro_precio){
        //utilizamos Matcher para buscar y comprobar el patron en la variable
		String dob=String.format("%.2f", pro_precio);
		if(pro_precio!=0 && dob.matches(PRECIO_PROD_PATTERN)) 
			return true;
		else
			return false;
	}
	/* ***************************************************************************************
	 * NOMBRE: cumpleIdProduc                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		El código de producto ha de tener 5 carácteres, letras y números.
	 * 		Dos letras mayúsculas al principio y 3 números al final
	 * 
	 * @param id_producto String con las carácteristicas anteriores. 
	 * 		
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Andrea Anton
	 * 
	 * **************************************************************************************/
	public static boolean cumpleIdproduc(String id_producto){
        //utilizamos Matcher para buscar y comprobar el patron en la variable
        return !isVacio(id_producto) && id_producto.matches(ID_PROD_PATTERN);
	
	}
	

	/* ***************************************************************************************
	 * NOMBRE: isEmailValido                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 			Comprueba si el email tiene un formato que pueda ser valido.
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea valido
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Andrea Anton
	 * 
	 * **************************************************************************************/
	public static boolean isEmailValido(String email){
        //utilizamos Matcher para buscar y comprobar el patron en la variable
        return !isVacio(email) && email.matches(EMAIL_PATTERN);
	}

	/* ***************************************************************************************
	 * NOMBRE: cumpleDNI                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 			Esta función verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L <br>
	 * 			El DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional.
	 * FECHA: Enero 2023
	 * AUTOR: Andrea Anton
	 * 
	 * **************************************************************************************/
	public static boolean cumpleDNI(String dni){
		int suma = 0;
		//Creamos un nuevo String copia desde el original convirtiendolo en CharArray
		String dniDos=String.copyValueOf(dni.toCharArray());
		//especificamos los carácteres que queremos eliminar para quedarnos con los integer
		String charsToRemove = ".-";
		//creamos un array de los caracteres a eliminar
        for (char c : charsToRemove.toCharArray()) {
        	//reemplazamos esos caracteres por ""
          dniDos = dniDos.replace(String.valueOf(c), "");
          //convertimos a integer después de eliminar los carácteres
          int miDni=Integer.parseInt(dniDos.substring(0, 8));
          //conseguimos el resto para conocer la letra que pertenece
          suma=miDni%23;
        }
		
	    return !isVacio(dni) && dni.matches(DNI_PATTERN)  && dni.length()== LONGITUD_DNI
	    		&& dni.charAt(dni.length()-1) == LETRA_DNI.charAt(suma);
	}
	

	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprueba que un número se necuentra entre 2 valores
	 * 
	 * @param valor (int)/(double) número a comprobar
	 * @param valorMinimo (int) número valor aceptable
	 * @param valorMaximo (int) número valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo
	 * FECHA: Enero 2023
	 * AUTOR: Andrea Anton 
	 * 
	 * **************************************************************************************/
	public static boolean cumpleRango(
			int valor, 
			int valorMinimo,
			int valorMaximo){
		//devuelve true si valor es mayor que el mínimo y menor que el máximo
		return valor >= valorMinimo && valor <= valorMaximo;
	}
	public static boolean cumpleRango(
			double valor, 
			int valorMinimo,
			int valorMaximo){
		//devuelve true si valor es mayor que el mínimo y menor que el máximo
		return (int)valor >= valorMinimo && (int)valor <= valorMaximo;
	}
	
	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprueba que un número se necuentra entre 2 valores
	 * 
	 * @param valor String valor a comprobar
	 * @param valorA String  valor aceptable
	 * @param valorB String valor aceptable
	 * 
	 * @return true si valorA == valor || valor== valorB
	 * FECHA: Enero 2023
	 * AUTOR: Andrea Anton 
	 * 
	 * **************************************************************************************/
	public static boolean cumpleRangoStat(
			char valor, 
			char valorA,
			char valorB){
		//devuelve true si valor es mayor que el mínimo y menor que el máximo
		return valor==valorA || valor==valorB;
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprobar que el texto pasado tiene una longitud de al menos x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String texto a comprobar
	 * @param longitudMinima int que indique longitud Mínima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 * FECHA: Enero 2023
	 * AUTOR: Andrea Anton
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMin(
			String texto, 
			int longitudMinima){
		//devuelve true si la longitud es mayor que la mínima
		return texto.length() >= longitudMinima;	
	}

	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprobar que el texto pasado tiene una longitud de, como mucho, x caracteres, siendo
	 * 		x el entero pasado como parámetro
	 * 
	 * @param texto String con el texto a comprobar
	 * @param longitudMaxima int con la longitud Máxima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud Máxima.
	 * FECHA: Enero 2023 
	 * AUTOR: Andrea Anton 
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMax(
			String texto, 
			int longitudMaxima){
		//devuelve true si la longitud 
		return !isVacio(texto)&& texto.length() <= longitudMaxima;
	}


	/****************************************************************************************
	 * NOMBRE: cumpleLongitud                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprobar que la longitud de un texto se encuentra entre unos valores máximos y mínimos 
	 * 
	 * @param texto String con el texto que a validar
	 * @param longitudMinima (int) Mínima longitud del texto
	 * @param longitudMaxima (int) Máxima longitud valida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima
	 *               <= longitudTexto <=longitudMaxima
	 * FECHA: Enero 2023 
	 * AUTOR: Andrea Anton - Madrid
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitud(
			String texto, 
			int longitudMinima, 
			int longitudMaxima){
		//devuelve true si se cumple que la longitud es mayor que la mínima y menor que la máxima
	return !isVacio(texto) &&texto.length() >= longitudMinima && texto.length() <= longitudMaxima;

	}
	/**
	 * Valida una fecha calendar con Mínimo min
	 * @param fecha
	 * @param min
	 * @return
	 */
	
	public static boolean valDateMin(LocalDate fecha, LocalDate min){
		//validamos que la fecha sea mayor que la mínima o igual
		return fecha.equals(min) || fecha.isAfter(min);
	}
	
	/**
	 * Valida una fecha calendar con máximo max
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max){
		//validamos que la fecha sea menor que la máxima o igual
		return  fecha.equals(max) || fecha.isBefore(max);
		
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha){
		//Le pasamos el formato que queremos de fecha
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//lo parseamos
		Optional<LocalDate>date=Optional.of(LocalDate.parse(fecha,formatter));
		//comprobamos que es correcto y devolvemos la fecha
		if(date.isPresent())
			 date.get();
		else
			return false;
		
		return true;
	}
	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con lasnormas de contraseña
	 * @param password string con la contraseña introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password){
        //utilizamos Matcher para buscar y comprobar el patron en la variable
		//devuelve true si se cumple la condicion
        return password !=null && password.matches(PASSWORD_PATTERN);
	}
}

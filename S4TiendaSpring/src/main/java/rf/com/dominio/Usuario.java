package  rf.com.dominio;

import rf.com.exception.DomainException;
import rf.com.util.*;

import java.time.LocalDate;

public class Usuario {
	/**
	 * declaramos los atributos de la clase Usuario
	 */
	private static int id_usuario;
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private int id_tipo;
	private String user_dni;
	private LocalDate user_fecAlta;
	private LocalDate user_fecConfirmacion;
	private String user_pago;
	private String user_envio;
	
	/**
	 * variables generadas para aplicar los filtros
	 */
	private final LocalDate FECHA_ACTUAL=LocalDate.now();
	private final int MAX_CARAC=200;
	
	/**
	 * iniciamos un contador para autoincrementar el ID
	 */
	private static int contador=0;
	
	/**
	 * generamos constructor vacio
	 */
	public Usuario() {
		//autoincrementamos el ID
		setId_usuario();	
	}
	


	public static int getId_usuario() {
		return contador;
	}

	public static void setId_usuario() {
		contador++;
	}

	public String getUser_name() {
		return user_nombre;
	}
	
	/**
	 * Aplicamos el filtro para saber si cumple el max longitud
	 * @param user_name
	 * @throws DomainException
	 */
	public void setUser_nombre(String user_name) throws DomainException {
		if(Validator.cumpleLongitudMax(user_name,MAX_CARAC)) {
			this.user_nombre=user_name;
		}else
			throw new DomainException(ErrorMessages.PROERR_002);
		
	}

	public String getUser_email() {
		return user_email;
	}
	/**
	 * aplicamos el filtro para saber si cumple el formato de email
	 * @param user_email
	 * @throws DomainException
	 */
	public void setUser_email(String user_email) throws DomainException {
		//
		if(Validator.isEmailValido(user_email)) {
			this.user_email=user_email;
		}else
			throw new DomainException(ErrorMessages.PROERR_001);
	}

	public String getUser_pass() {
		return user_pass;
	}
	
	/**
	 * Aplicamos el formato de password válida
	 * @param user_pass
	 * @throws DomainException
	 */
	public void setUser_pass(String user_pass) throws DomainException {
		//(
		if(Validator.esPasswordValida(user_pass)){
			this.user_pass=user_pass;
		}else 
			throw new DomainException(ErrorMessages.PROERR_012);
	}

	public String getUser_dni() {
		return user_dni;
	}
	
	/**
	 * Aplicamos el filtro para saber si se cumple el formato
	 * @param user_dni
	 * @throws DomainException
	 */
	public void setUser_dni(String user_dni) throws DomainException {
		if(Validator.cumpleDNI(user_dni)) {
			this.user_dni=user_dni;
		}else
			throw new DomainException(ErrorMessages.PROERR_012);
	}

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}
	/**
	 * aplicamos filtro para comprobar que la fecha es igual a la actual
	 * @param user_fecAlta
	 * @throws Exception
	 */
	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		if(user_fecAlta.equals(FECHA_ACTUAL)) {
			this.user_fecAlta=user_fecAlta;
		}else
			throw new DomainException(ErrorMessages.PROERR_009);
	}

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	/**
	 * 
	 * aplicamos filtro para comprobar que la fecha es igual a la actual
	 * 
	 */
	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if(user_fecConfirmacion.equals(FECHA_ACTUAL)) {
			this.user_fecConfirmacion=user_fecConfirmacion;
		}else
			throw new DomainException(ErrorMessages.PROERR_009);
	}

	public String getUser_pago() {
		return user_pago;
	}

	public void setUser_pago(String user_pago) {
		this.user_pago = user_pago;
	}

	public String getUser_envio() {
		return user_envio;
	}

	public void setUser_envio(String user_envio) {
		this.user_envio = user_envio;
	}
	
	
	
	

	
	
}

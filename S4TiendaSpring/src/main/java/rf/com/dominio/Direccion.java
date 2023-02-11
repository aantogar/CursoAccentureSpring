package  rf.com.dominio;

import rf.com.exception.DomainException;
import rf.com.util.Messagesmessages;
import rf.com.util.Validator;

public class Direccion {
	/**
	 * Atributos de la clase Direccion
	 */
	private String dir_nombre;
	private String dir_direccion;
	private String dir_poblacion;
	private String dir_cPostal;
	private String dir_provincia;
	private String dir_pais;
	private String dir_correoE;
	
	/**
	 * Generamos constantes necesarias para aplicar a los filtros.
	 */
	private static int MIN_CARAC=5;
	private static int MAX_CARAC=5;
	
	/**
	 * Generamos un constructor vacio
	 */
	public Direccion() {
		
	}

	
	/**
	 * getters & setters
	 * @return
	 */
	public String getDir_nombre() {
		return dir_nombre;
	}
	/**
	 * Aplicamos el filtro a para saber si cumple con max y min de longitud
	 * @param dir_nombre
	 * @throws DomainException
	 */
	public void setDir_nombre(String dir_nombre) throws DomainException {
		if(Validator.cumpleLongitud(dir_nombre, MIN_CARAC, MAX_CARAC)) {
			this.dir_nombre=dir_nombre;
		}else 
			throw new DomainException(Messagesmessages.PROERR_002);
	}
	public String getDir_direccion() {
		return dir_direccion;
	}
	public void setDir_direccion(String dir_direccion) {
		this.dir_direccion = dir_direccion;
	}
	public String getDir_poblacion() {
		return dir_poblacion;
	}
	public void setDir_poblacion(String dir_poblacion) {
		this.dir_poblacion = dir_poblacion;
	}
	public String getDir_cPostal() {
		return dir_cPostal;
	}
	public void setDir_cPostal(String dir_cPostal) {
		this.dir_cPostal = dir_cPostal;
	}
	public String getDir_provincia() {
		return dir_provincia;
	}
	public void setDir_provincia(String dir_provincia) {
		this.dir_provincia = dir_provincia;
	}
	public String getDir_pais() {
		return dir_pais;
	}
	public void setDir_pais(String dir_pais) {
		this.dir_pais = dir_pais;
	}
	public String getDir_correoE() {
		return dir_correoE;
	}
	public void setDir_correoE(String dir_correoE) {
		this.dir_correoE = dir_correoE;
	}
	public static int getMIN_CARAC() {
		return MIN_CARAC;
	}
	public static void setMIN_CARAC(int mIN_CARAC) {
		MIN_CARAC = mIN_CARAC;
	}
	public static int getMAX_CARAC() {
		return MAX_CARAC;
	}
	public static void setMAX_CARAC(int mAX_CARAC) {
		MAX_CARAC = mAX_CARAC;
	}

		
		
		
}

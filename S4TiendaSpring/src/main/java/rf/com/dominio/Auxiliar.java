package rf.com.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Transient;
import rf.com.exception.DAOException;

public interface Auxiliar {
	/**
	 * 
	 * Interfaz auxiliar para implementar en los Dominios
	 * @throws DAOException 
	 */
	
	@Transient
	@JsonIgnore
	public boolean isValidInsert() throws DAOException;
	
	@Transient
	@JsonIgnore
	public boolean isValidUpdate() throws DAOException;
	

}

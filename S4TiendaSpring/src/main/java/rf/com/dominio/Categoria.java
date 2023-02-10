package rf.com.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import rf.com.util.ErrorMessages;
import rf.com.util.Validator;
/**
 * 
 * Nombre		Categoria
 * Descripcion	Lista de categorías
 * @author 		Andrea Anton
 * @version		13 de abr. de 2016
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(schema="ALUMNO_AAG",name = "CATEGORIAS_AAG")
public class Categoria implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_categoria;			
	
	@Column(nullable=false)
	private String cat_nombre;	
	
	@Column(nullable=false)
	private String cat_descripcion;		
	
	
	public Categoria(){}
	
	@Transient
	/**
	 * Getter para identificador de categoria
	 * @return Integer con el id de la categoria
	 */

	public int getId_categoria() {
		return id_categoria;
	}
	
	/**
	 * Setter para identificador de categoria
	 * 
	 */

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	/**
	 * Getter para el nombre de categoria
	 * @return cadena con el nombre de la categoria
	 */

	public String getCat_nombre() {
		return cat_nombre;
	}
	
	/**
	 * Setter para el nombre de categoria
	 * 
	 */
	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}
	
	/**
	 * Getter para la descripcion de categoria
	 * @return cadena con la descripcion de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}
	
	/**
	 * setter para la descripcion de categoria
	 * 
	 */
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}
	
	@Transient
	@JsonIgnore
	public boolean isValidInsert() {
		boolean res=!Validator.isVacio(cat_nombre);
		if(res)
			return res;
		else {
			System.out.println(ErrorMessages.PROERR_013);
			return false;}
	}
	@Transient
	@JsonIgnore
	public boolean isValidUpdate() {
		boolean res=!Validator.isVacio(cat_nombre) &&
				id_categoria > 0;
		if(res)
			return res;
		else {
			System.out.println(ErrorMessages.PROERR_013);
			return false;}		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}
	
	
}

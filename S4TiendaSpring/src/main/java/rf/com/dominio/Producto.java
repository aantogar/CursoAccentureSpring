package  rf.com.dominio;

import rf.com.exception.DAOException;
import rf.com.exception.DomainException;
import rf.com.util.*;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


@Entity
@Table(schema="ALUMNO_AAG", name = "Productos")
public class Producto implements Serializable, Auxiliar{ 
	/**
	 * Propiedades de los atributos
	 * en la BBDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id_producto;
	
	@Column(nullable=false, length = 100)
	private String pro_descripcion;
	
	@Column(nullable=true, length = 2000)
	private String pro_desLarga;
	
	@Column(nullable=false, length = 100)
	private double pro_precio;
	
	@Column(nullable=true)
	private int stock;
	
	@Column(name = "FECHA_REPO", nullable = true)
	@Temporal(TemporalType.DATE)
	private LocalDate pro_fecRepos;
	
	@Column(name = "FECHA_ACTI", nullable = true)
	@Temporal(TemporalType.DATE)
	private LocalDate pro_fecActi;
	
	@Column(name = "FECHA_DESACTI", nullable = true)
	@Temporal(TemporalType.DATE)
	private LocalDate pro_fecDesacti;
	
	@Column(nullable=false,length=10)
	private String pro_uniVenta;
	
	@Column(nullable=true)
	private double pro_cantXUniVenta;
	
	@Column(nullable=true)
	private String pro_uniUltNivel;
	
	@Column(nullable=false)
	private  int id_pais;
	
	@Column(nullable=false,length=2000)
	private String pro_usoRecomendado;
	
	@ManyToOne(targetEntity = Categoria.class, cascade=CascadeType.ALL, 
			fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false)
	private int id_categoria;
	
	@Column(nullable=true)
	private int pro_stkReservado;
	
	@Column(nullable=true)
	private int pro_nStkAlto;
	
	@Column(nullable=true)
	private int pro_nStkBajo;
	
	@Column(nullable=true,length=1)
	private char pro_stat;
	
	/**
	 * variables generadas para los filtros.
	 */
	@JsonIgnore
	@Transient
	private final LocalDate FECHA_ACTUAL=LocalDate.now();
	@JsonIgnore
	@Transient
	private final int MAX_DESC_COR=100;
	@JsonIgnore
	@Transient
	private final int MAX_DESC_LAR=2000;
	@JsonIgnore
	@Transient
	private final char VALOR_A='A';
	@JsonIgnore
	@Transient
	private final char VALOR_B='B';
	
	
	/**
	 * Constructor
	 * 
	 */
	public Producto() {

		
	}
	
	/**
	 * Generamos getters and setters
	 * 
	 */
	@Transient
	public String getId_producto() {
		return id_producto;
	}
	
	/**
	 * 
	 * Aplicamos filtro para saber si cumple el patrón
	 * 
	 */
	public void setId_producto(String id_producto) throws DomainException {
	
		if(Validator.cumpleIdproduc(id_producto)){
			this.id_producto=id_producto;
		}else 
			throw new DomainException(Messagesmessages.PROERR_001);
	}
	
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	
	/**
	 * 
	 * Aplicamos filtro para saber si cumple con la longitud máxima
	 * 
	 */
	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if(Validator.cumpleLongitudMax(pro_descripcion,MAX_DESC_COR)){
			this.pro_descripcion=pro_descripcion;
		}else 
			throw new DomainException(Messagesmessages.PROERR_002);
	}
	public String getPro_desLarga() {
		return pro_desLarga;
	}
	
	/**
	 * 
	 * Aplicamos filtro para saber si cumple con la longitud máxima
	 * 
	 */
	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		
		if(Validator.cumpleLongitudMax(pro_desLarga,MAX_DESC_LAR)){
			this.pro_desLarga=pro_desLarga;
		}else 
			throw new DomainException(Messagesmessages.PROERR_002);
	}
	public double getPro_precio() {
		return pro_precio;
	}
	
	/**
	 * 
	 * Aplicamos el filtro para que cumpla con los dos decimales
	 * @throws Exception 
	 */
	public void setPro_precio(double pro_precio){
			this.pro_precio = pro_precio;	
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}
	
	/**
	 * 
	 * Aplicamos el filtro de fecha minima o mayor a la actual
	 * 
	 */
	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if(Validator.valDateMin(pro_fecRepos, LocalDate.now())) {
			this.pro_fecRepos = pro_fecRepos;
		}else {
			throw new DomainException(Messagesmessages.PROERR_007);
		}
	}

	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}
	
	/**
	 * 
	 * Aplicamos el filtro de fecha minima para fecha activacion
	 * 
	 */
	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		if(Validator.valDateMin(pro_fecActi,FECHA_ACTUAL)){
			this.pro_fecActi=pro_fecActi;
		}else 
			throw new DomainException(Messagesmessages.PROERR_007);
	}
	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}
	
	/**
	 * 	Comprobamos que no haya fecha de activación para
	 *  que sea superior a la actual.
	 *  Si tiene fecha de activación, la fecha será superior a ésta.
	 */
	public void setPro_fecDesacti(LocalDate pro_fecDesacti) throws DomainException {
		if(pro_fecActi==null && Validator.valDateMin(pro_fecDesacti, FECHA_ACTUAL)) {
			this.pro_fecDesacti=pro_fecDesacti;
		}else if(pro_fecActi!=null) {
			pro_fecDesacti.isAfter(pro_fecActi);
			this.pro_fecDesacti=pro_fecDesacti;
		}else
			throw new DomainException(Messagesmessages.PROERR_007);
	}
	
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}
	public void setPro_uniVenta(String pro_uniVenta) {
		this.pro_uniVenta = pro_uniVenta;
	}
	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}
	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}
	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}
	
	/**
	 * 
	 * Aplicamos filtro para saber si cumple con la longitud máxima
	 * 
	 */
	public void setPro_usoRecomendado(String pro_usoRecomendado) throws DomainException {
		if(Validator.cumpleLongitudMax(pro_usoRecomendado,MAX_DESC_LAR)){
			this.pro_usoRecomendado=pro_usoRecomendado;
		}else 
			throw new DomainException(Messagesmessages.PROERR_002);
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}
	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}
	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}
	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}
	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}
	public char getPro_stat() {
		return pro_stat;
	}
	
	/**
	 * Aplicamos filtro para saber que cumple el carácter a introducir
	 * @param pro_stat
	 * @throws Exception 
	 */
	public void setPro_stat(char pro_stat) throws DomainException {
		if(Validator.cumpleRangoStat(pro_stat, VALOR_A, VALOR_B)){
			this.pro_stat = pro_stat;
		}else 
			throw new DomainException(Messagesmessages.PROERR_012);
		
	}
	
	@JsonIgnore
	@Transient
	@Override
	public boolean isValidInsert() throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isValidUpdate() throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	


	
	

}

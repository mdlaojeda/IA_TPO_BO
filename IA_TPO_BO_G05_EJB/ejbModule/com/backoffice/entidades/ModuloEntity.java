package com.backoffice.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.backoffice.dto.ModuloDTO;

import javax.persistence.Id;

@Entity
@Table(name="Modulos")
public class ModuloEntity implements Serializable {

	private static final long serialVersionUID = -760031751255158407L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "nroModulo")
	private Integer nroModulo;
	
	@Column (name = "codModulo")
	private String codModulo;
	
	@Column (name = "nombre")
	private String nombre;
	
	public ModuloEntity (String codModulo, String nombre) {
		this.codModulo = codModulo;
		this.nombre = nombre;
	}
	public ModuloEntity (ModuloDTO mDTO) {
		this.nroModulo = mDTO.getNroModulo();
		this.codModulo = mDTO.getCodigo();
		this.nombre = mDTO.getNombre();
	}
	public Integer getNroModulo() {
		return nroModulo;
	}
	public void setNroModulo(Integer nroModulo) {
		this.nroModulo = nroModulo;
	}
	public String getCodModulo() {
		return codModulo;
	}
	public void setCodModulo(String codModulo) {
		this.codModulo = codModulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

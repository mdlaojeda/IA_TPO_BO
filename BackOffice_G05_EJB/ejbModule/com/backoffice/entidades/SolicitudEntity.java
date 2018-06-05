package com.backoffice.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backoffice.enums.Estado;
import com.backoffice.enums.TipoSolicitud;

@Entity
@Table(name = "Solicitudes")
public class SolicitudEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroSolicitud")
	private Integer nroSolicitud;

	@Column(name = "nroUsuario")
	private Integer nroUsuario;

	@Column(name = "nroEstablecimiento")
	private Integer nroEstablecimiento;

	@Column(name = "nroAgencia")
	private Integer nroAgencia;

	@Column(name = "tipo")
	private TipoSolicitud tipo;

	@Column(name = "estado")
	private Estado estado;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "fotoUrl")
	private String fotoUrl;

	public SolicitudEntity() {
	}

	public int getNroSolicitud() {
		return nroSolicitud;
	}

	public void setNroSolicitud(int nroSolicitud) {
		this.nroSolicitud = Integer.valueOf(nroSolicitud);
	}

	public int getNroUsuario() {
		return nroUsuario;
	}

	public void setNroUsuario(int idUsuario) {
		this.nroUsuario =  Integer.valueOf(idUsuario);
	}

	public int getNroEstablecimiento() {
		return nroEstablecimiento;
	}

	public void setNroEstablecimiento(int nroEstablecimiento) {
		this.nroEstablecimiento =  Integer.valueOf(nroEstablecimiento);
	}

	public int getNroAgencia() {
		return nroAgencia;
	}

	public void setNroAgencia(int nroAgencia) {
		this.nroAgencia =  Integer.valueOf(nroAgencia);
	}

	public TipoSolicitud getTipo() {
		return tipo;
	}

	public void setTipo(TipoSolicitud tipo) {
		this.tipo = tipo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String dir) {
		this.direccion = dir;
	}
	
	public String getFotoURL() {
		return fotoUrl;
	}

	public void setEstado(String foto) {
		this.fotoUrl = foto;
	}

	public void Aprobar() {
		this.setEstado(Estado.APROBADA);
	}

	public void Desaprobar() {
		this.setEstado(Estado.DESAPROBADA);
	}

}

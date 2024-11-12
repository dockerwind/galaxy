package com.challenge.galaxy.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "nave_espacial")
public class NaveEspacial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(length = 50)
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "serie_pelicula_id", referencedColumnName = "id")
	private SeriePelicula seriePelicula;

	@Column(name = "fecha_creacion", updatable = false)
	private LocalDateTime fechaCreacion;

    @Column(name = "ultima_modificacion")
    private LocalDateTime ultimaModificacion;
    
   
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public SeriePelicula getSeriePelicula() {
		return seriePelicula;
	}

	public void setSeriePelicula(SeriePelicula seriePelicula) {
		this.seriePelicula = seriePelicula;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	@PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        ultimaModificacion = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        ultimaModificacion = LocalDateTime.now();
    }

}

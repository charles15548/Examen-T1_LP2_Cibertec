package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name="citas")
@Entity
@Data
public class Citas {

	@Id
	private int num_cita;
	private String fecha;
	private String nom_dueño;
	private String nom_mascota;
	private int cod_servicio;
	@ManyToOne
	@JoinColumn(name = "cod_servicio",
	insertable=false ,updatable =false)
    private Servicio objcod_servicio;	
}

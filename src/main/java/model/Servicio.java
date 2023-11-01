package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "servicio")
@Data
public class Servicio {
	@Id
private int cod_servicio;
private String nom_servicio;
private double precio_servicio;
}

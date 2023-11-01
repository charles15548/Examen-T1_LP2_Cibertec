package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import antlr.collections.List;
import model.Servicio;

public class Demo01 {

	//obtener conexion
	
	
	public static void main(String[] args) {
		//llama la conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("repaso");
		EntityManager manager = fabrica.createEntityManager();
		
		//select from
		String sql = "select u from servicio u ";
		java.util.List<Servicio> lstServicio = manager.createQuery(sql, Servicio.class ).getResultList();
		
		//recorrer y mostrar
		
		for(Servicio u : lstServicio) {
			System.out.println("Código..:" + u.getCod_servicio());
			System.out.println("Nombre..:" + u.getNom_servicio()    );
			System.out.println("----------------------------------");
		}
		
		
		
		manager.close();

		
		
	}

}
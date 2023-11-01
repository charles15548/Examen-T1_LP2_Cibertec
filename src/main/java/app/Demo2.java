package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Servicio;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("repaso");
		//crear un manejador de las entidades
		EntityManager manager = fabrica.createEntityManager();
		//objeto a modificar
		Servicio u =new Servicio();
		 	
		u.setCod_servicio(1);
		
		
		//si queremos reqistrar, actualizar o eliminar
		try {
			manager.getTransaction().begin();
			
			manager.merge(u);
			manager.getTransaction().commit();
			System.out.print("Actualización ok");
		} catch (Exception e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
		manager.close();
	}

}

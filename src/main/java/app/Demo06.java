package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Servicio;

public class Demo06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("repaso");
		
		EntityManager manager = fabrica.createEntityManager();
		
		//select from tb_xxxx
	
				String sql = "FROM Servicio ";
				List<Servicio> lstSer = manager.createQuery(sql, Servicio.class).getResultList();
				//recorrer y mostrar
				
				for(Servicio u : lstSer) {
					System.out.println("Código..:" + u.getCod_servicio());
					System.out.println("Nombre:"+u.getNom_servicio());
					System.out.println("precio:"+u.getPrecio_servicio());
					
				}
				
				
				
				manager.close();
		
		
			 }
	
	}



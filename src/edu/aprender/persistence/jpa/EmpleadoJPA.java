package edu.aprender.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.aprender.persistence.entity.Empleado;

public class EmpleadoJPA {

	private EntityManagerFactory emf;
	private EntityManager em;

	public void setup() {
		// Referenciamos a nuestra unidad de persistencia para gestionar nuestras entidades
		emf = Persistence.createEntityManagerFactory("Aplicacion_06_Mapping_con_JPA");
		// Creamos instancia del EntityManager
		em = emf.createEntityManager();
	}

	public void close() {
		// cierra el EntityManager
		em.close();
	}

	public List<Empleado> consultar() throws Exception {
		// 1.Definimos JPQL
		String query = "SELECT o FROM Empleado o ORDER BY o.id";
		Query emquery = em.createQuery(query);
		// 2.Ejecutamos query
		List<Empleado> listaEntidad = emquery.getResultList();
		return listaEntidad;
	}

	public void insertar(Empleado entidadEmpleado) throws Exception {
		// 1.Inicia la transacción
		em.getTransaction().begin();
		// 2.Prepara operacion INSERT
		em.persist(entidadEmpleado);
		// 3.Ejecuta operación. 
		em.flush(); // De no usar este método, las operaciones se ejecutarán al invocar método commit()
		// 4.Ejecuta commit a la transacción
		em.getTransaction().commit();
	}
	
	public void actualizar(Empleado entidadEmpleado) throws Exception {
		// 1.Inicia la transacción
		em.getTransaction().begin();
		// 2 Prepara operación UPDATE
		em.merge(entidadEmpleado);
		// 3.Ejecuta operación. 
		em.flush(); // De no usar este método, las operaciones se ejecutarán al invocar método commit()
		// 4.Ejecuta commit a la transacción
		em.getTransaction().commit();
	}

	public void eliminar(Integer id) throws Exception {
		// 1.Inicia la transacción
		em.getTransaction().begin();
		// 2.Prepara las operaciones
		// 2.1 busca Empleado por llave primaria
		Empleado entidadEmpleado = (Empleado) em.find(Empleado.class, id);
		// 2.2 Elimina Empleado
		em.remove(entidadEmpleado);
		// 3.Ejecuta operación. 
		em.flush(); //De no usar este método, las operaciones se ejecutarán al invocar método commit()
		// 4.Ejecuta commit a la transacción
		em.getTransaction().commit();
	}

}

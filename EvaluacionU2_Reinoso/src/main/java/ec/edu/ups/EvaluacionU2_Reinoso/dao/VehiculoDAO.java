package ec.edu.ups.EvaluacionU2_Reinoso.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EvaluacionU2_Reinoso.model.Vehiculo;

@Stateless
public class VehiculoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo op) {
		em.persist(op);
	}
	
	public void update(Vehiculo op) {
		em.merge(op);
	}
	
	public Vehiculo read(int id) {
		Vehiculo op = em.find(Vehiculo.class, id);
		return op;
	}
	
	public void delete(int id) {
		Vehiculo op = em.find(Vehiculo.class, id);
		em.remove(op);
	}
	
	public List<Vehiculo> getList(){
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		
		String jpql = "SELECT op FROM Vehiculo op "
				+ "WHERE op.operacion = ?1";
		Query query = em.createQuery(jpql, Vehiculo.class);
		
		listado = query.getResultList();
		
		
		return listado;
	}
	
}

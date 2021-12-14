package ec.edu.ups.EvaluacionU2_Reinoso.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.EvaluacionU2_Reinoso.dao.VehiculoDAO;
import ec.edu.ups.EvaluacionU2_Reinoso.model.Vehiculo;

@Stateless
public class VehiculoON implements VehiculoONRemote {

	@Inject
	private VehiculoDAO daoProducto;
	public void insertar(Vehiculo op) {
		daoProducto.insert(op);
	}
	

	public List<Vehiculo> getList(){
		return daoProducto.getList();
	}
	
	
}

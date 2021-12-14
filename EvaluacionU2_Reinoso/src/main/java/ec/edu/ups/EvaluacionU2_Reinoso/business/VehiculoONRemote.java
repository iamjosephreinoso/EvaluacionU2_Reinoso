package ec.edu.ups.EvaluacionU2_Reinoso.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.EvaluacionU2_Reinoso.model.Vehiculo;

@Remote
public interface VehiculoONRemote {

	public void insertar(Vehiculo p);
	public List<Vehiculo> getList();
}

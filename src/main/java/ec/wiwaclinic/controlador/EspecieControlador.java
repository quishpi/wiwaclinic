package ec.wiwaclinic.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.wiwaclinic.modelo.dao.EspecieDao;
import ec.wiwaclinic.modelo.entidad.Especie;

@Service
public class EspecieControlador {

	@Autowired
	EspecieDao especieDao;

	public String guardar(Especie entity) {
		especieDao.save(entity);
		return null;
	}

	public String eliminar(Especie entity) {
		especieDao.delete(entity);
		return null;
	}

	public ArrayList<Especie> listarTodo() {
		return (ArrayList<Especie>) especieDao.findAll();
	}

	public Especie buscar(Integer id) {
		Especie especie = new Especie();
		especie = especieDao.findById(id).get();
		return especie;
	}
}

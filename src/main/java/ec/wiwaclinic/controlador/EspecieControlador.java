package ec.wiwaclinic.controlador;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import ec.wiwaclinic.modelo.dao.EspecieDao;
import ec.wiwaclinic.modelo.entidad.Especie;

@Service
public class EspecieControlador {

	@Autowired
	EspecieDao especieDao;

	public String guardar(Especie especie) {
		especieDao.save(especie);

		return null;
	}

	public ArrayList<Especie> listarTodo() {
		return (ArrayList<Especie>) especieDao.findAll();
	}
}

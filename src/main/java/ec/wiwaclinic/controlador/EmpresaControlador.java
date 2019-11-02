package ec.wiwaclinic.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.wiwaclinic.modelo.dao.EmpresaDao;
import ec.wiwaclinic.modelo.entidad.Empresa;

@Service
public class EmpresaControlador {

	@Autowired
	EmpresaDao empresaDao;

	public String guardar(Empresa empresa) {
		empresaDao.save(empresa);
		return null;
	}

	public ArrayList<Empresa> empresaLista() {
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		empresas = (ArrayList<Empresa>) empresaDao.findAll();
		return empresas;
	}

	public ArrayList<Empresa> listarTodo() {
		return (ArrayList<Empresa>) empresaDao.findAll();
	}
}

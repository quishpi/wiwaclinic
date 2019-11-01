package ec.wiwaclinic.vista.bean.especie;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ec.wiwaclinic.controlador.especie.EspecieControlador;
import ec.wiwaclinic.modelo.dao.EspecieDao;
import ec.wiwaclinic.modelo.entidad.Especie;

@Component
@Scope("especieListaBean")
public class EspecieListaBean {

	private ArrayList<Especie> especieLista;

	@Autowired
	EspecieControlador especieControlador;

	public EspecieListaBean() {
		System.out.println("EspecieLista Creado!");
	}

	@PostConstruct
	public void init() {
		especieLista = especieControlador.listarTodo();
	}

	public ArrayList<Especie> getEspecieLista() {
		return especieLista;
	}

	public void setEspecieLista(ArrayList<Especie> especieLista) {
		this.especieLista = especieLista;
	}

}

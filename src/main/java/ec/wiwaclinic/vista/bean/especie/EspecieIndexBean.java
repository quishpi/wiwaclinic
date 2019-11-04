package ec.wiwaclinic.vista.bean.especie;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ec.wiwaclinic.controlador.EspecieControlador;
import ec.wiwaclinic.modelo.entidad.Especie;
import ec.wiwaclinic.utils.Mensajes;
import ec.wiwaclinic.utils.Seguridad;
import ec.wiwaclinic.utils.Utils;

@Component
@Scope("view") // view,request,session
public class EspecieIndexBean {

	private ArrayList<Especie> especieLista;
	private Especie especie;
	private Boolean esNuevo;

	@Autowired
	EspecieControlador especieControlador;

	public EspecieIndexBean() {
		System.out.println("EspecieLista Creado!");
	}

	@PostConstruct
	public void init() {
		especie = new Especie();
		especieLista = especieControlador.listarTodo();
		LoadToEdit();
	}

	public void guardar() {
		String result = especieControlador.guardar(especie);
		especieLista = especieControlador.listarTodo();
		if (result == null) {
			especie = new Especie();
			Mensajes.addMsg(FacesMessage.SEVERITY_INFO, "Guardado correctamente");
		} else {
			Mensajes.addMsg(FacesMessage.SEVERITY_ERROR, "Error: " + result);
		}
	}

	public void eliminar() {
		String result = especieControlador.eliminar(especie);
		especieLista = especieControlador.listarTodo();
		if (result == null) {
			especie = new Especie();
			setEsNuevo(true);
			Mensajes.addMsg(FacesMessage.SEVERITY_INFO, "Eliminado correctamente");
		} else {
			Mensajes.addMsg(FacesMessage.SEVERITY_ERROR, "Error: " + result);
		}
	}

	private void LoadToEdit() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (params.size() > 0) {
			Integer id = 0;
			try {
				id = Integer.parseInt(Seguridad.decode(params.get("a")));
				especie = especieControlador.buscar(id);
			} catch (Exception e) {
				String Url = "index.xhtml";
				Utils.redirectToPage(Url);
			}
			if (especie != null) {
				setEsNuevo(false);
			}
		} else {
			setEsNuevo(true);
		}

	}

	public void goToEdit(Integer id) throws Exception {
		String Url = "/especie/index.xhtml?a=" + Seguridad.encode(id.toString());
		Utils.redirectToPage(Url);
	}

	public ArrayList<Especie> getEspecieLista() {
		return especieLista;
	}

	public void setEspecieLista(ArrayList<Especie> especieLista) {
		this.especieLista = especieLista;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Boolean getEsNuevo() {
		return esNuevo;
	}

	public void setEsNuevo(Boolean esNuevo) {
		this.esNuevo = esNuevo;
	}

}

package ec.wiwaclinic.vista.bean.empresa;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ec.wiwaclinic.Utils;
import ec.wiwaclinic.controlador.EmpresaControlador;
import ec.wiwaclinic.modelo.entidad.Empresa;

@Component
@Scope("empresaNuevoBean")
public class EmpresaNuevoBean {

	private Empresa empresa;

	@Autowired
	EmpresaControlador empresaControlador;

	public EmpresaNuevoBean() {
		System.out.println("Empresa Constructor Creado!");
	}

	@PostConstruct
	public void init() {
		System.out.println("postConstruct EmpresaNuevoBean");
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		empresas = empresaControlador.empresaLista();
		empresa = new Empresa();
		if (!empresas.isEmpty())
			empresa = empresas.get(0);
	}

	public void guardar() throws IOException {
		empresa = new Empresa();
		empresa.setNombre("WEBMARKET");
		empresa.setDireccion("Barcelona");
		empresa.setEmail("info@webmarket.ec");
		empresa.setTelefono("+34 666848949");
		empresa.setRuc("0301584173001");
		empresa.setFoto(Utils.generateImageForDataBase());

		empresaControlador.guardar(empresa);
		System.out.println("Empresa guardado");
		System.out.println(empresa.getId());
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}

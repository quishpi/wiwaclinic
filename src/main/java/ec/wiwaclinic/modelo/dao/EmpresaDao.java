package ec.wiwaclinic.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import ec.wiwaclinic.modelo.entidad.Empresa;

public interface EmpresaDao extends CrudRepository<Empresa, Integer> {

}

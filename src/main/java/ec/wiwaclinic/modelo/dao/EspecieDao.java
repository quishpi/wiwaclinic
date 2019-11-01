package ec.wiwaclinic.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import ec.wiwaclinic.modelo.entidad.Especie;

public interface EspecieDao extends CrudRepository<Especie, Integer> {

}

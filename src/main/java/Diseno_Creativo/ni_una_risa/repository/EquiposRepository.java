package Diseno_Creativo.ni_una_risa.repository;

import Diseno_Creativo.ni_una_risa.entity.Equipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EquiposRepository {
    @Autowired
    private EquiposCrudRepository equiposCrudRepository;

    public List<Equipos> findAll() {
        return (List<Equipos>) equiposCrudRepository.findAll();
    }

    public Optional<Equipos> findById(Long id) {
        return equiposCrudRepository.findById(id);
    }

    public <S extends Equipos> S save(S equipos) {
        return equiposCrudRepository.save(equipos);
    }

    public void deleteById(Long id) {
        equiposCrudRepository.deleteById(id);
    }
}

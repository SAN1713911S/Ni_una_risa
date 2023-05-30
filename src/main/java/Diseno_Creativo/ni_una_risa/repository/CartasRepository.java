package Diseno_Creativo.ni_una_risa.repository;

import Diseno_Creativo.ni_una_risa.entity.Cartas;
import Diseno_Creativo.ni_una_risa.entity.Equipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CartasRepository {
    @Autowired
    private CartasCrudRepository cartasCrudRepository;

    public List<Cartas> findAll() {
        return (List<Cartas>) cartasCrudRepository.findAll();
    }

    public Optional<Cartas> findById(Long id) {
        return cartasCrudRepository.findById(id);
    }

    public <S extends Cartas> S save(S Cartas) {
        return cartasCrudRepository.save(Cartas);
    }

    public void deleteById(Long id) {
        cartasCrudRepository.deleteById(id);
    }
}

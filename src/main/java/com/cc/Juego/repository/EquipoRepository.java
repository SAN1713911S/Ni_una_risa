package com.cc.Juego.repository;

import com.cc.Juego.interfaces.IEquipo;
import com.cc.Juego.modelo.Equipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EquipoRepository {
    @Autowired
    private IEquipo equipoCrudRepository;

    public List<Equipos> getAll(){ return (List<Equipos>) equipoCrudRepository.findAll(); }
    public Optional<Equipos> getEquipo(int id){
        return equipoCrudRepository.findById(id);
    }

    public Equipos save(Equipos c){ return equipoCrudRepository.save(c); }

    public List<Equipos> saveAll(List<Equipos> equipos){ return (List<Equipos>) equipoCrudRepository.saveAll(equipos);}

    public void delete(Equipos c){ equipoCrudRepository.delete(c);}


}

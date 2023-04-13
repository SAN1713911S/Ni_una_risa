package com.cc.Juego.interfaces;

import com.cc.Juego.modelo.Equipos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipo extends CrudRepository<Equipos, Integer> {
}

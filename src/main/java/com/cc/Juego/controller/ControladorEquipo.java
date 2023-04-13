package com.cc.Juego.controller;

import com.cc.Juego.modelo.Equipos;
import com.cc.Juego.service.ServiceEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Equipo")

public class ControladorEquipo {
    @Autowired
    private ServiceEquipo service;

    @GetMapping("/all")
    public List<Equipos> getAll(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Optional<Equipos> getEquipo(@PathVariable("id") int idEquipo) {
        return service.getEquipo(idEquipo);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipos save(@RequestBody Equipos c){ return service.save(c); }

    @PostMapping("/saveAll")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Equipos> saveAll(@RequestBody List<Equipos> e){return (List<Equipos>) service.saveAll(e); }

}

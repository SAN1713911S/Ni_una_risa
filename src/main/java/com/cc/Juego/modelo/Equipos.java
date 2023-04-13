package com.cc.Juego.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name= "equipos")
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String vida;

    public Equipos(int id, String nombre, String vida) {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
    }
    public Equipos(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }
}

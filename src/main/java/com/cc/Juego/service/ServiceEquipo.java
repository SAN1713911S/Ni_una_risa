package com.cc.Juego.service;
import com.cc.Juego.modelo.Equipos;
import com.cc.Juego.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEquipo {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipos> getAll(){ return equipoRepository.getAll(); }

    public Optional<Equipos> getEquipo(int id){ return equipoRepository.getEquipo(id); }

    public Equipos save(Equipos c){
        if(c.getId()==null){
            return equipoRepository.save(c);
        }else {
            Optional<Equipos> e = equipoRepository.getEquipo(c.getId());
            if(e.isPresent()){
                return c;
            }else {
                return equipoRepository.save(c);
            }
        }
    }

    public List<Equipos> saveAll(List<Equipos> cc){
        return (List<Equipos>) equipoRepository.saveAll(cc);
    }

    public Equipos update(Equipos cc){
        if(cc.getId()!=null){
            Optional<Equipos> e = equipoRepository.getEquipo(cc.getId());
            if (e.isPresent()){
                if (cc.getNombre()!=null){
                    e.get().setNombre(cc.getNombre());
                }
                equipoRepository.save(e.get());
                return e.get();
            }else {
                return cc;
            }
        }else {
            return cc;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Equipos> e = equipoRepository.getEquipo(id);
        if(e.isPresent()){
            equipoRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

}

package Diseno_Creativo.ni_una_risa.service;

import Diseno_Creativo.ni_una_risa.entity.Equipos;
import Diseno_Creativo.ni_una_risa.repository.EquiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquiposServices {
    @Autowired
    private EquiposRepository equiposRepository;
    public List<Equipos> getAll(){
        return equiposRepository.findAll();
    }

    public Equipos save(Equipos fp){
        return equiposRepository.save(fp);
    }

    public Equipos get(Long id){
        Optional<Equipos> g= equiposRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            Equipos rta=new Equipos();
            //rta.setName("Paila!");
            return rta;
        }

    }
}

package Diseno_Creativo.ni_una_risa.service;

import Diseno_Creativo.ni_una_risa.entity.Cartas;
import Diseno_Creativo.ni_una_risa.entity.Equipos;
import Diseno_Creativo.ni_una_risa.repository.CartasRepository;
import Diseno_Creativo.ni_una_risa.repository.EquiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartasServices {
    @Autowired
    private CartasRepository cartasRepository;
    public List<Cartas> getAll(){
        return cartasRepository.findAll();
    }

    public Cartas save(Cartas fp){
        return cartasRepository.save(fp);
    }

    public Cartas get(Long id){
        Optional<Cartas> g= cartasRepository.findById(id);
        if(g.isPresent()){
            return g.get();
        }else{
            Cartas rta=new Cartas();
            //rta.setName("Paila!");
            return rta;
        }

    }
}

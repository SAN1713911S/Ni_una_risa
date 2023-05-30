package Diseno_Creativo.ni_una_risa.controller;

import Diseno_Creativo.ni_una_risa.entity.Cartas;
import Diseno_Creativo.ni_una_risa.entity.Equipos;
import Diseno_Creativo.ni_una_risa.service.CartasServices;
import Diseno_Creativo.ni_una_risa.service.EquiposServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartas")
public class ControllerCartas {
    @Autowired
    private CartasServices cartasServices;


    @GetMapping("/prueba")
    public  String prueba(){
        return  "<h1>Esto es un mensaje de prueba</h1>";
    }


    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/all")
    public List<Cartas> getAll(){
        return cartasServices.getAll();
    }



    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/save")
    public Cartas save(@RequestBody Cartas c){

        return cartasServices.save(c);
    }
}

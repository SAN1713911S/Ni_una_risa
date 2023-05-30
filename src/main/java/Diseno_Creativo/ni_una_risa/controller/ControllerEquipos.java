package Diseno_Creativo.ni_una_risa.controller;

import Diseno_Creativo.ni_una_risa.entity.Equipos;
import Diseno_Creativo.ni_una_risa.service.EquiposServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class ControllerEquipos {
    @Autowired
    private EquiposServices equiposServices;


    @GetMapping("/prueba")
    public  String prueba(){
        return  "<h1>Esto es un mensaje de prueba</h1>";
    }


    //Que me extariga todos en un archivo json estudiante
    @GetMapping("/all")
    public List<Equipos> getAll(){
        return equiposServices.getAll();
    }



    //Recibe un game via json y nos lo va a guardar estudiante
    @PostMapping("/save")
    public Equipos save(@RequestBody Equipos c){

        return equiposServices.save(c);
    }
}

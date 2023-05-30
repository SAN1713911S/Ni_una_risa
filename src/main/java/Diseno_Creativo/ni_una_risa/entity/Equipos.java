package Diseno_Creativo.ni_una_risa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer vida;



    @PrePersist
    private void asignaciones(){
        vida=100;

    }


}

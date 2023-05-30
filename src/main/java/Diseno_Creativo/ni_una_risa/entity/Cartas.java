package Diseno_Creativo.ni_una_risa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cartas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String penitencia;
    private Integer ataque;



}

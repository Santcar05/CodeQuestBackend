package com.codequest.codequest_backend.modelos;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "examenes")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoExamen tipo; // MODULO, CURSO

    // Para tipo CURSO (nullable para permitir tipo MODULO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Para tipo MODULO (nullable para permitir tipo CURSO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;

    @Column(nullable = false, length = 160)
    private String titulo;

    @Lob
    private String descripcion;

    private Integer tiempoLimiteMinutos;
}

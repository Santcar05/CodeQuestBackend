package com.codequest.codequest_backend.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "preguntas")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "examen_id", nullable = false)
    private Examen examen;

    @Lob
    @Column(nullable = false)
    private String enunciado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoPregunta tipo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal puntuacion;
}

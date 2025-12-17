package com.codequest.codequest_backend.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modulos")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional: el hijo apunta al padre
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Column(nullable = false, length = 160)
    private String titulo;

    @Lob
    private String descripcion;

    @Column(nullable = false)
    private Integer orden;
}

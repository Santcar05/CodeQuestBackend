package com.codequest.codequest_backend.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecciones")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modulo_id", nullable = false)
    private Modulo modulo;

    @Column(nullable = false, length = 160)
    private String titulo;

    @Column(length = 240)
    private String descripcionCorta;

    @Column(nullable = false)
    private Integer orden;
}


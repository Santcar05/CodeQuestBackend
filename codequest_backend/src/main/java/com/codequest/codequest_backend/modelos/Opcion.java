package com.codequest.codequest_backend.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "opciones")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    @Lob
    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private Boolean esCorrecta;
}

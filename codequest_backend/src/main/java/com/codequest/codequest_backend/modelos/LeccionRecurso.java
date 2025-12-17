package com.codequest.codequest_backend.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leccion_recursos")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class LeccionRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "leccion_id", nullable = false)
    private Leccion leccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoRecurso tipo; // LECTURA, AUDIO, VIDEO, CODING

    @Column(nullable = false, length = 160)
    private String titulo;

    @Lob
    private String contenidoTexto;

    private String urlRecurso;

    @Lob
    private String configuracionJson;
}


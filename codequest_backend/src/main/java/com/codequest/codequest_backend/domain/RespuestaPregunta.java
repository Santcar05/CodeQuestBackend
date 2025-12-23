package com.codequest.codequest_backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(
        name = "respuestas_pregunta",
        uniqueConstraints = @UniqueConstraint(name = "uk_intento_pregunta", columnNames = {"intento_id", "pregunta_id"})
)
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class RespuestaPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "intento_id", nullable = false)
    private IntentoExamen intento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    @Lob
    private String respuestaTexto;

    // Si fue opción múltiple/VF
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opcion_seleccionada_id")
    private Opcion opcionSeleccionada;

    @Column(precision = 10, scale = 2)
    private BigDecimal calificacionObtenida;
}

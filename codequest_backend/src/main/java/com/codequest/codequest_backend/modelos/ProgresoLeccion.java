package com.codequest.codequest_backend.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "progreso_lecciones",
        uniqueConstraints = @UniqueConstraint(name = "uk_usuario_leccion", columnNames = {"usuario_id", "leccion_id"})
)
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ProgresoLeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "leccion_id", nullable = false)
    private Leccion leccion;

    @Column(nullable = false)
    private Boolean completado;

    private LocalDateTime fechaCompletado;

    @Column(nullable = false)
    private Integer porcentaje; 

    private LocalDateTime ultimoAcceso;
}

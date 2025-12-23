package com.codequest.codequest_backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "usuario_logos",
        uniqueConstraints = @UniqueConstraint(name = "uk_usuario_logo", columnNames = {"usuario_id", "logo_id"})
)
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class UsuarioLogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "logo_id", nullable = false)
    private Logo logo;

    @Column(nullable = false)
    private LocalDateTime fechaObtenido;
}

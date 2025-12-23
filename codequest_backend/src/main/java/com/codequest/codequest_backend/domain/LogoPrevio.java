package com.codequest.codequest_backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "logo_previos",
        uniqueConstraints = @UniqueConstraint(name = "uk_logo_prev", columnNames = {"logo_id", "logo_previo_id"})
)
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class LogoPrevio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // logo que quieres desbloquear
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "logo_id", nullable = false)
    private Logo logo;

    // logo requerido previamente
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "logo_previo_id", nullable = false)
    private Logo logoPrevio;
}

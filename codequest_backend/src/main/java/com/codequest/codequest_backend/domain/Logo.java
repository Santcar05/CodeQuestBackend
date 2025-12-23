package com.codequest.codequest_backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logos")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Logo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 160, unique = true)
    private String titulo;

    @Lob
    private String descripcion;
}

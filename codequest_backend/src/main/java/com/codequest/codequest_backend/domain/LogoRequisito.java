package com.codequest.codequest_backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logo_requisitos")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class LogoRequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "logo_id", nullable = false)
    private Logo logo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private TipoRequisitoLogo tipoRequisito;

    @Lob
    @Column(nullable = false)
    private String detalle; 
    
    @Column(nullable = false)
    private Integer orden;
}

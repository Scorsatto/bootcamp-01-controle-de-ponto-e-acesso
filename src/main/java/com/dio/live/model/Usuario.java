package com.dio.live.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Usuario {

    private long id;
    private CategoriaUsuario categoriaUsuario;
    private String nome;
    private Empresa empresa;
    private NivelAcesso nivelAcesso;
    private JornadaTrabalho jornadaTrabalho;
    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;
}

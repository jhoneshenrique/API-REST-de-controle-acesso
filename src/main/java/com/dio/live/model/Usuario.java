package com.dio.live.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter //Anotacao do Lombok
@Setter //Lombok
@AllArgsConstructor //Lombok
@NoArgsConstructor
@EqualsAndHashCode
@Builder //Usado para teste de software ou assagem de dados
@Entity
public class Usuario {
    @Id
    private long id;
    @ManyToOne
    private CategoriaUsuario categoriaUsuario;
    private String nome;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private NivelAcesso nivelAcesso;
    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;
    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime fimJornada;
}

package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter //Anotacao do Lombok
@Setter //Lombok
@AllArgsConstructor //Lombok
@NoArgsConstructor
@EqualsAndHashCode
@Builder //Usado para teste de software ou assagem de dados
@Entity
public class Movimentacao {


    //Classe para tratar uma chave composta
    @AllArgsConstructor //Lombok
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovimentacaoId implements Serializable{
        private long idMovimento;
        private long idUsuario;
    }

    //Referencia a classe que foi criada
    @Id
    @EmbeddedId
    private MovimentacaoId id;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;
    @ManyToOne
    private Ocorrencia ocorrencia;
    @ManyToOne
    private Calendario calendario;
}



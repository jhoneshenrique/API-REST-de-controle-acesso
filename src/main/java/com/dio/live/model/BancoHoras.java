package com.dio.live.model;


import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter //Anotacao do Lombok
@Setter //Lombok
@AllArgsConstructor //Lombok
@NoArgsConstructor
@EqualsAndHashCode
@Builder //Usado para teste de software ou assagem de dados
@Entity
public class BancoHoras {

    //Classe para tratar uma chave composta
    @AllArgsConstructor //Lombok
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class BancoHorasId implements Serializable {
        private long bancoHorasId;
        private long idMovimentacao;
        private long idUsuario;
    }

    @Id
    @EmbeddedId
    private BancoHorasId id;

    private LocalDateTime dataTrabalhada;

    private BigDecimal quantidadeHoras;

    private BigDecimal saldoHoras;
}

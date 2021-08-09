package com.dio.live.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //Anotacao do Lombok
@Setter //Lombok
@AllArgsConstructor //Lombok
@NoArgsConstructor
@EqualsAndHashCode
@Builder //Usado para teste de software ou assagem de dados
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;
}

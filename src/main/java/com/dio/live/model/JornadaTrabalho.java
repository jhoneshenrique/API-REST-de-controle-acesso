package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;

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
@Audited /* Todas as entidades que possuem relacionamento com uma que esta sendo auditada, devem ser auditadas tambem*/
public class JornadaTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
}

package com.joelson.swarm.model.entity;

import com.joelson.swarm.model.enterprise.IEntity;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CURSOS_EVENTOS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoEvent implements IEntity<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 255, message = "Descrição não deve ser maior que 255 caracteres")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "HORARIO")
    private LocalDateTime horario;

    @Column(name = "user")
    private String user;

}

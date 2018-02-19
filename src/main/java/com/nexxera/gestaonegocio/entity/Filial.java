package com.nexxera.gestaonegocio.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter @ToString
public class Filial implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String cnpj;
    @OneToOne(targetEntity = Cidade.class)
    private Cidade cidade;
}

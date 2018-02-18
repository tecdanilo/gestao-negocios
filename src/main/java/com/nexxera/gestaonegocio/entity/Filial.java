package com.nexxera.gestaonegocio.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
public class Filial {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String cnpj;
    @OneToOne(targetEntity = Cidade.class)
    private Cidade cidade;
}

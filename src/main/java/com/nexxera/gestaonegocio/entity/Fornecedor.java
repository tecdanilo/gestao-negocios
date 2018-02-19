package com.nexxera.gestaonegocio.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @ToString
public class Fornecedor implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String razao;
}

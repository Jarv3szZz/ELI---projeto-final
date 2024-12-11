package com.senai.eli.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "grupo_trabalho")
@Entity
@Getter
@Setter
public class GrupoTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "responsavel", nullable = false)
    private String responsavel;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "grupos")
    private List<Evento> eventos = new ArrayList<>();
}

    


package com.senai.eli.Model;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Local")
@Entity
@Getter
@Setter
public class Local {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "referencia", nullable = false)
    private String referencia;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "numero")
    private int numero;

    @Column(name = "cep", nullable = false, length = 9)
    @Pattern (regexp = "\\d(5)-\\d(3)")
    private String cep;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<>();





}

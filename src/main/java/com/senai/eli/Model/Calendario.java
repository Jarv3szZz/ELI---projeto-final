package com.senai.eli.Model;


import java.time.LocalDate;
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

@Table(name = "calendario")
@Entity
@Setter
@Getter
public class Calendario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "data")
    private LocalDate data;
    
    @ManyToMany(mappedBy = "calendarios")
    private List<Evento> eventos = new ArrayList<>();
}

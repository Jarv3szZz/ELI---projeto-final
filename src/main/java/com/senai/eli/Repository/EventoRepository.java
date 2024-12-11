package com.senai.eli.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.eli.Model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}

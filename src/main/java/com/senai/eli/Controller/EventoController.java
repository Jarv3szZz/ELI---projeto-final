package com.senai.eli.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.senai.eli.Model.Evento;
import com.senai.eli.Repository.EventoRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;
    
    @GetMapping("/evento/criar")
    public String criar(){
        return "evento/criar";
    }

    @PostMapping("/evento/criar")
    public String criar(Evento ev){
        er.save(ev);
        return "redirect:/evento";
    }

    @GetMapping("/evento")
    public String listar(Model view){
        List<Evento> listaEventos = er.findAll();

        view.addAttribute("listaEventosNoFront", listaEventos);

        return "evento/listar";
    }

    @GetMapping("/evento/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        Evento evento;
        evento = er.findById(id).orElseThrow();

        model.addAttribute("evento", evento);
        return "evento/alterar";
    }    

    @PostMapping("/evento/alterar/{id}")
    public String alterar(@PathVariable Long id, Evento ev) {
        ev.setId(id);

        er.save(ev);
        
        return "redirect:/evento";
    }
    

}

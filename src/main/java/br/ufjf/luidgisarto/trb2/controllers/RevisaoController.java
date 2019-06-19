package br.ufjf.luidgisarto.trb2.controllers;

import br.ufjf.luidgisarto.trb2.models.Avaliador;
import br.ufjf.luidgisarto.trb2.models.Revisao;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import br.ufjf.luidgisarto.trb2.repositories.AvaliadorRepository;
import br.ufjf.luidgisarto.trb2.repositories.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("revisoes")
public class RevisaoController {

    @Autowired
    TrabalhoRepository trabalhoRepository;

    @Autowired
    AvaliadorRepository avaliadorRepository;

    @GetMapping("/revisar")
    public ModelAndView revisarTrabalho() {
        ModelAndView mv = new ModelAndView();

        List<Trabalho> trabalhos = trabalhoRepository.findAll();

        List<Avaliador> avaliadores = avaliadorRepository.findAll();

        Revisao revisao = new Revisao();

        mv.setViewName("revisao/revisar");

        mv.addObject("trabalhos", trabalhos);
        mv.addObject("avaliadores", avaliadores);
        mv.addObject("revisao", revisao);

        return mv;
    }
}

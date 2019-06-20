package br.ufjf.luidgisarto.trb2.controllers;

import br.ufjf.luidgisarto.trb2.models.Avaliador;
import br.ufjf.luidgisarto.trb2.models.Revisao;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import br.ufjf.luidgisarto.trb2.repositories.AvaliadorRepository;
import br.ufjf.luidgisarto.trb2.repositories.RevisaoRepository;
import br.ufjf.luidgisarto.trb2.repositories.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("revisoes")
public class RevisaoController {

    @Autowired
    TrabalhoRepository trabalhoRepository;

    @Autowired
    AvaliadorRepository avaliadorRepository;

    @Autowired
    RevisaoRepository revisaoRepository;

    @GetMapping("/revisar/{id}")
    public ModelAndView revisarTrabalho(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();

        List<Trabalho> trabalhos = trabalhoRepository.findAll();

        List<Avaliador> avaliadores = avaliadorRepository.findAll();

        Avaliador avaliador = avaliadores.get(0);

        Revisao revisao = new Revisao();

        mv.setViewName("revisao/revisar");

        mv.addObject("trabalhos", trabalhos);
        mv.addObject("avaliadores", avaliadores);
        mv.addObject("revisao", revisao);
        mv.addObject("avaliador", avaliador);

        return mv;
    }

    @PostMapping("avaliar")
    public ModelAndView salvarRevisao(@Valid Revisao revisao) {
        ModelAndView mv = new ModelAndView();

        revisaoRepository.save(revisao);

        mv.setViewName("redirect:/");
        return mv;
    }
}

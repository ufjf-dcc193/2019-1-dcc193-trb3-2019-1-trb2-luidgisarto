package br.ufjf.luidgisarto.trb2.controllers;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.models.Avaliador;
import br.ufjf.luidgisarto.trb2.repositories.AreaRepository;
import br.ufjf.luidgisarto.trb2.repositories.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/avaliadores")
public class AvaliadorController {

    @Autowired
    AvaliadorRepository avaliadorRepository;

    @Autowired
    AreaRepository areaRepository;

    @RequestMapping({ "/" })
    public ModelAndView listarAvaliadores() {

        List<Avaliador> avaliadores = avaliadorRepository.findAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliador/index");

        mv.addObject("avaliadores", avaliadores);

        return mv;
    }

    @RequestMapping("/novo-avaliador")
    public ModelAndView novoAvaliador() {
        ModelAndView mv = new ModelAndView();

        Avaliador avaliador = new Avaliador();

        List<Area> areas = areaRepository.findAll();

        mv.setViewName("avaliador/form");

        mv.addObject("avaliador", avaliador);
        mv.addObject("areas", areas);

        return mv;
    }

    @PostMapping("salvar")
    public ModelAndView salvarAvaliador(@Valid Avaliador avaliador, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()) {
            mv.setViewName("form");
            mv.addObject("avaliador", avaliador);
            return mv;
        }
        avaliadorRepository.save(avaliador);
        mv.setViewName("redirect:/avaliadores/");
        return mv;
    }
}

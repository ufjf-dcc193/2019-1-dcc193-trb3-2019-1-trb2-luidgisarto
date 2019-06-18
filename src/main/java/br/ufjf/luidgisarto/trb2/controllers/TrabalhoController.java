package br.ufjf.luidgisarto.trb2.controllers;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import br.ufjf.luidgisarto.trb2.repositories.AreaRepository;
import br.ufjf.luidgisarto.trb2.repositories.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("trabalhos")
public class TrabalhoController {

    @Autowired
    TrabalhoRepository trabalhoRepository;

    @Autowired
    AreaRepository areaRepository;

    @GetMapping("/")
    public ModelAndView listarTrabalhos() {
        ModelAndView mv = new ModelAndView();

        List<Trabalho> trabalhos = trabalhoRepository.findAll();

        mv.setViewName("trabalho/index");

        mv.addObject("trabalhos", trabalhos);

        return mv;
    }

    @RequestMapping("/novo-trabalho")
    public ModelAndView novoTrabalho() {
        ModelAndView mv = new ModelAndView();

        Trabalho trabalho = new Trabalho();

        List<Area> areas = areaRepository.findAll();

        mv.setViewName("trabalho/form");

        mv.addObject("trabalho", trabalho);
        mv.addObject("areas", areas);

        return mv;
    }

    @PostMapping("salvar")
    public ModelAndView salvarTrabalho(@Valid Trabalho trabalho, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()) {
            mv.setViewName("form");
            mv.addObject("trabalho", trabalho);
            return mv;
        }
        trabalhoRepository.save(trabalho);
        mv.setViewName("redirect:/trabalhos/");
        return mv;
    }

}

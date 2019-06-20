package br.ufjf.luidgisarto.trb2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import br.ufjf.luidgisarto.trb2.repositories.AreaRepository;
import br.ufjf.luidgisarto.trb2.repositories.TrabalhoRepository;

@Controller
@RequestMapping("areas")
public class AreaController {
    @Autowired
    AreaRepository areaRepository;

    @Autowired
    TrabalhoRepository trabalhoRepository;

    @GetMapping("/")
    public ModelAndView listarAreas() {
        ModelAndView mv = new ModelAndView();

        List<Area> areas = areaRepository.findAll();

        mv.setViewName("area/index");

        mv.addObject("areas", areas);

        return mv;
    }

    @GetMapping("/nova-area")
    public ModelAndView novoArea() {
        ModelAndView mv = new ModelAndView();

        Area area = new Area();

        mv.setViewName("form");

        mv.addObject("area", area);

        return mv;
    }

    @GetMapping("/detalhar/{id}")
    public ModelAndView buscarTrabalhosPorArea(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();

        Area area = areaRepository.getOne(id);

        List<Trabalho> trabalhosArea = trabalhoRepository
                .findAll();

        mv.setViewName("area/trabalho-area");

        mv.addObject("area", area);
        mv.addObject("trabalhos", trabalhosArea);

        return mv;
    }
}

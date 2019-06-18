package br.ufjf.luidgisarto.trb2.controllers;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("areas")
public class AreaController {
    @Autowired
    AreaRepository areaRepository;

    @GetMapping("/")
    public ModelAndView listarAreas() {
        ModelAndView mv = new ModelAndView();

        List<Area> areas = areaRepository.findAll();

        mv.setViewName("area/index");

        mv.addObject("areas", areas);

        return mv;
    }

    @RequestMapping("/nova-area")
    public ModelAndView novoArea() {
        ModelAndView mv = new ModelAndView();

        Area area = new Area();

        List<Area> areas = areaRepository.findAll();

        mv.setViewName("form");

        mv.addObject("area", area);

        return mv;
    }
}

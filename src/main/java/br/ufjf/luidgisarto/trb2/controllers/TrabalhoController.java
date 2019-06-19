package br.ufjf.luidgisarto.trb2.controllers;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.models.Revisao;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import br.ufjf.luidgisarto.trb2.repositories.AreaRepository;
import br.ufjf.luidgisarto.trb2.repositories.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/novo-trabalho")
    public ModelAndView novoTrabalho() {
        ModelAndView mv = new ModelAndView();

        Trabalho trabalho = new Trabalho();

        List<Area> areas = areaRepository.findAll();

        mv.setViewName("trabalho/form");

        mv.addObject("trabalho", trabalho);
        mv.addObject("opcoes", areas);

        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarTrabalho(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();

        Trabalho trabalho = trabalhoRepository.getOne(id);

        List<Area> areas = areaRepository.findAll();

        mv.setViewName("trabalho/form");

        mv.addObject("trabalho", trabalho);
        mv.addObject("opcoes", areas);

        return mv;
    }

    @GetMapping("/revisar/{id}")
    public ModelAndView revisarTrabalho(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();

        Trabalho trabalho = trabalhoRepository.getOne(id);

        List<Area> areas = areaRepository.findAll();

        Revisao revisao = new Revisao();

        mv.setViewName("trabalho/revisar");

        mv.addObject("trabalho", trabalho);
        mv.addObject("opcoes", areas);
        mv.addObject("revisao", revisao);

        return mv;
    }

    @GetMapping("/excluir/{id}")
    public RedirectView excluirTrabalho(@PathVariable Long id) {
        Trabalho trabalho = trabalhoRepository.getOne(id);
        trabalhoRepository.delete(trabalho);
        return new RedirectView("/trabalhos/");
    }

    @PostMapping("/salvar")
    public ModelAndView salvarTrabalho(@Valid Trabalho trabalho, BindingResult binding) {
        ModelAndView mv = new ModelAndView();

        List<Area> areas = areaRepository.findAll();

        mv.addObject("opcoes", areas);

        if(binding.hasErrors()) {
            mv.setViewName("trabalho/form");
            mv.addObject("trabalho", trabalho);
            return mv;
        }
        trabalhoRepository.save(trabalho);
        mv.setViewName("redirect:/trabalhos/");
        return mv;
    }

    @GetMapping("/revisar-depois/{id}")
    public RedirectView revisarDepois(@PathVariable Long id) {
        return new RedirectView("/trabalhos/");
    }

    @GetMapping("/revisar-agora/{id}")
    public RedirectView revisarAgora(@PathVariable Long id) {
        return new RedirectView("/trabalhos/");
    }

    @GetMapping("/pular-revisao/{id}")
    public RedirectView pularRevisao(@PathVariable Long id) {
        return new RedirectView("/trabalhos/");
    }

}

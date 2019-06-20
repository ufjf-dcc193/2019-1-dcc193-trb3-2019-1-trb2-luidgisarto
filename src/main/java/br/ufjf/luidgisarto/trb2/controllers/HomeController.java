package br.ufjf.luidgisarto.trb2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.luidgisarto.trb2.enums.SituacaoRevisao;
import br.ufjf.luidgisarto.trb2.models.Avaliador;
import br.ufjf.luidgisarto.trb2.models.Revisao;
import br.ufjf.luidgisarto.trb2.repositories.AvaliadorRepository;
import br.ufjf.luidgisarto.trb2.repositories.RevisaoRepository;

@Controller
public class HomeController {

    @Autowired
    RevisaoRepository revisaoRepository;

    @Autowired
    AvaliadorRepository avaliadorRepository;

    @RequestMapping({ "/"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();

        Avaliador avaliador = avaliadorRepository.findAll().get(0);

        List<Revisao> revisoes = revisaoRepository.findAllByAvaliadorAndSituacao(avaliador, SituacaoRevisao.Avaliado);

        // List<Revisao> revisoes = revisaoRepository.findAllByAvaliadorAndSituacao(avaliador, 
        // SituacaoRevisao.Avaliado);

        mv.setViewName("index");

        mv.addObject("revisoes", revisoes);
        return mv;
    }
}

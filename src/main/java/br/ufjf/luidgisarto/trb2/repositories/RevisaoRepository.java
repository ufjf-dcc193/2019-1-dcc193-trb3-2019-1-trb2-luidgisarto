package br.ufjf.luidgisarto.trb2.repositories;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.luidgisarto.trb2.enums.SituacaoRevisao;
import br.ufjf.luidgisarto.trb2.models.Avaliador;
import br.ufjf.luidgisarto.trb2.models.Revisao;

@Repository
public interface RevisaoRepository extends JpaRepository<Revisao, Integer> {
    List<Revisao> findAllByAvaliadorAndSituacao(Avaliador avaliador, SituacaoRevisao situacao);
}

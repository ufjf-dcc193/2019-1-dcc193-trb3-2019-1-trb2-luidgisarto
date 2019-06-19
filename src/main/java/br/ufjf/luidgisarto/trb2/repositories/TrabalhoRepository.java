package br.ufjf.luidgisarto.trb2.repositories;

import br.ufjf.luidgisarto.trb2.dtos.TrabalhoAreaDto;
import br.ufjf.luidgisarto.trb2.enums.SituacaoRevisao;
import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Integer> {
    @Query("select new " +
            "br.ufjf.luidgisarto.trb2.dtos.TrabalhoAreaDto(count(r.id)," +
            "t.titulo, t.descricao, t.url) " +
            "from Trabalho t " +
            "join t.revisoes r " +
            "where t.area = :area " +
            "and r.id = :situacao " +
            "order by t.id")
    List<TrabalhoAreaDto> obterTrabalhosPorArea(@Param("area")Area area,
                                                @Param("situacao") Integer situacao);
}

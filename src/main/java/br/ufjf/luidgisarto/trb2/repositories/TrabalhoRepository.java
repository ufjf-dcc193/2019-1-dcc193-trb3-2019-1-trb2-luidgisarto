package br.ufjf.luidgisarto.trb2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.luidgisarto.trb2.models.Trabalho;


@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Integer> {
//     @Query("select new " +
//             "br.ufjf.luidgisarto.trb2.dtos.TrabalhoAreaDto(count(r.id)," +
//             "t.titulo, t.descricao, t.url) " +
//             "from Trabalho t " +
//             "left join t.revisoes r " +
//             "where t.area = :area " +
//             "and r.id = :situacao " +
//             "order by t.id asc")
//     List<TrabalhoAreaDto> obterTrabalhosPorArea(@Param("area")Area area,
//                                                 @Param("situacao") Integer situacao);
}

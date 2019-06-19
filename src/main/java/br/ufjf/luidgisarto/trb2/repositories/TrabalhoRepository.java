package br.ufjf.luidgisarto.trb2.repositories;

import br.ufjf.luidgisarto.trb2.models.Area;
import br.ufjf.luidgisarto.trb2.models.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
    List<Trabalho> findByAreaOrderByIdAsc(Area area);
}

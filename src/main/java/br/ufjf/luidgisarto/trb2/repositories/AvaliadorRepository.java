package br.ufjf.luidgisarto.trb2.repositories;

import br.ufjf.luidgisarto.trb2.models.Avaliador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliadorRepository extends JpaRepository<Avaliador, Integer> {

}

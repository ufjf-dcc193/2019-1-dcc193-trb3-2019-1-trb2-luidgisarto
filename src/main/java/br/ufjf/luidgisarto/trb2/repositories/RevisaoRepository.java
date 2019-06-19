package br.ufjf.luidgisarto.trb2.repositories;

import br.ufjf.luidgisarto.trb2.models.Revisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisaoRepository extends JpaRepository<Revisao, Integer> {

}

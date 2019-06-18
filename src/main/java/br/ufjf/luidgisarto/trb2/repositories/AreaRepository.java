package br.ufjf.luidgisarto.trb2.repositories;

import br.ufjf.luidgisarto.trb2.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}

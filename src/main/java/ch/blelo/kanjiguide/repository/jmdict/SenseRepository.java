package ch.blelo.kanjiguide.repository.jmdict;

import ch.blelo.kanjiguide.model.entity.jmdict.Sense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenseRepository extends JpaRepository<Sense, Long> {
}
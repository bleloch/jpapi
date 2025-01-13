package ch.blelo.jpapi.repository.kanjidic2;

import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Codepoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Kanjidic2CodepointRepository extends JpaRepository<Kanjidic2Codepoint, Long> {
}
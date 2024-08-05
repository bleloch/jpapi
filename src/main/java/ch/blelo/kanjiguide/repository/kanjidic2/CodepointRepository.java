package ch.blelo.kanjiguide.repository.kanjidic2;

import ch.blelo.kanjiguide.model.entity.kanjidic2.Codepoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodepointRepository extends JpaRepository<Codepoint, Long> {
}
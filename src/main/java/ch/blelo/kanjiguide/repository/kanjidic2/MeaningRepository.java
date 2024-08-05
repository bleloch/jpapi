package ch.blelo.kanjiguide.repository.kanjidic2;

import ch.blelo.kanjiguide.model.entity.kanjidic2.Meaning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeaningRepository extends JpaRepository<Meaning, Long> {
}
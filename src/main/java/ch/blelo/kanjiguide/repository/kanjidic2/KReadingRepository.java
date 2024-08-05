package ch.blelo.kanjiguide.repository.kanjidic2;

import ch.blelo.kanjiguide.model.entity.kanjidic2.KReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KReadingRepository extends JpaRepository<KReading, Long> {
}
package ch.blelo.kanjiguide.repository.kanjidic2;

import ch.blelo.kanjiguide.model.entity.kanjidic2.Radical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadicalRepository extends JpaRepository<Radical, Long> {
}
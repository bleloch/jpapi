package ch.blelo.kanjiguide.repository.kanjidic2;

import ch.blelo.kanjiguide.model.entity.kanjidic2.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant, Long> {
}
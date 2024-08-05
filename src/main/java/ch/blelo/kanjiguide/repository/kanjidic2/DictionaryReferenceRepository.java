package ch.blelo.kanjiguide.repository.kanjidic2;

import ch.blelo.kanjiguide.model.entity.kanjidic2.DictionaryReference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryReferenceRepository extends JpaRepository<DictionaryReference, Long> {
}
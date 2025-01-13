package ch.blelo.jpapi.repository.kanjidic2;

import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2DictionaryReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Kanjidic2DictionaryReferenceRepository extends JpaRepository<Kanjidic2DictionaryReference, Long> {
}
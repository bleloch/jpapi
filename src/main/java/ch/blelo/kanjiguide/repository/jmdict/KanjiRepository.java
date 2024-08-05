package ch.blelo.kanjiguide.repository.jmdict;

import ch.blelo.kanjiguide.model.entity.jmdict.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long> {
}
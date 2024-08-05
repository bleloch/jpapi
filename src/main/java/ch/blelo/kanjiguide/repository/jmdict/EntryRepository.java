package ch.blelo.kanjiguide.repository.jmdict;

import ch.blelo.kanjiguide.model.entity.jmdict.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByKanjiElementIgnoreCase(String element);
    List<Entry> findByReadingsElementIgnoreCase(String element);
    List<Entry> findBySensesGlossesElementIgnoreCase(String element);
}

package ch.blelo.jpapi.repository.jmdict;

import ch.blelo.jpapi.model.entity.jmdict.JMDictEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JMDictEntryRepository extends JpaRepository<JMDictEntry, Long> {
    List<JMDictEntry> findByKanjiElementIgnoreCase(String element);

    List<JMDictEntry> findByReadingsElementIgnoreCase(String element);

    List<JMDictEntry> findBySensesGlossesElementIgnoreCase(String element);
}
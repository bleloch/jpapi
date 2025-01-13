package ch.blelo.jpapi.repository.jmnedict;

import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JMNEDictEntryRepository extends JpaRepository<JMNEDictEntry, Long> {
    List<JMNEDictEntry> findByKanjiElementIgnoreCase(String element);
}

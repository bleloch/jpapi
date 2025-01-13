package ch.blelo.jpapi.repository.jmnedict;

import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictKanji;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JMNEDictKanjiRepository extends JpaRepository<JMNEDictKanji, Long> {
}

package ch.blelo.jpapi.repository.jmnedict;

import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictReadingFurigana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMNEDictReadingFuriganaRepository extends JpaRepository<JMNEDictReadingFurigana, Long> {
}

package ch.blelo.jpapi.repository.jmnedict;

import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JMNEDictTranslationRepository extends JpaRepository<JMNEDictTranslation, Long> {
}

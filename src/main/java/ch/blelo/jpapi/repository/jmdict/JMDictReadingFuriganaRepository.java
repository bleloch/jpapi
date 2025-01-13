package ch.blelo.jpapi.repository.jmdict;

import ch.blelo.jpapi.model.entity.jmdict.JMDictReadingFurigana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMDictReadingFuriganaRepository extends JpaRepository<JMDictReadingFurigana, Long> {
}

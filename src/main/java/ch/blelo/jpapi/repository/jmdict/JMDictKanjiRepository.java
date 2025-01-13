package ch.blelo.jpapi.repository.jmdict;

import ch.blelo.jpapi.model.entity.jmdict.JMDictKanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMDictKanjiRepository extends JpaRepository<JMDictKanji, Long> {
}
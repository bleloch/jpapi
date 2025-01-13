package ch.blelo.jpapi.repository.jmdict;

import ch.blelo.jpapi.model.entity.jmdict.JMDictGloss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMDictGlossRepository extends JpaRepository<JMDictGloss, Long> {
}
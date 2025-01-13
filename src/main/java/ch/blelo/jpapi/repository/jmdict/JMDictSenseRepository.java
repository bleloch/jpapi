package ch.blelo.jpapi.repository.jmdict;

import ch.blelo.jpapi.model.entity.jmdict.JMDictSense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMDictSenseRepository extends JpaRepository<JMDictSense, Long> {
}
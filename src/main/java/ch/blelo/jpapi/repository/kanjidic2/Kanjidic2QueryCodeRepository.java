package ch.blelo.jpapi.repository.kanjidic2;

import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2QueryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Kanjidic2QueryCodeRepository extends JpaRepository<Kanjidic2QueryCode, Long> {
}
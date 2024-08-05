package ch.blelo.kanjiguide.repository.kanjidic2;

import ch.blelo.kanjiguide.model.entity.kanjidic2.QueryCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryCodeRepository extends JpaRepository<QueryCode, Long> {
}
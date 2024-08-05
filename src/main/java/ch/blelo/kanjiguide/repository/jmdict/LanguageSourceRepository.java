package ch.blelo.kanjiguide.repository.jmdict;

import ch.blelo.kanjiguide.model.entity.jmdict.LoanwordSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageSourceRepository extends JpaRepository<LoanwordSource, Long> {
}
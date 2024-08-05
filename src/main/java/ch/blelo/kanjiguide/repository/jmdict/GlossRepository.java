package ch.blelo.kanjiguide.repository.jmdict;

import ch.blelo.kanjiguide.model.entity.jmdict.Gloss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlossRepository extends JpaRepository<Gloss, Long> {
}
package ch.blelo.jpapi.repository.kanjidic2;

import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Kanjidic2CharacterRepository extends JpaRepository<Kanjidic2Character, Long> {
    List<Kanjidic2Character> findByLiteral(String characterName);
    List<Kanjidic2Character> findByLiteralIn(List<String> characterNames);
}
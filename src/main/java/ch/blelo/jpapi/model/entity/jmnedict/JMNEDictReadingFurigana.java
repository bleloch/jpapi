package ch.blelo.jpapi.model.entity.jmnedict;

import ch.blelo.jpapi.model.entity.common.WithFurigana;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "jmned_reading_fg")
@SuperBuilder
@NoArgsConstructor
public class JMNEDictReadingFurigana extends WithFurigana<JMNEDictReading> {
}

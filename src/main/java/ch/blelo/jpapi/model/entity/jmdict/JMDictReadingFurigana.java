package ch.blelo.jpapi.model.entity.jmdict;

import ch.blelo.jpapi.model.entity.common.WithFurigana;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "jmd_reading_fg")
@NoArgsConstructor
@SuperBuilder
public class JMDictReadingFurigana extends WithFurigana<JMDictReading> {
}

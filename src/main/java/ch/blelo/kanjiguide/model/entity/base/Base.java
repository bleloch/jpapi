package ch.blelo.kanjiguide.model.entity.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
}

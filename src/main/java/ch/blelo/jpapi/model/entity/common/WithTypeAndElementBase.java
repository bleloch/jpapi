package ch.blelo.jpapi.model.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public abstract class WithTypeAndElementBase extends Base {
    @Column(name = "element")
    public String element;

    @Column(name = "type")
    public String type;
}

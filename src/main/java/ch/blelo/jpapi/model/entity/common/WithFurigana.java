package ch.blelo.jpapi.model.entity.common;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public abstract class WithFurigana<T> extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reading_id", nullable = false)
    public T readingId;

    @Column(name = "char", nullable = false)
    public String character;

    @Column(name = "reading")
    public String reading;

    @Column(name = "pos", nullable = false)
    public Integer position;
}

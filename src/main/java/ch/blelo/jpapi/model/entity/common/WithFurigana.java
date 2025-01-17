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
    public T reading;

    @Column(name = "element", nullable = false)
    public String element;

    @Column(name = "kana")
    public String kana;

    @Column(name = "pos", nullable = false)
    public Integer position;
}

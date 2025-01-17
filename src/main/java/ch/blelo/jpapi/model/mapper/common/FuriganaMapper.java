package ch.blelo.jpapi.model.mapper.common;

import ch.blelo.jpapi.model.dto.common.FuriganaDto;
import org.mapstruct.*;

public interface FuriganaMapper<T> {
    T toEntity(FuriganaDto furiganaDto);

    FuriganaDto toDto(T furigana);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    T partialUpdate(FuriganaDto furiganaDto, @MappingTarget T furigana);
}
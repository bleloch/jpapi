package ch.blelo.kanjiguide.model.mapper.jmdict;

import ch.blelo.kanjiguide.model.dto.jmdict.KanjiDto;
import ch.blelo.kanjiguide.model.entity.jmdict.Kanji;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface KanjiMapper {
    Kanji toEntity(KanjiDto kanjiDto);

    KanjiDto toDto(Kanji kanji);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanji partialUpdate(KanjiDto kanjiDto, @MappingTarget Kanji kanji);
}
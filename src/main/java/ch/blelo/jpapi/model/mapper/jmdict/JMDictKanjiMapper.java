package ch.blelo.jpapi.model.mapper.jmdict;

import ch.blelo.jpapi.model.dto.common.KanjiDto;
import ch.blelo.jpapi.model.entity.jmdict.JMDictKanji;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMDictKanjiMapper {
    JMDictKanji toEntity(KanjiDto kanjiDto);

    KanjiDto toDto(JMDictKanji kanji);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMDictKanji partialUpdate(KanjiDto kanjiDto, @MappingTarget JMDictKanji kanji);
}
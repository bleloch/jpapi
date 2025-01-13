package ch.blelo.jpapi.model.mapper.jmnedict;

import ch.blelo.jpapi.model.dto.common.KanjiDto;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictKanji;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMNEDictKanjiMapper {
    JMNEDictKanji toEntity(KanjiDto kanjiDto);

    KanjiDto toDto(JMNEDictKanji kanji);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMNEDictKanji partialUpdate(KanjiDto kanjiDto, @MappingTarget JMNEDictKanji kanji);
}
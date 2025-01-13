package ch.blelo.jpapi.model.mapper.jmnedict;

import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictTranslationDto;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictTranslation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMNEDictTranslationMapper {
    JMNEDictTranslation toEntity(JMNEDictTranslationDto translationDto);

    JMNEDictTranslationDto toDto(JMNEDictTranslation translation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMNEDictTranslation partialUpdate(JMNEDictTranslationDto translationDto, @MappingTarget JMNEDictTranslation translation);
}
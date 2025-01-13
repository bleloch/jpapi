package ch.blelo.jpapi.model.mapper.jmnedict;

import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictTranslationDetailDto;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictTranslationDetail;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMNEDictTranslationDetailMapper {
    JMNEDictTranslationDetail toEntity(JMNEDictTranslationDetailDto translationDetailDto);

    JMNEDictTranslationDetailDto toDto(JMNEDictTranslationDetail translationDetail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMNEDictTranslationDetail partialUpdate(JMNEDictTranslationDetailDto translationDetailDto, @MappingTarget JMNEDictTranslationDetail translationDetail);
}
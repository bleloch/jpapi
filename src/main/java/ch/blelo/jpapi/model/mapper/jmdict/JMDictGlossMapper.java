package ch.blelo.jpapi.model.mapper.jmdict;

import ch.blelo.jpapi.model.dto.jmdict.JMDictGlossDto;
import ch.blelo.jpapi.model.entity.jmdict.JMDictGloss;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMDictGlossMapper {
    JMDictGloss toEntity(JMDictGlossDto glossDto);

    JMDictGlossDto toDto(JMDictGloss gloss);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMDictGloss partialUpdate(JMDictGlossDto glossDto, @MappingTarget JMDictGloss gloss);
}
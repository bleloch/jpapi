package ch.blelo.jpapi.model.mapper.jmdict;

import ch.blelo.jpapi.model.dto.jmdict.JMDictSenseDto;
import ch.blelo.jpapi.model.entity.jmdict.JMDictSense;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMDictSenseMapper {
    JMDictSense toEntity(JMDictSenseDto senseDto);

    JMDictSenseDto toDto(JMDictSense sense);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMDictSense partialUpdate(JMDictSenseDto senseDto, @MappingTarget JMDictSense sense);
}
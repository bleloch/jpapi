package ch.blelo.jpapi.model.mapper.jmnedict;

import ch.blelo.jpapi.model.dto.common.ReadingDto;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictReading;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMNEDictReadingMapper {
    JMNEDictReading toEntity(ReadingDto readingDto);

    ReadingDto toDto(JMNEDictReading reading);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMNEDictReading partialUpdate(ReadingDto readingDto, @MappingTarget JMNEDictReading reading);
}
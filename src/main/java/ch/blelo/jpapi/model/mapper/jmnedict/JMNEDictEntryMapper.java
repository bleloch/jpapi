package ch.blelo.jpapi.model.mapper.jmnedict;

import ch.blelo.jpapi.model.dto.common.ReadingDto;
import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictEntryDto;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictEntry;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictReading;
import ch.blelo.jpapi.model.mapper.common.WithKanjidic2Mapper;
import org.mapstruct.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class JMNEDictEntryMapper extends WithKanjidic2Mapper {
    public abstract JMNEDictEntry toEntity(JMNEDictEntryDto entryDto);

    public abstract JMNEDictEntryDto toDto(JMNEDictEntry entry);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract JMNEDictEntry partialUpdate(JMNEDictEntryDto entryDto, @MappingTarget JMNEDictEntry entry);
}
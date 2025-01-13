package ch.blelo.jpapi.model.mapper.jmdict;

import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.entity.jmdict.JMDictEntry;
import ch.blelo.jpapi.model.mapper.common.WithLinkedKanjidic2Character;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class JMDictEntryMapper extends WithLinkedKanjidic2Character {
    abstract JMDictEntry toEntity(JMDictEntryDto entryDto);

    public abstract JMDictEntryDto toDto(JMDictEntry entry);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract JMDictEntry partialUpdate(JMDictEntryDto entryDto, @MappingTarget JMDictEntry entry);
}
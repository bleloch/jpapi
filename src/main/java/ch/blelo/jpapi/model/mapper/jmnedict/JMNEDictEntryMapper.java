package ch.blelo.jpapi.model.mapper.jmnedict;

import ch.blelo.jpapi.model.dto.common.ReadingDto;
import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictEntryDto;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictEntry;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictReading;
import ch.blelo.jpapi.model.mapper.common.WithLinkedKanjidic2Character;
import org.mapstruct.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class JMNEDictEntryMapper extends WithLinkedKanjidic2Character {
    public abstract JMNEDictEntry toEntity(JMNEDictEntryDto entryDto);

    public abstract JMNEDictEntryDto toDto(JMNEDictEntry entry);

    protected JMNEDictReading readingDtoToJMNEDictReading(ReadingDto readingDto) {
        if ( readingDto == null ) {
            return null;
        }

        JMNEDictReading.JMNEDictReadingBuilder<?, ?> jMNEDictReading = JMNEDictReading.builder();

        jMNEDictReading.id( readingDto.id() );
        jMNEDictReading.element( readingDto.element() );
        Set<String> set = readingDto.readingInformation();
        if ( set != null ) {
            jMNEDictReading.readingInformation( new LinkedHashSet<String>( set ) );
        }
        Set<String> set1 = readingDto.priorityInformation();
        if ( set1 != null ) {
            jMNEDictReading.priorityInformation( new LinkedHashSet<String>( set1 ) );
        }

        return jMNEDictReading.build();
    }

    protected ReadingDto jMNEDictReadingToReadingDto(JMNEDictReading jMNEDictReading) {
        if ( jMNEDictReading == null ) {
            return null;
        }

        ReadingDto.ReadingDtoBuilder readingDto = ReadingDto.builder();

        readingDto.id( jMNEDictReading.id );
        readingDto.element( jMNEDictReading.element );
        Set<String> set = jMNEDictReading.readingInformation;
        if ( set != null ) {
            readingDto.readingInformation( new LinkedHashSet<String>( set ) );
        }
        Set<String> set1 = jMNEDictReading.priorityInformation;
        if ( set1 != null ) {
            readingDto.priorityInformation( new LinkedHashSet<String>( set1 ) );
        }

        return readingDto.build();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract JMNEDictEntry partialUpdate(JMNEDictEntryDto entryDto, @MappingTarget JMNEDictEntry entry);
}
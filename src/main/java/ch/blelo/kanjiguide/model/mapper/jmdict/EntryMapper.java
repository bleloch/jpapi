package ch.blelo.kanjiguide.model.mapper.jmdict;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.entity.jmdict.Entry;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EntryMapper {
    Entry toEntity(EntryDto entryDto);

    EntryDto toDto(Entry entry);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Entry partialUpdate(EntryDto entryDto, @MappingTarget Entry entry);
}
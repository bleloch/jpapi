package ch.blelo.kanjiguide.model.mapper.jmdict;

import ch.blelo.kanjiguide.model.dto.jmdict.GlossDto;
import ch.blelo.kanjiguide.model.entity.jmdict.Gloss;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GlossMapper {
    Gloss toEntity(GlossDto glossDto);

    GlossDto toDto(Gloss gloss);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Gloss partialUpdate(GlossDto glossDto, @MappingTarget Gloss gloss);
}
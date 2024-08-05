package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.SemanticGroupDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.SemanticGroup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SemanticGroupMapper {
    SemanticGroup toEntity(SemanticGroupDto SemanticGroupDto);

    @AfterMapping
    default void linkReadings(@MappingTarget SemanticGroup semanticGroup) {
        semanticGroup.readings.forEach(reading -> reading.semanticGroup = semanticGroup);
    }

    @AfterMapping
    default void linkMeanings(@MappingTarget SemanticGroup semanticGroup) {
        semanticGroup.meanings.forEach(meaning -> meaning.semanticGroup = semanticGroup);
    }

    SemanticGroupDto toDto(SemanticGroup SemanticGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SemanticGroup partialUpdate(SemanticGroupDto SemanticGroupDto, @MappingTarget SemanticGroup SemanticGroup);
}
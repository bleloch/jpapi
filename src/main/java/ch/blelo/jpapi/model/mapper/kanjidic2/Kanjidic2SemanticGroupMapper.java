package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2SemanticGroupDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2SemanticGroup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2SemanticGroupMapper {
    Kanjidic2SemanticGroup toEntity(Kanjidic2SemanticGroupDto SemanticGroupDto);

    @AfterMapping
    default void linkReadings(@MappingTarget Kanjidic2SemanticGroup semanticGroup) {
        semanticGroup.readings.forEach(reading -> reading.semanticGroup = semanticGroup);
    }

    @AfterMapping
    default void linkMeanings(@MappingTarget Kanjidic2SemanticGroup semanticGroup) {
        semanticGroup.meanings.forEach(meaning -> meaning.semanticGroup = semanticGroup);
    }

    Kanjidic2SemanticGroupDto toDto(Kanjidic2SemanticGroup SemanticGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2SemanticGroup partialUpdate(Kanjidic2SemanticGroupDto SemanticGroupDto, @MappingTarget Kanjidic2SemanticGroup SemanticGroup);
}
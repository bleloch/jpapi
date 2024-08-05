package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Character;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacterMapper {

    @Mapping(source = "metadata.frequency", target = "frequency")
    @Mapping(source = "metadata.schoolGrade", target = "schoolGrade")
    @Mapping(source = "metadata.jlptGrade", target = "jlptGrade")
    @Mapping(source = "metadata.strokeCount", target = "strokeCount")
    @Mapping(source = "metadata.variants", target = "variants")
    @Mapping(source = "metadata.radicalNames", target = "radicalNames")
    @Mapping(source = "semantics.semanticGroups", target = "semanticGroups")
    @Mapping(source = "semantics.nanori", target = "nanori")
    Character toEntity(CharacterDto characterDto);

    @Mapping(source = "frequency", target = "metadata.frequency")
    @Mapping(source = "schoolGrade", target = "metadata.schoolGrade")
    @Mapping(source = "jlptGrade", target = "metadata.jlptGrade")
    @Mapping(source = "strokeCount", target = "metadata.strokeCount")
    @Mapping(source = "variants", target = "metadata.variants")
    @Mapping(source = "radicalNames", target = "metadata.radicalNames")
    @Mapping(source = "semanticGroups", target = "semantics.semanticGroups")
    @Mapping(source = "nanori", target = "semantics.nanori")
    CharacterDto toDto(Character character);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Character partialUpdate(CharacterDto characterDto, @MappingTarget Character character);
}
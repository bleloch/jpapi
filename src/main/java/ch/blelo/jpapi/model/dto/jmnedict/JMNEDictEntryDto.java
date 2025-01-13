package ch.blelo.jpapi.model.dto.jmnedict;

import ch.blelo.jpapi.model.dto.common.KanjiDto;
import ch.blelo.jpapi.model.dto.common.ReadingDto;
import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CharacterDto;
import ch.blelo.jpapi.model.dto.serde.JMNEDictSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonSerialize(using = JMNEDictSerializer.class)
public record JMNEDictEntryDto(
    @JsonIgnore
    long id,

    @JacksonXmlProperty(localName = "k_ele")
    @JacksonXmlElementWrapper(useWrapping = false)
    Set<KanjiDto> kanji,

    @JacksonXmlProperty(localName = "r_ele")
    @NotEmpty(message = "Must be at least one reading element")
    @JacksonXmlElementWrapper(useWrapping = false)
    Set<ReadingDto> readings,

    @JacksonXmlProperty(localName = "trans")
    @NotEmpty(message = "Must be at least one trans element")
    @JacksonXmlElementWrapper(useWrapping = false)
    Set<JMNEDictTranslationDto> translations,

    Set<Kanjidic2CharacterDto> linkedCharacters
) {
}

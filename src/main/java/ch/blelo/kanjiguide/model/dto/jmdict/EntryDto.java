package ch.blelo.kanjiguide.model.dto.jmdict;

import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.model.dto.serde.EntrySerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Entries consist of kanji elements, reading elements,
 * general information and sense elements.</p>
 * <p>Each entry must have at least one reading element and
 * one sense element. Others are optional.</p>
 *
 * @param entrySequence <p>A unique numeric sequence number for each entry.</p>
 * @param kanji <p>See {@link KanjiDto}</p>
 * @param readings <p>See {@link ReadingDto}</p>
 * @param senses <p>See {@link SenseDto}</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonSerialize(using = EntrySerializer.class)
public record EntryDto(
        long id,

        @JacksonXmlProperty(localName = "ent_seq")
        long entrySequence,

        @JacksonXmlProperty(localName = "k_ele")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<KanjiDto> kanji,

        @JacksonXmlProperty(localName = "r_ele")
        @NotEmpty(message = "Must be at least one reading element")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<ReadingDto> readings,

        @JacksonXmlProperty(localName = "sense")
        @NotEmpty(message = "Must be at least one sense element")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<SenseDto> senses,

        Set<CharacterDto> linkedCharacters
) {
        public static class EntryDtoBuilder {
                private Set<KanjiDto> kanji = new HashSet<>();
                private Set<ReadingDto> readings = new HashSet<>();
                private Set<SenseDto> senses = new HashSet<>();
        }
}

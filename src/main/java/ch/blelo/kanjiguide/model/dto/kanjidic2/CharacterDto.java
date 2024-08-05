package ch.blelo.kanjiguide.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CharacterDto(
        //@JacksonXmlProperty(localName = "literal")
        String literal,

        //@JacksonXmlElementWrapper(localName = "codepoint")
        Set<CodepointDto> codepoints,

        //@JacksonXmlElementWrapper(localName = "radical")
        Set<RadicalDto> radicals,

        //@JacksonXmlProperty(localName = "misc")
        MetadataDto metadata,

        //@JacksonXmlElementWrapper(localName = "dic_number")
        Set<DictionaryReferenceDto> dictionaryReferences,

        //@JacksonXmlElementWrapper(localName = "query_code")
        Set<QueryCodeDto> queryCodes,

        //@JacksonXmlProperty(localName = "reading_meaning")
        SemanticsDto semantics
) {
}

package ch.blelo.jpapi.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record Kanjidic2SemanticGroupDto(
        @JsonIgnore
        long id,

        @JacksonXmlProperty(localName = "reading")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<Kanjidic2ReadingDto> readings,

        @JacksonXmlProperty(localName = "meaning")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<Kanjidic2MeaningDto> meanings
) {
}

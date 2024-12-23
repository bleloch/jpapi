package ch.blelo.kanjiguide.model.dto.kanjidic2;

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
public record SemanticsDto(
        long id,

        @JacksonXmlProperty(localName = "rmgroup")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<SemanticGroupDto> semanticGroups,

        @JacksonXmlProperty(localName = "nanori")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> nanori
) {
}

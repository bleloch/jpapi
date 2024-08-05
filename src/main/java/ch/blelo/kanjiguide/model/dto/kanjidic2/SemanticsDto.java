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
public record SemanticsDto(
        //@JacksonXmlProperty(localName = "rmgroup")
        //@JacksonXmlElementWrapper(useWrapping = false)
        Set<SemanticGroupDto> semanticGroups,

        //@JacksonXmlProperty(localName = "nanori")
        //@JacksonXmlElementWrapper(useWrapping = false)
        Set<String> nanori
) {
}

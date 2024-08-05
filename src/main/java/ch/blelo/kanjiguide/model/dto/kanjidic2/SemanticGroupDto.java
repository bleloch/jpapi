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
public record SemanticGroupDto(
        //@JacksonXmlProperty(localName = "reading")
        //@JacksonXmlElementWrapper(useWrapping = false)
        Set<ReadingDto> readings,

        //@JacksonXmlProperty(localName = "meaning")
        //@JacksonXmlElementWrapper(useWrapping = false)
        Set<MeaningDto> meanings
) {
}

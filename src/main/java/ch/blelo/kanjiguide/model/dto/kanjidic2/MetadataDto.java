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
public record MetadataDto(
    //@JacksonXmlProperty(localName = "freq")
    int frequency,

    //@JacksonXmlProperty(localName = "grade")
    int schoolGrade,

    //@JacksonXmlProperty(localName = "jlpt")
    int jlptGrade,

    //@JacksonXmlProperty(localName = "stroke_count")
    int strokeCount, // there can be more than one element with this property, but we only need the first one

    //@JacksonXmlProperty(localName = "variant")
    //@JacksonXmlElementWrapper(useWrapping = false)
    Set<VariantDto> variants,

    //@JacksonXmlProperty(localName = "rad_name")
    //@JacksonXmlElementWrapper(useWrapping = false)
    Set<String> radicalNames
) {
}

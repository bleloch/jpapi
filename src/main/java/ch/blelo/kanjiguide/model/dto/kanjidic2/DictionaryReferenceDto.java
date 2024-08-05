package ch.blelo.kanjiguide.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record DictionaryReferenceDto(
        //@JacksonXmlText
        String element,

        //@JacksonXmlProperty(isAttribute = true, localName = "dr_type")
        String type,

        //@JacksonXmlProperty(isAttribute = true, localName = "m_vol")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        int morohashiVolume,

        //@JacksonXmlProperty(isAttribute = true, localName = "m_page")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        int morohashiPage
) {
}

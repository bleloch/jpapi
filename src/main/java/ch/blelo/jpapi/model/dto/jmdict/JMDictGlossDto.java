package ch.blelo.jpapi.model.dto.jmdict;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/**
 * <p>Within each sense will be one or more "glosses", i.e.
 * target language words or phrases which are equivalents to the
 * Japanese word.</p>
 * <p>This element would normally be present, however it
 * may be omitted in entries which are purely for a cross-reference.</p>
 *
 * @param element          <p>The target language word or phrase.</p>
 * @param languageCode     <p>The xml:lang attribute defines the target language of the
 *                         gloss. It will be coded using the three-letter language code from
 *                         the ISO 639 standard. When absent, the element "eng" (i.e. English)
 *                         is the default element.</p>
 * @param gender           <p>The g_gend attribute defines the gender of the gloss (typically
 *                         a noun in the target language. When absent, the gender is either
 *                         not relevant or has yet to be provided.</p>
 * @param semanticProperty <p>The g_type attribute specifies that the gloss is of a particular
 *                         type, e.g. "lit" (literal), "fig" (figurative), "expl" (explanation).</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record JMDictGlossDto(
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(localName = "lang", isAttribute = true)
        String languageCode,

        @JacksonXmlProperty(localName = "g_gend", isAttribute = true)
        String gender,

        @JacksonXmlProperty(localName = "g_type", isAttribute = true)
        String semanticProperty
) {
    public static class JMDictGlossDtoBuilder {
        JMDictGlossDtoBuilder() {
            this.languageCode = "eng";
        }
    }
}

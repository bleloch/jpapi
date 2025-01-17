package ch.blelo.jpapi.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/**
 * <p>Stores information about the root radical (部首) of the {@link Kanjidic2CharacterDto}.</p>
 *
 * @param element       <p>The radical number, in the range 1 to 214. The particular
 * 	                    classification type is stated in the rad_type attribute.</p>
 * @param type          <p>The rad_type attribute states the type of radical classification.</p>
 *                      <ul>
 *                              <li>
 * 		                                {@code classical} - based on the system first used in the KangXi Zidian.
 * 		                                The Shibano "JIS Kanwa Jiten" is used as the reference source.
 * 		                        </li>
 * 		                        <li>
 * 		                                {@code nelson_c} - as used in the Nelson "Modern Japanese-English
 * 		                                Character Dictionary" (i.e. the Classic, not the New Nelson).
 * 		                                This will only be used where Nelson reclassified the kanji.
 * 		                        </li>
 * 		                </ul>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record Kanjidic2RadicalDto(
        @JsonIgnore
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(localName = "rad_type", isAttribute = true)
        String type
) {
}

package ch.blelo.kanjiguide.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/**
 * <p>The codepoint element states the code of the character in the various
 * character set standards.</p>
 *
 * @param element       <p><b>Note: </b>Represented as {@code cp_value} in the source XML.</p>
 *                      <p>The {@code cp_value} contains the codepoint of the character in a particular
 * 	                    standard. The standard will be identified in the cp_type attribute.</p>
 * @param type          <p><b>Note: </b>Represented as {@code cp_type} in the source XML.</p>
 *                      <p>The {@code cp_type} attribute states the coding standard applying to the
 * 	                    element. The values assigned so far are:</p>
 * 	                    <ul>
 * 	                            <li>
 * 		                                jis208 - JIS X 0208-1997 - kuten coding (nn-nn)
 * 		                        </li>
 * 		                        <li>
 * 		                                jis212 - JIS X 0212-1990 - kuten coding (nn-nn)
 * 		                        </li>
 * 		                        <li>
 * 		                                jis213 - JIS X 0213-2000 - kuten coding (p-nn-nn)
 * 		                        </li>
 * 		                        <li>
 * 		                                ucs - Unicode 4.0 - hex coding (4 or 5 hexadecimal digits)
 * 		                        </li>
 * 		                </ul>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CodepointDto(
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(isAttribute = true, localName = "cp_type")
        String type
) {
}

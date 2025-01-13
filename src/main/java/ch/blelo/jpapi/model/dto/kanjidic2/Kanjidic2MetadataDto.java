package ch.blelo.jpapi.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

/**
 * <p>Various metadata relating to the {@link Kanjidic2CharacterDto} to which this object belongs.</p>
 * <p><b>Note: </b>Represented as {@code misc} in the source XML.</p>
 *
 * @param frequency             <p><b>Note: </b>Represented as {@code freq} in the source XML.</p>
 *                              <p>A frequency-of-use ranking. The 2,500 most-used characters have a
 * 	                            ranking; those characters that lack this field are not ranked. The
 * 	                            frequency is a number from 1 to 2,500 that expresses the relative
 * 	                            frequency of occurrence of a character in modern Japanese. This is
 * 	                            based on a survey in newspapers, so it is biased towards kanji
 * 	                            used in newspaper articles. The discrimination between the less
 * 	                            frequently used kanji is not strong. (Actually there are 2,501
 * 	                            kanji ranked as there was a tie.)</p>
 * @param schoolGrade           <p><b>Note: </b>Represented as {@code grade} in the source XML.</p>
 *                              <p>The kanji grade level. 1 through 6 indicates a <i>kyōiku</i> kanji
 * 	                            and the grade in which the kanji is taught in Japanese schools.
 * 	                            8 indicates it is one of the remaining <i>jōyō</i> kanji to be learned
 * 	                            in junior high school. 9 indicates it is a <i>jinmeiyō</i> (for use
 * 	                            in names) kanji which in addition  to the jōyō kanji are approved
 * 	                            for use in family name registers and other official documents. 10
 * 	                            also indicates a jinmeiyō kanji which is a variant of a
 * 	                            jōyō kanji. [G]</p>
 * @param jlptGrade             <p><b>Note: </b>Represented as {@code jlpt} in the source XML.</p>
 *                              <p>The <b>former</b> Japanese Language Proficiency test level for this kanji.
 * 	                            Values range from 1 (most advanced) to 4 (most elementary). This field
 * 	                            does not appear for kanji that were not required for any JLPT level.
 * 	                            Note that the JLPT test levels changed in 2010, with a new 5-level
 * 	                            system (N1 to N5) being introduced. No official kanji lists are
 * 	                            available for the new levels. The new levels are regarded as
 * 	                            being similar to the old levels except that the old level 2 is
 * 	                            now divided between N2 and N3.</p>
 * @param strokeCount           <p><b>Note: </b>Represented as {@code stroke_count} in the source XML.</p>
 *                              <p>The stroke count of the kanji, including the radical. If more than
 * 	                            one, the first is considered the accepted count, while subsequent ones
 * 	                            are common miscounts. (See Appendix E. of the KANJIDIC documentation
 * 	                            for some of the rules applied when counting strokes in some of the
 * 	                            radicals.) [S]</p>
 * @param variants              <p><b>Note: </b>Represented as {@code variant} in the source XML.</p>
 *                              <p>Either a cross-reference code to another kanji, usually regarded as a
 * 	                            variant, or an alternative indexing code for the current kanji.
 * 	                            The type of variant is given in the var_type attribute.</p>
 * @param radicalNames          <p><b>Note: </b>Represented as {@code rad_name} in the source XML.</p>
 *                              <p>When the kanji is itself a radical and has a name, this element
 * 	                            contains the name (in hiragana.) [T2]</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record Kanjidic2MetadataDto(
        long id,

        @JacksonXmlProperty(localName = "freq")
        int frequency,

        @JacksonXmlProperty(localName = "grade")
        int schoolGrade,

        @JacksonXmlProperty(localName = "jlpt")
        int jlptGrade,

        // There can be more than one element with this property, but only the first one is used.
        // See class documentation for more information
        @JacksonXmlProperty(localName = "stroke_count")
        int strokeCount,

        @JacksonXmlProperty(localName = "variant")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<Kanjidic2VariantDto> variants,

        @JacksonXmlProperty(localName = "rad_name")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> radicalNames
) {
}

package ch.blelo.jpapi.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/**
 * <p><b>Note: </b>Represented as {@code dic_number} in the source XML.</p>
 * <p>This element contains the index numbers and similar unstructured
 * information such as page numbers in a number of published dictionaries,
 * and instructional books on kanji.</p>
 *
 * @param element         <p><b>Note: </b>Represented as {@code dic_ref} in the source XML.</p>
 *                        <p>Each {@code dic_ref} contains an index number. The particular dictionary,
 *                        etc. is defined by the {@code dr_type} attribute.</p>
 * @param type            <p><b>Note: </b>Represented as {@code dr_type} in the source XML.</p>
 *                        <p>The {@code dr_type} defines the dictionary or reference book, etc. to which
 *                        {@code dic_ref} element applies. The initial allocation is:</p>
 *                        <ul>
 *                                <li>
 *                                       <p>{@code nelson_c}</p>
 *                                       <p>
 *                                              <b>Name: </b><a href="https://en.wikipedia.org/wiki/The_Modern_Reader%27s_Japanese%E2%80%93English_Character_Dictionary">Modern Reader's Japanese-English Character Dictionary</a>
 *                                       </p>
 *                                       <p>
 *                                              <b>Author: </b><a href="https://en.wikipedia.org/wiki/Andrew_Nelson_(lexicographer)">Andrew Nelson</a>
 *                                       </p>
 *                                       <p>
 *                                              <b>Publisher: </b><a href="https://tuttlepublishing.com">Tuttle</a>
 *                                       </p>
 *                                       <p>
 *                                              <b>ISBN: </b>9780804804080
 *                                       </p>
 *                                       <p>
 *                                              <b>Notes: </b>
 *                                              <ul>
 *                                                      <li>Now published as the "Classic" Nelson</li>
 *                                              </ul>
 *                                       </p>
 *                                </li>
 *                                <li>
 *                                       <p>{@code nelson_n}</p>
 *                                       <p>
 *                                               <b>Name: </b><a href="https://en.wikipedia.org/wiki/The_New_Nelson_Japanese-English_Character_Dictionary">The New Nelson Japanese-English Character Dictionary</a>
 *                                        </p>
 *                                        <p>
 *                                               <b>Author: </b>Andrew Nelson, John Haig
 *                                        </p>
 *                                        <p>
 *                                               <b>Publisher: </b>Tuttle
 *                                        </p>
 *                                        <p>
 *                                                <b>ISBN: </b>9780804820363
 *                                        </p>
 *                                        <p>
 *                                               <b>Notes: </b>
 *                                        </p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code halpern_njecd}</p>
 *                                        <p>
 *                                            <b>Name: </b>New Japanese-English Character Dictionary
 *                                        </p>
 *                                        <p>
 *                                              <b>Author: </b><a href="https://en.wikipedia.org/wiki/Jack_Halpern_(linguist)">Jack Halpern</a>
 *                                        </p>
 *                                        <p>
 *                                              <b>Publisher: </b><a href="https://www.kenkyusha.co.jp">Kenkyūsha (研究社)</a>
 *                                        </p>
 *                                        <p>
 *                                              <b>ISBN: </b>9784767490403
 *                                        </p>
 *                                        <p>
 *                                              <b>Notes: </b>
 *                                        </p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code halpern_kkd}</p>
 *                                        <p>
 *                                              <b>Name: </b>Kōdansha Kanji Dictionary
 *                                        </p>
 *                                        <p>
 *                                              <b>Author: </b>Jack Halpern
 *                                        </p>
 *                                        <p>
 *                                              <b>Publisher: </b><a href="https://www.kodansha.co.jp/">Kōdansha</a>
 *                                        </p>
 *                                        <p>
 *                                              <b>ISBN: </b>9781568364087
 *                                        </p>
 *                                        <p>
 *                                              <b>Notes: </b>
 *                                              <ul>
 *                                                      <li>Second edition of the New Japanese-English Character Dictionary</li>
 *                                              </ul>
 *                                        </p>
 *                                </li>
 *                               <li>
 *                                       <p>{@code halpern_kkld}</p>
 *                                       <p>
 *                                           <b>Name: </b>The Kōdansha Kanji Learner's Dictionary
 *                                       </p>
 *                                       <p>
 *                                          <b>Author: </b>Jack Halpern
 *                                       </p>
 *                                       <p>
 *                                              <b>Publisher: </b>Kōdansha
 *                                       </p>
 *                                       <p>
 *                                              <b>ISBN: </b>9784770023353
 *                                       </p>
 *                                       <p>
 *                                              <b>Notes: </b>
 *                                       </p>
 *                               </li>
 *                                <li>
 *                                        <p>{@code halpern_kkld_2ed}</p>
 *                                        <p>
 *                                              <b>Name: </b>The Kōdansha Kanji Learner's Dictionary: Revised & Expanded
 *                                        </p>
 *                                        <p>
 *                                              <b>Author: </b>Jack Halpern
 *                                        </p>
 *                                        <p>
 *                                              <b>Publisher: </b>Kōdansha
 *                                        </p>
 *                                        <p>
 *                                              <b>ISBN: </b>9781568364070
 *                                        </p>
 *                                        <p>
 *                                              <b>Notes: </b>
 *                                              <ul>
 *                                                      <li>Second edition of The Kōdansha Kanji Learner's Dictionary</li>
 *                                              </ul>
 *                                        </p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code heisig}</p>
 *                                        <p>
 *                                              <b>Name: </b>Remembering the Kanji
 *                                        </p>
 *                                      <p>
 *                                              <b>Author: </b><a href="https://en.wikipedia.org/wiki/James_Heisig">James Heisig</a>
 *                                      </p>
 *                                      <p>
 *                                              <b>Publisher: </b><a href="https://uhpress.hawaii.edu">University of Hawai'i Press</a>
 *                                      </p>
 *                                      <p>
 *                                              <b>ISBN: </b>
 *                                              <ul>
 *                                                      <li>9780824831653 (Volume 1)</li>
 *                                                      <li>9780824836696 (Volume 2)</li>
 *                                                      <li>9780824837020 (Volume 3)</li>
 *                                              </ul>
 *                                      </p>
 *                                      <p>
 *                                              <b>Notes: </b>
 *                                      </p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code heisig6}</p>
 *                                        <p>
 *                                              <b>Name: </b>Remembering the Kanji (Sixth Edition)
 *                                        </p>
 *                                        <p>
 *                                              <b>Author: </b>James Heisig
 *                                        </p>
 *                                        <p>
 *                                              <b>Publisher: </b>University of Hawai'i Press
 *                                        </p>
 *                                        <p>
 *                                              <b>ISBN: </b>9780824835927
 *                                        </p>
 *                                        <p>
 *                                              <b>Notes: </b>
 *                                        </p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code gakken}</p>
 *                                        <p>
 *                                              <b>Name: </b>A New Dictionary of Kanji Usage (新しい漢字用法辞典)
 *                                        </p>
 *                                        <p>
 *                                              <b>Author: </b>Nao'omi Kuratani (<a href="https://ja.wikipedia.org/wiki/%E5%80%89%E8%B0%B7%E7%9B%B4%E8%87%A3">倉谷直臣</a>), Akemi Kobayashi (小林朱美)
 *                                        </p>
 *                                      <p>
 *                                              <b>Publisher: </b>Gakushūkenkyūsha (学習研究社）(now <a href="https://www.corp-gakken.co.jp/">Gakken</a>)
 *                                      </p>
 *                                      <p>
 *                                              <b>ISBN: </b>9784050518050
 *                                      </p>
 *                                      <p>
 *                                              <b>Notes: </b>
 *                                      </p>
 *                                </li>
 *                                <li>
 *                                      <p>{@code oneill_names}</p>
 *                                      <p>
 *                                              <b>Name: </b>Japanese Names: A Comprehensive Index by Characters and Readings
 *                                      </p>
 *                                      <p>
 *                                              <b>Author: </b>P.G. O'Neill
 *                                      </p>
 *                                      <p>
 *                                              <b>Publisher: </b>Weatherhill
 *                                      </p>
 *                                      <p>
 *                                              <b>ISBN: </b>9780834800601
 *                                      </p>
 *                                </li>
 *                                <li>
 *                                      <p>{@code oneill_kk}</p>
 *                                      <p>
 *                                              <b>Name: </b>Essential Kanji: 2,000 Basic Japanese Characters Systematically Arranged For Learning And Reference
 *                                      </p>
 *                                      <p>
 *                                              <b>Author: </b>P.G. O'Neill
 *                                      </p>
 *                                      <p>
 *                                              <b>Publisher: </b>Weatherhill
 *                                      </p>
 *                                      <p>
 *                                              <b>ISBN: </b>9780834802223
 *                                      </p>
 *                                </li>
 *                                <li>
 *                                      <p>{@code moro}</p>
 *                                      <p>
 *                                              <b>Name: </b>Daikanwajiten (大漢和辞典)
 *                                      </p>
 *                                      <p>
 *                                              <b>Author: </b><a href="https://en.wikipedia.org/wiki/Tetsuji_Morohashi">Tetsuji Morohashi (諸橋轍次)</a>
 *                                      </p>
 *                                      <p>
 *                                              <b>Publisher: </b>Taishūkan (大修館)
 *                                      </p>
 *                                      <p>
 *                                              <b>ISBN: </b>
 *                                              <ul>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                                      <li></li>
 *                                              </ul>
 *                                      </p>
 *                                        <p>{@code moro}: "Daikanwajiten (大漢和辞典)" compiled by <a href="https://en.wikipedia.org/wiki/Tetsuji_Morohashi">Tetsuji Morohashi (諸橋轍次)</a>.
 *                                        For some kanji two additional attributes are used:</p>
 *                                        <ul>
 *                                                <li>
 *                                                        <p>{@code m_vol}: See {@link Kanjidic2DictionaryReferenceDto#morohashiVolume}</p>
 *                                                </li>
 *                                                <li>
 *                                                        <p>{@code m_page}: See {@link Kanjidic2DictionaryReferenceDto#morohashiPage}</p>
 *                                                </li>
 *                                        </ul>
 *                                </li>
 *                                <li>
 *                                        <p>{@code henshall}: "A Guide To Remembering Japanese Characters" by Kenneth G. Henshall</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code sh_kk}: "Kanji and Kana" by Spahn and Hadamitzky</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code sh_kk2}: "Kanji and Kana" (2011 edition) by Spahn and Hadamitzky</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code sakade}: "A Guide To Reading and Writing Japanese",
 *                                        edited by Florence Sakade</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code jf_cards}: Japanese Kanji Flashcards (Series 1) by Max Hodges and Tomoko Okazaki</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code henshall3}: "A Guide To Reading and Writing Japanese" 3rd edition,
 *                                        edited by Kenneth G. Henshall, Seeley and De Groot</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code tutt_cards}: Tuttle Kanji Cards, compiled by Alexander Kask</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code crowley}: "The Kanji Way to Japanese Language Power" by Dale Crowley</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code kanji_in_context}: "Kanji in Context" by Nishiguchi and Kono</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code busy_people}: "Japanese For Busy People" vols I-III (AJLT)
 *                                        The codes are the volume.chapter</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code kodansha_compact}: the "Kodansha Compact Kanji Guide"</p>
 *                                </li>
 *                                <li>
 *                                        <p>{@code maniette}: "Les Kanjis dans la tete" (the French adaptation of Heisig's Remembering the Kanji)
 *                                        by Yves Maniette</p>
 *                                </li>
 *                        </ul>
 * @param morohashiVolume <p><b>Note: </b>Only populated if {@link Kanjidic2DictionaryReferenceDto#type} is `moro`.</p>
 *                        <p>The volume of the dictionary in which the kanji is found</p>
 * @param morohashiPage   <p><b>Note: </b>Only populated if {@link Kanjidic2DictionaryReferenceDto#type} is `moro`.</p>
 *                        <p>The page number in that volume</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record Kanjidic2DictionaryReferenceDto(
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(localName = "dr_type", isAttribute = true)
        String type,

        @JacksonXmlProperty(localName = "m_vol", isAttribute = true)
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        int morohashiVolume,

        @JacksonXmlProperty(localName = "m_page", isAttribute = true)
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        int morohashiPage
) {
}

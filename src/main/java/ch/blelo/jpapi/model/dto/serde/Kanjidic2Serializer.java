package ch.blelo.jpapi.model.dto.serde;

import ch.blelo.jpapi.model.dto.common.KanjiDto;
import ch.blelo.jpapi.model.dto.common.ReadingDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictGlossDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictSenseDto;
import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CharacterDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class Kanjidic2Serializer extends StdSerializer<Kanjidic2CharacterDto> {
    public Kanjidic2Serializer() {
        this(null);
    }

    public Kanjidic2Serializer(Class<Kanjidic2CharacterDto> c) {
        super(c);
    }

    @Override
    public void serialize(Kanjidic2CharacterDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeNumberField("id", value.id());

        gen.writeStringField("literal", value.literal());

        gen.writeObjectField("codepoints", value.codepoints());

        gen.writeObjectField("radicals", value.radicals());

        gen.writeObjectField("metadata", value.metadata());

        gen.writeObjectField("dictionaryReferences", value.dictionaryReferences());

        gen.writeObjectField("queryCodes", value.queryCodes());

        gen.writeObjectField("semantics", value.semantics());

        gen.writeArrayFieldStart("words");
        if (!value.words().isEmpty()) {
            for (JMDictEntryDto e : value.words()) {

                gen.writeStartObject();

                gen.writeArrayFieldStart("kanji");
                if (!e.kanji().isEmpty()) {
                    for (KanjiDto k : e.kanji()) {
                        gen.writeString(k.element());
                    }
                }
                gen.writeEndArray();

                gen.writeArrayFieldStart("reading");
                for (ReadingDto r : e.readings()) {
                    gen.writeString(r.element());
                }
                gen.writeEndArray();

                gen.writeArrayFieldStart("definitions");
                for (JMDictSenseDto s : e.senses()) {
                    if (!s.glosses().isEmpty()) {
                    for (JMDictGlossDto g : s.glosses()) {
                        gen.writeString(g.element());
                    }
                    }
                }
                gen.writeEndArray();

                gen.writeEndObject();
            }
        }
        gen.writeEndArray();

        gen.writeEndObject();
    }
}

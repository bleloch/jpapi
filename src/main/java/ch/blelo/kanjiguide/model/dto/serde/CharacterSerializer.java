package ch.blelo.kanjiguide.model.dto.serde;

import ch.blelo.kanjiguide.model.dto.jmdict.*;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CharacterSerializer extends StdSerializer<CharacterDto> {
    public CharacterSerializer() {
        this(null);
    }

    public CharacterSerializer(Class<CharacterDto> c) {
        super(c);
    }

    @Override
    public void serialize(CharacterDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
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
            for (EntryDto e : value.words()) {

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
                for (SenseDto s : e.senses()) {
                    if (!s.glosses().isEmpty()) {
                    for (GlossDto g : s.glosses()) {
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

package ch.blelo.jpapi.model.dto.serde;

import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CharacterDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class JMDictSerializer extends StdSerializer<JMDictEntryDto> {
    public JMDictSerializer() {
        this(null);
    }

    public JMDictSerializer(Class<JMDictEntryDto> c) {
        super(c);
    }

    @Override
    public void serialize(JMDictEntryDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeNumberField("id", value.id());

        gen.writeNumberField("entrySequence", value.entrySequence());

        if (!value.kanji().isEmpty()) {
            gen.writeObjectField("kanji", value.kanji());
        }

        gen.writeObjectField("readings", value.readings());

        gen.writeObjectField("senses", value.senses());

        gen.writeArrayFieldStart("kanjiMatches");
        if (!value.linkedCharacters().isEmpty()) {
            for (Kanjidic2CharacterDto c : value.linkedCharacters()) {
                gen.writeString(c.literal());
            }
        }
        gen.writeEndArray();

        gen.writeEndObject();
    }
}

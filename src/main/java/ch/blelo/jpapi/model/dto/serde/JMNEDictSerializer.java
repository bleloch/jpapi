package ch.blelo.jpapi.model.dto.serde;

import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictEntryDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class JMNEDictSerializer extends StdSerializer<JMNEDictEntryDto> {
    public JMNEDictSerializer() { this(null); }

    protected JMNEDictSerializer(Class<JMNEDictEntryDto> t) {
        super(t);
    }

    @Override
    public void serialize(JMNEDictEntryDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeNumberField("id", value.id());

        if (!value.kanji().isEmpty()) {
            gen.writeObjectField("kanji", value.kanji());
        }

        gen.writeObjectField("readings", value.readings());

        gen.writeObjectField("translations", value.translations());

        gen.writeEndObject();
    }
}

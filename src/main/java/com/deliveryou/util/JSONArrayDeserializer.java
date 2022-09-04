package com.deliveryou.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.List;

public class JSONArrayDeserializer extends StdDeserializer<List<String>> {
    public JSONArrayDeserializer() {
        this(null);
    }

    public JSONArrayDeserializer(Class<List<String>> c) {
        super(c);
        System.out.println("JSON called");
    }

    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        System.out.println("JSON: " + jsonParser.getText());
        return null;
    }
}

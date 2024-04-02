package br.edu.ifsp.arq.web1.ifitness.model.util.users;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public JsonElement serialize(LocalDate date, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(date.format(formatter));
    }
    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return LocalDate.parse(jsonElement.getAsString(), formatter);
    }
}

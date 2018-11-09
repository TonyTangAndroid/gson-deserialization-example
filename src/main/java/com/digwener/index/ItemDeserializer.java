package com.digwener.index;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ItemDeserializer implements JsonDeserializer<Item> {


    @Override
    public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Item item;
        JsonObject jsonObject = json.getAsJsonObject();
        item = new Item();
        item.type = jsonObject.get("type").getAsInt();
        item.item_id = jsonObject.get("item_id").getAsString();
        item.data = jsonObject.get("data").getAsJsonObject().toString();
        return item;
    }

}

package com.flaterlab.uskg.data;


import androidx.room.TypeConverter;

import com.flaterlab.uskg.models.Campus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class CampusTypeConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Campus> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Campus>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listToString(List<Campus> data) {
        return gson.toJson(data);
    }
}

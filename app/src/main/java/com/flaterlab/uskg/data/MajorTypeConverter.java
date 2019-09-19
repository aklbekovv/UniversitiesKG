package com.flaterlab.uskg.data;

import androidx.room.TypeConverter;

import com.flaterlab.uskg.models.Major;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class MajorTypeConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Major> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type dataType = new TypeToken<List<Major>>() {
        }.getType();

        return gson.fromJson(data, dataType);
    }

    @TypeConverter
    public static String listToString(List<Major> data) {
        return gson.toJson(data);
    }
}

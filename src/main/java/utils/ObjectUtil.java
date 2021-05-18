package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;

public class ObjectUtil {
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static <T> T getObjectFromJson(Reader file, Class<T> tClass) {
        return gson.fromJson(file, tClass);
    }

    public static String getJsonFromObject(Object object, Class tClass) {
        return gson.toJson(object, tClass);
    }
}

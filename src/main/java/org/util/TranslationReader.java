package org.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

public class TranslationReader {
    public String getTranslation(String key) {
        String translation = null;
        TestConfigs config = new TestConfigs();
        String languageLocale = config.getLocale();

        try {
            String translationsPath = "src/main/resources/translations/";
            String fileName = translationsPath + "translation_" + languageLocale + ".json";

            // Read the JSON file
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader(fileName), JsonObject.class);

            // Get the translation value for the specified key
            translation = jsonObject.get(key).getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading translation for " + languageLocale + " and key " + key);
        }
        return translation;
    }
}
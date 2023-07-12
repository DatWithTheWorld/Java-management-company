package View;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
public class JsonFileReader {
    public static void main(String[] args) {
    	try (BufferedReader reader = new BufferedReader(new FileReader("phaphc.json"))) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<JsonObject>>(){}.getType();
            List<JsonObject> jsonArray = gson.fromJson(reader, type);
            for (JsonObject jsonObject : jsonArray) {
                System.out.println(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
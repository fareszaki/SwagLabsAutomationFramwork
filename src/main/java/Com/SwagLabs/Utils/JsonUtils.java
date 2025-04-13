package Com.SwagLabs.Utils;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtils {
    private final static String JSON_PATH = "src/test/resources";
    public static String JsonReader;
    public String JsonFileName;

    public JsonUtils(String filename) {
        this.JsonFileName = filename;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(JSON_PATH + "/"+this.JsonFileName+ ".json"));
            JsonReader = jsonObject.toJSONString();
        } catch (Exception e) {
            LogsUtils.error("Failed to load json file", e.getMessage());
        }
    }

        public static String getJsonValue(String key){
             String data = " " ;
             try {
                 data = JsonPath.read(JsonReader, key);
             }catch (Exception e){
                    LogsUtils.error("Failed to get json value", e.getMessage());
             }
             return data;

        }
    }



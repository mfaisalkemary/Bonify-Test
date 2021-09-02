package utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class TestData {
    public JSONObject getTestDataFromJsonFile() throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        FileReader reader=new FileReader("./src/main/java/utils/testData.json");
        return (JSONObject) parser.parse(reader);
    }
}

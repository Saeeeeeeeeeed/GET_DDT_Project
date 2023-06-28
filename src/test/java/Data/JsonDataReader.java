package Data;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public String firstname,lastname,cityValue,phone,emailAddress,password;

    public void JsonReader () throws IOException, ParseException {
        String filePath = System.getProperty("user.dir")+"/src/test/java/Data/UserData.Json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));

        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj ;

            firstname = (String) person.get("firstname");
            System.out.println(firstname);

            lastname = (String) person.get("lastname");
            System.out.println(lastname);

            cityValue = (String) person.get("cityValue");
            System.out.println(cityValue);

            phone = (String) person.get("phone");
            System.out.println(phone);

            emailAddress = (String) person.get("emailAddress");
            System.out.println(emailAddress);

            password = (String) person.get("password");
            System.out.println(password);

        }
        }
    }


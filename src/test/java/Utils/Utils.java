package Utils;

import config.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;


public class Utils {
    public static void doScroll(WebDriver driver, int firstPos, int lastPos) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("wind.scrollBy(" + firstPos + "," + lastPos + ")");
    }

    public static void saveUsers(UserModel userModel) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/user.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileLocation));
        JSONObject userObj = new JSONObject();
        userObj.put("firstName", userModel.getFirstname());
        userObj.put("lastName", userModel.getLastname());
        userObj.put("userName", userModel.getUsername());
        userObj.put("password", userModel.getPassword());

        jsonArray.add(userObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static JSONArray getUser() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/user.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileLocation));
        return jsonArray;
    }

    public static void waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

package TestRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DirectoryPage;
import pages.LoginPage;
import pages.PIMPage;

import java.io.IOException;

public class EmployeeSearchTestRunner extends Setup {
    @BeforeTest
    public void doLogin(){
        LoginPage testLoginPage = new LoginPage(driver);
        testLoginPage.doLogin("admin","admin123");
    }

    @Test
    public void searchEmployee() throws IOException, ParseException, InterruptedException {
        DirectoryPage directoryPage = new DirectoryPage(driver);
        Utils utils = new Utils();
        JSONArray jsonArray = utils.getUser();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size()-1);
        String firstName = "Odis";
        directoryPage.searchUser(firstName);

    }


}

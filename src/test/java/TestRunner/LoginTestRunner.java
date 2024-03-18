package TestRunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTestRunner extends Setup {

    @Test(priority = 1, description = "Wrong creds user can not login")
    public void loginByWrongCreds(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("randomMia","random1234");
        String alertActual = driver.findElements(By.className("oxd-text")).get(1).getText();
        String alertExpected = "Invalid credentials";

        Assert.assertTrue(alertActual.contains(alertExpected));
    }

    @Test(priority = 2, description = "Admin can login successfully")
    public void doLogin() throws IOException, ParseException {
        LoginPage testLoginPage = new LoginPage(driver);
        Utils utils = new Utils();
        JSONArray jsonArray = utils.getUser();
        JSONObject userObj = (JSONObject) jsonArray.get(0);
        if (System.getProperty("userName") == null && System.getProperty("password") == null) {
            String username = (String) userObj.get("userName");
            String password = (String) userObj.get("password");
            testLoginPage.doLogin(username, password);
        }else {
            String username = System.getProperty("userName");
            String password = System.getProperty("password");
            testLoginPage.doLogin(username, password);
        }

        WebElement imgProfile = driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(imgProfile.isDisplayed());
    }
}

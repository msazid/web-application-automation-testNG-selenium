package TestRunner;

import Utils.Utils;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;
import config.Setup;
import config.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DirectoryPage;
import pages.LoginPage;
import pages.PIMPage;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PIMTestRunner extends Setup {


    @BeforeTest
    public void doLogin(){
        LoginPage testLoginPage = new LoginPage(driver);
        testLoginPage.doLogin("admin","admin123");
    }
    @Test(priority = 1, description = "Create new user")
    public void newUserRegistration() throws InterruptedException, IOException, ParseException {
        PIMPage pimPage = new PIMPage(driver);
        Faker faker = new Faker();
        String fistName =faker.name().firstName();
        String lastName =faker.name().lastName();
        String userName = faker.name().username();
        String password = generatePassword();
        pimPage.registerUser(fistName,lastName,userName,password);

        List<WebElement> title = driver.findElements(By.className("orangehrm-main-title"));

        Utils.waitForElement(driver, title.get(0));
        UserModel userModel = new UserModel();
        userModel.setFirstname(fistName);
        userModel.setLastname(lastName);

        userModel.setUsername(userName);
        userModel.setPassword(password);
        Utils.saveUsers(userModel);

        Thread.sleep(20000);
    }

    public static String generatePassword() {

        int length = 12;
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/";
        StringBuilder password = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return password.toString();
    }


    @Test(priority = 2)
    public void searchEmployee() throws IOException, ParseException, InterruptedException {
        DirectoryPage directoryPage = new DirectoryPage(driver);
        Utils utils = new Utils();
        JSONArray jsonArray = utils.getUser();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size()-1);
        String fullName =(String) userObj.get("firstName")+" "+(String) userObj.get("lastName");

        directoryPage.searchUser(fullName);
    }

}

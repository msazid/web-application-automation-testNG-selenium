package pages;

import Utils.Utils;
import com.github.javafaker.IdNumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {

    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> menuitems;
    @FindBy(className = "oxd-button")
    List<WebElement> button;
    @FindBy(className = "oxd-input")
    List<WebElement> inputField;

    @FindBy(className = "oxd-switch-input")
    WebElement toggleBtn;

    WebDriver driver;
    public PIMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void registerUser(String firstName, String lastName, String userName, String password){
        menuitems.get(1).click(); //click on PIM page
        button.get(2).click(); //click on Add Button
        toggleBtn.click();
        inputField.get(1).sendKeys(firstName);
        inputField.get(3).sendKeys(lastName);
        inputField.get(5).sendKeys(userName);
        inputField.get(6).sendKeys(password);
        inputField.get(7).sendKeys(password);
       // Utils.doScroll(driver,0,500);
        button.get(1).click(); //click on save button
    }


}

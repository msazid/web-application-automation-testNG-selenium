package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DirectoryPage {

    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> menuitems;
    @FindBy(css = "input[placeholder='Type for hints...'][data-v-75e744cd='']")
    WebElement input;

    @FindBy(className = "oxd-button")
    List <WebElement> buttons;

    WebDriver driver;
    public DirectoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void searchUser(String firstName ) throws InterruptedException {
        menuitems.get(8).click();
        input.sendKeys(firstName);
        Thread.sleep(5000);
        buttons.get(1).click();
    }}

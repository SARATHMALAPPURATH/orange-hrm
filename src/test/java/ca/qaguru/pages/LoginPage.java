package ca.qaguru.pages;

import ca.qaguru.lib.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //PageFactory - Object Repository

    @FindBy(xpath="//input[@id='txtUsername']")
    WebElement userName;

    @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//img[contains(@src,'/webres_5faa8393a82311.28834036/themes/default/images/login/logo.png')]")
    WebElement orangeHRMLogo;
//initializing the page objects
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
//Actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return orangeHRMLogo.isDisplayed();
    }
    public HomePage login(String un, String pwd){
        userName.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }
}

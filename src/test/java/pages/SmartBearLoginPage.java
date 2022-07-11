package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearLoginPage extends BasePage{
    public SmartBearLoginPage(){
        super();
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameInputBox;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordInputBox;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;
}

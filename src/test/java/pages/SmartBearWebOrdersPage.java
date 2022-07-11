package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SmartBearWebOrdersPage extends BasePage{
    public SmartBearWebOrdersPage(){
        super();
    }

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllLink;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllLink;

    @FindBy(css = "input[id^='ctl00_MainContent_orderGrid_ctl']")
    public List<WebElement> rowCheckBoxes;
}

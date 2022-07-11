package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickOnMenuItem(List<WebElement> items, String itemText){
        for(WebElement element: items){
            if(element.getText().equals(itemText)){
                element.click();
                break;
            }
        }
    }
}

package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearWebOrdersPage;
import utils.Driver;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearWebOrdersPage smartBearWebOrdersPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        smartBearWebOrdersPage = new SmartBearWebOrdersPage();
    }

    @When("user clicks on {string} link")
    public void userClicksOnButton(String linkText) {
        WebElement linkToBeClicked = null;
        switch (linkText){
            case "Check All":
                linkToBeClicked = smartBearWebOrdersPage.checkAllLink;
                break;
            case "Uncheck All":
                linkToBeClicked = smartBearWebOrdersPage.uncheckAllLink;
                break;
            default:
                throw new NotFoundException("Link text is not properly defined in the feature file!!!");
        }
        linkToBeClicked.click();
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for(WebElement checkBox: smartBearWebOrdersPage.rowCheckBoxes){
            Assert.assertTrue(checkBox.isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for(WebElement checkBox: smartBearWebOrdersPage.rowCheckBoxes){
            Assert.assertFalse(checkBox.isSelected());
        }
    }
}

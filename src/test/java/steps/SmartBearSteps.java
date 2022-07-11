package steps;

import com.github.javafaker.Faker;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearWebOrdersPage;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearWebOrdersPage smartBearWebOrdersPage;
    Faker faker;
    String customerName;
    String street;
    String city;
    String state;
    String zipCode;
    String paymentType;
    String cardNo;
    String expDate;
    int numberOfOrders = 8;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        faker = new Faker();
        customerName = faker.name().fullName();
        street = faker.address().streetAddress();
        city = faker.address().city();
        state = faker.address().state();
        zipCode = faker.address().zipCode().substring(0, 5);
        paymentType = "Visa";
        cardNo = faker.business().creditCardNumber().replace("-", "");
        expDate = "12/27";
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
            case "Process":
                linkToBeClicked = smartBearWebOrdersPage.processLink;
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

    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String menuItemText) {
        smartBearWebOrdersPage.clickOnMenuItem(smartBearWebOrdersPage.webOrdersMenuItems, menuItemText);
    }

    @When("user selects {string} as product")
    public void user_selects_as_product(String productName) {
        DropdownHandler.selectOptionByVisibleText(smartBearWebOrdersPage.productDropdown, productName);
    }

    @When("user enters {string} as quantity")
    public void user_enters_as_quantity(String quantity) {
        smartBearWebOrdersPage.quantityInputBox.sendKeys(quantity);
    }

    @When("user enters all address information")
    public void user_enters_all_address_information() {
        smartBearWebOrdersPage.customerNameInputBox.sendKeys(customerName);
        smartBearWebOrdersPage.streetInputBox.sendKeys(street);
        smartBearWebOrdersPage.cityInputBox.sendKeys(city);
        smartBearWebOrdersPage.stateInputBox.sendKeys(state);
        smartBearWebOrdersPage.zipInputBox.sendKeys(zipCode);
    }

    @When("user enters all payment information")
    public void user_enters_all_payment_information() {
        smartBearWebOrdersPage.selectPaymentType(paymentType);
        smartBearWebOrdersPage.cardNumberInputBox.sendKeys(cardNo);
        smartBearWebOrdersPage.cardExpirationDateInputBox.sendKeys(expDate);
    }

    @Then("user should see their order displayed in the List of All Orders table")
    public void user_should_see_their_order_displayed_in_the_table() {
        int newTotal = smartBearWebOrdersPage.rowCheckBoxes.size();
        Assert.assertTrue((numberOfOrders + 1) == newTotal);
    }

    @Then("validate all information entered displayed correct with the order")
    public void validate_all_information_entered_displayed_correct_with_the_order() {
        Assert.assertEquals(customerName, smartBearWebOrdersPage.orderInfo.get(1).getText());
        Assert.assertEquals(street, smartBearWebOrdersPage.orderInfo.get(5).getText());
        Assert.assertEquals(city, smartBearWebOrdersPage.orderInfo.get(6).getText());
        Assert.assertEquals(state, smartBearWebOrdersPage.orderInfo.get(7).getText());
        Assert.assertEquals(zipCode, smartBearWebOrdersPage.orderInfo.get(8).getText());
        Assert.assertEquals(paymentType, smartBearWebOrdersPage.orderInfo.get(9).getText());
        Assert.assertEquals(cardNo, smartBearWebOrdersPage.orderInfo.get(10).getText());
        Assert.assertEquals(expDate, smartBearWebOrdersPage.orderInfo.get(11).getText());
    }
}

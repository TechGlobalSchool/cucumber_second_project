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

    @FindBy(css = "#ctl00_menu a")
    public List<WebElement> webOrdersMenuItems;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInputBox;

    @FindBy(css = "input[id^='ctl00_MainContent_fmwOrder_cardList_']")
    public List<WebElement> paymentTypeInputBoxes;

    @FindBy(css = "label[for^='ctl00_MainContent_fmwOrder_cardList_']")
    public List<WebElement> paymentTypeInputLabels;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberInputBox;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement cardExpirationDateInputBox;

    @FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processLink;

    @FindBy (css = "table[class='SampleTable'] tr:nth-child(2) td")
    public List<WebElement> orderInfo;

    public void selectPaymentType(String paymentType){
        for(WebElement element: paymentTypeInputLabels){
            if(element.getText().equals(paymentType)){
                element.click();
                break;
            }
        }
    }
}

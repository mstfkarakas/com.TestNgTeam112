package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    // for locating webelement we will use webSite's Page Class

    public ZeroPage (){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement loginPageUserTextBox;

    @FindBy(id = "user_password")
    public WebElement loginPagePasswordTextBox;

    @FindBy(name = "submit")
    public WebElement loginPageSignInButton;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsButton;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement foreignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement payBillsCurrencyDropDown;






}
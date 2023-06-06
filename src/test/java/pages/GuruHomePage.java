package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GuruHomePage {

    public GuruHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Agile Project")
    public WebElement agileProjectLink;

    @FindBy(linkText = "Bank Project")
    public WebElement bankProjectLink;

    @FindBy(linkText = "Payment Gateway Project")
    public WebElement paymentProjectLink;

    @FindBy(linkText = "Telecom Project")
    public WebElement telecomProjectLink;

    @FindBy(name = "btnLogin")
    public WebElement submitBtn;



}

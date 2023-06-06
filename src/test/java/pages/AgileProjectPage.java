package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AgileProjectPage {

    public AgileProjectPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ol/li[1]")
    public WebElement userIDAccess;

    @FindBy(xpath = "//ol/li[2]")
    public WebElement passwordAccess;

    @FindBy(name = "uid")
    public WebElement userIDInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(name = "btnLogin")
    public WebElement loginBtn;

    @FindBy(linkText = "Log out")
    public WebElement logoutBtn;

    public void login(String userID, String password){
        userIDInput.sendKeys(userID);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }


}

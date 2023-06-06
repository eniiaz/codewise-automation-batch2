package guru;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AgileProjectPage;
import pages.GuruHomePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class AgileProject {

    GuruHomePage guruHomePage = new GuruHomePage();
    AgileProjectPage agileProjectPage = new AgileProjectPage();

    @Test
    public void login(){
        Driver.getDriver().get("https://demo.guru99.com");
        Driver.getDriver().findElement(By.linkText("Agile Project")).click();
        WebElement userID = Driver.getDriver().findElement(By.xpath("//ol/li[1]"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//ol/li[2]"));
        String userIDString = userID.getText().trim().substring(9);
        String passwordString = password.getText().trim().substring(11);
        Driver.getDriver().findElement(By.name("uid")).sendKeys(userIDString);
        Driver.getDriver().findElement(By.name("password")).sendKeys(passwordString + Keys.ENTER);
        String expectedURL = "https://demo.guru99.com/Agile_Project/Agi_V2/customer/Customerhomepage.php";
        ApplicationFlow.pause(500);
        Assert.assertEquals("Login functionality failed",expectedURL, Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void logout(){
        Driver.getDriver().get("https://demo.guru99.com");
        Driver.getDriver().findElement(By.linkText("Agile Project")).click();
        WebElement userID = Driver.getDriver().findElement(By.xpath("//ol/li[1]"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//ol/li[2]"));
        String userIDString = userID.getText().trim().substring(9);
        String passwordString = password.getText().trim().substring(11);
        Driver.getDriver().findElement(By.name("uid")).sendKeys(userIDString);
        Driver.getDriver().findElement(By.name("password")).sendKeys(passwordString + Keys.ENTER);
        String expectedURL = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";
        ApplicationFlow.pause(500);
        Assert.assertEquals("Login functionality failed",expectedURL, Driver.getDriver().getCurrentUrl());
        Driver.getDriver().findElement(By.linkText("Log out")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        String expectedMessage = "You Have Succesfully Logged Out!!";
        Assert.assertEquals("Logout alert message failed", expectedMessage, alert.getText());
        alert.accept();
        String expectedLogoutURL = "https://demo.guru99.com/Agile_Project/Agi_V1/index.php";
        ApplicationFlow.pause(500);
        Assert.assertEquals("Logout URL failed", expectedLogoutURL, Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void pomTest(){
        Driver.getDriver().get(Config.getValue("guruURL"));
        guruHomePage.agileProjectLink.click();
        String userID = agileProjectPage.userIDAccess.getText().trim().substring(9);
        String password= agileProjectPage.passwordAccess.getText().trim().substring(11);
        agileProjectPage.userIDInput.sendKeys(userID);
        agileProjectPage.passwordInput.sendKeys(password);
        agileProjectPage.loginBtn.click();
        ApplicationFlow.pause(500);
        String expectedURL = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";
        Assert.assertEquals("URL Failed", expectedURL, Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void logoutPom(){
        Driver.getDriver().get(Config.getValue("guruURL"));
        guruHomePage.agileProjectLink.click();
        String userID = agileProjectPage.userIDAccess.getText().trim().substring(9);
        String password= agileProjectPage.passwordAccess.getText().trim().substring(11);
        agileProjectPage.login(userID, password);
        agileProjectPage.logoutBtn.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        String expectedMessage = "You Have Succesfully Logged Out!!";
        Assert.assertEquals("Alert message failed", expectedMessage, alert.getText());
        alert.accept();
    }

    @After
    public void cleanUp(){
        Driver.quit();
    }
}

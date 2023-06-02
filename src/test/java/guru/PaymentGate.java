package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class PaymentGate {

    public static void main(String[] args) {
        Driver.getDriver().get(Config.getValue("paymentGateURL"));
        Driver.getDriver().findElement(By.linkText("Generate Card Number")).click();
        ApplicationFlow.switchToSecondWindow();
        WebElement creditCard = Driver.getDriver().findElement(By.xpath("//h4[1]"));
        WebElement cvv = Driver.getDriver().findElement(By.xpath("//h4[2]"));
        WebElement limit = Driver.getDriver().findElement(By.xpath("//h4[4]"));

        String ccString = creditCard.getText().substring(14);
        System.out.println(ccString.length());
        if (ccString.length() == 16){
            System.out.println("Credit Card validation PASSED");
        }else{
            System.out.println("Credit Card Validation FAILED");
        }

    }
}

package guru;

import org.openqa.selenium.By;
import utilities.ApplicationFlow;
import utilities.Driver;

public class Cup {

    public static void main(String[] args) {
        Driver.getDriver().get("https://www.letskodeit.com/");
        Driver.getDriver().quit();
        Driver.getDriver().get("https://google.com");
        String name = "James";
        String s = name;
        s = null;

    }
}

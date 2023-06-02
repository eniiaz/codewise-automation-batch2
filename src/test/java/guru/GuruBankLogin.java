package guru;

import utilities.Config;
import utilities.Driver;

public class GuruBankLogin {

    public static void main(String[] args) {
//        Driver.getDriver().get(Config.getValue("guruBankURL"));
        System.out.println(Config.getValue("guruBankURL"));
    }
}

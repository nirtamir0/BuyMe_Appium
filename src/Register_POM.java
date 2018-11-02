import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Register_POM {


    private static MobileElement Register =null;

    public static MobileElement New_Register (MobileDriver driver) {

        Register = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Register);

        Register.click();

        return Register;


        // This method is for new users in the app and can be used only in case the ap has been installed or re-installed


    }

    private static MobileElement RegisterGoogle =null;

    public static MobileElement Register_Google (MobileDriver driver) {

        RegisterGoogle = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Register_With_Google);

        RegisterGoogle.click();

        return RegisterGoogle;


        //Register with your gmail account


    }
}

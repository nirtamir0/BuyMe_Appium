import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class How_To_Send_POM {


    private static MobileElement After_Pay = null;

    public static MobileElement AfterPay(MobileDriver driver) {


        After_Pay = (MobileElement) driver.findElement(Appium_BuyMe_Constants.After_Pay_Btn);

        After_Pay.click();


        return After_Pay;


    }

    private static WebElement Send_By_Email = null;

    public static WebElement SendByEmail (WebDriver driver) {

        List<WebElement> all_Send_Options =driver.findElements(Appium_BuyMe_Constants.How_To_Send);

        all_Send_Options.get(2).click();

        return Send_By_Email;



    }

    private static MobileElement Email_Address = null;

    public static MobileElement Eamil (MobileDriver driver) {


        Email_Address = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Email_Address);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Email_Address.sendKeys("Appium123@gmail.com");

        return Email_Address;


    }


    private static MobileElement Next_How_To_Send = null;


    public static MobileElement Nextbtn2 (MobileDriver driver) {



        Next_How_To_Send  = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Next_Btn2);

        Next_How_To_Send .click();

        return Next_How_To_Send ;


    }
}

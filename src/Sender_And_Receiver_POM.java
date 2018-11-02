import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sender_And_Receiver_POM {



    private static MobileElement Receiver_Name = null;

    public static MobileElement ReceiverName (MobileDriver driver) throws InterruptedException {



        Receiver_Name= (MobileElement) driver.findElement(Appium_BuyMe_Constants.Receiver_Name);

        Receiver_Name.sendKeys("David");

        KeyBoard_Close.tryHideKeyboard();

        return Receiver_Name;

        //Filling up receiver's name - David


    }


    private static WebElement Event_Box = null;


    public static WebElement Event_Box_Select(WebDriver driver) {

        Event_Box = driver.findElement(Appium_BuyMe_Constants.Choose_Event_BOx);

        Event_Box.click();

        return Event_Box;

        //Clicking on the event  dropbox


    }


    private static WebElement Event_Select = null;

    public static WebElement Event_Selection(WebDriver driver) {

        List<WebElement> all_Events =driver.findElements(Appium_BuyMe_Constants.Choose_Event_BOx);

        all_Events.get(4).click();

        return Event_Select;

        //Choosing an event from the list - "WEDDING"


    }

    private static WebElement Sender = null;


    public static WebElement SenderName (WebDriver driver)  {

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false))"
                + ".scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/userFrom\"))"));


        Sender = driver.findElement(Appium_BuyMe_Constants.Sender_Name);


        Sender.sendKeys("Jimmy job");


        KeyBoard_Close.tryHideKeyboard();


        return Sender;


        //Filling up receiver's name - Jimmy job


    }
    private static MobileElement NextBotton = null;

    public static MobileElement Nextbtn (MobileDriver driver)  {


        NextBotton  = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Next_Btn);

        NextBotton.click();

        return NextBotton ;


        //Press on Nxt botton


    }


}

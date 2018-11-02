import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home_Screen_POM {


    private static MobileElement Pick_Catagory = null;

    public static MobileElement PickCatagory(MobileDriver driver) {


        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false))"
                + ".scrollIntoView(new UiSelector().text(\"גיפט קארד לבריאות, ספורט ואקסטרים\"))"));

        Pick_Catagory = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Catagory);

        Pick_Catagory.click();

        return Pick_Catagory;


        //Choose specific catagory for the gift from the list - VACATIONS GIFT CARDS


    }


    private static MobileElement Pick_Business = null;

    public static MobileElement PickBusiness(MobileDriver driver) {


        List<MobileElement> all_Business = driver.findElements(Appium_BuyMe_Constants.Business);

        all_Business.get(3).click();

        return Pick_Business;

        //Choose specific business for the gift from the list - ISTA SPORT

    }


    private static MobileElement Budget = null;

    public static MobileElement Gift_Price(MobileDriver driver) {

        Budget = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Gift_Budget);

        Budget.sendKeys("200");

        return Budget;

        //Pick price for the gift-200
    }

    private static MobileElement Purchase = null;

    public static MobileElement PurchaseBtn (MobileDriver driver) {

        Purchase = (MobileElement) driver.findElement(Appium_BuyMe_Constants.Purchase_Button);

        Purchase.click();

        return Purchase;


        //submit button after choosing price
    }

}

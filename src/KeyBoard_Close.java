
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;


public class KeyBoard_Close {



    public static AndroidDriver<MobileElement> driver;



    public static void tryHideKeyboard(){
        try {
            driver.hideKeyboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

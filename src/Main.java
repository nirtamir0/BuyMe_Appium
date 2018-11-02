import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Main {

       private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

    private static ExtentReports extent;


    private static ExtentTest test;

    private static AndroidDriver <MobileElement> driver;

    @Rule
    public TestName SS = new TestName();


    @BeforeClass
    public static void setUp() throws Exception {

        String report_path = XML_Class.getData("report");

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(report_path);

        htmlReporter.setAppendExisting(true);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.setAppendExisting(false);

        test = extent.createTest("@BeforeClass_Appium", "Loading BuyMe page with Appium");


        boolean driverEstablish = false;
        try {

            String app_package = XML_Class.getData("appPackage");
            String app_activity = XML_Class.getData("appActivity");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            capabilities.setCapability("appPackage", app_package);
            capabilities.setCapability("appActivity", app_activity);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            driverEstablish = true;

        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect App");
            test.log(Status.FATAL, "Connection Failed! " + e.getMessage());
            driverEstablish = false;
        } finally {
            if (driverEstablish) {
                test.log(Status.PASS, "Connect Succesfull");

            }
        }
    }

    @Test

    public void test01_register () {

        test = extent.createTest("@Register_Appium", "New Register");

        boolean Register = false;

        try {

            Thread.sleep(300);

            test.pass("Register Page SS", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\User\\Desktop\\Screen_Shots_App" + SS.getMethodName())).build());

            // Register_POM.New_Register(driver);  //for a new user  -see full details in Register_POM.Register

            Register_POM.Register_Google(driver);

            Register = true;

        } catch (Exception e) {
            e.printStackTrace();
        test.log(Status.FAIL, "Register Failed" + e.getMessage());
        Register = false;
    } finally {
        if (Register) {
            test.log(Status.PASS, "Succesfull register by Gmail");

        }
    }

    }

    @Test

    public void test02_Catagory () {

        test = extent.createTest("@PickCatagory_Appium", "HomeScreen");

        boolean PickCatagory = false;

        try {


            Home_Screen_POM.PickCatagory(driver);


            test.pass("After Register Page SS", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\User\\Desktop\\Screen_Shots_App" + SS.getMethodName())).build());


            PickCatagory= true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Catagory failed" + e.getMessage());
            PickCatagory= false;
        } finally {
            if ( PickCatagory) {
                test.log(Status.PASS, "Catagory Succesfull");

            }
        }
    }


    @Test

    public void test03_Business () {

        test = extent.createTest("@PickBusiness_Appium", "HomeScreen");

        boolean PickBusiness = false;

        try {

            test.pass("Business_pick SS", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\User\\Desktop\\Screen_Shots_App" + SS.getMethodName())).build());

            Home_Screen_POM.PickBusiness(driver);

            PickBusiness = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Catagory failed" + e.getMessage());
            PickBusiness = false;
        } finally {
            if (PickBusiness) {
                test.log(Status.PASS, "Catagory Succesfull");

            }
        }

    }

        @Test
        public void test04_Price () {

            test = extent.createTest("@PickValue_Appium", "HomeScreen");

            boolean Price = false;

            try {

                Home_Screen_POM.Gift_Price(driver);

                test.pass("Value_pick SS", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\User\\Desktop\\Screen_Shots_App" + SS.getMethodName())).build());

                Home_Screen_POM.PurchaseBtn(driver);

                Price = true;

            } catch (Exception e) {
                e.printStackTrace();
                test.log(Status.FAIL, "Choosing price failed" + e.getMessage());
                Price = false;
            } finally {
                if (Price) {
                    test.log(Status.PASS, "Choosing price Succesfull");

                }
            }
        }

        @Test

        public void test05_ReceiverAndSenderInfo ()  {

        test = extent.createTest("@ReceiverAndSenderInfo_Appium", "HomeScreen");

        boolean SenderAndReceiverDetails = false;

        try {

            Sender_And_Receiver_POM.ReceiverName(driver);

            test.pass("Sender and Receiver SS", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\User\\Desktop\\Screen_Shots_App" + SS.getMethodName())).build());

            Sender_And_Receiver_POM.Event_Box_Select(driver);

            Sender_And_Receiver_POM.Event_Selection(driver);

            Sender_And_Receiver_POM.SenderName(driver);

            Sender_And_Receiver_POM.Nextbtn(driver);

            SenderAndReceiverDetails = true;


        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Details failed" + e.getMessage());
            SenderAndReceiverDetails = false;
        } finally {
            if (SenderAndReceiverDetails) {
                test.log(Status.PASS, "Details succesfull");

            }
        }


    }

    @Test

    public void test06_HowToSend  () {

        test = extent.createTest("@howtosend Appium", "HomeScreen");

        boolean howtosend = false;

        try {

            Thread.sleep(200);

            test.pass("how to send SS", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\User\\Desktop\\Screen_Shots_App" + SS.getMethodName())).build());

            How_To_Send_POM.AfterPay(driver);

            How_To_Send_POM.SendByEmail(driver);

            How_To_Send_POM.Eamil(driver);

            How_To_Send_POM.Nextbtn2(driver);

            howtosend = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "how to send failed" + e.getMessage());
            howtosend = false;
        } finally {
            if (howtosend) {
                test.log(Status.PASS, "how to send succesfull");

            }
        }

    }

    @Test

    public void test07_PaymentAprrovalPage  () {

        test = extent.createTest("@paymentapprovalpage Appium", "HomeScreen");

        boolean paymentpage = false;

        try {

            Thread.sleep(200);

            test.pass("payment approval SS", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\User\\Desktop\\Screen_Shots_App" + SS.getMethodName())).build());

            paymentpage  = true;


    } catch (Exception e) {
        e.printStackTrace();
        test.log(Status.FAIL, "approval page failed" + e.getMessage());
            paymentpage = false;
    } finally {
        if ( paymentpage) {
            test.log(Status.PASS, "welcome to approval page");
        }
    }


    }


    @AfterClass

    public static void After_Class() {

        driver.quit();

        extent.flush();
    }
}


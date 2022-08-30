package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;
    public static String userFirstName = "automation";
    public static String userLastName = "tester";
    public static String dateOfBirth = "10/7/2001";
    public static String gender = "female";
    public static String companyName = "EcommerceAutomationTesting";
    public static String option = "True";
    public static String userEmail = "m1@gmail.com";
    public static String userInvalidEmail = "wrong@gmail.com";
    public static String userValidPassword = "P@ssw0rd";
    public static SoftAssert verifyRegistration = new SoftAssert();
    public static boolean CheckRegistration = false;
    public static String nokiaProductDetailsPageUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
    public static String iphoneProductDetailsPageUrl = " https://demo.nopcommerce.com/iphone-6";

    @Before
    public static void openBrowser() {
//set system property
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\monica.george\\OneDrive - ITWorx\\Desktop\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        //configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");


    }

    @After
    public static void quitBrowser() throws InterruptedException {
//        Thread.sleep(3000);
        driver.quit();
    }
}

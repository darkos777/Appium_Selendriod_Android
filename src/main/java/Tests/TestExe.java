package Tests;

import Screens.Base;
import Screens.HomeScreen;
import Screens.RegisterUser;
import Server.AppiumServer;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestExe
{
    AndroidDriver android_driver;
    AppiumServer appium_server;
    DesiredCapabilities desired_caps;

    Base base;
    HomeScreen home_screen;
    RegisterUser register_user;

    @BeforeTest
    public void launchApp() throws MalformedURLException
    {
        // Start Appium Server
        appium_server = new AppiumServer();
        if(appium_server.checkIfServerIsRunning(4723))
        {
            appium_server.stopServer();
        }
        appium_server.startServer();

        // Set up DesiredCapabilities
        desired_caps = new DesiredCapabilities();
        desired_caps.setCapability("deviceName", "Samsung J7");
        desired_caps.setCapability("udid", "52004540ecaec431");
        desired_caps.setCapability("platformName", "Android");
        desired_caps.setCapability("version", "7.0");
        desired_caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 30000);
        desired_caps.setCapability("appPackage", "io.selendroid.testapp");
        desired_caps.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
        //desired_caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,420000);
        desired_caps.setCapability(MobileCapabilityType.NO_RESET,"true");
        desired_caps.setCapability(MobileCapabilityType.FULL_RESET,"false");

        android_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desired_caps);
        android_driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        base = new Base(android_driver);
    }

    @Test (priority = 1)
    public void homeScreenTest()
    {
        home_screen = new HomeScreen(android_driver);

        home_screen.typeSomeText("Some random text");
        home_screen.tapUserRegistration();
    }

    @Test (priority = 2)
    public void registerUserTest()
    {
        register_user = new RegisterUser(android_driver);

        register_user.typeUsername("username1");
        register_user.typeEmail("user1@gmail.com");
        register_user.typePassword("user111");
    }

    @AfterTest
    public void tearDown()
    {
        android_driver.quit();
        appium_server.stopServer();
        System.out.println("Closing the server and driver...");
    }
}

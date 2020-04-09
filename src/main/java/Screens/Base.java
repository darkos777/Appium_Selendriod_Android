package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.util.NoSuchElementException;

public class Base
{
    public AndroidDriver android_driver;

    public  Base(AndroidDriver a_driver)
    {
        this.android_driver = a_driver;
    }

    public void tapOnElement(By mobile_element)
    {
        try
        {
            android_driver.findElement(mobile_element).click();
        }
        catch(NoSuchElementException nse)
        {
            System.out.println("There is no element that you are loking for: " + nse.getMessage());
        }
    }

    public void typeText(By txt_element, String text)
    {
        android_driver.findElement(txt_element).sendKeys(text);
    }
}

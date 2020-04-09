package Screens;

/*
 * Class No 2
 */

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class RegisterUser extends Base
{
    protected By username = By.id("io.selendroid.testapp:id/inputUsername");
    protected By email = By.id("io.selendroid.testapp:id/inputEmail");
    protected By password = By.id("io.selendroid.testapp:id/inputPassword");

    public RegisterUser(AndroidDriver a_driver)
    {
        super(a_driver);
    }

    public void typeUsername(String txt_username)
    {
        typeText(username, txt_username);
    }

    public void typeEmail(String txt_email)
    {
        typeText(email, txt_email);
    }

    public void typePassword(String txt_password)
    {
        typeText(password, txt_password);
    }
}

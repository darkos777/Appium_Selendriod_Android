package Screens;

/*
* Class No 1
*/
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen extends Base
{
    //@AndroidBy(id = "io.selendroid.testapp:id/my_text_field") WebElement text_field;
    //@AndroidBy(id = "io.selendroid.testapp:id/startUserRegistration") WebElement user_registration_icon;

    protected By text_field = By.id("io.selendroid.testapp:id/my_text_field");
    protected By user_registration_icon = By.id("io.selendroid.testapp:id/startUserRegistration");

    public HomeScreen(AndroidDriver a_driver)
    {
        super(a_driver);
        //PageFactory.initElements(new AppiumFieldDecorator(a_driver), this);
    }

    public void typeSomeText(String random_text)
    {
        typeText(text_field, random_text);
    }

    public void tapUserRegistration()
    {
        tapOnElement(user_registration_icon);
    }
}

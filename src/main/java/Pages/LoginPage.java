package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


    private AndroidDriver<MobileElement> driver;
    private static Logger log = LogManager.getLogger(Pages.LoginPage.class);

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/appicon")
    public WebElement AppIcon;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/etUsername")
    public WebElement UserName;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/etPassword")
    public WebElement Password;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/btLogin")
    public WebElement LoginButton;


    public LoginPage(AndroidDriver Driver)
    {
        super(Driver);
        driver = Driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void loginWithUserNameAndPassword(String username, String password) {
        wait(AppIcon);
        UserName.sendKeys(username);
        Password.sendKeys(password);
        LoginButton.click();
        log.info("username and password is entered");
    }





}

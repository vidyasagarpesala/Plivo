package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{

    private AndroidDriver<MobileElement> driver;
    private static Logger log = LogManager.getLogger(Pages.LoginPage.class);

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/logging_in_label")
    public WebElement LoginLabel;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/logged_in_as")
    public WebElement CallerID;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/call_text")
    public WebElement CallTextBox;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/call_hint_label")
    public WebElement CallHintLabel;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/call_btn")
    public WebElement CallButton;


    public HomePage(AndroidDriver Driver) {
        super(Driver);
        driver = Driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void verifyHomeScreen(String username) {
        wait(CallTextBox);
        Assert.assertTrue(LoginLabel.isDisplayed(),"Logged in as label is not displayed");
        Assert.assertEquals(CallerID.getText(), username, "User id is not matching");
        Assert.assertTrue(CallTextBox.isDisplayed(),"call text box not displayed");
        Assert.assertTrue(CallHintLabel.isDisplayed(),"call hint label is not displayed");
        Assert.assertTrue(CallButton.isDisplayed(),"call button is not displayed");
        log.info("Home page is displayed");
    }

    public void callToCallee(String callee) {
        CallTextBox.sendKeys(callee);
        hideKeyBoard();
        wait(CallButton).click();
        log.info("call to callee is initiated");
    }
}

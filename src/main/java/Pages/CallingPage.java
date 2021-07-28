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

public class CallingPage extends BasePage {

    private AndroidDriver<MobileElement> driver;
    private static Logger log = LogManager.getLogger(Pages.LoginPage.class);

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/user_icon")
    public WebElement UserIcon;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/caller_name")
    public WebElement CallerName;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/caller_state")
    public WebElement CallState;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/speaker")
    public WebElement Speaker;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/hold")
    public WebElement HoldButton;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/mute")
    public WebElement MuteButton;

    @AndroidFindBy(id = "com.plivo.plivosimplequickstart:id/end_btn")
    public WebElement EndButton;


    public CallingPage(AndroidDriver Driver) {
        super(Driver);
        driver = Driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void verifyOutGoingCallScreen(String callee) {
        waitForText(CallState,"Ringing...");
        log.info("Verifying out going call screen");
        //Verifying the out going call screen
        Assert.assertTrue(UserIcon.isDisplayed(),"UserIcon is not displayed");
        Assert.assertEquals(CallerName.getText(), callee, "callee is not matching");
        Assert.assertEquals(CallState.getText(), "Ringing...", "call state is not matching");
        Assert.assertTrue(Speaker.isDisplayed(),"Speaker is not displayed");
        Assert.assertTrue(HoldButton.isDisplayed(),"HoldButton is not displayed");
        Assert.assertTrue(MuteButton.isDisplayed(),"MuteButton is not displayed");
        Assert.assertTrue(EndButton.isDisplayed(),"EndButton is not displayed");
    }

    public void verifyActiveCallScreen(String callee) throws InterruptedException {
        log.info("Verifying active call screen");
        System.out.println("waiting");
        Thread.sleep(10000);
        //Verifying the out going call screen
        Assert.assertTrue(UserIcon.isDisplayed(),"UserIcon is not displayed");
        Assert.assertEquals(CallerName.getText(), callee, "callee is not matching");
        //Verifying the absence of ringing state
        Assert.assertFalse(CallState.getText().equals("Ringing..."),"call state is not matching");
        Assert.assertTrue(Speaker.isDisplayed(),"Speaker is not displayed");
        Assert.assertTrue(HoldButton.isDisplayed(),"HoldButton is not displayed");
        Assert.assertTrue(MuteButton.isDisplayed(),"MuteButton is not displayed");
        Assert.assertTrue(EndButton.isDisplayed(),"EndButton is not displayed");
        Assert.assertTrue(CallState.isDisplayed(),"CallState is not displayed");
    }

    public void endTheCall() {
        EndButton.click();
        log.info("ended the call");
    }

}

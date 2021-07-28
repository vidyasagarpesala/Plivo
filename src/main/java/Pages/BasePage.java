package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


    private AndroidDriver<MobileElement> driver;

    public BasePage(AndroidDriver Driver)
    {
        driver = Driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    public WebElement wait(WebElement ID){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOf(ID));
    }

    public void waitForText(WebElement ID, String text){
        WebDriverWait wait=new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.textToBePresentInElement(ID, text));
    }



    public void hideKeyBoard(){
        driver.hideKeyboard();
    }
}

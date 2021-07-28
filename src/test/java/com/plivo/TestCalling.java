package com.plivo;

import Pages.CallingPage;
import Pages.HomePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;

public class TestCalling extends BaseTest{

    private AndroidDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CallingPage callingPage;
    private static Logger log = LogManager.getLogger(com.plivo.TestCalling.class);

    @Parameters({"port"})
    @BeforeClass
    public void beforeClass(@Optional String port){

    String DevicePort = port;

    if(DevicePort == null){
        driver = BaseTest.getDriver();
    }else{
        driver = BaseTest.getDriver(DevicePort);
    }

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        callingPage = new CallingPage(driver);
    }

    @Test
    public void TestVerifyCalling() throws InterruptedException {
        log.info("Test case starts");
        loginPage.loginWithUserNameAndPassword("csdkcaller2205010941826351041747","plivo");
        homePage.verifyHomeScreen("csdkcaller2205010941826351041747");
        homePage.callToCallee("csdkcallee22953588125995310");
        callingPage.verifyOutGoingCallScreen("csdkcallee22953588125995310");
        callingPage.verifyActiveCallScreen("csdkcallee22953588125995310");
        callingPage.endTheCall();
        homePage.verifyHomeScreen("csdkcaller2205010941826351041747");
        log.info("Test case ends");
}

}

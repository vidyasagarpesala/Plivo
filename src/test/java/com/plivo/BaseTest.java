package com.plivo;

import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.HashMap;

public class BaseTest {

    private static HashMap<String, AndroidDriver> drivers = new HashMap<String, AndroidDriver>();
    private static AndroidDriver driver = null;
    private static Logger log = LogManager.getLogger(LoginPage.class);

    @Parameters({"nodeIP","port","DeviceID"})
    @BeforeTest
    public void beforeTest(@Optional String nodeIP, @Optional String port, @Optional String DeviceID){

        DOMConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j2.xml");
        if(port==null){
            //Do nothing
        }else{
            driver = new PlivoDriver(nodeIP,port,DeviceID).createAndroidDriverInstance();
            drivers.put(port,driver);
        }
    }

    public static AndroidDriver getDriver(){

        if(driver == null){
            driver=new PlivoDriver("127.0.0.1","4723","2160520822057ece").createAndroidDriverInstance();
        }else{
            return driver;
        }
        return driver;
    }
    public static AndroidDriver getDriver(String port){

        return drivers.get(port);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        log.info("ended the call");
    }
}

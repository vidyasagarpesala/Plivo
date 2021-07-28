package com.plivo;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PlivoDriver {

    private static String AppiumPort;
    private static String Nodeip;
    private static String appPackage="com.plivo.plivosimplequickstart";
    private static String appActivity="com.plivo.plivosimplequickstart.LoginActivity";
    public static String deviceid;
    private static AndroidDriver driver;
    private static Logger log = LogManager.getLogger(com.plivo.PlivoDriver.class);


    PlivoDriver(String NodeIP, String Port, String DeviceID){
        AppiumPort = Port;
        Nodeip=NodeIP;
        deviceid=DeviceID;
    }

    public static AndroidDriver createAndroidDriverInstance(){

        log.info("Creating driver session");
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability(CapabilityType.VERSION, "9.0");
        Capabilities.setCapability(CapabilityType.PLATFORM, "android");
        Capabilities.setCapability("deviceName","Samsung");
        Capabilities.setCapability("automationName","uiautomator2");
        Capabilities.setCapability("appPackage",appPackage);
        Capabilities.setCapability("appActivity",appActivity);
        Capabilities.setCapability("autoGrantPermissions",true);

        try {
            driver = new AndroidDriver(new URL("http://"+Nodeip+":"+ AppiumPort +"/wd/hub"),Capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        log.info("Android driver is created");
        return driver;
    }
}

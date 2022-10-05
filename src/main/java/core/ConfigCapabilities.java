package core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pmw.tinylog.Logger;

import java.io.FileReader;

public class ConfigCapabilities {
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String JSON_FILE_PATH = "src/main/resources/Capabilities.json";
    private static final JsonParser parser = new JsonParser();
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void applicationSetUp(){
        capabilities.setCapability(APP_PACKAGE, getJsonDataProperty(APP_PACKAGE));
        capabilities.setCapability(APP_ACTIVITY, getJsonDataProperty(APP_ACTIVITY));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability("automationName", "UiAutomator2");
    }

    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property).getAsString();
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        return "";
    }

    public DesiredCapabilities getCapabilities(){
            applicationSetUp();
        return capabilities;
    }

}

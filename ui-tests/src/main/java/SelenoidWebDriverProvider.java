//http://automation-remarks.com/2017/selenoid/index.html
//https://github.com/aerokube

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("firefox");
        browser.setVersion("64.0");
        browser.setCapability("enableVNC", true);

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    browser
            );
            driver.manage().window().setSize(new Dimension(1366, 768));
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    //19
    //23
    //29
    //30
    //33


}
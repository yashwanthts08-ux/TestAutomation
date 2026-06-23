package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import driverfactory.DriverFactory;

public class BaseTest {

    public static Properties p = new Properties();

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws IOException {

        FileReader fr = new FileReader(
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\configfiles\\config.properties");

        p.load(fr);

        DriverFactory.initDriver(browser);

        DriverFactory.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        DriverFactory.getDriver().manage().window().maximize();

        DriverFactory.getDriver().get(p.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
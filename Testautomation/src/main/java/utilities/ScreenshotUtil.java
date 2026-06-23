package utilities;




import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenshotUtil {
	public static String capture(WebDriver driver, String testName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());


        String filePath = System.getProperty("user.dir")
                + "/screenshots/" + testName + timestamp+ ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path dest = Paths.get(filePath);

            // no folder creation since you already have it
            Files.copy(src.toPath(), dest);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filePath;
    }
}



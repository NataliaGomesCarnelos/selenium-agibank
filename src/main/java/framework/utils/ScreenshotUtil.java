package framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String name) {

        try {

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String fileName = name + "_" + System.currentTimeMillis() + ".png";

            File dest = new File("build/screenshots/" + fileName);

            dest.getParentFile().mkdirs();

            Files.copy(
                    src.toPath(),
                    dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
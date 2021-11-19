package rough;

import com.base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class RoughTest {

    @Test
    public void browserTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().mac().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.quit();
    }
}

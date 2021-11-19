package com.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.concurrent.TimeUnit;

public class BrowserConfig {


    public static WebDriver get_local_driver(WebDriver driver, String browser_name, String url, String os) {

        if (browser_name.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.chromedriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.chromedriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.chromedriver().linux().setup();

            }
            driver = new ChromeDriver();

        } else if (browser_name.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.firefoxdriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.firefoxdriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.firefoxdriver().linux().setup();

            }

            driver = new FirefoxDriver();
        } else if (browser_name.equalsIgnoreCase("opera")) {
            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.operadriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.operadriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.operadriver().linux().setup();

            }

            driver = new FirefoxDriver();
        } else if (browser_name.equalsIgnoreCase("edge")) {
            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.edgedriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.edgedriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.edgedriver().linux().setup();

            }

            driver = new EdgeDriver();
        } else if (browser_name.equalsIgnoreCase("safari")) {
            if (os.equalsIgnoreCase("windows")) {
                //WebDriverManager.firefoxdriver().win().setup();
                System.out.println("Not available");

            } else if (os.equalsIgnoreCase("mac")) {
                //WebDriverManager.firefoxdriver().mac().setup();
                System.out.println("Not available");

            } else if (os.equalsIgnoreCase("linux")) {
                //WebDriverManager.firefoxdriver().linux().setup();
                System.out.println("Not available");

            }

            driver = new SafariDriver();
        }

        driver.get(url);
        //
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //
        driver.manage().window().maximize();
        //
        driver.get(url);
        //
        /*returning the driver for later use*/
        return driver;
    }

    public static WebDriver get_cloud_driver(WebDriver driver, String os, String browserName, String url) {
        DesiredCapabilities cap = null;

        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                cap = DesiredCapabilities.chrome();
                cap.setPlatform(Platform.WINDOWS);

            } else if (os.equalsIgnoreCase("mac")) {
                cap = DesiredCapabilities.chrome();
                cap.setPlatform(Platform.MAC);

            } else if (os.equalsIgnoreCase("linux")) {
                cap = DesiredCapabilities.chrome();
                cap.setPlatform(Platform.LINUX);

            } else if (os.equalsIgnoreCase("ios")) {
                cap = DesiredCapabilities.chrome();
                cap.setPlatform(Platform.IOS);

            } else if (os.equalsIgnoreCase("android")) {
                cap = DesiredCapabilities.chrome();
                cap.setPlatform(Platform.ANDROID);
            }

        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("windows")) {
                cap = DesiredCapabilities.firefox();
                cap.setPlatform(Platform.WINDOWS);

            } else if (os.equalsIgnoreCase("mac")) {
                cap = DesiredCapabilities.firefox();
                cap.setPlatform(Platform.MAC);

            } else if (os.equalsIgnoreCase("linux")) {
                cap = DesiredCapabilities.firefox();
                cap.setPlatform(Platform.LINUX);

            } else if (os.equalsIgnoreCase("ios")) {
                cap = DesiredCapabilities.firefox();
                cap.setPlatform(Platform.IOS);

            } else if (os.equalsIgnoreCase("android")) {
                cap = DesiredCapabilities.firefox();
                cap.setPlatform(Platform.ANDROID);
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            if (os.equalsIgnoreCase("windows")) {
                cap = DesiredCapabilities.edge();
                cap.setPlatform(Platform.WINDOWS);

            } else if (os.equalsIgnoreCase("mac")) {
                cap = DesiredCapabilities.edge();
                cap.setPlatform(Platform.MAC);

            } else if (os.equalsIgnoreCase("linux")) {
                cap = DesiredCapabilities.edge();
                cap.setPlatform(Platform.LINUX);

            } else if (os.equalsIgnoreCase("ios")) {
                cap = DesiredCapabilities.edge();
                cap.setPlatform(Platform.IOS);

            } else if (os.equalsIgnoreCase("android")) {
                cap = DesiredCapabilities.edge();
                cap.setPlatform(Platform.ANDROID);
            }

        } else if (browserName.equalsIgnoreCase("opera")) {
            if (os.equalsIgnoreCase("windows")) {
                cap = DesiredCapabilities.operaBlink();
                cap.setPlatform(Platform.WINDOWS);

            } else if (os.equalsIgnoreCase("mac")) {
                cap = DesiredCapabilities.operaBlink();
                cap.setPlatform(Platform.MAC);

            } else if (os.equalsIgnoreCase("linux")) {
                cap = DesiredCapabilities.operaBlink();
                cap.setPlatform(Platform.LINUX);

            } else if (os.equalsIgnoreCase("ios")) {
                cap = DesiredCapabilities.firefox();
                cap.setPlatform(Platform.IOS);

            } else if (os.equalsIgnoreCase("android")) {
                cap = DesiredCapabilities.operaBlink();
                cap.setPlatform(Platform.ANDROID);
            }

        } else if (browserName.equalsIgnoreCase("safari")) {
            if (os.equalsIgnoreCase("windows")) {
                cap = DesiredCapabilities.safari();
                cap.setPlatform(Platform.WINDOWS);

            } else if (os.equalsIgnoreCase("mac")) {
                cap = DesiredCapabilities.safari();
                cap.setPlatform(Platform.MAC);

            } else if (os.equalsIgnoreCase("linux")) {
                cap = DesiredCapabilities.safari();
                cap.setPlatform(Platform.LINUX);

            } else if (os.equalsIgnoreCase("ios")) {
                cap = DesiredCapabilities.safari();
                cap.setPlatform(Platform.IOS);

            } else if (os.equalsIgnoreCase("android")) {
                cap = DesiredCapabilities.safari();
                cap.setPlatform(Platform.ANDROID);
            }

        }

        driver.get(url);
        //
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //
        driver.manage().window().maximize();
        //
        /*returning the driver for later use*/
        return driver;
    }

    public static WebDriver get_headless_driver(WebDriver driver, String os, String browser_name, String url) {

        if (browser_name.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();

            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.chromedriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.chromedriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.chromedriver().linux().setup();

            }
            driver = new ChromeDriver(chromeOptions);

        } else if (browser_name.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.firefoxdriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.firefoxdriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.firefoxdriver().linux().setup();

            }

            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser_name.equalsIgnoreCase("opera")) {
            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.operadriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.operadriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.operadriver().linux().setup();

            }

            driver = new FirefoxDriver();
        } else if (browser_name.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.edgedriver().win().setup();

            } else if (os.equalsIgnoreCase("mac")) {
                WebDriverManager.edgedriver().mac().setup();

            } else if (os.equalsIgnoreCase("linux")) {
                WebDriverManager.edgedriver().linux().setup();

            }

            driver = new EdgeDriver(edgeOptions);
        } else if (browser_name.equalsIgnoreCase("safari")) {
            SafariOptions safariOptions = new SafariOptions();

            if (os.equalsIgnoreCase("windows")) {
                //WebDriverManager.firefoxdriver().win().setup();
                System.out.println("Not available");

            } else if (os.equalsIgnoreCase("mac")) {
                //WebDriverManager.firefoxdriver().mac().setup();
                System.out.println("Not available");

            } else if (os.equalsIgnoreCase("linux")) {
                //WebDriverManager.firefoxdriver().linux().setup();
                System.out.println("Not available");

            }

            driver = new SafariDriver(safariOptions);
        }

        driver.get(url);
        //
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //
        driver.manage().window().maximize();
        //
        driver.get(url);
        //
        /*returning the driver for later use*/
        return driver;
    }

}

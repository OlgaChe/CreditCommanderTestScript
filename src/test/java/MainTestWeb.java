import Data.MainMethods;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class MainTestWeb extends MainMethods {

    WebDriver driver;

    String os = System.getProperty("os.name").toLowerCase();

    File dir = new File("src");
    File chw = new File(dir, "chromedriver.exe");
    File chl = new File(dir, "chromedriverl");
    File chm = new File(dir, "chromedriverm");
    File ie = new File(dir, "IEDriverServer.exe");


    @BeforeTest(groups = {"testCH"})
    public void  DriverCH() {
        if (os.contains("win")){
            System.setProperty("webdriver.chrome.driver", String.valueOf(chw));
        }else if (os.contains("nux") || os.contains("nix")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(chl));
        }else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(chl));
        }
        driver = new ChromeDriver();
        driver.get(getProperty("baseUrl"));
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    
    @BeforeTest(groups = {"testFF"})
    public void  DriverFF() {
        driver = new FirefoxDriver();
        driver.get(getProperty("baseUrl"));
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterTest(groups = {"testCH", "testFF"})
    public void quit(){
        driver.quit();
    }
}



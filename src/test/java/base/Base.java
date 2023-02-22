package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class Base {
    public static WebDriver driver;
    public static Properties prop;
    public void loadPropertiesFile() throws IOException {
        prop=new Properties();
        File propFile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
        try {
            FileInputStream fis=new FileInputStream(propFile);
            prop.load(fis);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    @BeforeMethod
    public void openBrowser() throws IOException {
        loadPropertiesFile();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

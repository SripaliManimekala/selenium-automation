package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configuration {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void navigateToURL(String url){
        driver.get(url);
    }
}

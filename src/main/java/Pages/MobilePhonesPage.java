package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class MobilePhonesPage {

    WebDriver driver;
    public MobilePhonesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Function to select brand as “Apple” from side panel[checkbox]
    public void SelectAppleProducts(){
        By appleProductsCheckbox = By.xpath("//div[@id='x-refine__group_1__0']/ul/li/div/a/div/span/input[@aria-label='Apple']");
        driver.findElement(appleProductsCheckbox ).click();
    }

    //Function to select the first search item (first apple product) visible on the webpage
    public void selectTheFirstAppleProductVisible(){
        By product = By.xpath("//div[@class='srp-river-results clearfix']/ul/li[2]/div/div[2]/a");
        driver.findElement(product).click();

        //Change the chrome driver handler to the newly opened tab from the previous tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }
}

package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InitialPage {
    WebDriver driver;

    public InitialPage(WebDriver driver) {
        this.driver = driver;
    }

    //Function to get the url of the navigated web page
    public String getNavigatedUrl(){
        By urlNavigated = By.xpath("//td[@class='gh-td'][1]/h1/a");
        String navigatedUrl = (driver.findElement(urlNavigated).getAttribute("href"));
    return navigatedUrl;
    }

    public void navigateToCellPhonesPage(){

        //Select categories dropdown
        By categories = By.xpath("//div[@id='gh-cat-box']/select");
        driver.findElement(categories).click();

        //Select Cell Phones & Accessories from the categories drop down
        By cellphonesOption = By.xpath("//div[@id='gh-cat-box']/select/option[@value = '15032']");
        driver.findElement(cellphonesOption).click();

        //Type “Mobile phone” on search bar
        By searchBar = By.xpath("//div[@id='gh-ac-box2']/input");
        String searchItem = "Mobile phone";
        driver.findElement(searchBar).sendKeys(searchItem);

        //Click on Search button icon
        By searchButton = By.xpath("//td[@class='gh-td gh-sch-btn']/input");
        driver.findElement(searchButton).click();
    }
}

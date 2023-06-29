package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.NoSuchElementException;

public class ApplePhonePage {

    WebDriver driver;
    public ApplePhonePage(WebDriver driver) {
        this.driver = driver;
    }

    //Function to determine the availability of the dropdowns and to capture it if available
    public void CaptureModelOptions(){
        try {
            WebElement dropdownelement = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[1]/label/span[2]/select"));
            String optionText = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[1]/label/span[2]/select/option[2]")).getText();
            isOptionAvailableInDropDown(dropdownelement, optionText);
        }
        // Element not found, handle the exception
        catch (NoSuchElementException e) {
        }
    }

    //Function to determine the availability of the dropdowns and to capture it if available
    public void CaptureCarrierOptions() {
        try {
            WebElement dropdownelement = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[2]/label/span[2]/select"));
            String optionText = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[2]/label/span[2]/select/option[2]")).getText();
            isOptionAvailableInDropDown(dropdownelement, optionText);
        }
        // Element not found, handle the exception
        catch (NoSuchElementException e) {
        }
    }

    //Function to determine the availability of the dropdowns and to capture it if available
    public void CaptureStorageCapacityOptions() {
        try {
            WebElement dropdownelement = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[3]/label/span[2]/select"));
            String optionText = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[3]/label/span[2]/select/option[2]")).getText();
            isOptionAvailableInDropDown(dropdownelement, optionText);
        }
        // Element not found, handle the exception
        catch (NoSuchElementException e) {
        }
    }

    //Function to determine the availability of the dropdowns and to capture it if available
    public void CaptureColourOptions() {
        try{
            WebElement dropdownelement = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[4]/label/span[2]/select"));
            String optionText = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[4]/label/span[2]/select/option[2]")).getText();
            isOptionAvailableInDropDown(dropdownelement,optionText);
        }
        catch (NoSuchElementException e) {
            // Element not found, handle the exception
        }
    }

    //Function to determine the availability of the dropdowns and to capture it if available
    public void CaptureCosmeticOptions() {
        try {
            WebElement dropdownelement = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[5]/label/span[2]/select"));
            String optionText = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[5]/label/span[2]/select/option[2]")).getText();
            isOptionAvailableInDropDown(dropdownelement, optionText);
        }
        // Element not found, handle the exception
        catch (NoSuchElementException e) {
        }
    }

    //Function to check the availability of drop down options from each drop down and select a preferable option
    public boolean isOptionAvailableInDropDown(WebElement dropDownElement, String optionText) {
            try {
                Select dropdown = new Select(dropDownElement);
                List<WebElement> options = dropdown.getOptions();
                for (WebElement option : options) {
                    if (option.getText().equals(optionText)) {
                        dropdown.selectByVisibleText(optionText);
                        return true;
                    }
                }
                return false;
            } catch (NoSuchElementException e) {
                return false;
            }
    }

    //Return the product name and print in the console
    public String getItemName(){
        String itemName = driver.findElement(By.xpath("//div[@class='vim x-item-title']/h1/span")).getText();
        System.out.println("Item Name : " + itemName);
        return itemName;
    }

    //Return the product price and print in the console
    public String getItemPrice(){
        String itemPrice = driver.findElement(By.xpath("//div[@class='x-price-primary']/span/span")).getText();
        System.out.println("Item Price : " + itemPrice);
        return itemPrice;
    }

    //Return the product condition and print in the console
    public String getItemCondition(){
        String itemCondition = driver.findElement(By.xpath("//div[@class='vim x-msku']/div[5]/label/span[2]/select/option[4]")).getText();
        System.out.println("Item Condition : " + itemCondition);
        return itemCondition;
    }

    //Return the product quantity and print in the console
    public String getItemQuantity(){
        String itemQuantity = driver.findElement(By.xpath("//div[@class='d-quantity__wrapper']/span/input")).getAttribute("value");
        System.out.println("Item Quantity : " + itemQuantity);
        return itemQuantity;
    }

    //Function to add the product to the cart
    public void addToCart(){
        By addToCartIcon = By.xpath("//div[@class='vim x-atc-action overlay-placeholder']/a/span");
        driver.findElement(addToCartIcon).click();

    }
}

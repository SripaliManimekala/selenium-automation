import Pages.ApplePhonePage;
import Pages.CartPage;
import Pages.InitialPage;
import Pages.MobilePhonesPage;
import org.openqa.selenium.WebDriver;
import Utils.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Main {

    //Initiating an object from Configurations
    Configuration conf = new Configuration();
    //Define a driver from WebDriver
    WebDriver driver;
    //Define soft assert from SoftAssert class. Here soft asserts are used to continue the execution of the program even if one assertion fails.
    SoftAssert softAssert = new SoftAssert();
    //Define the URL of the webpage
    String url = "https://www.ebay.com/";

    @BeforeTest
    //Navigate to the web page
    public void setUp(){
        conf.openBrowser();
        conf.navigateToURL(url);
        driver = Configuration.getDriver();
    }

    @Test
    public void urlNavigation(){
        //Assert the navigated URL and the entered URL initially
        InitialPage initialPage = new InitialPage(driver);
        String navigatedUrl = initialPage.getNavigatedUrl();
        softAssert.assertEquals(navigatedUrl,url,"The navigated url test failed");

        //Select All Categories and Navigate to Cell Phones and Accessories Page
        initialPage.navigateToCellPhonesPage();


        MobilePhonesPage mobilePhonesPage = new MobilePhonesPage(driver);
        //Tick the apple products checkbox
        mobilePhonesPage.SelectAppleProducts();
        //Select the first appearing apple product
        mobilePhonesPage.selectTheFirstAppleProductVisible();

        ApplePhonePage applePhonePage = new ApplePhonePage(driver);

        //Fill the model option drop down
        applePhonePage.CaptureModelOptions();
        //Fill the carrier option drop down
        applePhonePage.CaptureCarrierOptions();
        //Fill the storage capacity option drop down
        applePhonePage.CaptureStorageCapacityOptions();
        //Fill the colour option drop down
        applePhonePage.CaptureColourOptions();
        //Fill the cosmetic option drop down
        applePhonePage.CaptureCosmeticOptions();

        //Get the item name displayed in the cart and print in console
        String productName = applePhonePage.getItemName();
        //Get the item price displayed in the cart print in console
        String productPrice = applePhonePage.getItemPrice();
        //Print the item condition in the console
        applePhonePage.getItemCondition();
        //Print the item quantity in the console
        applePhonePage.getItemQuantity();

        //Navigate to the cart page by adding the products to the cart
        applePhonePage.addToCart();

        CartPage cartPage = new CartPage(driver);

        //Assert the product name displayed in the cart with the product name displayed in the previous web page
        String productNameInCart = cartPage.getItemNameInCart();
        softAssert.assertEquals(productNameInCart,productName,"The item name in the cart validation was successful");

        //Assert the product price displayed in the cart with the product price displayed in the previous web page
        String productPriceInCart = cartPage.itemPriceInCart();
        softAssert.assertEquals(productPriceInCart,productPrice,"The item price in the cart validation was successful");

        //Assert the quantity in the cart with the entered quantity
        String productQuantityInCart = cartPage.itemQuantityInCart();
        softAssert.assertEquals(productQuantityInCart ,productQuantityInCart!=null,"The item price in the cart validation was successful");

        //Assert the shopping cart subtotal with the product price
        String shoppingCartSubTotal = cartPage.getTheShoppingCartSubTotal();
        softAssert.assertEquals(shoppingCartSubTotal,productPriceInCart,"The Shopping cart Sub Total Validation Was Successful");

        //Print the shipping value in the console
        cartPage.getTheShippingValue();
    }

    @AfterTest
    //Close the browser
    public void closePage(){
        driver.quit();
    }

}

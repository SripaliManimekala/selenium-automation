package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Function to return the item name displayed in the cart
    public String getItemNameInCart(){
        String itemNameInCart = driver.findElement(By.xpath("//div[@class='listsummary-content-itemdetails']/h3/span/a/span/span/label")).getText();
        return itemNameInCart;
    }

    //Function to return the item price displayed in the cart
    public String itemPriceInCart(){
        String itemPriceInCart = driver.findElement(By.xpath("//div[@class='item-price font-title-3']/span/span/span")).getText();
        return itemPriceInCart;
    }

    //Function to return the item quantity displayed in the cart
    public String itemQuantityInCart(){
        String itemQuantityInCart = driver.findElement(By.xpath("//div[@class='grid prices-and-quantity']/div/div/div/div/span/span/span[2]")).getText();
        System.out.println("The item quantity in cart : " +itemQuantityInCart.substring(4));
        return itemQuantityInCart;
    }

    //Function to return the subtotal displayed in the cart
    public String getTheShoppingCartSubTotal(){
        String shoppingCartSubTotal = driver.findElement(By.xpath("//div[@class='table']/div[4]/div[2]/span/span/span")).getText();
        return  shoppingCartSubTotal;
    }

    //Function to print the shipping value in the console
    public void getTheShippingValue(){
        String shippingValue = driver.findElement(By.xpath("//div[@class='table']/div[2]/div[2]/span/span/span")).getText();
        System.out.println("The Shipping Value is : " + shippingValue);
    }
}

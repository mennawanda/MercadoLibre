package mercadoLibre.pages;

import mercadoLibre.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomePage extends BasePage {
    private By searchBox = By.id("cb1-edit");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By productResult = By.xpath("//li[contains(@class, 'ui-search-layout__item')]");
    private By productContainer = By.xpath("//li[contains(@class, 'ui-search-layout__item')]");
    private By productPrice = By.xpath("//span[contains(@class, 'andes-money-amount__fraction')]");
    private By productId = By.xpath(".//a");

    //method to do the search
    public void searchProduct(String productName){
        set(searchBox, productName); //write in the search field
        click(searchButton); //click the button
    }

    //method to verify if products are returned
    public boolean areResultsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //wait 5 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(productResult)); //wait until products are visible
        return !driver.findElements(productResult).isEmpty(); //returns true if there are products
    }

    //method to obtain the 3 cheapest products
    public List<Product> getCheapestProduct(int top){
        List<WebElement> products = driver.findElements(productContainer); //list of products
        List<Product> productList = new ArrayList<>();

        for(WebElement product : products){
            String priceText = product.findElement(productPrice).getText().replace(".","");
            int price = Integer.parseInt(priceText); //convert the price to int
            String id = product.findElement(productId).getAttribute("href"); //obtain id of product through link
            productList.add(new Product(id, price));
        }

        //order the list
        productList.sort(Comparator.comparingInt(Product::getPrice));

        //return the top N cheapest products
        return productList.subList(0, Math.min(top, productList.size()));
    }

}

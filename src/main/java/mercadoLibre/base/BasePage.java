package mercadoLibre.base;//Parent of Page Object Classes

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
        System.out.println("Driver asignado en BasePage:" + driver);
    }

    protected WebElement find(By locator){
        if(driver == null){
            System.out.println("Driver es null en find()");
        }
        return driver.findElement(locator);
    }

    protected void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public void click(By locator){
        find(locator).click();
    }

    public static void delay(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch(InterruptedException exc){
            exc.printStackTrace();
        }
    }

}

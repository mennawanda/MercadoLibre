package base;

import mercadoLibre.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static mercadoLibre.base.BasePage.delay;
import mercadoLibre.base.BasePage;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    private String ML_URL = "https://www.mercadolibre.com.ar/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("WebDriver inicializado:" + driver);

        BasePage basePage = new BasePage();
        basePage.setDriver(driver);
        System.out.println("WebDriver asignado a BasePage:" + BasePage.driver);
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(ML_URL);
        System.out.println("Página cargada:" + ML_URL);
        homePage = new HomePage();
    }

    @AfterClass
    public void tearDown(){
        delay(3000);
        driver.quit();
    }
}

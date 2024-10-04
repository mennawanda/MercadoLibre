package tests;

import base.BaseTest;
import mercadoLibre.pages.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {
    @Test

    public void testSearch(){

        System.out.println("Iniciando búsqueda");

        homePage.searchProduct("cuadro copa libertadores 2018");

        boolean resultsDisplayed = homePage.areResultsDisplayed();

        if (resultsDisplayed) {
            System.out.println("Productos retornados correctamente");
        } else {
            System.out.println("No se encontraron productos");
        }

        assert resultsDisplayed : "No se encontraron productos después de la búsqueda";

        //obtain the 3 cheapest products
        List<Product> cheapestProducts = homePage.getCheapestProduct(3);

        //show the results in the console
        System.out.println("Los 3 productos más baratos son:");
        for(Product product : cheapestProducts){
            System.out.println(product);
        }
    }
}

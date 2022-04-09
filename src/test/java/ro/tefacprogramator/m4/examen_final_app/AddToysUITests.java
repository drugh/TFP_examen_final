package ro.tefacprogramator.m4.examen_final_app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToysUITests {
    
    @Test
    public void shouldAddToyFromUi() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/");

        driver.findElement(By.cssSelector("#desc"))
            .sendKeys("random description");

        driver.findElement(By.cssSelector("#price"))
            .sendKeys("7");

        driver.findElement(By.cssSelector("#typeID"))
            .sendKeys("1");

        driver.findElement(By.cssSelector("#categoryID"))
            .sendKeys("4");
        
        
        driver.findElement(By.cssSelector("#submit"))
            .click();
        
        String response = driver.findElement(By.cssSelector("#message"))
            .getText();

        driver.quit();

        assertTrue(response.contains("successfully"), "The status contains the word successfully");


    }

    @Test
    public void shouldHaveATable() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/");

        List<WebElement> elm = driver.findElements(By.cssSelector("tr"));

        assertTrue(elm.size() >= 3);
    }
}

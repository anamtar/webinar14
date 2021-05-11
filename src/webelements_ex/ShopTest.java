package webelements_ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ShopTest extends BasePage  //rozszerzenie o klasę główną gdzie jest driver
{
    @Test // tak oznaczamy tesy
    public void openHomePage()
    {
        WebElement logoElement = driver.findElement(By.id("_desktop_logo")); //Wyszukiwanie elementu z logotypem na stronie
        String pageTitle = driver.getTitle(); //Pobieranie tytułu strony (wyświetlanego na pasku przeglądarki/zakładki)

        Assert.assertEquals(pageTitle, "Automation Sample Shop"); //Upewnianie się, że tytuł jest poprawny
    }


    @Test
    public void checkHomePageUrl()
    {
        String pageUrl = driver.getCurrentUrl();   //Pobieranie bieżącego adresu strony

        Assert.assertEquals(pageUrl, "http://sampleshop.inqa.pl/");
    }


}

package webelements_ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CategoryTest extends BasePage
{

    @Test
    public void openMenClothesCategory()
    {
        WebElement clothesCategoryElement = driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(clothesCategoryElement).pause(2000).moveToElement(driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a"))).click().build().perform();
        //Wykorzystanie akcji do otwierania kategorii z wykorzystaniem menu dynamicznego
        driver.findElement(By.cssSelector(".breadcrumb > ol:nth-child(1) > li:nth-child(3) > span:nth-child(1)"));
        //Upewnienie się, że strona kategorii została otwarta
        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Men");
    }

    @Test
    public void openArtCategory()
    {
        WebElement artCategory = driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[3]/a"));
        artCategory.click();

        String artTitle = driver.getTitle();
        String artUrl = driver.getCurrentUrl();

        Assert.assertEquals(artTitle, "Art");
        Assert.assertEquals(artUrl, "http://sampleshop.inqa.pl/9-art");

    }

    @Test
    public void searchOption()
    {

        WebElement searchField = driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[2]/form/input[2]"));
        searchField.sendKeys("brown bear notebook");
        WebElement startSearching = driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[2]/form/button/i"));
        startSearching.click();

        String searchPage = driver.getCurrentUrl();

        Assert.assertEquals(searchPage,"http://sampleshop.inqa.pl/szukaj?controller=search&s=brown+bear+notebook");

    }

}

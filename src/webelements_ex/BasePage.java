package webelements_ex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver; // tutaj, żeby każda klasa miała dostęp

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();    // określenie drivera - w tym wypadku Firefox
        driver.get("http://sampleshop.inqa.pl/"); //otworzenie strony
        driver.manage().window().maximize(); // maksymalizacja okna
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //automatyczne czekanie na elementy
    }

    @BeforeMethod
    public void methodSetup() {
        System.out.println("Uruchamiam kolejną metodę");
    }

    @AfterClass
    public void tearDown() {

        //driver.quit(); // wyjście i zamknięcie strony
    }
}


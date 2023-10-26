import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "drivers\\selenium-firefox-driver-4.14.1.jar");
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void differentLocatorsTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var confirmPasswordElement = driver.findElement(By.name("confirm_password"));
    }

    @Test
    public void validSizeCheckTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("size")).sendKeys("42");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.id("size-success")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assertions.assertEquals(expectedResult, actualResult, "Несоответствующее сообщение");
    }

    @Test
    public void emptySizeCheckTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "Введите размер обуви!";
        Assertions.assertEquals(expectedResult, actualResult, "Отсутствие сообщения об ошибке");

    }

    @Test
    public void bookShopLocatorsTest() {
        driver.navigate().to("https://qajava.skillbox.ru/");
        var feedbackLink = driver.findElement(By.linkText("Обратная связь"));
        var preorderLink = driver.findElement(By.partialLinkText("Предзаказы"));
        var aboutUsLink = driver.findElement(By.linkText("О магазине"));
        var bookAddLink = driver.findElement(By.tagName("button"));
        var cartCount = driver.findElement(By.id("cart_count"));
        var genresLink = driver.findElement(By.id("genres"));
        var searchField = driver.findElement(By.name("search-input-form"));
    }

    @Test
    public void bookShopCountTest() {
        driver.navigate().to("https://qajava.skillbox.ru/");
        var bookElement = driver.findElements(By.className("book-info"));
        Assertions.assertEquals(15, bookElement.size(), "Несоответствующее количество элементов на странице");

    }
}

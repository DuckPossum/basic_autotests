import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OnlineCinemaRegistrationTests {
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
    public void validRegistrationTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Валентин");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-result")).getText();
        var expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assertions.assertEquals(expectedResult, actualResult, "Несоответствующий текст сообщения");
    }

    @Test
    public void emptyFieldsRegistrationTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-error")).getText();
        var expectedResult = "Введите имя";
        Assertions.assertEquals(expectedResult, actualResult, "Несоответствующий текст ошибки");

    }

}

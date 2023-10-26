import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComplexHelloPageTests {
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
    public void emptyFieldsTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Данные поля обязательны для заполнения: ФИО, E-mail, Телефон";
        Assertions.assertEquals(expectedResult, actualResult, "Несоответствующий текст ошибки");
    }
    @Test
    public void correctFieldsTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Зубенко Михаил Петрович");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("88005553535");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Зубенко Михаил Петрович.\n" +
                "На вашу почту (test@test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 88005553535.";
        Assertions.assertEquals(expectedResult, actualResult, "Несоответствующий текст приветствия");
    }
    @Test
    public void invalidEmailTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Зубенко Михаил Петрович");
        driver.findElement(By.name("email")).sendKeys("testing@@test..ru");
        driver.findElement(By.name("phone")).sendKeys("88005553535");
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        driver.findElement(By.className("button")).click();
        var expectedResult = "Недействительный e-mail адрес!";
        Assertions.assertEquals(expectedResult, actualResult, "Несоответствующий текст ошибки");
    }
    @Test
    public void invalidPhoneNumberTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Зубенко Михаил Петрович");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("8800555иван");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Недействительный номер телефона!";
        Assertions.assertEquals(expectedResult, actualResult,"Несоответствующий текст ошибки");
    }
    @Test
    public void invalidNameTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("%@@!*&!%!%148");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("88005553535");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Недопустимые символы в поле 'Имя'!";
        Assertions.assertEquals(expectedResult, actualResult, "Несоответствующий текст ошибки");
    }
}

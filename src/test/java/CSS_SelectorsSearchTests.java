import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyHomeworkTests {

    private WebDriver driver;

    // computerRepairPageTest Locators
    By nameField = By.cssSelector("input.form-input.fio");
    By streetField = By.cssSelector(".data.form-input.street");
    By houseNumberField = By.cssSelector(".form-input.house");
    By flatNumberField = By.cssSelector(".form-input.flat");
    By dateField = By.cssSelector(".form-input.date");
    By submitButton = By.cssSelector("button.form-submit");
    By allEnteredData = By.cssSelector("p.form-result-description");

    // funnySocksClubAuthorisationTest Locators
    By emailField = By.id("email");
    By passwordField = By.name("password");
    By signInButton = By.tagName("button");
    By errorMessage = By.className("form-error-password-email");

    // funnySocksClubAuthorisationTest2 Locators
    By emailField2 = By.cssSelector(".form-input.input-data");
    By passwordField2 = By.cssSelector(".form-input.password");
    By signInButton2 = By.cssSelector(".form-submit");
    By errorMessage2 = By.cssSelector(".form-error-password-email");

    // funnySocksClubAuthorisationTest3 Locators
    By emailField3 = By.cssSelector("input.form-input.input-data");
    By passwordField3 = By.cssSelector("input.form-input.password");
    By signInButton3 = By.cssSelector("button.form-submit");
    By errorMessage3 = By.cssSelector("pre.form-error-password-email");

    // funnySocksClubAuthorisationTest4 Locators
    By emailField4 = By.cssSelector("#email");
    By passwordField4 = By.cssSelector("#password");
    By signInButton4 = By.cssSelector("#submit");
    By errorMessage4 = By.cssSelector("#error");

    // funnySocksClubAuthorisationTest5 Locators
    By emailField5 = By.cssSelector("input#email.form-input.input-data");
    By passwordField5 = By.cssSelector("input#password.form-input.password");
    By signInButton5 = By.cssSelector("button#submit.form-submit");
    By errorMessage5 = By.cssSelector("pre#error.form-error-password-email");

    @BeforeEach
    public void setUp()
    {
        System.setProperty("webdriver.firefox.driver", "drivers\\selenium-firefox-driver-4.14.1.jar");
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void computerRepairPageTest() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson3/index.html");
        var name = "Петров Мох Сергеевич";
        var street = "Гаршина";
        var house = "9А";
        var flat = "64";
        var date = "Суббота";
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(streetField).sendKeys(street);
        driver.findElement(houseNumberField).sendKeys(house);
        driver.findElement(flatNumberField).sendKeys(flat);
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(submitButton).click();
        Assertions.assertTrue(driver.findElement(allEnteredData).isDisplayed(), "Не отобразилось сообщение о введённых данных");
        Assertions.assertEquals("Вы ввели следующие данные:", driver.findElement(allEnteredData).getText(), "Неверный текст сообщения о введённых данных");
    }
    @Test
    public void funnySocksClubAuthorisationTest() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/index.html");
        var email = "@";
        var password = "123";
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        Assertions.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Не отобразилось сообшение об ошибке");
        Assertions.assertEquals("Некорректный email или пароль", driver.findElement(errorMessage).getText());


    }
    @Test
    public void funnySocksClubAuthorisationTest2() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        driver.findElement(emailField2).sendKeys(email);
        driver.findElement(passwordField2).sendKeys(password);
        driver.findElement(signInButton2).click();
        Assertions.assertTrue(driver.findElement(errorMessage2).isDisplayed(), "Не отобразилось сообщение об ошибке");
        Assertions.assertEquals("Некорректный email или пароль", driver.findElement(errorMessage2).getText());
    }
    @Test
    public void funnySocksClubAuthorisationTest3() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        driver.findElement(emailField3).sendKeys(email);
        driver.findElement(passwordField3).sendKeys(password);
        driver.findElement(signInButton3).click();
        Assertions.assertTrue(driver.findElement(errorMessage3).isDisplayed(), "Не отобразилось сообщение об ошибке");
        Assertions.assertEquals("Некорректный email или пароль", driver.findElement(errorMessage3).getText());
    }
    @Test
    public void funnySocksClubAuthorisationTest4() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        driver.findElement(emailField4).sendKeys(email);
        driver.findElement(passwordField4).sendKeys(password);
        driver.findElement(signInButton4).click();
        Assertions.assertTrue(driver.findElement(errorMessage4).isDisplayed(), "Не отобразилось сообщение об ошибке");
        Assertions.assertEquals("Некорректный email или пароль", driver.findElement(errorMessage4).getText());
    }
    @Test
    public void funnySocksClubAuthorisationTest5() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        driver.findElement(emailField5).sendKeys(email);
        driver.findElement(passwordField5).sendKeys(password);
        driver.findElement(signInButton5).click();
        Assertions.assertTrue(driver.findElement(errorMessage5).isDisplayed(), "Не отобразилось сообщение об ошибке");
        Assertions.assertEquals("Некорректный email или пароль", driver.findElement(errorMessage5).getText());
    }

}

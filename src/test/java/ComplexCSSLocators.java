import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyHomeworkTests {

    private WebDriver driver;

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

    // Задание №1 (подзадания 1-7)

    By firstCaseLocator1 = By.cssSelector("[test-info='about-us']");
    By firstCaseLocator2 = By.cssSelector("a[href='']");
    By firstCaseLocator3 = By.cssSelector("[selected]");
    By firstCaseLocator4 = By.cssSelector("div[class='book-price'");
    By firstCaseLocator5 = By.cssSelector("button[class^='book'");
    By firstCaseLocator6 = By.cssSelector("[class$='main']");
    By firstCaseLocator7 = By.cssSelector("a[class*='menu']");

    // Задание №2 (подзадания 1-3)

    By secondCaseLocator1 = By.cssSelector("footer[id='footer']>div");
    By secondCaseLocator2 = By.cssSelector("[id='genres'] + *");
    By secondCaseLocator3 = By.cssSelector("div.filter-container ~ *");

    // Задание №3 (подзадания 1-5)

    By thirdCaseLocator1 = By.cssSelector("section.important-section-block[for = 'main-header-page'] > h1:first-child");
    By thirdCaseLocator2 = By.cssSelector("form.form[id = 'login-form'] > p:last-child");
    By thirdCaseLocator3 = By.cssSelector("body > *:nth-child(3)");
    By thirdCaseLocator4 = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");
    By thirdCaseLocator5 = By.cssSelector("div.footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)");

    @Test
    public void FirstCase() {
        driver.navigate().to("https://qajava.skillbox.ru/index.html");
        driver.findElement(firstCaseLocator1);
        driver.findElement(firstCaseLocator2);
        driver.navigate().to("https://qajava.skillbox.ru/search.html");
        driver.findElement(firstCaseLocator3);
        driver.navigate().to("https://qajava.skillbox.ru/index.html");
        driver.findElement(firstCaseLocator4);
        driver.findElement(firstCaseLocator5);
        driver.findElement(firstCaseLocator6);
        driver.findElement(firstCaseLocator7);
    }

    @Test
    public void SecondCase() {
        driver.navigate().to("https://qajava.skillbox.ru/index.html");
        driver.findElement(secondCaseLocator1);
        driver.findElement(secondCaseLocator2);
        driver.navigate().to("https://qajava.skillbox.ru/search.html");
        driver.findElement(secondCaseLocator3);
    }
    @Test
    public void ThirdCase() {
        driver.navigate().to("https://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(thirdCaseLocator1);
        driver.findElement(thirdCaseLocator2);
        driver.findElement(thirdCaseLocator3);
        driver.findElement(thirdCaseLocator4);
        driver.findElement(thirdCaseLocator5);
    }
}


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyHomeworkTests {
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

    By locatorA = By.cssSelector("section.header p");

    By locatorB = By.cssSelector("div.text a");

    By locatorC = By.cssSelector("section > div.text:nth-of-type(2) a");

    By taxiPageLocator1 = By.cssSelector("input[type=text]:not([id])");
    By taxiPageLocator2 = By.cssSelector("p[class*=form]:not([class$=error])");
    By taxiPageLocator3 = By.cssSelector("div.form-inner p.form-row:nth-of-type(1)");

    @Test
    public void organizerPageTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By articleLinkButton = By.cssSelector("button.articlePreview__link");
        By firstArticle = By.cssSelector("div.articlePreview.pageArticle__articlePreview:nth-of-type(1)");
        By secondArticle = By.cssSelector("div.articlePreview.pageArticle__articlePreview:nth-of-type(2)");
        By articleTitleText = By
                .cssSelector("div.articlePreview.pageArticle__articlePreview:nth-of-type(1) p.articlePreview__title");
        By articleText = By
                .cssSelector("div.articlePreview.pageArticle__articlePreview:nth-of-type(1) p.articlePreview__text");
        By articleDeleteButton = By.cssSelector("button.pageArticle__button:nth-of-type(2)");
        var expectedTitle = "План на следующий месяц";
        var expectedText = "Прочитать книгу «Искусство цвета».";
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        driver.findElement(articleLinkButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(firstArticle));
        wait.until(ExpectedConditions.presenceOfElementLocated(secondArticle));
        Assertions.assertTrue(driver.findElement(firstArticle).isDisplayed(), "Заметка не отображается в общем списке");
        Assertions.assertEquals(expectedTitle, driver.findElement(articleTitleText).getText(),
                "Заголовок заметки не соответствует ожидаемому");
        Assertions.assertEquals(expectedText, driver.findElement(articleText).getText(),
                "Текст заметки не соответствует ожидаемому");
        driver.findElement(articleDeleteButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(firstArticle));
        driver.findElement(articleLinkButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(articleDeleteButton));
        driver.findElement(articleDeleteButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(secondArticle));
        Assertions.assertTrue(driver.findElements(secondArticle).size() == 0);

    }
}

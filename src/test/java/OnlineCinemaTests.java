import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OnlineCinemaTests {
    WebDriver driver;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "drivers\\selenium-firefox-driver-4.14.1.jar");
        driver = new FirefoxDriver();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void preferencesSaveTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var films = driver.findElement(By.id("films"));
        var serials = driver.findElement(By.id("serials"));
        var saveButton = driver.findElement(By.id("save"));
        var nextPageButton = driver.findElement(By.id("two"));
        var showAnswersButton = driver.findElement(By.id("ok"));
        var addedFilms = driver.findElement(By.id("best_films"));
        var addedSerials = driver.findElement(By.id("best_serials"));
        var favoriteFilms = "Скотт Пилигрим против всех";
        var favoriteSerials = "Клиника";
        films.sendKeys(favoriteFilms);
        serials.sendKeys(favoriteSerials);
        saveButton.click();
        nextPageButton.click();
        saveButton.click();
        showAnswersButton.click();
        var expectedFilms = addedFilms.getText();
        var expectedSerials = addedSerials.getText();
        Assertions.assertEquals(favoriteFilms, expectedFilms,
                "Несоответствие введённых и выводимых после сохранения данных");
        Assertions.assertEquals(favoriteSerials, expectedSerials,
                "Несоответствие введённых и выводимых после сохранения данных");
    }

    @Test
    public void preferencesSaveTest2() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var films = driver.findElement(By.id("films"));
        var serials = driver.findElement(By.id("serials"));
        var russianSubtitlesCheckBox = driver
                .findElement(By.xpath("/html/body/main/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[1]/label/span"));
        var originalSoundCheckBox = driver
                .findElement(By.xpath("/html/body/main/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[3]/label/span"));
        var ageRadioButton = driver
                .findElement(By.xpath("/html/body/main/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/label/span"));
        var saveButton = driver.findElement(By.id("save"));
        var nextPageButton = driver.findElement(By.id("two"));
        var showAnswersButton = driver.findElement(By.id("ok"));
        var addedFilms = driver.findElement(By.id("best_films"));
        var addedSerials = driver.findElement(By.id("best_serials"));
        var favoriteFilms = "Маяк";
        var favoriteSerials = "Извне";
        films.sendKeys(favoriteFilms);
        serials.sendKeys(favoriteSerials);
        saveButton.click();
        nextPageButton.click();
        russianSubtitlesCheckBox.click();
        originalSoundCheckBox.click();
        ageRadioButton.click();
        saveButton.click();
        showAnswersButton.click();
        var actualFilms = addedFilms.getText();
        var actualSerials = addedSerials.getText();
        var actualPreferences = driver.findElement(By.id("language")).getText();
        var actualAge = driver.findElement(By.id("age")).getText();
        Assertions.assertEquals(favoriteFilms, actualFilms,
                "Несоответствие введённых и выводимых после сохранения данных в поле 'Ваши любмиые фильмы:'");
        Assertions.assertEquals(favoriteSerials, actualSerials,
                "Несоответствие введённых и выводимых после сохранения данных в поле 'Ваши любимые сериалы:'");
        Assertions.assertEquals("С русскими субтитрами, В оригинале", actualPreferences,
                "Несоответствие введённых и выводимых после сохранения данных в поле 'Я люблю смотреть фильмы:'");
        Assertions.assertEquals("26-30", actualAge,
                "Несоответствие введённых и выводимых после сохранения данных в поле 'Возраст:'");

    }

    @Test
    public void clearFieldsTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var films = driver.findElement(By.id("films"));
        var clearFilmsButton = driver.findElement(By.className("delete"));
        var favoriteFilms = "Большой куш";
        var clearFilmsField = "";
        films.sendKeys(favoriteFilms);
        clearFilmsButton.click();
        Assertions.assertEquals(clearFilmsField, films.getText());
    }

}

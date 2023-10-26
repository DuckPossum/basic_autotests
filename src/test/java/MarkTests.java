import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarkTests {

    @Test
    public void lowMarkTest1() {
        var actualResult = getMarkResult(0);
        Assertions.assertEquals("2", actualResult);
    }

    @Test
    public void lowMarkTest2() {
        var actualResult = getMarkResult(24);
        Assertions.assertEquals("2", actualResult);
    }

    @Test
    public void lowMarkTest3() {
        var actualResult = getMarkResult(35);
        Assertions.assertEquals("2", actualResult);
    }

    @Test
    public void averageMarkTest1() {
        var actualResult = getMarkResult(36);
        Assertions.assertEquals("3", actualResult);
    }

    @Test
    public void averageMarkTest2() {
        var actualResult = getMarkResult(48);
        Assertions.assertEquals("3", actualResult);
    }

    @Test
    public void averageMarkTest3() {
        var actualResult = getMarkResult(56);
        Assertions.assertEquals("3", actualResult);
    }

    @Test
    public void goodMarkTest1() {
        var actualResult = getMarkResult(57);
        Assertions.assertEquals("4", actualResult);
    }

    @Test
    public void goodMarkTest2() {
        var actualResult = getMarkResult(60);
        Assertions.assertEquals("4", actualResult);
    }

    @Test
    public void goodMarkTest3() {
        var actualResult = getMarkResult(71);
        Assertions.assertEquals("4", actualResult);
    }

    @Test
    public void excellentMarkTest1() {
        var actualResult = getMarkResult(72);
        Assertions.assertEquals("5", actualResult);
    }

    @Test
    public void excellentMarkTest2() {
        var actualResult = getMarkResult(89);
        Assertions.assertEquals("5", actualResult);
    }

    @Test
    public void excellentMarkTest3() {
        var actualResult = getMarkResult(100);
        Assertions.assertEquals("5", actualResult);
    }

    @Test
    public void allMarksTests() {
        testMark(0, "2");
        testMark(25, "2");
        testMark(35, "2");
        testMark(36, "3");
        testMark(48, "3");
        testMark(56, "3");
        testMark(57, "4");
        testMark(60, "4");
        testMark(71, "4");
        testMark(72, "5");
        testMark(89, "5");
        testMark(100, "5");
    }

    private void testMark(int mark, String expectedMarkResult) {
        var actualResult = getMarkResult(mark);
        Assertions.assertEquals(expectedMarkResult, actualResult);
    }

    private String getMarkResult(Integer mark) {

        if (mark >= 0 && mark <= 35)
            return "2";

        if (mark > 35 && mark <= 56)
            return "3";

        if (mark > 56 && mark < 71)
            return "4";

        if (mark > 72 && mark < 100)
            return "5";

        return "no mark result";

    }
}
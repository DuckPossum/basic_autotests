public class TicketTests {

    @Test
    public void concertCancelledTest() {
        var actualResult = getRefundTicketPricePercent(150, true, true);
        Assertions.assertEquals(100, actualResult);
    }

    @Test
    public void plentyOfTimeBeforeConcertTest() {
        var actualResult = getRefundTicketPricePercent(264, false, false);
        Assertions.assertEquals(100, actualResult);
    }

    @Test
    public void exactTimeBeforeConcertTest() {
        var actualResult = getRefundTicketPricePercent(240, false, false);
        Assertions.assertEquals(100, actualResult);
    }

    @Test
    public void middleTimeBeforeConcertTest() {
        var actualResult = getRefundTicketPricePercent(144, false, false);
        Assertions.assertEquals(50, actualResult);
    }

    @Test
    public void shortTimeBeforeConcertTest() {
        var actualResult = getRefundTicketPricePercent(48, false, true);
        Assertions.assertEquals(30, actualResult);
    }

    @Test
    public void almostNoTimeBeforeConcertTest() {
        var actualResult = getRefundTicketPricePercent(4, false, true);
        Assertions.assertEquals(30, actualResult);
    }

    @Test
    public void noTimeBeforeConcertTest() {
        var actualResult = getRefundTicketPricePercent(2, false, true);
        Assertions.assertEquals(0, actualResult);
    }

    private int getRefundTicketPricePercent(int hoursBeforeConcert, boolean wasConcertCancelled,
            boolean wasConcertRescheduled) {
        if (wasConcertCancelled && wasConcertRescheduled)
            return 100;
        if (hoursBeforeConcert > 240)
            return 100;
        if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240)
            return 50;
        if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144)
            return 30;
        return 0;
    }
}

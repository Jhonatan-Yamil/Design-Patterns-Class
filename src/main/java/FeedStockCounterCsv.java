public class FeedStockCounterCsv extends FeedStockCounter {
    @Override
    protected FeedParser buildParser() {
        return new FeedParserCsv();
    }
}

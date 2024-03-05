public class FeedStockCounterJson extends FeedStockCounter{
    @Override
    protected FeedParser buildParser() {
        return new FeedParserJson();
    }
}

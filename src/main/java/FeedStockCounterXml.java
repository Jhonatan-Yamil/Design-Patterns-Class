import java.util.List;

public class FeedStockCounterXml extends FeedStockCounter {
    @Override
    protected FeedParser buildParser() {
        return new FeedParserXml();
    }

    @Override
    public int totalStock(String content) {
        FeedParserXml parser = (FeedParserXml) buildParser();
        List<Flower> flowers = parser.parse(content);
        
        int totalStock = 0;
        for (Flower flower : flowers) {
            totalStock += flower.totalStock(); // Utiliza el método totalStock de la clase Flower
        }
        return totalStock;
    }
}

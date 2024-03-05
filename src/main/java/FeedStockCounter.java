import java.util.List;

public abstract class FeedStockCounter {
    public int totalStock(String feed) {
        List<Flower> flowers = this.buildParser().parse(feed);
        return this.countTotalStock(flowers);
    }

    private int countTotalStock(List<Flower> flowers) {
        int total = 0;
        for (Flower item: flowers) {
            total += item.totalStock();
        }

        return total;
    }


    protected abstract FeedParser buildParser();
}

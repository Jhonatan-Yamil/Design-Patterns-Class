import java.util.ArrayList;
import java.util.List;

public class FeedParserCsv implements FeedParser {
    @Override
    public List<Flower> parse(String content) {
        List<Flower> flowersData = new ArrayList();
        String[] rows = content.split("\n", 0);

        for(int index = 0; index < rows.length; index++) {
            if (index > 0) {
                String[] fields = rows[index].split(",", 0);
                flowersData.add(new Flower(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2])));
            }
        }

        return flowersData;
    }
}

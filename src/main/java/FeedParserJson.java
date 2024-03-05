import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.List;

public class FeedParserJson implements FeedParser {
    @Override
    public List<Flower> parse(String content) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Flower>>() {}.getType();

        List<Flower> flowersData = gson.fromJson(content, listType);
        return flowersData;
    }
}

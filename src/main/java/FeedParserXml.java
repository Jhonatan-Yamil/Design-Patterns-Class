import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class FeedParserXml implements FeedParser {
    @Override
    public List<Flower> parse(String content) {
        List<Flower> flowersData = new ArrayList<>();

        try {
            // Crear un constructor de documentos
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el contenido XML
            Document document = builder.parse(new ByteArrayInputStream(content.getBytes()));

            // Obtener la lista de elementos 'row'
            NodeList nodeList = document.getElementsByTagName("row");

            // Iterar sobre los elementos 'row'
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                // Obtener los valores de id, name y stock
                int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                int stock = Integer.parseInt(element.getElementsByTagName("stock").item(0).getTextContent());

                // Crear un objeto Flower y añadirlo a la lista
                Flower flower = new Flower(id, name, stock);
                flowersData.add(flower);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flowersData;
    }
}

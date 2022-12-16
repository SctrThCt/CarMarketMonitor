package PriceAnalysis;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class GetData {

   public static Path pathWithCode = Path.of("C:\\Projects\\CarMarketMonitor\\CarMarketMonitor\\test.txt");
   public static Path pathToTransformed = Path.of("C:\\Projects\\CarMarketMonitor\\CarMarketMonitor\\testOut.txt");
    public static void getPageCode(URL url) throws IOException
    {
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        Files.write(pathWithCode, buffer);

    }
    public static ArrayList<String> getCarInfo(String url) throws IOException
    {
        ArrayList<String> carProperties = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements saleInfo = doc.select("div.block-sale-info");
        String id = saleInfo.text();
        Elements carName = doc.select("a.link");
        String carManufacturer = "Manufacturer: ".concat(carName.text().substring(0,carName.text().indexOf(" ")));
        String carModel = "Model:".concat(carName.text().substring(carName.text().indexOf(" "),carName.text().indexOf(",")));
        carProperties.add(carManufacturer);
        carProperties.add(carModel);
        id = "Id: ".concat(id.substring(id.indexOf("#")+1,id.indexOf("#")+8));
        carProperties.add(id);
        Elements price = doc.select("div.block-sale-price");
        String priceAsString = "Цена: ".concat(price.text().replaceAll("[^0-9]",""));
        carProperties.add(priceAsString);
        Elements body = doc.select("div.sale-property");
        for (Element e:body)
        {
            carProperties.add(e.text());
        }
        return carProperties;
    }




}

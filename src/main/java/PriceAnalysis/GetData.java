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

public class GetData {

   public static Path pathWithCode = Path.of("C:\\Projects\\CarMarketMonitor\\CarMarketMonitor\\test.txt");
   public static Path pathToTransformed = Path.of("C:\\Projects\\CarMarketMonitor\\CarMarketMonitor\\testOut.txt");
    public static void getPageCode(URL url) throws IOException
    {
        InputStream input =url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        Files.write(pathWithCode, buffer);

    }
    public static void removeCode(String url) throws IOException
    {
        Document doc = Jsoup.connect(url).get();
        Elements saleInfo = doc.select("div.block-sale-info");
        for (Element e:saleInfo)
        {
            System.out.println(e.text());
        }
        Elements price = doc.select("div.block-sale-price");
        System.out.println(price.text());
        Elements body = doc.select("div.sale-property");
        for (Element e:body)
        {
            System.out.println(e.text());
        }
    }




}

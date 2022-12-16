package PriceAnalysis;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {


        URL url = new URL("https://autosakhcom.ru/sale/1620790");
        String ur1 = "https://autosakhcom.ru/sale/1631462/";
        ArrayList<String> carInfo = null;
        try {
            carInfo = GetData.getCarInfo(ur1);
        }
        catch (Exception e)
        {
            System.out.println("Че то не так");
        }
        System.out.println("Вроде все ок");

        //carInfo.forEach(System.out::println);

        CarInfo info = new CarInfo(carInfo);
        System.out.println(info.toString());

    }
}
package PriceAnalysis;

import java.util.ArrayList;

public class CarInfo {

    public int id;
    public String manufacturer;
    public String modelName;
    public int price;
    public int year;
    public String bodyType;
    public String transmission;
    public String engineType;
    public int engineVolume;
    public int enginePower;
    public String driveType;
    public int mileage;
    public String city;

    public CarInfo(ArrayList<String> carInfo)
    {
        for(String e:carInfo)
        {
            if (e.startsWith("Id: ")) this.id = Integer.parseInt(e.split(": ")[1]);
            if (e.startsWith("Manufacturer: ")) this.manufacturer = e.split(": ")[1];
            if (e.startsWith("Model: ")) this.modelName = e.split(": ")[1];
            if (e.startsWith("Цена: ")) this.price = Integer.parseInt(e.split(": ")[1]);
            if (e.startsWith("Год: ")) this.year = Integer.parseInt(e.split(": ")[1]);
            if (e.startsWith("Тип кузова: ")) this.bodyType = e.split(": ")[1];
            if (e.startsWith("Трансмиссия: ")) this.transmission = e.split(": ")[1];
            if (e.startsWith("Привод: ")) this.driveType = e.split( ": ")[1];
            if (e.startsWith("Пробег: ")) this.mileage = Integer.parseInt(e.split(": ")[1].replaceAll("[^0-9]",""));
            if (e.startsWith("Город: ")) this.city = e.split(": ")[1];
            if (e.startsWith("Двигатель: "))
            {
                String[] temp = e.split(": ")[1].split(", ");
                for (String t:temp)
                {
                    System.out.println(t);
                }
                for (String s:temp) {
                    if (s.startsWith("Б")||s.startsWith("Д")||s.startsWith("Э")||s.startsWith("Г"))
                    {
                        this.engineType = s;
                    }
                    if (s.endsWith(" см3"))
                    {
                        this.engineVolume = Integer.parseInt(s.substring(0, s.indexOf(" ")));
                    }
                    if (s.endsWith(" л.с."))
                    {
                        this.enginePower = Integer.parseInt(s.substring(0, s.indexOf(" ")));
                    }
                }
            }




        }
    }

    @Override
    public String toString() {
        return  id+"/"+
                manufacturer+"/"+
                modelName+"/"+
                price+"/"+
                year+"/"+
                bodyType+"/"+
                transmission+"/"+
                engineType+"/"+
                engineVolume+"/"+
                enginePower+"/"+
                driveType+"/"+
                mileage+"/"+
                city;

    }
}

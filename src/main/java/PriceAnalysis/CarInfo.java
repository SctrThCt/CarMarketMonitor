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
                for (String s:temp) {
                    if (e.startsWith("Б")||e.startsWith("Д")||e.startsWith("Э")||e.startsWith("Г"))
                    {
                        this.engineType = s;
                    }
                    if (e.endsWith("см3"))
                    {
                        this.engineVolume = Integer.parseInt(s.substring(0, s.indexOf(" ")));
                    }
                    if (e.endsWith("л.с."))
                    {
                        Integer.parseInt(e.replaceAll("[^0-9]", ""));
                    }
                }
            }




        }
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", bodyType='" + bodyType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineVolume=" + engineVolume +
                ", enginePower=" + enginePower +
                ", driveType='" + driveType + '\'' +
                ", mileage=" + mileage +
                ", city='" + city + '\'' +
                '}';
    }
}

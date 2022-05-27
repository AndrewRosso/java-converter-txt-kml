package org.example;

import org.example.io.Data;
import org.example.template.KmlPageTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConvertToKML {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("geo.txt");
        Data data = new Data(path);
        KmlPageTemplate kmlPage = new KmlPageTemplate();

        FileWriter writer = new FileWriter("PlacemarksScooters.kml", false);

        System.out.println("Дайте название меткам самокатов");
        String namePlacemarks = scanner.nextLine();

        String text = kmlPage.createKMLPageText(namePlacemarks, data);
        writer.write(text);
        writer.flush();
    }
}

package org.example.template;

import org.example.io.Data;
import org.example.model.Scooter;
import org.example.service.ScooterService;

import java.util.List;

public class KmlPageTemplate {

    public String createKMLPageText(String headerName, Data data) {
        ScooterService scooterService = new ScooterService();

        return createFooter() +
                createHeader(headerName) +
                createBody(scooterService.createScooters(data)) +
                createEndingPage();
    }

    private String createFooter() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<kml xmlns=\"http://earth.google.com/kml/2.0\">\n" +
                "<Document>\n";
    }

    private String createHeader(String header) {
        return String.format("<name> %s </name>\n", header);
    }

    private String createBody(List<Scooter> scooters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Scooter scooter : scooters) {
            stringBuilder
                    .append(String.format(
                            "<Placemark>\n" +
                                    "<name>%s</name>\n" +
                                    "<Point><coordinates>%s,%s</coordinates></Point>\n" +
                                    "</Placemark>\n",
                            scooter.getName(),
                            scooter.getLongitude(),
                            scooter.getLatitude()
                    ));
        }
        return stringBuilder.toString();
    }

    private String createEndingPage() {
        return "</Document>\n" +
                "</kml>";
    }
}

package org.example.service;

import org.example.io.Data;
import org.example.model.Scooter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScooterService {

    public List<Scooter> createScooters(Data scootersData) {
        List<Scooter> scooterList = new ArrayList<>();

        for (String scooterInfo : scootersData.getListData()) {
            scooterList.add(createScooter(scooterInfo));
        }
        return scooterList;
    }

    private Scooter createScooter(String scooterInfo) {
        List<String> infoList = convertToInfoList(scooterInfo);
        String name = infoList.get(0);
        String latitude = infoList.get(1);
        String longitude = infoList.get(2);
        return new Scooter(name, latitude, longitude);
    }

    private List<String> convertToInfoList(String scooterInfo) {
        return Stream.of(scooterInfo.split(" "))
                .map(s -> s.replace(",", "."))
                .collect(Collectors.toList());
    }

    ///test
}

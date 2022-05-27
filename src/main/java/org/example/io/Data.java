package org.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Data {
    private final Path path;
    private final List<String> listData;

    public Data(Path path) throws IOException {
        this.path = path;
        listData = Files.readAllLines(path);
    }

    public Path getPath() {
        return path;
    }

    public List<String> getListData() {
        return listData;
    }
}

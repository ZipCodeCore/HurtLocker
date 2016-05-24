package io.steve_dimitri;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {



    public static void main(String[] args) throws Exception {
        App app = new App();
        app.run();
    }
}

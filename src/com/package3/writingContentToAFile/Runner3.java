package com.package3.writingContentToAFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Runner3 {

    public static void main(String[] args) throws IOException {
        Path fileToWrite = Paths.get("./resources/file-write.txt");
        List<String> list = List.of("apple", "boy", "cat", "Dog");
        // Creates the file if it doesn't already exist & write the lines to the file, this method overrides the existing lines.
        Files.write(fileToWrite, list);
    }

}
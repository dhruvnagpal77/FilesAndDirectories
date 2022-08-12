package com.package2.readContentFromAFile;

// Reading the contents of the file

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Runner2 {

    public static void main(String[] args) throws IOException {
        Path fileToRead = Paths.get("./resources/file-read.txt");

        // Not a good approach since it reads the entire content of the file all at once & puts it into memory,
        // thus if a file has lot of data then it will consume a lot of memory.
        List<String> lines = Files.readAllLines(fileToRead);
        System.out.println(lines);

        // Return a stream of each of the line & process them one by one, thus it is much more efficient & consumes less memory.
        Files.lines(fileToRead).forEach(System.out::println);

        // Converts each line of the file to lowercase & then return the line which contains "a"
        Files.lines(fileToRead).map(String::toLowerCase).filter(str -> str.contains("a")).forEach(System.out::println);
    }

}
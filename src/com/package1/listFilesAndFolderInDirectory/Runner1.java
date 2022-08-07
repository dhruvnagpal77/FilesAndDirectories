package com.package1.listFilesAndFolderInDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

// Prints the elements(files & directory) in the root directory(FilesAndDirectories)

public class Runner1 {

    public static void main(String[] args) throws IOException {
        Path currentDirectory = Paths.get(".");

        System.out.println("\nPrinting the elements in the root directory only one level deep");
        Files.list(currentDirectory).forEach(System.out::println);

        System.out.println("\nPrinting the elements in the root directory 4 levels deep");
        Files.walk(currentDirectory, 4).forEach(System.out::println);

        System.out.println("\nPrinting the .java files in the root directory 5 levels deep");
        Predicate<? super Path> predicate = path -> String.valueOf(path).contains(".java");
        Files.walk(currentDirectory, 5).filter(predicate).forEach(System.out::println);

        System.out.println("\nPrinting the .java files in the root directory 5 levels deep using find method");
        BiPredicate<Path, BasicFileAttributes> javaMatcher = (path, basicFileAttributes) -> String.valueOf(path).contains(".java");
        Files.find(currentDirectory, 5, javaMatcher).forEach(System.out::println);

        System.out.println("\nPrinting only directories in the root directory 5 levels deep using find method");
        BiPredicate<Path, BasicFileAttributes> directoryMatcher = (path, basicFileAttributes) -> basicFileAttributes.isDirectory();
        Files.find(currentDirectory, 5, directoryMatcher).forEach(System.out::println);
    }

}
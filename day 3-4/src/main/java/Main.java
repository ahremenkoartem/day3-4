package main.java;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RepeatedWordReader repeatedWordReader = new RepeatedWordReader("C:\\Users\\user\\IdeaProjects\\day 3-4\\src\\main\\resources\\test");
        repeatedWordReader.count();
    }
}

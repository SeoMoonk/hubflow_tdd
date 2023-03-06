package com.ll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.*;
import java.util.Scanner;

import static java.lang.System.in;

public class TestUtil {
    public static Scanner genScanner(String input) {

        return new Scanner(in);
    }

    public static ByteArrayOutputStream setOutToByteArray() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        return output;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream output) {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        try {
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
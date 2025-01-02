package com.example;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class KnownIssuesExample {

    // Code Smell: Complex Method (Too many lines in a single method)
    public void complexMethod() {
        String result = "";
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 50; j++) {
                result += i + ":" + j + " ";
            }
        }
        System.out.println(result);
    }

    // Bug: Null Pointer Dereference
    public void nullPointerBug() {
        String str = null;
        System.out.println(str.length());  // Will throw NullPointerException
    }

    // Vulnerability: Using SHA1 which is deprecated and insecure
    public void insecureHashing() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1"); // Vulnerable to attacks
            md.update("test".getBytes());
            byte[] hash = md.digest();
            System.out.println(new String(hash));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Code Smell: Duplicated Code (The same logic appears twice)
    public void duplicatedCode() {
        int a = 0;
        int b = 0;
        int c = 0;

        // Code Block 1
        for (int i = 0; i < 10; i++) {
            a += i;
            b += i;
            c += i;
        }

        // Code Block 2 (Duplicated)
        for (int i = 0; i < 10; i++) {
            a += i;
            b += i;
            c += i;
        }
    }

    // Code Smell: Long Class (Class is too long and should be split into smaller classes)
    public void longClassMethod() {
        int total = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 100; i++) {
            total += numbers.get(i);
        }
        System.out.println(total);
    }

    // Bug: Array Index Out of Bounds Exception
    public void arrayIndexOutOfBounds() {
        int[] arr = new int[5];
        System.out.println(arr[10]);  // Will throw ArrayIndexOutOfBoundsException
    }

    // Unused Variable (Code Smell)
    public void unusedVariable() {
        int unused = 100;  // Variable is never used
    }

    // Deprecated API Usage (Code Smell)
    public void deprecatedApi() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        for (String item : list) {
            System.out.println(item);
        }
    }

    // Main method to run the class
    public static void main(String[] args) {
        KnownIssuesExample example = new KnownIssuesExample();
        example.complexMethod();
        example.nullPointerBug();
        example.insecureHashing();
        example.duplicatedCode();
        example.longClassMethod();
        example.arrayIndexOutOfBounds();
        example.unusedVariable();
        example.deprecatedApi();
    }
}

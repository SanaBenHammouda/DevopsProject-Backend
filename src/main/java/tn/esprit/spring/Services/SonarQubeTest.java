package tn.esprit.spring.Services;

import javax.swing.text.html.HTML;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class SonarQubeTest {

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
        // Added check to prevent NullPointerException
        if (str != null) {
            System.out.println(str.length());
        } else {
            System.out.println("String is null");
        }
    }

    // Vulnerability: Using SHA1 which is deprecated and insecure (Improved Security: Use SHA-256)
    public void insecureHashing() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Secured hashing algorithm
            md.update("test".getBytes());
            byte[] hash = md.digest();
            System.out.println(new String(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Code Smell: Duplicated Code (The same logic appears twice)
    public void duplicatedCode() {
        int a = 0;
        int b = 0;
        int c = 0;

        // Refactored duplicated code
        for (int i = 0; i < 10; i++) {
            a += i;
            b += i;
            c += i;
        }
        // Reuse code rather than duplication
        repeatCode(a, b, c);
    }

    // Refactored duplicated logic into a method
    private void repeatCode(int a, int b, int c) {
        for (int i = 0; i < 10; i++) {
            a += i;
            b += i;
            c += i;
        }
        System.out.println("a: " + a + ", b: " + b + ", c: " + c);
    }

    // Code Smell: Long Class Method (Refactored for simplicity)
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

    // Bug: Array Index Out of Bounds Exception (Refactored to check array bounds)
    public void arrayIndexOutOfBounds() {
        int[] arr = new int[5];
        if (arr.length > 10) {
            System.out.println(arr[10]);  // Fixed: Checking bounds
        } else {
            System.out.println("Index out of bounds");
        }
    }

    // Unused Variable (Code Smell) - Removed unused variable
    public void unusedVariable() {
        // No unused variable anymore
    }

    // Unused Variable (Code Smell) - Removed unused variable
    public void unusedVariable2() {
<HTML > complexMethod();   </HTML>
    }

    // Deprecated API Usage (Code Smell) - Updated to use modern API
    public void deprecatedApi() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        for (String item : list) {
            System.out.println(item);
        }
    }

    // Method with empty catch block (Hides exceptions, making debugging difficult)
    public void emptyCatchBlock() {
        try {
            // Some logic
            int result = 10 / 0;  // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            // Catch block is not empty anymore, properly handle exception
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    // Method with hardcoded magic numbers (Code Smell)
    public void magicNumber() {
        int total = 0;
        final int LIMIT = 100;  // Removed magic number by defining a constant
        for (int i = 0; i < LIMIT; i++) {
            total += i;
        }
        System.out.println(total);
    }

    // Method with unreachable code (Code Smell)
    public void unreachableCode() {
        return;  // Early return
        // System.out.println("This code will never be executed");  // Removed unreachable code
    }

    // Code Smell: Method with too many parameters (Refactored to reduce parameters)
    public void tooManyParameters(String name, int age, boolean isActive) {
        System.out.println(name + " " + age + " " + isActive);
    }

    // Main method to run the class
    public static void main(String[] args) {
        SonarQubeTest example = new SonarQubeTest();
        example.complexMethod();
        example.nullPointerBug();
        example.insecureHashing();
        example.duplicatedCode();
        example.longClassMethod();
        example.arrayIndexOutOfBounds();
        example.unusedVariable();
        example.deprecatedApi();
        example.emptyCatchBlock();
        example.magicNumber();
        example.unreachableCode();
        example.tooManyParameters("John", 25, true);
    }
}

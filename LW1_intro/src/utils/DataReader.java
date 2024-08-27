package utils;

import models.Student;

import java.io.FileInputStream;
import java.util.Scanner;

public class DataReader {

    public static void readFromFile(String filePath, List outputData) {
        FileInputStream fileStream = null;
        Scanner scanner = null;

        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(";");
                outputData.add(new Student(lines[0], lines[1], Integer.parseInt(lines[2]), lines[3]));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void readSelected(String filePath, LinkedList<Selctedmodule> outputData) {
        FileInputStream fileStream = null;
        Scanner scanner = null;

        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(",");
                outputData.add(new Selctedmodule(lines[0], lines[1], lines[2], lines[3]));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    public static void readTeachers(String filePath, LinkedList<Teachers> outputData) {
        FileInputStream fileStream = null;
        Scanner scanner = null;

        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(",");
                outputData.add(new Teachers(lines[0], lines[1], lines[2], Integer.parseInt(lines[3])));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }



    public static void readFromFile1(String filePath, stack outputData) {
        FileInputStream fileStream = null;
        Scanner scanner = null;

        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(";");
                outputData.push(new Student(lines[0], lines[1], Integer.parseInt(lines[2]), lines[3]));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
}
}

package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {
    static String FILEPATH = "src/main/resources/arnikaByteArray.txt";
    static String FileOutput = "src/main/resources/outPutPdfOfArnika.pdf";


    static File file = new File(FILEPATH);

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(file);
            //read btye of file
            byte[] bytes = inputStream.readAllBytes();
            //convert to string object
            String s = new String(bytes, StandardCharsets.UTF_8);
            //print string object content to console
            System.out.println(s);
            //split string by ',' character and make an array of them
            String[] stringArray = s.split(",");
            //convert array to list
            List<String> listOfBytes = Arrays.asList(stringArray);
            List<String> list = new ArrayList<>();
            //trim each element of list for deleting white spaces
            for (String r : listOfBytes) {
                list.add(r.trim());
            }
            List<Byte> byteList = new ArrayList<>();
            for (String s2 : list) {
                byteList.add(Byte.valueOf(s2));
            }
            //create a byte array
            byte[] ba = new byte[byteList.size()];
            for (int i = 0; i < byteList.size(); i++) {
                ba[i] = byteList.get(i);
            }

            OutputStream outputStream = new FileOutputStream(FileOutput);
            //write it to a file
            outputStream.write(ba);

            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

//public class Main{
//    static String FILEPATH = "./src/main/resources/outPutPdfOfArnika.pdf";
//
//    static String TempTextFile = "./TempTextFile.txt";
//    static String FileOutput = "./src/main/resources/outPutPdfOfArnika2.pdf";
//
//
//    static File file = new File(FILEPATH);
//    public static void main(String[] args) {
//        try {
//            OutputStream outputStream = new FileOutputStream(FileOutput);
//            InputStream inputStream = new FileInputStream(file);
//            byte[] bytes = inputStream.readAllBytes();
//            String s = new String(bytes, StandardCharsets.UTF_8);
//            System.out.println(s);
//            String[] stringArray = s.split(",");
//            List<String> listOfBytes = Arrays.asList(stringArray);
//            List<String> list = new ArrayList<>();
//            for (String r : listOfBytes) {
//                list.add(r.trim());
//            }
//            List<Byte> byteList = new ArrayList<>();
//            for (String s2: list) {
//                byteList.add(Byte.valueOf(s2));
//            }
//            byte[] ba = new byte[byteList.size()];
//            for (int i=0; i < byteList.size(); i++){
//                ba[i] = byteList.get(i);
//            }
//            outputStream.write(bytes);
//            inputStream.close();
//        }
//        catch (Exception e) {
//            System.out.println("Exception: " + e);
//        }
//    }
//}


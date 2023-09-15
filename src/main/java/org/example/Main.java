package org.example;
import java.io.*;
import java.util.StringTokenizer;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //new WordManager().start();
        /*try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String oneline;
            while((oneline = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(oneline,"|");
                int level = Integer.parseInt(st.nextToken());
                String word = st.nextToken();
                String mean = st.nextToken();
                //Word a = new Word(0,level,word,mean);
                System.out.println(level + word + mean);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        /*try {
            Reader fr = new FileReader("test.txt");
            int data;
            String str = "";
            while((data = fr.read()) !=-1){
                str += (char)data;

            }
            System.out.println(str);
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */
        new WordManager().start();
    }
}
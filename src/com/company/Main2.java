package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) throws IOException, InterruptedException {
       // камень/ножницы/бумага
      int rez1=0;
      int rez2=0;

        while (rez1<10 && rez2<10) {
            FileWriter fw = new FileWriter("1.txt");
            Random rand = new Random();

            Thread g1 = new Thread(() -> {
                String gr1 = null;
                int i = rand.nextInt(3);
                switch (i) {
                    case 0:
                        gr1 = "P";
                        break;
                    case 1:
                        gr1 = "S";
                        break;
                    case 2:
                        gr1 = "R";
                        break;
                    default:
                        System.out.println("ошибочка вышла");

                }
                try {
                    synchronized (fw) {
                        fw.write("1" + gr1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

            Thread g2 = new Thread(() -> {
                String gr2 = null;
                int i = rand.nextInt(3);
                switch (i) {
                    case 0:
                        gr2 = "P";
                        break;
                    case 1:
                        gr2 = "S";
                        break;
                    case 2:
                        gr2 = "R";
                        break;
                    default:
                        System.out.println("ошибочка вышла");

                }
                try {
                    synchronized (fw) {
                        fw.write("2" + gr2);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            g1.start();
            g2.start();
            g1.join();
            g2.join();
            fw.flush();
            fw.close();
            FileReader fr = new FileReader("1.txt");
            char[] match = new char[4];
            fr.read(match);
            fr.close();

            if (match[1] != match[3]) {
                if (match[1] == 'P' && match[3] == 'S') {
                    rez2++;
                }
                if (match[1] == 'P' && match[3] == 'R') {
                    rez1++;
                }
                if (match[1] == 'S' && match[3] == 'P') {
                    rez1++;
                }
                if (match[1] == 'S' && match[3] == 'R') {
                    rez2++;
                }
                if (match[1] == 'R' && match[3] == 'S') {
                    rez1++;
                }
                if (match[1] == 'R' && match[3] == 'P') {
                    rez2++;
                }
            }
        }
        if (rez1 > rez2) {
            System.out.println("Победил игрок 1   "   +rez1+"   "+rez2);
        }
        if (rez1 < rez2) {
            System.out.println("Победил игрок 2   "+rez1+"   "+rez2);
        }
        if (rez1 == rez2) {
            System.out.println("Победила дружба   "+rez1+"  "+rez2);
        }
        }

    }



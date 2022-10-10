package com.company;

import javax.sound.sampled.AudioFormat;
import java.sql.Array;

public class Main {

    public static void main(String[] args) {
        // шифр цезаря
        String s = "NEZE ETTPMGEXMSRW EVI XCTMGEPPC GSQTMPIH XS FCXIGSHI XLEX GER VYR SR ERC NEZE ZMVXYEP QEGLMRI" +
                " VIKEVHPIWW SJ XLI YRHIVPCMRK GSQTYXIV EVGLMXIGXYVI";
        int k = 4;
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                c = ' ';
            }
            if (c >= 'A' && c <= 'Z') {
                c -= k;
            }

            if (c < 'A' && c != ' ') {
                c += 26;
            }

            sb.append(c);
        }
        String s2 = sb.toString();
        System.out.println(s2);
        //сортировка
        int[] t = {1, -1, 33, 235, 22, -1, 10, -1, 12};
        for (int i = 0; i < t.length - 1; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if ((t[i] > t[j]) && t[j]!=-1) {
                    int tmp = t[i];
                    t[i] = t[j];
                    t[j] = tmp;
                }
            }
        }

        //
        for (int e : t) {
            System.out.println(e);
        }
    }
}

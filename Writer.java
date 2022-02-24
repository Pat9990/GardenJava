package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Writer{

    public void write(String text,String plik) {
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(plik), true));
            bw.write(text);
            bw.newLine();
            bw.close();


        } catch (Exception e) {
        }
    }


}
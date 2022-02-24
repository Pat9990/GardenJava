package com.company;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;


public class OwnerReader{

    public void read(String plik) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(plik));
            String line;
            line = reader.readLine();
            String name,surname,gender;
            while (line != null){

                name=line;

                line = reader.readLine();
                surname=line;

                line = reader.readLine();
                gender=line;

                line = reader.readLine();
                int age = Integer.parseInt(line);

                line = reader.readLine();
                int id = Integer.parseInt(line);
                line = reader.readLine();

                Owner person = new Owner(name,surname,gender,age,id);
                Owner.add(person);

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cleanFile(plik);

    }
    public void cleanFile(String plik) {
        try (PrintWriter writer = new PrintWriter(plik)) {
            writer.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
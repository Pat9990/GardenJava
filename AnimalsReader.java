package com.company;

import java.io.*;

public class AnimalsReader {


        public void read(String plik) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(plik));
                String line="ok";

                String animal,name,BreedState,gender;
                int age,x,y,id,ownerID;
                int i=0;
                while (line != null){
                    if(i==0) {
                        line = reader.readLine();
                        i++;

                    }
                    animal = line;


                    line = reader.readLine();
                    name = line;




                    line = reader.readLine();
                    age = Integer.parseInt(line);



                    line = reader.readLine();
                    x = Integer.parseInt(line);


                    line = reader.readLine();
                    y = Integer.parseInt(line);



                    line = reader.readLine();
                    BreedState = line;



                    line = reader.readLine();
                    gender = line;



                    line = reader.readLine();
                    id = Integer.parseInt(line);



                    line = reader.readLine();
                    ownerID = Integer.parseInt(line);


                    line= reader.readLine();


                    if(animal.equals("turtle")){

                        Turtle turtle = new Turtle(animal, name, age,x,y,id,ownerID);
                        if(BreedState.equals("ACTIVE")){turtle.setState(Turtle.State.ACTIVE);}
                        else{turtle.setState(Turtle.State.HIDDEN);}
                        if(gender.equals("HE")){turtle.setGender(Turtle.Gender.HE);}
                        else{turtle.setGender(Turtle.Gender.SHE);}
                        Turtle.addTurtle(turtle);

                    }
                    if(animal.equals("dog")){
                        Dog dog = new Dog(animal, name,age,x,y,BreedState,id,ownerID);
                        if(gender.equals("HE")){dog.setGender(Dog.Gender.HE);System.out.println(gender+"dog");}
                        else{dog.setGender(Dog.Gender.SHE);}
                        Dog.addDog(dog);
                    }
                    else{

                        Cat cat = new Cat(animal, name,age,x,y,BreedState,id,ownerID);
                        if(gender.equals("HE")){cat.setGender(Cat.Gender.HE);System.out.println(gender+"cat");}
                        else{cat.setGender(Cat.Gender.SHE);}
                        Cat.addCat(cat);


                    }


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


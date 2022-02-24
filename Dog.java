package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dog extends Cat {
   //konstruktory
    public Dog(String animal, String name, int age, int x, int y,String breed, int id, int ownerId ) {
        super(animal, name, age, x, y, breed, id, ownerId);
    }
    public Dog(String animal, String name, int age, int x, int y,String breed, int ownerId ){
        super(animal, name, age, x, y, breed, ownerId);
    }

    ///////////// metody na listach obiektów typu Dog /////////////////
    protected static List<Dog> dogs = new ArrayList<>();
    private static boolean isIdUnique1(int id) {
        for (Dog d : Dog.dogs) {
            if (d.id == id) return false;
        }
        return true;
    }
    private static int generateId1() {
        int max = 0;
        for (Dog d : Dog.dogs) {
            if (max < d.id) max = d.id;
        }
        return max+1;
    }
    public static void addDog(Dog d){
        int id = d.getId();
        if (id == 0) {
            d.setId(Dog.generateId1());
        } else if (!Dog.isIdUnique1(id)) {
            // throw
        }
        Dog.dogs.add(d);
    }
    public static void removeByIdDog(int id) {
        for (Dog cd : Dog.dogs) {
            if (cd.id == id) {
                Dog.dogs.remove(cd);
                return;
            }
        }
        // throw
    }
    public static void infoDog() {
        for (Dog cd : dogs) {
            cd.info();
        }
    }
        private void setId(int id){
        this.id=id;
    }
    public static void move(int id){
        for (Dog c : Dog.dogs) {
            if (c.id == id) {

                System.out.println("W celu przesunięcia zwierzęcia wybierz odpowiedni numer.\n" +
                        "1. W górę.\n" +
                        "2. W dół.\n" +
                        "3. W lewo.\n" +
                        "4. W prawo.");
                Scanner scanner = new Scanner(System.in);
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        if ((c.y - 1) >= 0 ) {
                            c.y = c.y - 1;
                            System.out.println("Aktualna pozycja to X: "+ c.x+" Y: "+c.y );
                        } else {
                            System.out.println("Nie można przesunąć zwierzaka.\n" +
                                    "Będzie wykraczać poza granice ogrodu.");
                        }
                        break;
                    case 2:
                        if ((c.y + 1) <= 14) { //14
                            c.y = c.y + 1;
                            System.out.println("Aktualna pozycja to X: "+ c.x+" Y: "+c.y );
                        } else {
                            System.out.println("Nie można przesunąć zwierzaka.\n" +
                                    "Będzie wykraczać poza granice ogrodu.");
                        }
                        break;
                    case 3:
                        if ((c.x - 1) >= 0) {
                            c.x = c.x - 1;
                            System.out.println("Aktualna pozycja to X: "+ c.x+" Y: "+c.y );
                        } else {
                            System.out.println("Nie można przesunąć zwierzaka.\n" +
                                    "Będzie wykraczać poza granice ogrodu.");
                        }
                        break;
                    case 4:
                        if ((c.x + 1) <= 14) { //14
                            c.x = c.x + 1;
                            System.out.println("Aktualna pozycja to X: "+ c.x+" Y: "+c.y );
                        } else {
                            System.out.println("Nie można przesunąć zwierzaka.\n" +
                                    "Będzie wykraczać poza granice ogrodu.");
                        }
                        break;
                    default:
                        System.out.println("Niepoprawna opcja.");
                        break;
                }
            }
        }

    }
    // metoda 'postarzająca' każdy obiekt typu Dog o rok
    public static void Year(){
        for (Dog d : dogs) {
            d.setAge(d.age+1);

        }
    }

}

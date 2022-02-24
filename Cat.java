package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cat {
    private String name;
    protected int age;
    protected int x;          //wymiar ogrodu oś x-wiersz
    protected int y;          //wymiar ogrodu oś y-kolumna
    private Owner owner;
    private String breed;
    private Gender gender;
    protected int id ;
    private String animal;
    private int ownerId;


    public enum Gender{
        HE("HE"),SHE("SHE");
        private String value;


        Gender(String value) {
            this.value = value;

        }

        public String getValue() {
            return value;
        }

        public void setValue(String value){this.value=value;}
    }
    ///////////// metody na listach obiektów typu Cat /////////////////
    protected static List<Cat> cats = new ArrayList<>();
    private static boolean isIdUnique(int id) {
        for (Cat cd : Cat.cats) {
            if (cd.id == id) return false;
        }
        return true;
    }
    private static int generateId() {
        int max = 0;
        for (Cat cd : Cat.cats) {
            if (max < cd.id) max = cd.id;
        }
        return max+1;
    }
    public static void addCat(Cat cd){
        int id = cd.getId();
        if (id == 0) {
            cd.setId(Cat.generateId());
        } else if (!Cat.isIdUnique(id)) {
            // throw
        }
        Cat.cats.add(cd);
    }
    public static void removeById(int id) {
        for (Cat cd : Cat.cats) {
            if (cd.id == id) {
                Cat.cats.remove(cd);
                return;
            }
        }
        // throw
    }
    public void info() {
        System.out.println("animal:"+animal);
        System.out.println("ID: "+id);
        System.out.println("Imię: "+ name);
        System.out.println("Płeć: "+ gender.getValue());
        System.out.println("Wiek: "+ age);
        System.out.println("x: "+ x);
        System.out.println("y: "+ y);
        System.out.println("rasa: "+ breed);
        System.out.println("ID właściciela: "+ ownerId);
        List<Owner> owners = new ArrayList<>();
        for(Owner o: Owner.owners) {
            if(o.getId()==ownerId) {
                System.out.println("Imię, nazwisko i wiek właściciela: " +o.getName()+" "+o.getSurname()+" "+o.getAge());
                break;
            }
        }
        System.out.println("------------------------------");

    }
    public static void infoCat(){
        for (Cat cd : cats) {
            cd.info();
        }

    }
    public static void move(int id){
        for (Cat c : Cat.cats) {
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

    // metoda 'postarzająca' każdy obiekt typu Cat o rok
        public static void Year(){
            for (Cat c : cats) {
                c.setAge(c.age+1);

            }
        }


    //konstruktory

    public Cat(String animal, String name, int age, int x, int y, String breed, int id, int ownerId ){

        this.name=name;
        this.age=age;
        this.x=x;
        this.y=y;
        this.id = id;
        this.animal=animal;
        this.breed=breed;
        this.ownerId=ownerId;
    }
    public Cat(String animal, String name, int age, int x, int y, String breed, int ownerId ){

        this.name=name;
        this.age=age;
        this.x=x;
        this.y=y;
        this.animal=animal;
        this.breed=breed;
        this.ownerId=ownerId;
    }


    //////////////////////// gettery i settery ////////////////

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Owner getOwner(){
        return owner;
    }
    public String getBreed(){
        return breed;
    }
    public int getId(){
        return id;
    }
    public Gender getGender(){
        return gender;
    }
    public int getOwnerId(){
        return ownerId;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setOwner(Owner owner){
        this.owner=owner;
    }
    public void setBreed(String breed){
        this.breed=breed;
    }
    private void setId(int id){
        this.id=id;
    }
    public void setGender(Gender gender){
        this.gender=gender;
    }
    private void setOwnerID(int ownerId){
        this.ownerId=ownerId;
    }

}


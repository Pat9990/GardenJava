package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turtle {
    private String name;
    private int age;
    private int x;
    private int y;
    private Owner owner;
    private State state;
    private Gender gender;
    private int id ;
    private String animal;
    private int ownerId;



    public enum State{
        ACTIVE("ACTIVE"), HIDDEN("HIDDEN");

        private String value;


        State(String value) {
            this.value = value;

        }

        public String getValue() {
            return value;
        }

        public void setValue(String value){this.value=value;}


    }
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

    ///////////// metody na listach obiektów typu Turtle /////////////////
    protected static List<Turtle> turtles = new ArrayList<>();
    private static boolean isIdUnique(int id) {
        for (Turtle t : Turtle.turtles) {
            if (t.id == id) return false;
        }
        return true;
    }
    private static int generateId() {
        int max = 0;
        for (Turtle t : Turtle.turtles) {
            if (max < t.id) max = t.id;
        }
        return max+1;
    }
    public static void addTurtle(Turtle t){
        int id = t.getId();
        if (id == 0) {
            t.setId(Turtle.generateId());
        } else if (!Turtle.isIdUnique(id)) {
            // throw
        }
        Turtle.turtles.add(t);
    }
    public static void removeById(int id) {
        for (Turtle t : Turtle.turtles) {
            if (t.id == id) {
                Turtle.turtles.remove(t);
                return;
            }
        }
        // throw
    }
    public static void setStateById(int id) {
        for (Turtle t : Turtle.turtles) {
            if (t.id == id) {
                ((Turtle) t).setState(Turtle.State.ACTIVE);

                return;
            }
        }
        // throw
    }
    public static void infoTurtle(){
        for (Turtle turtle : turtles) {
            turtle.info();
        }

    }

    public void info() {
        System.out.println("animal: turtle");
        System.out.println("ID: "+ id);
        System.out.println("Imię: "+ name);
        System.out.println("Płeć: "+ gender.getValue());
        System.out.println("Wiek: "+ age);
        System.out.println("x: "+ x);
        System.out.println("y: "+ y);
        System.out.println("stan: "+ state.getValue());
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


    public static void move(int id) {

        for (Turtle t : Turtle.turtles) {
            if (t.id == id) {
                //Turtle.turtles.t.id;
                if (t.state == State.ACTIVE) {
                    t.state = State.HIDDEN;
                    System.out.println("W celu przesunięcia zwierzęcia wybierz odpowiedni numer.\n" +
                            "1. W górę.\n" +
                            "2. W dół.\n" +
                            "3. W lewo.\n" +
                            "4. W prawo.");
                    Scanner scanner = new Scanner(System.in);
                    int number = scanner.nextInt();
                    switch (number) {
                        case 1:
                            if ((t.y - 1) >= 0 ) {
                                t.y = t.y - 1;
                                System.out.println("Aktualna pozycja to X: "+ t.x+" Y: "+t.y );
                            } else {
                                System.out.println("Nie można przesunąć zwierzaka.\n" +
                                        "Będzie wykraczać poza granice ogrodu.");
                            }
                            break;
                        case 2:
                            if ((t.y + 1) <= 14) { //14
                                t.y = t.y + 1;
                                System.out.println("Aktualna pozycja to X: "+ t.x+" Y: "+t.y );
                            } else {
                                System.out.println("Nie można przesunąć zwierzaka.\n" +
                                        "Będzie wykraczać poza granice ogrodu.");
                            }
                            break;
                        case 3:
                            if ((t.x - 1) >= 0) {
                                t.x = t.x - 1;
                                System.out.println("Aktualna pozycja to X: "+ t.x+" Y: "+t.y );
                            } else {
                                System.out.println("Nie można przesunąć zwierzaka.\n" +
                                        "Będzie wykraczać poza granice ogrodu.");
                            }
                            break;
                        case 4:
                            if ((t.x + 1) <= 14) { //14
                                t.x = t.x + 1;
                                System.out.println("Aktualna pozycja to X: "+ t.x+" Y: "+t.y );
                            } else {
                                System.out.println("Nie można przesunąć zwierzaka.\n" +
                                        "Będzie wykraczać poza granice ogrodu.");
                            }
                            break;
                        default:
                            System.out.println("Niepoprawna opcja.");
                            break;
                    }
                } else {
                    System.out.println("Aby przenieść żółwia musisz go nakarmić!");
                }
            }

        }
    }
    // metoda 'postarzająca' każdy obiekt typu Turtle o rok
    public static void Year(){
        for (Turtle t : turtles) {
            t.setAge(t.age+1);

        }
    }
    //konstruktory
    public Turtle(String animal,String name,int age,int x,int y,int id, int ownerId ){

        this.name=name;
        this.age=age;
        this.x=x;
        this.y=y;
        this.ownerId=ownerId;
        this.id = id;
        this.animal=animal;

    }
    public Turtle(String animal,String name,int age,int x,int y, int ownerId ){

        this.name=name;
        this.age=age;
        this.x=x;
        this.y=y;
        this.ownerId=ownerId;
        this.animal=animal;

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
    public int getId(){
        return id;
    }
    public State getState(){
        return state;
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
    private void setId(int id){
        this.id=id;

    }
    public void setState(State state){
        this.state=state;
    }
    public void setGender(Gender gender){
        this.gender=gender;
    }
    private void setOwnerId(int ownerId){
        this.ownerId=ownerId;
    }

}

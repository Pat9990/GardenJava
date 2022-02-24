package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Owner  {
    private String name;
    private String surname;
    private String gender;
    private int age;
    private int id ;

    ///////////// metody na listach obiektów typu Owner /////////////////
    protected static List<Owner> owners = new ArrayList<>();
    private static boolean isIdUnique(int id) {
        for (Owner o : Owner.owners) {
            if (o.id == id) return false;
        }
        return true;
    }
    private static int generateId() {
        int max = 0;
        for (Owner o : Owner.owners) {
            if (max < o.id) max = o.id;
        }
        return max+1;
    }
    public static void add(Owner o) {
        int id = o.getId();
        if (id == 0) {
            o.setId(Owner.generateId());
        } else if (!Owner.isIdUnique(id)) {
            // throw
        }
        Owner.owners.add(o);
    }

    public static void infoOwner(){

        for (Owner person : owners) {
            person.info();

        }

    }

    public void info() {

        System.out.println("ID: "+ id);
        System.out.println("Imię: "+ name);
        System.out.println("Nazwisko: "+ surname);
        System.out.println("Płeć: "+ gender);
        System.out.println("Wiek: "+ age);
        List<Turtle> turtles = new ArrayList<>();
        for(Turtle t: Turtle.turtles) {
            if (t.getOwnerId() == id) {
                System.out.println("Żółw: ID: " + t.getId() +", imię: "+ t.getName()+", wiek: "+t.getAge()+", płeć: "+t.getGender()+ ", stan: "+t.getState());
            }
        }
        List<Cat> cats = new ArrayList<>();
        for(Cat c: Cat.cats) {
            if (c.getOwnerId() == id) {
                System.out.println("Kot: ID: "+c.getId()+", imię: " + c.getName()+ ", wiek: "+c.getAge()+", płeć: "+c.getGender()+", rasa: "+c.getBreed());
            }
        }
        List<Dog> dogs = new ArrayList<>();
        for(Dog d: Dog.dogs) {
            if (d.getOwnerId() == id) {
                System.out.println("Pies: ID: "+d.getId()+", imię: " + d.getName()+ ", wiek: "+d.getAge()+", płeć: "+d.getGender()+", rasa: "+d.getBreed());
            }
        }
        System.out.println("------------------------------");
    }

    // metoda 'postarzająca' każdy obiekt typu Owner o rok
    public static void Year(){
        for (Owner person : owners) {
            person.setAge(person.age+1);

        }
    }
    //konstruktory
    public Owner(String name, String surname, String gender, int age, int id){

        this.name=name;
        this.surname=surname;
        this.gender=gender;
        this.age=age;
        this.id = id;
    }
    public Owner(String name, String surname, String gender, int age){

        this.name=name;
        this.surname=surname;
        this.gender=gender;
        this.age=age;
    }
    //////////////////////// gettery i settery ////////////////
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public void setAge(int age){
        this.age=age;
    }
    private void setId(int id){
        this.id=id;

    }

}

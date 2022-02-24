package com.company;

import java.util.Scanner;

public class GardenStart {


    public void start() {

        Writer writer = new Writer();
        OwnerReader reader = new OwnerReader();
        AnimalsReader reader2 = new AnimalsReader();
        String path1="C:\\Users\\Patrycja\\IdeaProjects\\garden\\src\\com\\company\\owners.txt"; //ścieżka do pliku, w którym są informacje o właścicielach
        String path2="C:\\Users\\Patrycja\\IdeaProjects\\garden\\src\\com\\company\\animals.txt"; //ścieżka do pliku, w którym są informacje o zwierzętach

        reader.read(path1);
        reader2.read(path2);
        int number = 1;
        while (number != 0) {
            System.out.println("Wybierz odpowiedni numer z menu zadań:\n" +
                    "\t1. Dodaj właściciela\n" +
                    "\t2. Lista właścicieli\n" +
                    "\t3. Nakarm żółwia\n" +
                    "\t4. Przemieść zwierzę\n" + //opcja polegająca na przemieszczaniu zwierzęcia po ogrodzie o wymiarach 15 x 15
                    "\t5. Lista zwierząt\n" +
                    "\t6. Dodaj żółwia\n"+
                    "\t7. Dodaj kota \n"+
                    "\t8. Dodaj psa \n"+
                    "\t9. Usuń żółwia\n"+
                    "\t10. Usuń kota\n"+
                    "\t11. Usuń psa\n"+
                    "\t12. Mija rok\n"+ //opcja polegająca na postarzeniu każdego zwierzaka i właściciela o rok
                    "\t0. Zakończ\n");

            Scanner scanner = new Scanner(System.in);
            // Not using nextInt because of https://stackoverflow.com/a/13102066
            number = Integer.parseInt(scanner.nextLine());

            switch (number) {
                case 1:
                    System.out.println("Podaj imię: \n");
                    String name = scanner.nextLine();
                    System.out.println("Podaj nazwisko: \n");
                    String surname = scanner.nextLine();
                    System.out.println("Podaj płeć: \n");
                    String gender = scanner.nextLine();
                    System.out.println("Podaj wiek: \n");
                    int age = scanner.nextInt();
                    Owner person = new Owner(name, surname, gender, age);

                    Owner.add(person);
                    break;
                /*case 2:
                    System.out.println("Podaj id właściciela: \n");
                    int id = scanner.nextInt();
                    Owner.removeById(id);
                    break;

                 */
                case 2:
                    System.out.println("---------- lista wszystkich właścicieli ------------");
                    Owner.infoOwner();
                    break;
                case 3:
                    System.out.println("Podaj id żółwia: \n");
                    int id = scanner.nextInt();
                    Turtle.setStateById(id);
                    break;
                case 4:
                    System.out.println("Wybierz odpowiedni numer, jakie zwierzę chcesz przenieść. \n" +
                            "1. Żółw.\n" +
                            "2. Kot.\n" +
                            "3. Pies.");
                    Scanner scanner1 = new Scanner(System.in);
                    int nr = scanner1.nextInt();
                    switch (nr) {
                        case 1:
                            System.out.println("Podaj ID żółwia. \n");
                             nr = scanner.nextInt();
                            Turtle.move(nr);
                            break;
                        case 2:
                            System.out.println("Podaj ID kota. \n");
                            nr = scanner.nextInt();
                            Cat.move(nr);
                            break;
                        case 3:
                            System.out.println("Podaj ID psa.");
                            nr = scanner.nextInt();
                            Dog.move(nr);
                            break;
                        default:
                            System.out.println("Niepoprawna opcja");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("---------- lista wszystkich zwierząt ------------");
                    Cat.infoCat();
                    Turtle.infoTurtle();
                    Dog.infoDog();
                    break;
                case 6:
                    System.out.println("Podaj imię: \n");
                    name = scanner.nextLine();
                    System.out.println("Podaj wiek: \n");
                    age = scanner.nextInt();
                    System.out.println("Podaj ID właściciela: \n");
                    int ownerID = scanner.nextInt();
                    Turtle turtle = new Turtle("turtle", name,age, 0,0,ownerID);
                    System.out.println("Podaj czy żółw jest aktywny(1) czy schowany(0) w skorupie wpisz odpowiednią cyfrę: \n");
                    int state = scanner.nextInt();
                    if(state==1) {turtle.setState(Turtle.State.ACTIVE);}
                    else{turtle.setState(Turtle.State.HIDDEN);}
                    System.out.println("Podaj płeć żółwia ona(1) on(0), wpisz odpowiednią cyfrę: \n");
                    int i = scanner.nextInt();
                    if(i==1){turtle.setGender(Turtle.Gender.SHE);}
                    else{turtle.setGender(Turtle.Gender.HE);}

                    Turtle.addTurtle(turtle);
                    break;
                case 7:
                    System.out.println("Podaj imię: \n");
                    name = scanner.nextLine();
                    System.out.println("Podaj rasę zwierzęcia: \n");
                    String text =scanner.nextLine();
                    System.out.println("Podaj wiek: \n");
                    age = scanner.nextInt();
                    System.out.println("Podaj ID właściciela: \n");
                    ownerID = scanner.nextInt();

                    Cat cat = new Cat("cat",name,age,0,0,text,ownerID);
                    System.out.println("Podaj płeć zwierzęcia, ona(1) lub on(0), wpisz cyfrę: \n");
                    i=scanner.nextInt();
                    if(i==1){cat.setGender(Cat.Gender.SHE);}
                    else{cat.setGender(Cat.Gender.HE);}

                    Cat.addCat(cat);
                    break;
                case 8:
                    System.out.println("Podaj imię: \n");
                    name = scanner.nextLine();
                    System.out.println("Podaj rasę zwierzęcia: \n");
                    text =scanner.nextLine();
                    System.out.println("Podaj wiek: \n");
                    age = scanner.nextInt();
                    System.out.println("Podaj ID właściciela: \n");
                    ownerID = scanner.nextInt();

                    Dog dog = new Dog("dog",name,age,0,0,text,ownerID);
                    System.out.println("Podaj płeć zwierzęcia, ona(1) lub on(0), wpisz cyfrę: \n");
                    i=scanner.nextInt();
                    if(i==1){dog.setGender(Dog.Gender.SHE);}
                    else{dog.setGender(Dog.Gender.HE);}

                    Dog.addDog(dog);
                    break;
                case 9:
                    System.out.println("Podaj id żółwia: \n");
                    id = scanner.nextInt();
                    Turtle.removeById(id);
                    break;
                case 10:
                    System.out.println("Podaj id zwierzęcia: \n");
                    id = scanner.nextInt();
                    Cat.removeById(id);
                    break;
                case 11:
                    System.out.println("Podaj id zwierzęcia: \n");
                    id = scanner.nextInt();
                    Dog.removeByIdDog(id);
                    break;
                case 12:
                    Owner.Year();
                    Turtle.Year();
                    Cat.Year();
                    Dog.Year();
                    break;

                    case 0:
                        for (Owner o : Owner.owners) {
                            writer.write(o.getName(), path1);
                            writer.write(o.getSurname(), path1);
                            writer.write(o.getGender(), path1);
                            writer.write(Integer.toString(o.getAge()), path1);
                            writer.write(Integer.toString(o.getId()), path1);
                        }
                        for (Turtle t : Turtle.turtles) {
                            writer.write("turtle", path2);
                            writer.write(t.getName(), path2);
                            writer.write(Integer.toString(t.getAge()), path2);
                            writer.write(Integer.toString(t.getX()), path2);
                            writer.write(Integer.toString(t.getY()), path2);
                            writer.write(t.getState().getValue(), path2);
                            writer.write(t.getGender().getValue(), path2);
                            writer.write(Integer.toString(t.getId()), path2);
                            writer.write(Integer.toString(t.getOwnerId()), path2);
                        }
                        for (Cat c: Cat.cats){
                            writer.write("cat",path2);
                            writer.write(c.getName(),path2);
                            writer.write(Integer.toString(c.getAge()),path2);
                            writer.write(Integer.toString(c.getX()),path2);
                            writer.write(Integer.toString(c.getY()),path2);
                            writer.write(c.getBreed(), path2);
                            writer.write(c.getGender().getValue(),path2);
                            writer.write(Integer.toString(c.getId()),path2);
                            writer.write(Integer.toString(c.getOwnerId()),path2);
                        }
                        for(Dog d: Dog.dogs){
                            writer.write("dog",path2);
                            writer.write(d.getName(),path2);
                            writer.write(Integer.toString(d.getAge()),path2);
                            writer.write(Integer.toString(d.getX()),path2);
                            writer.write(Integer.toString(d.getY()),path2);
                            writer.write(d.getBreed(), path2);
                            writer.write(d.getGender().getValue(),path2);
                            writer.write(Integer.toString(d.getId()),path2);
                            writer.write(Integer.toString(d.getOwnerId()),path2);
                        }
                        break;

                default:
                    System.out.println("Niepoprawna opcja");
            }
        }




    }


}

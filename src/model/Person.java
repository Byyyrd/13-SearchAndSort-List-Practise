package model;

public class Person {
    private String name;
    private String birthdate;

    public Person(String name){
        this.name = name;
        this.birthdate = createBirthdate();
    }

    public String getName(){
        return name;
    }

    public String getBirthdate(){
        return birthdate;
    }

    private String createBirthdate(){
        String output = String.valueOf((int)(Math.random()*31)+1);
        output = output + "." + String.valueOf((int)(Math.random()*12)+1);
        output = output + "." + String.valueOf((int)(Math.random()*50)+1970);
        return output;
    }
}

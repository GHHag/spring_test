package test.example.test;

import lombok.Data;

@Data
public class SuperHero {

    private String name;
    private int age;
    private String[] superPowers;

    public SuperHero(String name, int age, String[] superPowers) {
        this.name = name;
        this.age = age;
        this.superPowers = superPowers;
    }

}

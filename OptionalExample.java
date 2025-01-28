package com.streamAPIs;

import java.util.Optional;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}

public class OptionalExample {
    public static void main(String[] args) {
        // Create a Person object with a name
        Person personWithName = new Person("Alina");
        
        // Use Optional.ofNullable() to safely handle the name
        String name = personWithName.getName().orElse("Unknown");
        System.out.println("Name: " + name);

        // Check if the name equals "Alina" using Optional
        if (personWithName.getName().isPresent() && personWithName.getName().get().equalsIgnoreCase("Alina")) {
            System.out.println("Name is equal to Alina");
        } else {
            System.out.println("Name is not equal to Alina");
        }

        // Create a Person object with no name
        Person personWithoutName = new Person(null);

        // Use Optional.ofNullable() to handle null
        String noName = personWithoutName.getName().orElse("No Name Provided");
        System.out.println("Name: " + noName);
    }
}

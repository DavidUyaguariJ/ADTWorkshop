package exerciseTwo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Person class represents a person with a name.
 * It is used in the management of the queue in the bank application.
 */
public class Person {
    private String name;

    /**
     * Empty constructor for Person.
     */
    public Person() {
    }
    /**
     * Constructor for Person with a name.
     * @param name The name of the person.
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the person.
     * @return The person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the person's name as a string.
     * @return The name of the person in text format.
     */
    @Override
    public String toString() {
        return name;
    }
}

package models;
import org.jetbrains.annotations.NotNull;
import utils.Teachers;

import java.util.Comparator;

public class Student implements utils.Parsable<Student> {
    String firstName;
    String lastName;
    int age;
    String group;

    public Student(){}

    public Student(String firstName, String lastName, int age, String group){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString(){
        return String.format("%s %s age: %d group: %s", firstName, lastName, age, group);
    }

    @Override
    public boolean equals(Object student) {
        return ((Student) student).firstName.equals(this.firstName) && ((Student) student).lastName.equals(this.lastName);
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return 0;
    }
}

package utils;

import org.jetbrains.annotations.NotNull;

public class Instructors  implements Comparable<Instructors> {

    String name ;
    String surname ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Instructors() {};
    public Instructors(String name , String surname){this.name =name; this.surname=surname;}

    @Override
    public int compareTo(@NotNull Instructors o) {
        int c1 = this.name.compareTo(o.name);
        int c2 = this.surname.compareTo(o.surname);
        if (c1>=0 && c2 <= 0)
            return 1;
        else  { return -1;}
    }
}

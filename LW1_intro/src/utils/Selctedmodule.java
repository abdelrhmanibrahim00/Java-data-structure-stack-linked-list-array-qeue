package utils;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;

public class Selctedmodule  implements utils.Parsable<Selctedmodule> {

String module ;
String surname ;
String name ;
String group ;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public Selctedmodule(){}
    public Selctedmodule(String module , String surname, String name , String group)
    {
        this.module=module;
        this.surname=surname;
        this.group=group;
        this.name=name;
    }
    @Override
    public String toString() { return String.format("|  %5s    |  %3s    |    %4s     |     %2s   |",name,surname,module,group); }
    @Override
    public boolean equals (Object x)
    { return ((Selctedmodule) x).name.equals(this.name) && ((Selctedmodule) x).surname.equals(this.surname); }

    @Override
    public int compareTo(@NotNull Selctedmodule o) {

        return 0;
    }
}

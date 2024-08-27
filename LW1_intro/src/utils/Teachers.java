package utils;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;

public class Teachers  implements utils.Parsable<Teachers>{
     String module ;
    String name ;
    String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    int credit ;

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teachers() {}
    public Teachers(String module, String name , String surname, int credit)
    { this.module=module ; this.credit=credit;this.surname=surname;this.name=name;}

    @Override
    public String toString() { return String.format("|  %5s    |  %5s    |    %3s     |     %2d   |",name,surname,module,credit); }
    @Override
    public boolean equals(Object x) {
        return ((Teachers) x).name.equals(this.name) && ((Teachers) x).surname.equals(this.surname);
    }

    @Override
    public int compareTo(@NotNull Teachers o) {
        int c1 = this.name.compareTo(o.name);
        int c2 = this.surname.compareTo(o.surname);
        if (c1 > 0 || (c1 == 0 && c2 < 0))
            return 1;
        else if (c1 < 0 || (c1 == 0 && c2 > 0))
            return -1;
        return 0;
        }



    }


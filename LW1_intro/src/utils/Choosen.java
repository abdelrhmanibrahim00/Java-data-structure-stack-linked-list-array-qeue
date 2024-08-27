package utils;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
public class Choosen implements utils.Parsable<Choosen>{

    String module ;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
    public Choosen() {}
    public Choosen( String module){this.module=module;}
    @Override
    public String toString() { return String.format("|   %2s  |",this.module);}

    @Override
    public int compareTo(@NotNull Choosen o) {
        return 0;
    }
}

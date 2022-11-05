package Object.Account;

import Object.*;
import java.io.Serializable;

public abstract class Account implements Serializable {

    private final String name;

    public Account(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    abstract void run(Data data);
}

package Messager;

import java.io.Serializable;
import java.util.ArrayList;

public class Messenger implements Serializable {
    private final String name;
    private final ArrayList<String> messenger;

    public Messenger(String userName1, String userName2) {
        this.name = userName1 + "-" + userName2;
        this.messenger = new ArrayList<>();
    }

    public String name(){
        return name;
    }

    public void chat(String userName, String comment){
        messenger.add(userName + ": " + comment);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Messenger: ").append(name).append("\n");
        if(messenger.size() < 10){
            for(String i : messenger)
                string.append(i).append("\n");
        }else {
            for (int i = messenger.size() -10 ;  i < messenger.size(); i++) {
                string.append(messenger.get(i)).append("\n");
            }
        }
        return string.toString();

    }

}

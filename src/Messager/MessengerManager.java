package Messager;


import IO.__IOClass;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MessengerManager implements Serializable {
    private final ArrayList<Messenger> messengers;
    private final HashMap<String, HashMap<String,Integer>> messengerBox;
    private final File file;

    public MessengerManager(File file) {
        this.messengers = new ArrayList<>();
        this.messengerBox = new HashMap<>();
        this.file = file;
    }

    public void addNew(String userName1, String userName2){
        if(!check(userName1)){
            messengerBox.put(userName1, new HashMap<>());
        }
        if(!check(userName2)){
            messengerBox.put(userName2, new HashMap<>());
        }
        messengerBox.get(userName1).put(userName2,messengers.size());
        messengerBox.get(userName2).put(userName1,messengers.size());
        messengers.add(new Messenger(userName1,userName2));
        save();
    }

    public Messenger get(String userName1, String userName2){
        if(!check(userName1)){
            System.out.println("no box messenger!");
            return null;
        }
        if(messengerBox.get(userName1).containsKey(userName2)){
            int index = messengerBox.get(userName1).get(userName2);
            return messengers.get(index);
        }else{
            System.out.println("Messenger is not exist!");
            return null;
        }
    }

    public ArrayList<String> getList(String userName){
        return new ArrayList<>(messengerBox.get(userName).keySet());
    }



    public void save(){
        __IOClass.writeFile(this, file, false);
    }

    public boolean check(String userName){
        return messengerBox.containsKey(userName);
    }
    public int sizeBox(String username){
        return messengerBox.get(username).size();
    }

}

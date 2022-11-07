package Messager;

import Input.Input;
import Object.*;
import Object.Account.User;

import java.util.ArrayList;

public class MessengerMenu {
    private final Data data;

    private final User user;

    public MessengerMenu(Data data, User user) {

        this.data = data;
        this.user = user;
    }

    public void boxMessenger(){
        ArrayList<String> list = data.messenger().getList(user.getName());
        if (list.size() > 0){
            System.out.println("========= Box Messenger ===========");
            for( int i = 0 ; i < list.size() ; i++){
                System.out.printf("%-10d %-20s \n", i , list.get(i));
            }
            int index = Input.inputRange("Input index of user (0-" + (list.size() - 1 ) + "): " , 0, list.size() -1 );
            chatWithUser(list.get(index));
        }else{
            System.out.println("No messenger!");
        }

    }

    private void createNewMessenger(){
        String userName = Input.inputString("Input username: ");
        if(data.account().check(userName)){
            data.messenger().addNew(user.getName(), userName);
        }
        chatWithUser(userName);
    }


    private void chatWithUser(String userName){

        Messenger messenger = data.messenger().get(user.getName(), userName);

        while (true){
            System.out.println(messenger.toString());
            System.out.println("""
                    1. Send Messenger
                    0. Back
                    """);
            switch (Input.inputRange("Choice: ", 0,1)){
                case 0 -> {return;}
                case 1 -> {
                    String comment = Input.inputString("Comment: ");
                    messenger.chat(user.getName(), comment);
                    data.messenger().save();
                }
            }
        }
    }

    public void chat(){
        while (true){
            System.out.println("""
                1. Box messenger
                2. Create messenger
                0. Back
                """);
            switch (Input.inputRange("Input your choice:  ", 0 , 2)){
                case 0 -> {return;}
                case 1 -> boxMessenger();
                case 2 -> createNewMessenger();
            }
        }

    }
}

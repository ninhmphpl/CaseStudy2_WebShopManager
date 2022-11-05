package Object.Account;

import Input.Input;
import Object.*;

import java.util.HashMap;

public class UserManager {
    private final Data data;
    private final HashMap<String, User> user;

    public UserManager(Data data) {
        this.data = data;
        this.user = data.getAllUser();
    }
    public void showAllUser(){
        System.out.println("    SHOW ALL USER");
        if(data.usersSize() > 0){
            System.out.printf("%-20s%-20s%-20s%-20s%n", "Name", "Password", "Wallet", "Spent");
            for (String userName : user.keySet()){
                System.out.println(user.get(userName));
            }
        }else{
            System.out.println("No User!");
        }
    }
    public void checkInfoUser(){
        System.out.println("    CHECK INFO USER");
        String userName = Input.inputString("Input User Name: ");
        if (data.checkAccount(userName)){
            User u = data.getUser(userName);
            System.out.printf("""
                    Name:  %s   Password: %s
                    Wallet: %s
                    """, u.getName(), u.getPassword(), u.getWallet());
            AccountManage accountManage = new AccountManage(data.getUser(userName), data);
            accountManage.showBought();
        }else{
            System.out.println("User is not exist !");
        }
    }
    public void addMoneyForUser(){
        System.out.println("    ADD MONEY FOR USER");
        String userName = Input.inputString("Input User Name: ");
        if (data.checkAccount(userName)){
            AccountManage accountManage = new AccountManage(data.getUser(userName), data);
            accountManage.addMoney();
        }else{
            System.out.println("User is not exits");
        }
    }
    public void deleteUser(){
        String userName = Input.inputString("Input User Name: ");
        if(data.checkAccount(userName)){
            data.getAllUser().remove(userName);
            System.out.println("Delete Successful");
            data.saveUserFile();
        }else{
            System.out.println("User is not exist!");
        }
    }
    public void changePasswordUser(){
        System.out.println("    CHANGE PASSWORD USER");
        String userName  = Input.inputString("Input User Name: ");
        if(data.checkAccount(userName)){
            AccountManage accountManage = new AccountManage(data.getUser(userName), data);
            accountManage.changePassword();
        }else{
            System.out.println("User is not exist!");
        }
    }


    public void menu(){
        while(true){
            System.out.println("""
                 ___________________________
                |       USER MANAGER        |
                |1. Show all user           |
                |2. Check Info User         |
                |3. Add Money For User      |
                |4. Delete User             |
                |5. Change Password User    |
                |0. Back                    |
                |___________________________|
                """);
            switch (Input.inputRange("Input your choice: ", 0, 5)){
                case 0 -> {return;}
                case 1 -> showAllUser();
                case 2 -> checkInfoUser();
                case 3 -> addMoneyForUser();
                case 4 -> deleteUser();
                case 5 -> changePasswordUser();
            }
        }
    }

}

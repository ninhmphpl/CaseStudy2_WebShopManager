package Object.Account;

import Bill.Bill;
import Input.Input;
import Messager.MessengerMenu;
import Object.*;

public class AccountManagers {
    User user;
    Data data;

    public AccountManagers(User user, Data data) {
        this.user = user;
        this.data = data;
    }

    public void changePassword(){
        String newPassword = Input.inputPassword("Input new Password: ");
        user.setPassword(newPassword);
        data.account().save();
        System.out.println("Change password successfully!");
    }
    public void addMoney(){
        int amount = Input.inputInt("Amount to deposit to wallet:");
        if (amount<1){
            System.out.println("Invalid!, Add money Failed!");
            return;
        }
        int walletOfUser = user.getWallet();
        user.setWallet(walletOfUser + amount);
        data.account().save();
        System.out.println("Recharge successful!\nThe money in your account is currently : " + user.getWallet() + "$");
    }
    public void showAccount(){
        System.out.println("==============================================================");
        System.out.println("User Name: " + user.getName() + "\nAccount Balance: " + user.getWallet() + "$" );
    }
    public void showBought(){
        System.out.println("==== Product Bought =====");
        if(user.getBought().size() > 0){
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%s\n","Product Code", "Name","Price", "Category","Post Time", "Amount");
            for(long productCode : user.getBought().keySet()){
                Product product = data.product().get(productCode);
                int value = user.getBought().get(productCode);
                System.out.println(product.toString() + value);
            }
            System.out.println("Money Spent: " + user.getSpent() + "$");
        }else {
            System.out.println("No Product");
        }
    }
    public void bill(){
        if(data.bill().get(user.getName()) != null){
            for (Bill i : data.bill().get(user.getName())){
                System.out.println(i);
            }
        }else {
            System.out.println("No Bill");
        }

    }
    public void menu(){
        MessengerMenu messengerMenu = new MessengerMenu(data, user);
        while (true){
            System.out.println("""
                _____________________________________
                |       Account Manager             |
                |___________________________________|
                |1. Show information account        |
                |2. Add money to wallet             |
                |3. Product bought                  |
                |4. Change Password                 |
                |5. Bill                            |
                |6. Messenger
                |0. Back                            |
                |___________________________________|
                """);
            switch (Input.inputRange("Input your choice: ",0,6)){
                case 1 -> showAccount();
                case 2 -> addMoney();
                case 3 -> showBought();
                case 4 -> changePassword();
                case 5 -> bill();
                case 6 -> messengerMenu.chat();
                case 0 ->{
                    return;
                }
            }
        }
    }
}

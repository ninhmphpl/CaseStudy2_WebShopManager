package Object.Buy;

import Input.Input;
import Object.Account.User;
import Object.*;

import java.util.HashMap;

public class Buy {
    User user;
    Data data;
    HashMap<Long,Integer> bought;

    public Buy(User user, Data data) {
        this.user = user;
        bought = user.getBought();
        this.data = data;
    }

    public boolean checkWalletEnough(int total){
        if(total > user.getWallet()){
            System.out.println("Not enough money! ");
            return false;
        }else return true;
    }

    public boolean buy(long productCode, int amount){
        Product product = data.getProduct(productCode);
        int total = product.getPrice() * amount;
        if (!Input.inputChoice("Total is: " + total + ", choice to buy (y = yes, n = no): ")){
            return  false;
        }
        if (!checkWalletEnough(total)) return false;
        if (bought.containsKey(productCode)){
            int value = bought.get(productCode);
            bought.replace(productCode,value+amount);
        }else{
            bought.put(productCode,amount);
        }
        user.setWallet(user.getWallet() - total);
        user.setSpent(user.getSpent() + total);
        data.saveUserFile();
        System.out.println("Buy Successful, I am Shipping to you :D ");
        return true;
    }

    public void buy(){
        long productCode = Input.inputInt("Input code product: ");
        if (data.checkProduct(productCode)){
            int amount = Input.inputRange("Input amount : ", 1, Integer.MAX_VALUE);
            buy(productCode,amount);
        }else {
            System.out.println("Product is not exist!");
        }
    }

}

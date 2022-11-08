package Object.Account;

import Input.Input;
import Object.*;
import Object.Buy.Buy;
import Object.Cart.CartManager;
import Object.Rating.RatingManager;

import java.util.HashMap;

public class User extends Account{
    private String password;
    private final HashMap<Long,Integer> cart;
    private final HashMap<Long,Integer> bought;
    private int wallet;
    private int spent;
    public User(String name, String password) {
        super(name);
        this.password = password;
        this.cart = new HashMap<>();
        this.bought = new HashMap<>();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {this.password = password;}
    public HashMap<Long,Integer> getCart() {return cart;}
    public HashMap<Long,Integer> getBought() {
        return bought;
    }
    public boolean checkBought(long productCode){
        return bought.containsKey(productCode);
    }
    public int getWallet() {return wallet;}
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    public int getSpent() {
        return spent;
    }
    public void setSpent(int spent) {this.spent = spent;}

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s", getName(),password, wallet, spent);
    }

    @Override
    public void run(Data data){
        Show show = new Show(data);
        AccountManagers accountManagers = new AccountManagers(this, data);
        CartManager cartManager = new CartManager(this, data );
        Buy buys = new Buy(this, data);
        RatingManager ratingManager = new RatingManager(this, data);
        while (true){
            System.out.printf("""
                    ========= MENU (User: %s)===========
                    |___________________________________|
                    |1. Show All Product                |
                    |2. Buy Product                     |
                    |3. Card                            |
                    |4. Account Manager                 |
                    |5. Rating Product                  |
                    |0. Log Out                         |
                    |___________________________________|
                    """, this.getName());
            switch (Input.inputRange("Input your choice: ", 0 , 5)){
                case 1 -> show.showAllProduct();
                case 2 -> buys.buy();
                case 3 -> cartManager.menu();
                case 4 -> accountManagers.menu();
                case 5 -> ratingManager.menu();
                case 0 -> {return;}
                default -> System.out.println("Invalid selection ...");
            }
        }
    }
}

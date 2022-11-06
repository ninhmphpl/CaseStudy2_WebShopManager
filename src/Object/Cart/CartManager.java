package Object.Cart;

import Input.Input;
import Object.Account.User;
import Object.*;
import Object.Buy.Buy;

import java.util.HashMap;

public class CartManager {
    User user;
    Data data;
    HashMap<Long,Integer> carts;

    public CartManager(User user, Data data) {
        this.user = user;
        this.carts = user.getCart();
        this.data = data;
    }

    public void showCart(){
        if(carts.size()<1){
            System.out.println("No Product in Cart!");
            return;
        }
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%s\n","Product Code", "Name", "Price", "Category","Port Time", "Amount");
        for(long productCode : carts.keySet()){
            System.out.println(data.product().get(productCode).toString() + carts.get(productCode));
        }
    }
    public void addProductToCart(){
        Show show = new Show(data);
        show.showAllProduct();
        long productCode = Input.inputLong("Input Product Code: ");
        if (data.product().check(productCode)){
            int amount = Input.inputRange("Input amount: ", 1 , Integer.MAX_VALUE);
            if(carts.containsKey(productCode)){
                int value = carts.get(productCode);
                carts.replace(productCode,value + amount);
            }else {
                carts.put(productCode, amount);
            }
            data.account().save();
        }else{
            System.out.println("Product is not exist!");
        }
    }
    public void buyOrDeleteProductInCart(boolean buy){
        showCart();
        long productCode = Input.inputLong("Input Product Code: ");
        if (data.product().check(productCode)){
            if(carts.containsKey(productCode)){
                int value = carts.get(productCode);
                int amount = Input.inputRange("Input amount Product(1 - "+ value + "): ",1,value);
                if (buy){
                    Buy buys = new Buy(user,data);
                    if(buys.buy(productCode,amount)){
                        carts.replace(productCode, value - amount);
                        if(carts.get(productCode) <= 0){
                            carts.remove(productCode);
                        }
                        data.account().save();
                    }
                }else{
                    carts.replace(productCode, value - amount);
                    if(carts.get(productCode) <= 0){
                        carts.remove(productCode);
                    }
                    data.account().save();
                }
            }
        }else{
            System.out.println("Product is not exist!");
        }
    }
    public void buyProductInCard(){
        buyOrDeleteProductInCart(true);
    }
    public void deleteProductInCard(){
        buyOrDeleteProductInCart(false);
    }
    public void menu(){
        while (true){
            System.out.println("""
                        CART
                    1. Show cart
                    2. Add to cart
                    3. Buy Product in Cart
                    4. Delete Product in cart
                    0. Back
                    """);
            switch (Input.inputRange("Input your choice: ",0,4)){
                case 1 -> showCart();
                case 2 -> addProductToCart();
                case 3 -> buyProductInCard();
                case 4 -> deleteProductInCard();
                case 0 -> {return;}
            }
        }
    }
}

package Object.Rating;

import Input.Input;
import Object.*;
import Object.Account.Account;
import Object.Account.User;


import java.util.ArrayList;

public class RatingManager {
    private final Account account;
    private final Data data;

    public RatingManager(Account account, Data data) {
        this.account = account;
        this.data = data;
    }

    public void ratingProduct(){
        long productCode = Input.inputLong("Input product code: ");
        if(data.product().check(productCode)){
            Product product = data.product().get(productCode);
            Rating rating = new Rating(account.getName(), Input.inputRange("Star count(1-5): ",1,5),Input.inputString("Comment: "));
            product.getRatings().add(rating);
            data.product().save();
        }else{
            System.out.println("Product is not exist!");
        }
    }
    public void showAllRatingOfProduct(){
        long productCode = Input.inputLong("Input product code: ");
        if(data.product().check(productCode)){
            Product product = data.product().get(productCode);
            ArrayList<Rating> ratings = product.getRatings();
            if (ratings.size()<1){
                System.out.println("No rating");
                return;
            }
            for (Rating a : ratings) {
                a.show();
            }
        }else{
            System.out.println("No Product!");
        }
    }
    public void menu(){

        if(account instanceof User){
            while (true){
                System.out.println("""
                     _______________________
                    |[1] Show Rating List   |
                    |[2] Rating             |
                    |[0] Back               |
                    |_______________________|
                    """);
                switch (Input.inputRange("Input your choice: ",0,2)){
                    case 0 -> {return;}
                    case 1 -> showAllRatingOfProduct();
                    case 2 -> ratingProduct();
                }
            }
        }else{
            while (true){
                System.out.println("""
                     _______________________
                    |[1] Show Rating List   |
                    |[0] Back               |
                    |_______________________|
                    """);
                switch (Input.inputRange("Input your choice: ",0,2)){
                    case 0 -> {return;}
                    case 1 -> showAllRatingOfProduct();
                }
            }
        }
    }


}

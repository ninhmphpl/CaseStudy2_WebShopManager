package Tool;

import java.util.*;

import Input.Input;
import Object.*;

public class Filter2 {
    List<Product> products;

    public Filter2(HashMap<Long,Product> products) {
        this.products = new ArrayList<>();
        this.products.addAll(products.values());
    }

    private void showHighToLow(){
        Show.title();
        for (int i = products.size()-1; i >=0 ; i--){
            System.out.println("|" + products.get(i).toString() + "|");
        }
        Show.footer();
    }
    private void showLowToHigh(){
        Show.title();
        for (Product product : products) {
            System.out.println("|" + product.toString() + "|");
        }
        Show.footer();
    }

    private void filterByPrice(){
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println("""
                ==== Sort by Price ====
                1. Sort High to Low
                2. Sort Low to High
                """);
        switch (Input.inputRange("Input your choice",1,2)){
            case 1 -> showHighToLow();
            case 2 -> showLowToHigh();
        }
    }
    public void showByTimeLasted(){
        products.sort(Comparator.comparing(Product::getCurrentTimeMilli));
        showHighToLow();
    }

    private void filterByTime(){
        products.sort(Comparator.comparing(Product::getCurrentTimeMilli));
        System.out.println("""
                ==== Sort by Time ====
                1. Sort oldest - latest
                2. Sort latest - oldest
                """);
        switch (Input.inputRange("Input your choice",1,2)){
            case 1 -> showLowToHigh();
            case 2 -> showHighToLow();
        }
    }

    private void filterByName(){
        products.sort(Comparator.comparing(Product::getName));
        System.out.println("""
                ==== Sort by Name ====
                1. Sort (a-z)
                2. Sort (z-a)
                """);
        switch (Input.inputRange("Input your choice",1,2)){
            case 1 -> showLowToHigh();
            case 2 -> showHighToLow();
        }
    }
    public void menu(){
        Search search = new Search(products);
        while(true){
            System.out.println("""
                     _____________________
                    |       Filter        |
                    |1. By Price          |
                    |2. By Time           |
                    |3. By Name           |
                    |4. Search            |
                    |0. Back              |
                    |_____________________|
                    """);
            switch (Input.inputRange("Input your choice: ", 0 , 4)){
                case 0 -> {return;}
                case 1 -> filterByPrice();
                case 2 -> filterByTime();
                case 3 -> filterByName();
                case 4 -> search.search();
            }
        }
    }

}

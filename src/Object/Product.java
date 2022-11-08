package Object;

import Date.ToolDate;
import Object.Rating.Rating;
import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private final long productCode;
    private String name;
    private int price;
    private String categories;
    private final ArrayList<Rating> ratings;
    private final long currentTimeMilli;


    public Product(long codeProduct, String name, int price, String categories) {
        this.productCode = codeProduct;
        this.name = name;
        this.price = price;
        this.categories = categories;
        ratings = new ArrayList<>();
        currentTimeMilli = System.currentTimeMillis();
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public long getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
    public void show(){
        System.out.printf("|%-5s%-50s%-20d%-20s|\n", productCode, name,price,categories);
    }

    public long getCurrentTimeMilli() {
        return currentTimeMilli;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-50s%-20d%-20s%-20s", productCode, name,price,categories, ToolDate.timeAgo(currentTimeMilli));
    }
}

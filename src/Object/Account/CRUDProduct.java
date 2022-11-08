package Object.Account;

import Input.Input;
import Object.*;
import String.EditString;

import java.util.regex.Pattern;

public class CRUDProduct {

    private final Data data;

    public CRUDProduct(Data data) {
        this.data = data;
    }

    public void addProduct(){
        try{
            String name = Input.inputName("Name: ");
            int price = Input.inputInt("Price: ");
            String category = Input.inputString("Category: ");
            if(data.product().add(new Product(data.product().newCode(),name, price, category))){
                System.out.println("Add Successful!");
            }else{
                System.out.println("Failed to add Product !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage() + "Failed to add Product !");
        }
    }
    public void deleteProduct(){
        long productCode = Input.inputLong("Enter product code: ");
        if(data.product().delete(productCode)){
            System.out.println("Successful delete");
        }else {
            System.out.println("Failed to delete Product !");
        }
    }
    public void upDateProduct(){
        long productCode = Input.inputLong("Code product: ");
        if(data.product().check(productCode)) {
            String name, price, category;
            if (!(name = Input.inputName("Name: ")).equals("")){
                data.product().get(productCode).setName(name);
            }
            if (!(price = Input.inputString("Price: ")).equals("")){
                if(Pattern.matches("[0-9]+", price)){
                    data.product().get(productCode).setPrice(Integer.parseInt(price));
                }else{
                    System.out.println("Illegal, try again");
                }
            }
            if (!(category = Input.inputString("Category: ")).equals("")){
                data.product().get(productCode).setCategories(category);
            }
            data.product().save();
        }else {
            System.out.println("Product Code is not exist!");
        }
    }
}

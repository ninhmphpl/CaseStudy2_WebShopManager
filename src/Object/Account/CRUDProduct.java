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
        long key = Input.inputLong("Code Product: ");
        if (data.checkProduct(key)){
            System.out.println("Code product is exist \n Try again?");
            if (Input.inputChoice("(Y = yes, N = no): ")){
                addProduct();
            }
            return;
        }
        try{
            String name = EditString.upperCaseAlphabetOfWord2(Input.inputString("Name: "));
            int price = Input.inputInt("Price: ");
            String category = Input.inputString("Category: ");
            data.getAllProduct().put(key,new Product(key,name, price, category));
            data.saveProductFile();
            System.out.println("Add Successful!");
        }catch (Exception e){
            System.out.println(e.getMessage() + "Failed to add Product !");
        }
    }
    public void deleteProduct(){
        long key = Input.inputLong("Enter product code: ");
        if(data.checkProduct(key)){
            data.getAllProduct().remove(key);
            System.out.println("Successful delete");
            data.saveProductFile();
        }
    }
    public void upDateProduct(){
        long key = Input.inputLong("Code product: ");
        if(data.checkProduct(key)) {
            String name, price, category;
            if (!(name = Input.inputString("Name: ")).equals("")){
                data.getAllProduct().get(key).setName(EditString.upperCaseAlphabetOfWord2(name));
            }
            if (!(price = Input.inputString("Price: ")).equals("")){
                if(Pattern.matches("[0-9]+", price)){
                    data.getAllProduct().get(key).setPrice(Integer.parseInt(price));
                }else{
                    System.out.println("Illegal, try again");
                }
            }
            if (!(category = Input.inputString("Category: ")).equals("")){
                data.getAllProduct().get(key).setCategories(category);
            }
            data.saveProductFile();
        }else {
            System.out.println("Product Code is not exist!");
        }
    }
}

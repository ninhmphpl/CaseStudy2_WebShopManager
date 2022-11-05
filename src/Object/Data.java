package Object;

import IO.__IOClass;
import Object.Account.User;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class Data extends __IOClass implements Serializable {
    private HashMap<Long,Product> products;
    private HashMap<String, User> users;

    private final File PRODUCT_DATA_FILE = new File("Product");
    private final File USER_DATA_FILE = new File("User");


    public Data() {
        products = (HashMap<Long, Product>) readFile(PRODUCT_DATA_FILE);
        if (products == null){
            products = new HashMap<>();
        }
        users = (HashMap<String, User>) readFile(USER_DATA_FILE);
        if (users == null){
            users = new HashMap<>();
        }
    }
    public int productSize(){return products.size();}
    public int usersSize(){return users.size();}

    public boolean checkAccount(String userName){return users.containsKey(userName);}
    public User getUser(String userName){return users.get(userName);}
    public boolean checkProduct(long key){return products.containsKey(key);}
    public Product getProduct(long productCoke){
        return products.get(productCoke);
    }

    public void saveUserFile(){
        writeFile(users, USER_DATA_FILE, false);
    }
    public void saveProductFile(){
        writeFile(products, PRODUCT_DATA_FILE, false);
    }
    public void addUser(User user){
        users.put(user.getName(), user);
        saveUserFile();
    }

    public HashMap<Long,Product> getAllProduct(){
        return products;
    }

    public HashMap<String,User> getAllUser(){
        return users;
    }

}




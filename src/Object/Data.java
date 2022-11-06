package Object;

import IO.__IOClass;
import java.io.File;
import java.io.Serializable;

public class Data extends __IOClass implements Serializable {
    private ProductManager products;
    private AccountManager accounts;


    public Data() {
        File PRODUCT_DATA_FILE = new File("Product");
        File USER_DATA_FILE = new File("User");

        products = (ProductManager) readFile(PRODUCT_DATA_FILE);
        if (products == null){
            products = new ProductManager(PRODUCT_DATA_FILE);
        }
        accounts = (AccountManager) readFile(USER_DATA_FILE);
        if (accounts == null){
            accounts = new AccountManager(USER_DATA_FILE);
        }
    }

    public ProductManager product(){
        return products;
    }
    public AccountManager account(){
        return accounts;
    }

}




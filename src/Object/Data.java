package Object;

import Bill.BillManager;
import IO.__IOClass;
import Messager.MessengerManager;

import java.io.File;
import java.io.Serializable;

public class Data extends __IOClass implements Serializable {
    private ProductManager products;
    private AccountManager accounts;
    private BillManager bills;
    private MessengerManager managers;


    public Data() {
        File PRODUCT_DATA_FILE = new File("Product");
        File USER_DATA_FILE = new File("User");
        File BILL_DATA = new File("Bill");
        File MESSENGER_DATA = new File("Messenger");

        products = (ProductManager) readFile(PRODUCT_DATA_FILE);
        if (products == null){
            products = new ProductManager(PRODUCT_DATA_FILE);
        }
        accounts = (AccountManager) readFile(USER_DATA_FILE);
        if (accounts == null){
            accounts = new AccountManager(USER_DATA_FILE);
        }
        bills = (BillManager) readFile(BILL_DATA);
        if (bills == null){
            bills = new BillManager(BILL_DATA);
        }
        managers = (MessengerManager) readFile(MESSENGER_DATA);
        if (managers == null){
            managers = new MessengerManager(MESSENGER_DATA);
        }
    }

    public ProductManager product(){
        return products;
    }
    public AccountManager account(){
        return accounts;
    }
    public BillManager bill(){return bills;}
    public MessengerManager messenger(){return managers;}

}




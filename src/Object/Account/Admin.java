package Object.Account;

import Input.Input;
import Object.*;

public class Admin extends User{
    public Admin(String name,String password) {
        super(name,password);
    }

    @Override
    public void run(Data data) {
        CRUDProduct crudProduct = new CRUDProduct(data);
        UserManager userManager = new UserManager(data);
        while (true){
            System.out.printf("""
                    ======== Menu (%s) ========
                     _______________________
                    |1. Menu User (demo)    |
                    |2. Add Product         |
                    |3. Delete Product      |
                    |4. Update Product      |
                    |5. User Manager        |
                    |0. Log Out             |
                    |_______________________|
                    """, getName());
            int choice = Input.inputRange("Input your choice (0-5): ", 0 ,5);
            switch (choice){
                case 1 -> super.run(data);
                case 2 -> crudProduct.addProduct();
                case 3 -> crudProduct.deleteProduct();
                case 4 -> crudProduct.upDateProduct();
                case 5 -> userManager.menu();
                case 0 -> {return;}
                default -> System.out.println("Avail Input!");
            }
        }
    }
}

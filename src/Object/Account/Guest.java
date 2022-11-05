package Object.Account;

import Input.Input;
import Object.*;
public class Guest extends Account{

    public Guest(String name) {
        super(name);
    }

    @Override
    public void run(Data data) {
        Show show = new Show(data);
        RegisterAndLogIn registerAndLogIn = new RegisterAndLogIn(data);
        while (true){
            System.out.printf("""
                    ======= Menu (%s)=======
                    1. Show all product.
                    2. Register.
                    3. Log in.
                    0. Exit.
                    """,getName());
            int choice = Input.inputInt("Input your choice: ");
            switch (choice){
                case 1 -> show.showAllProduct();
                case 2 -> registerAndLogIn.register();
                case 3 -> registerAndLogIn.logIn();
                case 0 -> System.exit(0);
                default -> System.out.println("Illegal, try again!!");

            }
        }
    }


}

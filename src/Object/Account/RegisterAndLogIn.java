package Object.Account;

import Input.Input;
import Object.*;

public class RegisterAndLogIn {
    private final Data data;

    public RegisterAndLogIn(Data data) {
        this.data = data;
    }

    public void logIn(){
        System.out.println("== LOG IN ==");
        String name = Input.inputString("User name: ");
        String password = Input.inputPassword("Password: ");

        if (data.account().check(name) &&
                ((User)data.account().get(name)).getPassword().equals(password)){
            Account user = data.account().get(name);
            System.out.println("Log in successful!");
            user.run(data);
        }else System.out.println("Account or password is not true...");
    }

    public void register(){
        System.out.println("== Register ==");
        String name = Input.inputString("User name: ");
        if ( !data.account().check(name)){
            data.account().add(new User(name, Input.inputPassword("Password: ")));
            System.out.println("Register successful");
        }
    }
}

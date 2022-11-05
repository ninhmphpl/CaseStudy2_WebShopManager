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
        if (data.getAllUser().containsKey(name)){
            if(data.getAllUser().get(name).getPassword().equals(password)){
                User user = data.getAllUser().get(name);
                System.out.println("Log in successful!");
                if (user instanceof Admin){
                    user.run(data);
                }else {
                    user.run(data);
                }
            }else {
                System.out.println("Account or password is not true...");
            }
        }
    }

    public void register(){
        System.out.println("== Register ==");
        String name = Input.inputString("User name: ");
        if ( !data.checkAccount(name)){
            data.addUser(new User(name, Input.inputPassword("Password: ")));
            data.saveUserFile();
            System.out.println("Register successful");
        }
    }
}

import Object.Account.Guest;
import Object.Data;
import Object.Account.Admin;


public class Main {
    public static void main(String[] args){
        Data data = new Data();
        if(!data.account().check("admin")){
            Admin admin = new Admin("admin", "1234567");
            data.account().add(admin);
        }

        Guest guest = new Guest("name");
        guest.run(data);
    }
}
import Object.Account.Guest;
import Object.Data;
import Object.Account.Admin;


public class Main {
    public static void main(String[] args){
        Data data = new Data();
        Admin admin = new Admin("admin", "1234567");
        admin.run(data);
        Guest guest = new Guest("name");
        guest.run(data);
    }
}
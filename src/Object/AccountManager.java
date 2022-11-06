package Object;

import IO.__IOClass;
import Object.Account.Account;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class AccountManager implements Serializable {

    private final HashMap<String, Account> accounts;
    private final File file;

    public AccountManager(File file) {
        this.file = file;
        accounts = new HashMap<>();
    }

    public boolean add(Account account) {
        if (check(account.getName())) return false;
        accounts.put(account.getName(),account);
        save();
        return true;
    }

    public boolean delete(String userName) {
        if(!check(userName)) return false;
        accounts.remove(userName);
        save();
        return true;
    }

    public Account get(String userName) {
        return accounts.get(userName);
    }

    public boolean check(String userName){
        return accounts.containsKey(userName);
    }
    public int size(){
        return accounts.size();
    }
    public Set<String> keySet(){
        return accounts.keySet();
    }

    public void save(){
        __IOClass.writeFile(this, file, false);
    }
}

package Bill;

import IO.__IOClass;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BillManager implements Serializable {
    private final ArrayList<Bill> bills;
    private final HashMap<String, ArrayList<Integer>> userBill;
    private final File file;
    public BillManager(File file) {
        bills = new ArrayList<>();
        userBill = new HashMap<>();
        this.file = file;
    }

    public boolean add(Bill bill){
        if(bill.getBillNumber() != size()) return false;
        bills.add(bill);

        if(!check(bill.getUserName())){
            userBill.put(bill.getUserName(),new ArrayList<>());
        }
        userBill.get(bill.getUserName()).add(bill.getBillNumber());
        save();
        return true;
    }
    public Bill get(Integer billNumber){
        return bills.get(billNumber);
    }
    public ArrayList<Bill> get(String userName){
        if (!check(userName)) return null;
        ArrayList<Bill> bill = new ArrayList<>();
        for (int i : userBill.get(userName)) {
            bill.add(bills.get(i));
        }
        return bill;
    }
    public ArrayList<Bill> get(){
        return bills;
    }

    public boolean check(String userName){
        return userBill.containsKey(userName);
    }
    public boolean check(int billNumber){
        return billNumber >= 0 && billNumber < bills.size();
    }
    public void save(){
        __IOClass.writeFile(this, file,false);
    }
    public int size(){
        return bills.size();
    }

}



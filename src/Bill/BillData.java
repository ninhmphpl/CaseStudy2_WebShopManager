package Bill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BillData implements Serializable {
    private final ArrayList<Bill> listBills;
    private final HashMap<String, ArrayList<Integer>> billNumbersOfUser;
    private int size;

    public BillData() {
        listBills = new ArrayList<>();
        billNumbersOfUser = new HashMap<>();
    }

    public ArrayList<Bill> getListBills() {
        return listBills;
    }
    public Bill getBill(int billNumber){
        return listBills.get(billNumber);
    }

    public ArrayList<Integer> getBillNumbersOfUser(String name) {
        return billNumbersOfUser.get(name);
    }
    public boolean checkUser(String userName){
        return billNumbersOfUser.containsKey(userName);
    }
}

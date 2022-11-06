package Bill;

public class BillManager {
    private final BillData billData;

    public BillManager(BillData billData) {
        this.billData = billData;
    }

    public void addBill(Bill bill){
        billData.getListBills().add(bill);
        billData.getBillNumbersOfUser(bill.getUserName()).add(bill.getBillNumber());
    }
    public void showAllBillOfUser(String user){
        if(billData.checkUser(user)){
            for (int i : billData.getBillNumbersOfUser(user)){
                System.out.println(billData.getBill(i).toString());
            }
        }else{
            System.out.println("You Have Not Any Bill!");
        }
    }
}

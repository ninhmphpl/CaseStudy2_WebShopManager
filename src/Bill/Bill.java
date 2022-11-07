package Bill;

import Date.ToolDate;
import Object.*;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Bill implements Serializable {
    private final int billNumber;
    private final String userName;
    private final long productCode;
    private final String nameProduct;
    private final int price;
    private final int amount;
    private final int total;
    private final long date;

    public Bill(int billNumber, String userName, Product product, int amount) {
        this.billNumber = billNumber;
        this.userName = userName;
        this.productCode = product.getProductCode();
        this.nameProduct = product.getName();
        this.price = product.getPrice();
        this.amount = amount;
        this.total = price * amount;
        this.date = System.currentTimeMillis();
    }

    public int getBillNumber() {
        return billNumber;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "==========BILL("+ billNumber +")===========\n" +
                "User Name: " + userName + '\n' +
                " Product Code: " + productCode + '|' +
                " Name Product: " + nameProduct + '|' +
                " Price: " + price + '|' +
                " Amount: " + amount + '|' +
                " Total: " + total + '|' +
                " Date: " + ToolDate.convertCurrentTimeMillisToLocalDateTime(date).format(dateTimeFormatter);
    }
}

package Object;

import IO.__IOClass;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class ProductManager implements Serializable {
    private final HashMap<Long,Product> products;
    private final File file;
    private long productCode;

    public ProductManager(File file) {
        this.products = new HashMap<>();
        this.file = file;
    }

    public boolean add(Product product) {
        if (check(product.getProductCode())) return false;
        products.put(product.getProductCode(), product);
        save();
        return true;
    }


    public boolean delete(long productCode) {
        if (!check(productCode)) return false;
        products.remove(productCode);
        save();
        return true;
    }

    public Product get(long productCode){
        return products.get(productCode);
    }
    public HashMap<Long, Product> get(){
        return products;
    }


    public boolean check(long productCode){
        return products.containsKey(productCode);
    }

    public void save(){
        __IOClass.writeFile(this, file, false);
    }

    public int size(){
        return products.size();
    }
    public long newCode(){
        productCode++;
        save();
        return productCode;
    }
}

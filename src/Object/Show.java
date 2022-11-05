package Object;


public class Show {
    Data data;

    public Show(Data data) {
        this.data = data;
    }
    public static void title(){
        System.out.printf(" %-100s \n","_".repeat(100) );
        System.out.printf("|%-20s%-20s%-20s%-20s%-20s|\n","Code Product", "Name","Price","Category","Post Time");
        System.out.printf("|%-100s|\n", "_".repeat(100));
    }
    public static void footer(){
        System.out.printf("|%-100s|\n","_".repeat(100));
    }

    public void showAllProduct(){
        if (data.productSize() > 0){
            title();
            for ( long productCode : data.getAllProduct().keySet()){
                System.out.println("|" + data.getProduct(productCode).toString() + "|");
            }
            footer();
        }else {
            System.out.println("No Product!");
        }
    }


}

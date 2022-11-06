package Object;


import Tool.Filter2;

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
        if (data.product().size() > 0){
            Filter2 filter2 = new Filter2(data.product().get());
            filter2.showByTimeLasted();
            filter2.menu();
        }else {
            System.out.println("No Product!");
        }
    }


}

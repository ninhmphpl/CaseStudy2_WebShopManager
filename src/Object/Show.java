package Object;


import Tool.Filter2;

public class Show {
    Data data;

    public Show(Data data) {
        this.data = data;
    }
    public static void title(){
        System.out.printf(" %-115s \n","_".repeat(115) );
        System.out.printf("|%-5s%-50s%-20s%-20s%-20s|\n","Code", "Name","Price","Category","Post Time");
        System.out.printf("|%-115s|\n", "_".repeat(115));
    }
    public static void footer(){
        System.out.printf("|%-115s|\n","_".repeat(115));
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

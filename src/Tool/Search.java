package Tool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Input.Input;
import Object.*;

public class Search {
    List<Product> products;

    public Search(List<Product> products) {
        this.products = products;
    }

    private List<SearchCount> listCountOfProduct(String keySearch){

        String regex = regexString(keySearch.toLowerCase());
        List<SearchCount> listSearch = new ArrayList<>();

        for (Product product : products){
            Matcher searchWordInName = Pattern.compile(regex).matcher(product.getName().toLowerCase());
            int count = 0;
            while(searchWordInName.find()){
                count++;
            }
            if (count > 0){
                listSearch.add(new SearchCount(count,product));
            }
        }
        return listSearch;
    }

    public static String regexString(String string){
        String regex = string.replaceAll("[ !@#$%^&*()_+--=<>?.,]+","|");
        regex = regex.replaceAll("^[|]|[|]$", "");
        return regex;
    }
    public void search(){
        String searchKey = Input.inputString("Search key: ");
        List<SearchCount> listSearch = listCountOfProduct(searchKey);
        listSearch.sort(Comparator.comparing(SearchCount:: getCount ));
        showDecrease(listSearch);

    }

    private void showDecrease(List<SearchCount> listSearch){
        if (listSearch.size() > 0){
            Show.title();
            for(int i = listSearch.size()-1; i >= 0; i--){
                System.out.println(listSearch.get(i).getProduct().toString());
            }
            Show.footer();
        }else{
            System.out.println("No Products Found !");
        }
    }

    private static class SearchCount {
        int count;
        Product product;

        public SearchCount(int count, Product product) {
            this.count = count;
            this.product = product;
        }

        public int getCount() {
            return count;
        }

        public Product getProduct() {
            return product;
        }
    }

}

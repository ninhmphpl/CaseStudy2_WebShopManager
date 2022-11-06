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
        String hasTagRegex = hashTagRegex(keySearch.toLowerCase());
        System.out.println("regex: " + regex);
        System.out.println("hashTag regex: " + hasTagRegex);
        List<SearchCount> listSearch = new ArrayList<>();

        for (Product product : products){
            Matcher searchWordInName = Pattern.compile(regex).matcher(product.getName().toLowerCase());
            Matcher searchWordInCategory = Pattern.compile(hasTagRegex).matcher(product.getCategories().toLowerCase());
            int count = 0;
            if(!regex.isEmpty()){
                while(searchWordInName.find()){
                    count++;
                }
            }
            if (!hasTagRegex.isEmpty()){
                while(searchWordInCategory.find()){
                    count++;
                }
            }

            if (count > 0){
                listSearch.add(new SearchCount(count,product));
            }
        }
        return listSearch;
    }

    private String regexString(String string){
        String regex = string.replaceAll("[ !@$%^&*()_+--=<>?.,]+","|");
        regex = regex.replaceAll("^[|]|[|]$", "");
        return regex;
    }

    private String hashTagRegex(String keySearch){
        StringBuilder regex = new StringBuilder();
        Matcher hashTagRegex = Pattern.compile("#[a-zA-Z0-9]+").matcher(keySearch);
        while (hashTagRegex.find()){
            regex.append("|").append(keySearch, hashTagRegex.start(), hashTagRegex.end());
        }
        if(regex.length()>0){
            return regex.deleteCharAt(0).toString().replaceAll("#+", "");
        }else return "";

    }
    public void search(){
        String searchKey = Input.inputString("Search key: ");
        List<SearchCount> listCountOfProduct = listCountOfProduct(searchKey);
        listCountOfProduct.sort(Comparator.comparing(SearchCount:: getCount ));
        showDecrease(listCountOfProduct);

    }

    private void showDecrease(List<SearchCount> listCountOfProduct){
        if (listCountOfProduct.size() > 0){
            Show.title();
            for(int i = listCountOfProduct.size()-1; i >= 0; i--){
                System.out.println("|" + listCountOfProduct.get(i).getProduct().toString() + "|");
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

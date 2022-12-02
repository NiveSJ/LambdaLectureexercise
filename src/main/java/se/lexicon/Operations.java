package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Operations {
    List<Product> productList = new ArrayList<>();

    public Operations() {

        this.productList = createProducts();
    }

    public List<Product> createProducts() {

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("BCS", 50.0, 0);
        Product product2 = new Product("BNP", 100.0, 20);
        Product product3 = new Product("Accenture", 130.0, 0);
        Product product4 = new Product("TCS", 120.0, 6);
        Product product5 = new Product("Infosys", 400.0, 12);


        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        return productList;

    }


    public List<Product> findstock(Conditional filter) {

        List<Product> FilteredList = new ArrayList<>();
        for (Product prod : productList)

            if (filter.test(prod))

                FilteredList.add(prod);

        return FilteredList;
    }

    public List<Product> findstockandExecute(Conditional filter, Action apply) {
        List<Product> filterList = new ArrayList<>();

        for (Product prod : productList)
            if (filter.test(prod))
                filterList.add(prod);

        for (Product prod : filterList) {
            apply.execute(prod);
        }


        return filterList;


    }

    public List<Product> findAll() {

        return new ArrayList<Product>(this.productList);
    }


}

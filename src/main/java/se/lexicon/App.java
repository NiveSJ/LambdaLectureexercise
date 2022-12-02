package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        Operations op = new Operations();
        op.createProducts();
        System.out.println("Find All");
        op.findAll();
        System.out.println("Get Stock of 0");
        op.findstock(p -> p.getStock() == 0).forEach(System.out::println);
        System.out.println("Stock Name contains B");
        op.findstock(p -> p.getProductName().startsWith("B")).forEach(System.out::println);
        System.out.println("Stock price from 100 to 150");
        op.findstock(p -> p.getPrice() > 100 && p.getPrice() <= 150).forEach(System.out::println);

        System.out.println("Increased Stock rates");
        op.findstockandExecute(p -> p.getStock() > 0 && p.getStock()<10,p -> p.setPrice(p.getPrice() + p.getPrice()*.5)).forEach(System.out::println);


    }
}

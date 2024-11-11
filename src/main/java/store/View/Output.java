package store.View;

import static store.Constants.Welcome;

import java.text.NumberFormat;
import java.util.List;
import store.Manager.Product;

public class Output {
    public void welcome(){
        System.out.println(Welcome);
    }

    public void stock(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getPromotion());
        }
    }
}

package store.Manager;

import static store.Domain.Constants.monetaryUnit;
import static store.Domain.Constants.noStock;
import static store.Domain.Constants.noStockNumber;
import static store.Domain.Constants.thing;

import java.text.NumberFormat;

public class Product {
    public String getPromotion;
    private String name;
    private int price;
    private int quantity;
    private String promotion;

    public Product(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return NumberFormat.getInstance().format(price) + monetaryUnit;
    }

    public int getPriceInt() {
        return price;
    }

    public String getQuantity() {
        String quantities = String.valueOf(quantity);
        if (quantities.equals(noStockNumber)) {
            quantities = noStock;
        } else {
            quantities = quantities + thing;
        }
        return quantities;
    }

    public int getQuantityInt() {
        return quantity;
    }

    public String getPromotion() {
        if (promotion == null) {
            promotion = " ";
        }
        return promotion;
    }
}

package store.Contoller;

import static store.Constants.comma;
import static store.Constants.hyphen;

import java.util.ArrayList;
import java.util.List;
import store.Manager.ProductPurchaseManager;
import store.Manager.ProductPurchaseManager.ProductPurchase;

public class ParsingPurchase {
    public List<ProductPurchase> parse(String inputPurchase) {
        List<ProductPurchase> purchases = new ArrayList<>();

        String[] items = inputPurchase.split(comma);
        for (String item : items) {
            item = item.substring(1, item.length() - 1);

            String[] parts = item.split(hyphen);
            String name = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            purchases.add(new ProductPurchase(name, quantity));
        }
        return purchases;
    }
}
